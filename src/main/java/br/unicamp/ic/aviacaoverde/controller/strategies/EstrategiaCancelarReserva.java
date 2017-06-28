package br.unicamp.ic.aviacaoverde.controller.strategies;

import br.unicamp.ic.aviacaoverde.exceptions.ClasseIncorretaException;
import br.unicamp.ic.aviacaoverde.model.Reserva;
import br.unicamp.ic.aviacaoverde.model.Voo;

/**
 * Created by pegoraroluiz on 6/27/17.
 */
public interface EstrategiaCancelarReserva {
    void cancelarReserva(Voo voo, Reserva reserva) throws ClasseIncorretaException;
}
