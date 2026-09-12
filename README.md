# UnoGWT

Front-end web do ecossistema **UNO Soluções / UCommerce**, desenvolvido em **Java** com **Google Web Toolkit (GWT)** e **SmartGWT**. O projeto entrega módulos ricos de interface (grids, formulários, lookups, relatórios) que são embutidos no ERP principal, integrando-se via JavaScript e RPC com o backend Struts/UCommerce.

> **Importante:** este repositório contém apenas o **cliente GWT**. As ações de negócio do servidor (`com.br.server.*`) e a aplicação Struts/UCommerce principal residem em outros projetos.

## Tecnologias

| Tecnologia | Versão / detalhe |
|------------|------------------|
| Linguagem | Java 7 |
| Framework UI | GWT 2.6.0 |
| Componentes | SmartGWT 4.1p (SmartClient v9.1p) |
| Framework proprietário | HowMake / HowMGWT (`HowMGWTNIO.jar`) |
| Plataforma legada | Google App Engine SDK 1.9.30 |
| Persistência (legado) | DataNucleus JPA 3.1.3 |
| Exportação JS | GWT Exporter 2.3.0 |
| Gráficos | JsGantt |
| Upload | MoxieApps GWT Uploader |
| IDE / build | Eclipse + plugins GWT e App Engine |
| Localização | `pt_BR` (fixo) |
| Licença | Apache 2.0 |

Não há `pom.xml` nem `build.xml`. O build é feito pelo Eclipse com os JARs em `war/WEB-INF/lib/`.

## Arquitetura

### Visão geral

```
┌─────────────────────────────────────────────────────────────┐
│  ERP UCommerce (Struts / JSP / HTML legado)                 │
│  ┌─────────────────────────────────────────────────────┐    │
│  │  UnoGWT.html — host page com parâmetros JS          │    │
│  │  (empresa, colaborador, programa, URLs de serviço)  │    │
│  └──────────────────────┬──────────────────────────────┘    │
│                         │                                   │
│  ┌──────────────────────▼──────────────────────────────┐    │
│  │  Cliente GWT (este repositório)                     │    │
│  │  UnoGWT.java / UnoGWTGateway.java                  │    │
│  │  SmartGWT + HowMGWT (telas, grids, formulários)     │    │
│  └──────────────────────┬──────────────────────────────┘    │
│                         │ GWT RPC                           │
│  ┌──────────────────────▼──────────────────────────────┐    │
│  │  Servlets HowM (HowMProxy, HowMDownload)          │    │
│  └──────────────────────┬──────────────────────────────┘    │
│                         │                                   │
│  ┌──────────────────────▼──────────────────────────────┐    │
│  │  Backend Struts/UCommerce (outro repositório)     │    │
│  │  com.br.server.* — ações de negócio, JasperReports │    │
│  └─────────────────────────────────────────────────────┘    │
└─────────────────────────────────────────────────────────────┘
```

### Cliente (GWT)

- **Entry point:** `com.br.client.UnoGWT` — carrega o módulo indicado por `getUnoProgramaGWT()` na página hospedeira.
- **Gateway JS:** `com.br.client.UnoGWTGateway` — exportado como `uno.UnoGWTGateway`, permite ao ERP abrir lookups, relatórios Jasper, uploads e widgets sem recarregar o módulo inteiro.
- **Configuração:** `com.br.client.configuracao` — sessão (empresa, colaborador), URLs de serviço e proxy RPC.
- **Modelos:** `com.br.client.model.<domínio>` — DTOs/entidades de transferência por área de negócio.
- **Telas:** `com.br.client.panel.<domínio>` — componentes SmartGWT organizados por módulo.
- **Componentes compartilhados:** `com.br.client.panel.business` — lookups reutilizáveis (cliente, produto, fornecedor, colaborador, etc.).

### Servidor (neste WAR)

| Servlet | Classe | URL |
|---------|--------|-----|
| `HowMProxy` | `com.howmake.server.HowMProxyImpl` | `/unogwt/HowMProxy` |
| `HowMDownload` | `com.howmake.server.NIO.remote.HowMDonwloadFile` | `/unogwt/HowMDownload` |

O fluxo RPC envia entidades `HowMGWTEntity` ao proxy, que delega para ações remotas no backend Struts (`com.br.server.*`) ou executa localmente conforme a configuração da entidade. Timeout RPC: 160 segundos.

### Convenção de códigos de programa

Cada tela segue o padrão **`XX` + `T` + `NNNN`**:

| Letra (3ª posição) | Significado |
|--------------------|-------------|
| **D** | Dialog / cadastro auxiliar |
| **W** | Window / tela de trabalho |
| **Q** | Query / lookup / busca |
| **R** | Report / relatório |
| **P** | Panel / dashboard |

Exemplos: `VDP0001` (Placar de Vendas), `CDQ0101` (Busca de Cliente), `FNW0217` (Resultado Financeiro Mensal).

## Estrutura do projeto

