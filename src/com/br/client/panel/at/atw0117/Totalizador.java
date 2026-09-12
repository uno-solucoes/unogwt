package com.br.client.panel.at.atw0117;

import java.util.ArrayList;

import com.br.client.model.at.entity.eTouchAgenda;

public class Totalizador {
	
	private int reserva 	= 0;
	private int confirmado 	= 0;
	private int semSituacao = 0;

	ArrayList<eTouchAgenda> agendas = new ArrayList<eTouchAgenda>();

	/**
	 * @return the reserva
	 */
	public int getReserva() {
		return reserva;
	}
	/**
	 * @param reserva the reserva to set
	 */
	public void setReserva(int reserva) {
		this.reserva = reserva;
	}
	/**
	 * @return the confirmado
	 */
	public int getConfirmado() {
		return confirmado;
	}
	/**
	 * @param confirmado the confirmado to set
	 */
	public void setConfirmado(int confirmado) {
		this.confirmado = confirmado;
	}
	/**
	 * @return the semSituacao
	 */
	public int getSemSituacao() {
		return semSituacao;
	}
	/**
	 * @param semSituacao the semSituacao to set
	 */
	public void setSemSituacao(int semSituacao) {
		this.semSituacao = semSituacao;
	}
	/**
	 * @return the agendas
	 */
	public ArrayList<eTouchAgenda> getAgendas() {
		return agendas;
	}
	/**
	 * @param agendas the agendas to set
	 */
	public void setAgendas(ArrayList<eTouchAgenda> agendas) {
		this.agendas = agendas;
	}

	public void configureAgendaDia(){
		
	}
 
}
