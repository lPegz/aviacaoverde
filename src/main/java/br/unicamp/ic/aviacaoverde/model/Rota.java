package br.unicamp.ic.aviacaoverde.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Rota {

	private Aeroporto origem;
	private Aeroporto destino;
	private List<Aeroporto> escalas;

	public Rota() {
		super();
		escalas = new ArrayList<>();
	}


}
