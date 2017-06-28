package br.unicamp.ic.aviacaoverde.controller.strategies;

import br.unicamp.ic.aviacaoverde.model.Aeronave;
import br.unicamp.ic.aviacaoverde.model.AeronaveComPrimeiraClasse;
import br.unicamp.ic.aviacaoverde.model.AeronaveSimples;

/**
 * Created by pegoraroluiz on 6/27/17.
 */
public class FabricaDeAeronaves {

    public static Aeronave criarAeronave() {
        Aeronave aeronave = new Aeronave();
        aeronave.setCapacidadeTotal(30);
        return aeronave;
    }

    public static AeronaveComPrimeiraClasse criarAeronaveComPrimeiraClasse() {
        AeronaveComPrimeiraClasse aeronave = new AeronaveComPrimeiraClasse();
        aeronave.setCapacidadeTotal(40);
        return aeronave;
    }

    public static AeronaveSimples criarAeronaveSimples() {
        return (AeronaveSimples) criarAeronave();
    }
}
