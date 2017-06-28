package br.unicamp.ic.aviacaoverde.controller;

import br.unicamp.ic.aviacaoverde.model.Reserva;
import br.unicamp.ic.aviacaoverde.model.Voo;

import java.util.Map;

/**
 * Created by pegoraroluiz on 6/15/17.
 */
public class ControladorDeReserva {

    public Reserva buscarReserva(Integer idPassageiro, Voo voo) {
        if (!existeReserva(idPassageiro, voo)) {
            System.err.println("Não existe uma reserva para esse passageiro neste voo");
            return null;
        }
        if (existeReserva(idPassageiro, voo)) {
            System.err.println("Já existe uma reserva para esse passageiro neste voo");
            return null;
        }
        Reserva reserva;
        Map<Integer, Integer> idsReservados = voo.getIdsReservados();
        Map<Integer, Integer> idsListaEspera = voo.getIdsListaEspera();
        if (idsReservados.containsKey(idPassageiro)) {
            int index = idsReservados.get(idPassageiro);
            reserva = voo.getReservas().get(index);
        } else {
            int index = idsListaEspera.get(idPassageiro);
            reserva = voo.getListaDeEspera().get(index);
        }
        return reserva;
    }

    public boolean existeReserva(Integer idPassageiro, Voo voo) {
        return voo.getIdsReservados().containsKey(idPassageiro) ||
                voo.getIdsListaEspera().containsKey(idPassageiro);
    }
}
