package br.unicamp.ic.aviacaoverde.controller;

import br.unicamp.ic.aviacaoverde.model.Passageiro;

/**
 * Created by pegoraroluiz on 6/15/17.
 */
public class ConstrutorDePassageiro {

    private static Passageiro instance;

    public static Passageiro criarPassageiro(Integer idPassageiro,
                                              String nome) {
        if(instance == null) {
            instance = new Passageiro();
            instance .setId(idPassageiro);
            instance .setNome(nome);
        }
        return instance;
    }
}
