package br.unicamp.ic.aviacaoverde.model;

import br.unicamp.ic.aviacaoverde.model.enums.EstadoDoVoo;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
public class Voo {

	private String numero;
	private Aeronave aeronave;
	private Rota rota;
	private EstadoDoVoo estadoDoVoo;
	private List<Reserva> reservas;
	private Stack<Reserva> listaDeEspera;
	private Map<Integer, Integer> idsReservados;
	private Map<Integer, Integer> idsListaEspera;

	public Voo() {
		super();
		reservas = new LinkedList<>();
		estadoDoVoo = EstadoDoVoo.ABERTO;
		listaDeEspera = new Stack<>();
		idsReservados = new HashMap<>();
		idsListaEspera = new HashMap<>();
	}

	public void adicionarParaReservas(Reserva reserva) {
		if(EstadoDoVoo.ABERTO.equals(estadoDoVoo)) {
			idsReservados.put(reserva.getPassageiro().getId(), reservas.size());
			reservas.add(reserva);
			if(reservas.size() == aeronave.getCapacidadeTotal()) {
				setEstadoDoVoo(EstadoDoVoo.FULL);
			}
		} else {
			adicionarParaListaEspera(reserva);
		}
	}

	public void adicionarParaListaEspera(Reserva reserva) {
		idsReservados.put(reserva.getPassageiro().getId(), listaDeEspera.size());
		listaDeEspera.push(reserva);
	}

}
