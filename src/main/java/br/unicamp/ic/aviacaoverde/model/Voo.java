package br.unicamp.ic.aviacaoverde.model;

import br.unicamp.ic.aviacaoverde.model.Aeronave;
import br.unicamp.ic.aviacaoverde.model.Reserva;
import br.unicamp.ic.aviacaoverde.model.Rota;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Voo {

	private String numero;
	private Aeronave aeronave;
	private Rota rota;
	private List<Reserva> reservas;
	private Stack<Reserva> listaDeEspera;
	private Map<Integer, Integer> idsReservados;
	private Map<Integer, Integer> idsListaEspera;

	public Voo() {
		super();
		reservas = new LinkedList<>();
		listaDeEspera = new Stack<>();
		idsReservados = new HashMap<>();
		idsListaEspera = new HashMap<>();
	}

	public void adicionarParaReservas(Reserva reserva) {
		idsReservados.put(reserva.getPassageiro().getId(), reservas.size());
		reservas.add(reserva);
	}

	public void adicionarParaListaEspera(Reserva reserva) {
		idsReservados.put(reserva.getPassageiro().getId(), listaDeEspera.size());
		listaDeEspera.push(reserva);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Aeronave getAeronave() {
		return aeronave;
	}

	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}

	public Rota getRota() {
		return rota;
	}

	public void setRota(Rota rota) {
		this.rota = rota;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Stack<Reserva> getListaDeEspera() {
		return listaDeEspera;
	}

	public void setListaDeEspera(Stack<Reserva> listaDeEspera) {
		this.listaDeEspera = listaDeEspera;
	}

	public Map<Integer, Integer> getIdsListaEspera() {
		return idsListaEspera;
	}

	public Map<Integer, Integer> getIdsReservados() {
		return idsReservados;
	}
}
