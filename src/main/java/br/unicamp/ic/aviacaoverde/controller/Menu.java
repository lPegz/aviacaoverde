package br.unicamp.ic.aviacaoverde.controller;

import br.unicamp.ic.aviacaoverde.model.Passageiro;
import br.unicamp.ic.aviacaoverde.model.Reserva;
import br.unicamp.ic.aviacaoverde.model.Rota;
import br.unicamp.ic.aviacaoverde.model.Voo;

import java.util.List;

/**
 * Created by pegoraroluiz on 6/15/17.
 */
public class Menu {

    private Voo voo;

    public Menu() {
        voo = ConstrutorDeVoo.criarVoo();
    }

    public void criarReserva(Integer idPassageiro,
                             String nomeDePassageiro,
                             String numeroVoo) {
        if (!validarDados(numeroVoo)) {
            return;
        }
        Passageiro passageiro =
                ConstrutorDePassageiro.criarPassageiro(idPassageiro, nomeDePassageiro);
        Reserva reserva = new Reserva();
        reserva.setPassageiro(passageiro);
        int capacidadeTotal = voo.getAeronave().getCapacidadeTotal();

        if (voo.getReservas().size() < capacidadeTotal) {
            reserva.setConfirmada(true);
            voo.adicionarParaReservas(reserva);
            System.out.println("Reserva efetuada com sucesso!");
        } else {
            voo.adicionarParaListaEspera(reserva);
            System.out.println("Este voo está lotado, a reserva foi adicionada à lista de espera.");
        }
    }

    public Reserva consultaReserva(Integer idPassageiro) {
        ControladorDeVoo controladorDeVoo = new ControladorDeVoo();

        return controladorDeVoo.buscarReserva(idPassageiro, voo);
    }

    public void imprimir() {
        System.out.println("Passageiros do voo " + voo.getNumero() + ":");
        imprimeLista(voo.getReservas(), "Status da Reserva: Confirmada");
        imprimeLista(voo.getListaDeEspera(), "Status da Reserva: Na Lista de Espera");
    }

    private void imprimeLista(List<Reserva> reservaList, String status) {
        for(Reserva reserva : reservaList) {
            System.out.println("Passageiro: " + reserva.getPassageiro().getNome());
            System.out.println(status + "\n");
        }
    }

    private boolean validarDados(String numeroVoo) {
        if (!numeroVoo.equals("AD4032")) {
            System.err.println("Número de voo inválido");
            return false;
        }
        return true;
    }

    public Rota getRota() {
        return voo.getRota();
    }

    public Voo getVoo() {
        return voo;
    }
}
