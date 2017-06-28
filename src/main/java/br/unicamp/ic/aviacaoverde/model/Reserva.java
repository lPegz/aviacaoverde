package br.unicamp.ic.aviacaoverde.model;

import br.unicamp.ic.aviacaoverde.model.enums.Classe;
import br.unicamp.ic.aviacaoverde.model.enums.EstadoDaReserva;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reserva {

	private Passageiro passageiro;
	private Classe classe;
	private EstadoDaReserva estado;
	private boolean confirmada;

}
