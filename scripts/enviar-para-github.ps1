# Reconstroi o commit da pasta UnoGWT sem arquivos grandes e envia para origin/master.
# Uso (PowerShell), de dentro da pasta do projeto:
#   powershell -ExecutionPolicy Bypass -File .\scripts\enviar-para-github.ps1

$ErrorActionPreference = "Stop"

$gitignore = @"
# Subversion - metadados da working copy, nao versionar no Git
.svn/
*.svn-base

# Cache e saida gerada do GWT (arquivos facilmente > 100 MB)
gwt-unitCache/
.gwt/
war/WEB-INF/deploy/
war/WEB-INF/classes/
www-test/
gwt-unitCache*

# Eclipse / compilacao local
bin/
tmp/
*.class
*.launch
.metadata/

# Maven / Gradle / saidas de build
target/
build/
.gradle/
out/

# Pacotes gerados (reconstroi no build)
*.war
*.ear

# Logs e sistema
*.log
*.tmp
*.swp
.DS_Store
Thumbs.db
hs_err_pid*
*~
"@

function Get-GitLargePaths {
    param([long]$MinBytes)
    $found = @()
    foreach ($rel in (git diff --cached --name-only)) {
        if (-not $rel) { continue }
        if (-not (Test-Path -LiteralPath $rel)) { continue }
        $item = Get-Item -LiteralPath $rel -Force
        if ($item.PSIsContainer) { continue }
        if ($item.Length -ge $MinBytes) { $found += $item }
    }
    return $found
}

Write-Host "Diretorio: $(Get-Location)"
git fetch origin
git checkout master
git reset --soft origin/master

Set-Content -LiteralPath ".gitignore" -Value $gitignore -Encoding utf8

# Tira tudo do indice (nao apaga arquivos do disco) e reinsere so o que o .gitignore permite.
git rm -rf --cached --ignore-unmatch .
git add .gitignore
git add .

$limite = 90MB
foreach ($item in (Get-GitLargePaths -MinBytes $limite)) {
    $rel = $item.FullName.Substring((Get-Location).Path.Length).TrimStart("\", "/")
    $rel = $rel -replace "\\", "/"
    Write-Host ("Fora do Git ({0:N2} MB): {1}" -f ($item.Length / 1MB), $rel)
    git rm --cached --ignore-unmatch -- $rel
    Add-Content -LiteralPath ".gitignore" -Value $rel
}

git add .gitignore

$aindaGrandes = Get-GitLargePaths -MinBytes $limite
if ($aindaGrandes.Count -gt 0) {
    Write-Host "Ainda ha arquivos grandes no commit. Abortando o push."
    $aindaGrandes | ForEach-Object { "{0:N2} MB  {1}" -f ($_.Length / 1MB), $_.FullName }
    exit 1
}

git status --short
git commit -m "Importa o projeto UnoGWT sem caches nem metadados SVN"
git push origin HEAD:master
Write-Host "Push concluido."
