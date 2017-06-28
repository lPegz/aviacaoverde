package br.unicamp.ic.aviacaoverde.controller.strategies;

import br.unicamp.ic.aviacaoverde.exceptions.ClasseIncorretaException;
import br.unicamp.ic.aviacaoverde.model.Reserva;
import br.unicamp.ic.aviacaoverde.model.Voo;
import br.unicamp.ic.aviacaoverde.model.enums.Classe;
import br.unicamp.ic.aviacaoverde.model.enums.EstadoDaReserva;

/**
 * Created by pegoraroluiz on 6/27/17.
 */
public class EstategiaCancelarEconomica implements EstrategiaCancelarReserva {

    @Override
    public void cancelarReserva(Voo voo, Reserva reserva) throws ClasseIncorretaException {
        if(Classe.ECONOMICA.equals(reserva.getClasse())) {
            reserva.setEstado(EstadoDaReserva.CANCELADA);
        } else {
            throw new ClasseIncorretaException();
        }
    }
}
