package br.unicamp.ic.aviacaoverde.controller;

import br.unicamp.ic.aviacaoverde.model.Aeroporto;
import br.unicamp.ic.aviacaoverde.model.Rota;
import br.unicamp.ic.aviacaoverde.model.Voo;

import static br.unicamp.ic.aviacaoverde.controller.strategies.FabricaDeAeronaves.criarAeronave;

/**
 * Created by pegoraroluiz on 6/15/17.
 */
public class FabricaDeVoo {

    public static Voo criarVoo() {
        Voo voo = new Voo();
        voo.setNumero("AD4032");
        voo.setAeronave(criarAeronave());
        voo.setRota(criarRota());
        return voo;
    }



    private static Rota criarRota() {
        Rota rota = new Rota();
        rota.setOrigem(criarAeroporto("Campinas"));
        rota.setDestino(criarAeroporto("Campo Grande"));
        return rota;
    }

    private static Aeroporto criarAeroporto(String nomeCidade) {
        Aeroporto aeroporto = new Aeroporto();
        aeroporto.setNomeCidade(nomeCidade);
        return aeroporto;
    }
}
