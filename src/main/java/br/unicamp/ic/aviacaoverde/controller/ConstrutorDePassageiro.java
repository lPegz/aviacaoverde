package br.unicamp.ic.aviacaoverde.controller;

import br.unicamp.ic.aviacaoverde.model.Passageiro;

/**
 * Created by pegoraroluiz on 6/15/17.
 */
public class ConstrutorDePassageiro {

    public static Passageiro criarPassageiro(Integer idPassageiro,
                                              String nome) {
        Passageiro passageiro = new Passageiro();
        passageiro.setId(idPassageiro);
        passageiro.setNome(nome);

        return passageiro;
    }
}
