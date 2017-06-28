package br.unicamp.ic.aviacaoverde.view;

import br.unicamp.ic.aviacaoverde.controller.Menu;
import br.unicamp.ic.aviacaoverde.model.Passageiro;
import br.unicamp.ic.aviacaoverde.model.Reserva;
import br.unicamp.ic.aviacaoverde.model.Rota;
import br.unicamp.ic.aviacaoverde.model.Voo;

import java.util.Scanner;

public class Principal {

	private final Scanner scanner;
	private static Principal instance;
	private int opcao;
	private Menu menu;

	private Principal() {
		super();
		menu = new Menu();
		scanner = new Scanner(System.in);
	}

	public static Principal getInstance() {
		if(instance == null) {
			instance = new Principal();
		}
		return instance;
	}

	public static void main(String[] args) {
		Principal principal = Principal.getInstance();
		principal.iniciarSistema();
	}

	private void iniciarSistema() {
		while (opcao != 4) {
			mostrarMenu();
			opcao = scanner.nextInt();
			executaOperacao();
		}
	}

	private void mostrarMenu() {
		System.out.println("Aviação Verde");
		System.out.println();
		System.out.println("Escolha uma opção");
		System.out.println("1. Reserva");
		System.out.println("2. Consulta de Reservas");
		System.out.println("3. Imprimir");
		System.out.println("4. Encerrar");
	}

	private void executaOperacao() {
		switch (opcao) {
		case 1:
			Integer idPassageiro = solicitarIdPassageiro();
			String numeroVoo = solicitarNumeroVoo();
			String nomePassageiro = solicitarNomePassageiro();
			menu.criarReserva(idPassageiro, nomePassageiro,
					numeroVoo);
			break;
		case 2:
			consultarReserva();
			break;
		case 3:
			menu.imprimir();
			break;
		case 4:
			encerrar();
			break;
		default:
			System.err.println("Operação Inválida!");
			break;
		}
	}

	private void consultarReserva() {
		Integer idPassageiro = solicitarIdPassageiro();
		Reserva reserva = menu.consultaReserva(idPassageiro);
		Rota rota = menu.getRota();

		System.out.println("Dados da reserva:");
		System.out.println("Voo: " + menu.getVoo().getNumero());
		System.out.println("Origem: " + rota.getOrigem().getNomeCidade());
		System.out.println("Destino: " + rota.getDestino().getNomeCidade());

		String escalas = rota.getEscalas().size() > 0 ? Integer.toString(rota.getEscalas().size()) : "Não";
		System.out.println("Escalas: " + escalas);

		Passageiro passageiro = reserva.getPassageiro();
		System.out.println("Id do Passageiro: " + passageiro.getId());
		System.out.println("Nome do Passageiro: " + passageiro.getNome());

		String statusReserva = reserva.isConfirmada() ? "Confirmada" : "Na Lista de Espera";
		System.out.println("Status da Reserva: " + statusReserva);
		System.out.println();
	}


	private void encerrar() {
		System.out.println("Pedidos encerrados.");
		Voo voo = menu.getVoo();
		System.out.println("O voo partiu com " + voo.getReservas().size() + " passageiros");

		boolean lotado = voo.getReservas().size() == voo.getAeronave().getCapacidadeTotal();
		System.out.println("A aeronave estava " + (lotado ? "loatada" : "com assentos desocupados"));
	}

	private Integer solicitarIdPassageiro() {
		System.out.println("Informe o número de identificação do passageiro");
		return scanner.nextInt();
	}

	private String solicitarNumeroVoo() {
		System.out.println("Informe o número do voo");
		return scanner.next();
	}
	private String solicitarNomePassageiro() {
		System.out.println("Informe o nome do passageiro");
		return scanner.next();
	}
}