```
.
├── src/
│   ├── com/br/
│   │   ├── UnoGWT.gwt.xml          # Módulo GWT principal
│   │   └── client/
│   │       ├── configuracao/       # Config, RPC, fábrica de entidades
│   │       ├── model/              # DTOs por domínio de negócio
│   │       └── panel/              # Telas SmartGWT
│   ├── com/howmake/                # Framework HowMake/HowMGWT
│   └── META-INF/
│       └── persistence.xml         # JPA DataNucleus (legado GAE)
├── war/
│   ├── UnoGWT.html                 # Página de entrada + configuração JS
│   ├── unogwt/                     # Saída compilada do GWT
│   ├── images/                     # Assets estáticos
│   └── WEB-INF/
│       ├── web.xml
│       ├── appengine-web.xml
│       └── lib/                    # Dependências (JARs)
├── scripts/
│   └── enviar-para-github.ps1      # Script de publicação no Git
├── leia-me                          # URL de desenvolvimento
└── LICENSE
```

O projeto possui **579 arquivos Java** no diretório `src/`.

## Módulos de negócio

| Sigla | Área | Principais funcionalidades |
|-------|------|---------------------------|
| **vd** | Vendas | Placar de vendas, busca de pedidos/produtos, NFS-e, devoluções, comissões, performance |
| **cd** | Cadastro | Busca de clientes, condições de pagamento, restrições de tabela de preço |
| **fn** | Financeiro | Boletim de caixa, resultado operacional, razão, apuração por competência e centro de custo |
| **ed** | EDI | Configuração, monitoramento e importação de arquivos EDI |
| **sg** | Sistema Gerencial | Parâmetros do sistema, GED, NFS-e (legado), busca de colaboradores |
| **cc** | Compras | Busca de fornecedores |
| **oc** | Ocorrências | Gráfico de Gantt e integração com Google Agenda |
| **at** | Atendimento | Agenda/calendário |
| **sv** | Vendedor | Exceções de comissão |
| **eq** | Equipamentos / Estoque | Devolução |
| **ex** | Extranet | GED extranet |
| **gg** | Gerencial | Rentabilidade de pedido |
| **aj** | Artigos | Painéis de conteúdo (CMS) |

### Telas registradas no entry point

| Código | Título |
|--------|--------|
| VDP0001 | Placar de Vendas |
| VDW0028 / VDW0030 | Motivos de Devolução |
| VDW0031 | Solicitação de Devolução |
| VDW0035 | Exportação NFS-e Contador |
| VDW0800 / VDW1000 | NFS-e — Nota Fiscal de Serviço |
| FNW0015 | Boletim de Caixa |
| FNW0016 | Resultado Operacional |
| FNW0017 | Ebitida |
| FNW0217 | Resultado Financeiro Mensal |
| FNW0221 | Resultado Financeiro por Centro de Custo |
| FNW0223 / FNW0224 | Apuração por Competência |
| FNW0228 / FNW0229 / FNW0230 / FNW0235 | Apuração Anastassiadis |
| FNR0010 / FNR0011 | FUP — Razão Fornecedores / Clientes |
| EDW0001 | Configuração EDI |
| EDW0002 | Monitoramento EDI |
| EDW0003 | Importação Arquivos EDI |
| SGW0027 | NFS-e RPS (legado) |
| CDQ0101 | Busca de Cliente (popup) |
| VDQ0002 | Busca de Produtos (popup) |
| OCW0001 | Gráfico de Gantt |
| ATW0117 | Agenda |

Outras telas são acessíveis via `UnoGWTGateway` (lookups, relatórios Jasper, uploads, GED, etc.) sem passar pelo entry point principal.

## Desenvolvimento

### Pré-requisitos

- Java 7+
- Eclipse com plugins GWT e Google App Engine
- Servidor de aplicação compatível (Tomcat ou ambiente UCommerce)

### Modo de desenvolvimento

Com o GWT Dev Mode ativo:

```
http://127.0.0.1:8080/gwt/UnoGWT.html?gwt.codesvr=127.0.0.1:9997
```

### Compilação

1. Importar o projeto no Eclipse (`.project` / `.classpath`).
2. Compilar com o plugin GWT — a saída é gerada em `war/unogwt/`.
3. As classes compiladas vão para `war/WEB-INF/classes/` (ignorado pelo Git).

### Integração com o ERP

A página `war/UnoGWT.html` define funções JavaScript usadas pelo ERP para configurar o contexto:

| Função JS | Propósito |
|-----------|-----------|
| `getUnoUrlServiceStruts()` | URL base do Struts (`/Inicio`) |
| `getUnoUrlService()` | URL absoluta dos serviços GWT |
| `getUnoEmpresa()` / `getUnoColaborador()` | Contexto de sessão |
| `getUnoProgramaGWT()` | Módulo a carregar |
| `unoGWTInitializeGateway()` | Instancia o gateway JS |

## Publicação

O script `scripts/enviar-para-github.ps1` automatiza a republicação do repositório, excluindo caches GWT, classes compiladas e arquivos acima de 90 MB.

O `.gitignore` exclui artefatos de build (`gwt-unitCache/`, `war/WEB-INF/deploy/`, `*.class`, `*.war`, etc.).

## Licença

Este projeto está licenciado sob a [Apache License 2.0](LICENSE).
