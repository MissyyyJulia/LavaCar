
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controller.CarroController;
import controller.ConsultorController;
import controller.LavagemController;
import controller.TabelaPrecoController;
import model.entities.Carro;
import model.entities.CarroNovo;
import model.entities.CarroSemiNovo;
import model.entities.Consultor;
import model.entities.Lavagem;
import model.entities.TabelaPreco;
import model.services.CarroService;
import model.services.ConsultorService;
import model.services.LavagemService;
import model.services.TabelaPrecoService;
import view.CarroDTO;
import view.ConsultorDTO;
import view.LavagemDTO;
import view.TabelaPrecoDTO;

public class App {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		boolean menu = true;

		while (menu) {
			System.out.println("Bem-Vindo! Escolha uma opção");
			System.out.println("1- Menu Carros");
			System.out.println("2- Menu Consultores");
			System.out.println("3- Menu Tabela de Preços");
			System.out.println("4- Menu Lavagens");
			System.out.println("0- Sair");
			int opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				menuCarros();
				break;
			case 2:
				menuConsultores();
				break;
			case 3:
				menuTabelaPrecos();
				break;
			case 4:
				menuLavagens();
				break;
			case 0:
				System.out.println("Você escolheu 'Sair'");
				menu = false;
			}

		}
		System.out.println("Sessão encerrada");

	}

	// Submenu Carros
	private static void menuCarros() {

		CarroDTO carroDTO = new CarroDTO();
		CarroController carroController = new CarroController(new CarroService());

		Scanner scanner = new Scanner(System.in);
		boolean submenu = true;

		while (submenu) {
			System.out.println("\n--- Menu Carros ---");
			System.out.println("1. Cadastrar carro");
			System.out.println("2. Listar todos");
			System.out.println("3. Buscar por placa");
			System.out.println("4. Buscar por chassi");
			System.out.println("5. Atualizar");
			System.out.println("6. Excluir");
			System.out.println("0. Voltar");
			System.out.print("Opção: ");
			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				System.out.print("Tipo (NOVO/SEMINOVO): ");
				String tipo = scanner.nextLine();
				carroDTO.setTipo(tipo);

				if ("NOVO".equalsIgnoreCase(carroDTO.getTipo())) {
					System.out.print("Chassi: ");
					carroDTO.setChassi(scanner.nextLine());
				} else {
					System.out.print("Placa: ");
					carroDTO.setPlaca(scanner.nextLine());
				}

				System.out.print("Modelo: ");
				carroDTO.setModelo(scanner.nextLine());

				System.out.print("Cor: ");
				carroDTO.setCor(scanner.nextLine());

				carroController.adicionarCarro(carroDTO);
				break;

			case 2:
			    List<Carro> lista = carroController.findAll();

			    if (lista.isEmpty()) {
			        System.out.println("Nenhum carro cadastrado.");
			    } else {
			        lista.forEach(x -> {
			            System.out.print(x.getId() + " | " + x.getModelo() + " | " + x.getCor());

			            // Se for carro seminovo, imprime placa
			            if (x instanceof CarroSemiNovo) {
			                System.out.print(" | Placa: " + ((CarroSemiNovo) x).getPlaca());
			            } else {
			                System.out.print(" | Placa: -");
			            }

			            // Se for carro novo, imprime chassi
			            if (x instanceof CarroNovo) {
			                System.out.print(" | Chassi: " + ((CarroNovo) x).getChassi());
			            } else {
			                System.out.print(" | Chassi: -");
			            }

			            System.out.println(); // Quebra de linha no final de cada carro
			        });
			    }
			    break;

			case 3:
				System.out.print("Placa: ");
				String placa = scanner.nextLine();
				Carro carroPlaca = carroController.findByPlaca(placa);

				if (carroPlaca == null) {
					System.out.println("Nenhum carro encontrado.");
				} else {
					System.out.println("Modelo: " + carroPlaca.getModelo());
					System.out.println("Cor: " + carroPlaca.getCor());

					if (carroPlaca instanceof CarroSemiNovo) {
						System.out.println("Placa: " + ((CarroSemiNovo) carroPlaca).getPlaca());
						System.out.println("Tipo: SEMINOVO");
					} else {
						System.out.println("O carro encontrado não é do tipo SEMINOVO");
					}
				}
				break;

			case 4:
				System.out.print("Chassi: ");
				String chassi = scanner.nextLine();
				Carro carroChassi = carroController.findByChassi(chassi);

				if (carroChassi == null) {
					System.out.println("Nenhum carro encontrado.");
				} else {
					System.out.println("Modelo: " + carroChassi.getModelo());
					System.out.println("Cor: " + carroChassi.getCor());

					if (carroChassi instanceof CarroNovo) {
						System.out.println("Chassi: " + ((CarroNovo) carroChassi).getChassi());
						System.out.println("Tipo: NOVO");
					} else {
						System.out.println("O carro encontrado não é do tipo NOVO");
					}
				}
				break;

			case 5:
				System.out.print("ID: ");
				Long idAtt = Long.parseLong(scanner.nextLine());
				
				System.out.print("Tipo (NOVO/SEMINOVO): ");
				carroDTO.setTipo(scanner.nextLine());
				System.out.print("Modelo: ");
				carroDTO.setModelo(scanner.nextLine());
				System.out.print("Cor: ");
				carroDTO.setCor(scanner.nextLine());

				if ("NOVO".equalsIgnoreCase(carroDTO.getTipo())) {
					System.out.print("Chassi: ");
					carroDTO.setChassi(scanner.nextLine());
				} else {
					System.out.print("Placa: ");
					carroDTO.setPlaca(scanner.nextLine());
				}

				carroController.atualizarCarro(carroDTO, idAtt);
				break;

			case 6:
				System.out.print("ID: ");
				carroController.excluirCarro(Long.parseLong(scanner.nextLine()));
				break;

			case 0:
				submenu = false;
				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
	}

	// Submenu Consultores
	private static void menuConsultores() {
		ConsultorDTO consultorDTO = new ConsultorDTO();
		ConsultorController consultorController = new ConsultorController(new ConsultorService());

		Scanner scanner = new Scanner(System.in);
		boolean submenu = true;

		while (submenu) {
			System.out.println("\n--- Menu Consultores ---");
			System.out.println("1. Cadastrar");
			System.out.println("2. Listar todos");
			System.out.println("3. Atualizar");
			System.out.println("4. Excluir");
			System.out.println("0. Voltar");
			System.out.print("Opção: ");
			int opcao = scanner.nextInt();
			scanner.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.print("Nome: ");
				consultorDTO.setNome(scanner.nextLine());
				consultorController.adicionarConsultor(consultorDTO);
				System.out.println("Consultor criado com sucesso.");
				break;

			case 2:
				List<Consultor> todos = consultorController.findAll();
				if (todos.isEmpty()) {
					System.out.println("Nenhum consultor cadastrado.");
				} else {
					todos.forEach(x -> System.out.println(x.getId() + " | " + x.getNome()));
				}
				break;

			case 3:
				System.out.print("ID: ");
				Long idAtt = Long.parseLong(scanner.nextLine());
				
				System.out.print("Nome: ");
				consultorDTO.setNome(scanner.nextLine());
				consultorController.atualizarConsultor(consultorDTO, idAtt);
				break;

			case 4:
				System.out.print("ID: ");
				consultorController.excluirConsultor(Long.parseLong(scanner.nextLine()));
				break;

			case 0:
				submenu = false;
				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
	}
	
	// Submenu Tabela de Preços
	private static void menuTabelaPrecos() {
		TabelaPrecoDTO tabelaPrecoDTO = new TabelaPrecoDTO();
		TabelaPrecoController tabelaPrecoController = new TabelaPrecoController(new TabelaPrecoService());

		Scanner scanner = new Scanner(System.in);
		boolean submenu = true;

		while (submenu) {
			System.out.println("\n--- Menu Tabela de Preços ---");
			System.out.println("1. Cadastrar preço");
			System.out.println("2. Listar todos");
			System.out.println("3. Buscar por modelo");
			System.out.println("4. Atualizar");
			System.out.println("5. Excluir");
			System.out.println("0. Voltar");
			System.out.print("Opção: ");
			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				System.out.print("Modelo: ");
				tabelaPrecoDTO.setModelo(scanner.nextLine());

				System.out.print("Preço: ");
				tabelaPrecoDTO.setPreco(Double.parseDouble(scanner.nextLine()));

				tabelaPrecoController.adicionarTabelaPreco(tabelaPrecoDTO);
				break;

			case 2:
				List<TabelaPreco> precos = tabelaPrecoController.findAll();
				if (precos.isEmpty()) {
					System.out.println("Nenhum preço cadastrado.");
				} else {
					precos.forEach(p -> System.out.println(p.getId() + " | " + p.getModelo() + " | R$" + p.getPreco()));
				}
				break;

			case 3:
				System.out.print("Modelo: ");
				String modelo = scanner.nextLine();

				TabelaPreco precoEncontrado = tabelaPrecoController.findByModelo(modelo);
				if (precoEncontrado != null) {
					System.out.println("ID: " + precoEncontrado.getId());
					System.out.println("Modelo: " + precoEncontrado.getModelo());
					System.out.println("Preço: R$" + precoEncontrado.getPreco());
				} else {
					System.out.println("Modelo não encontrado.");
				}
				break;

			case 4:
				System.out.print("ID: ");
				Long idAtt = Long.parseLong(scanner.nextLine());

				System.out.print("Modelo: ");
				tabelaPrecoDTO.setModelo(scanner.nextLine());

				System.out.print("Preço: ");
				tabelaPrecoDTO.setPreco(Double.parseDouble(scanner.nextLine()));

				tabelaPrecoController.atualizarTabelaPreco(tabelaPrecoDTO, idAtt);
				break;

			case 5:
				System.out.print("ID: ");
				tabelaPrecoController.excluirTabelaPreco(scanner.nextLong());
				break;

			case 0:
				submenu = false;
				break;

			default:
				System.out.println("Opção inválida!");
			}
		}
	}

	// Submenu Lavagens
	private static void menuLavagens() {
		LavagemDTO lavagemDTO = new LavagemDTO();
		LavagemController lavagemController = new LavagemController(new LavagemService());

		Scanner scanner = new Scanner(System.in);
		boolean submenu = true;

		while (submenu) {
			System.out.println("\n--- Menu Lavagens ---");
			System.out.println("1. Cadastrar");
			System.out.println("2. Listar todas");
			System.out.println("3. Buscar por consultor");
			System.out.println("4. Atualizar");
			System.out.println("5. Excluir");
			System.out.println("0. Voltar");
			System.out.print("Opção: ");
			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				System.out.print("Data (YYYY-MM-DD): ");
				try {
					lavagemDTO.setData(LocalDate.parse(scanner.nextLine()));
					System.out.print("Ordem serviço: ");
					lavagemDTO.setOrdemServico(scanner.nextLine());
					System.out.print("Tipo carro (NOVO/SEMINOVO): ");
					lavagemDTO.setTipoCarro(scanner.nextLine());
					System.out.print("Identificador: ");
					lavagemDTO.setIdentificador(scanner.nextLine());
					System.out.print("Nome consultor: ");
					lavagemDTO.setNomeConsultor(scanner.nextLine());
					Lavagem n = lavagemController.adicionarLavagem(lavagemDTO);
					if (n == null) {
						System.out.println("Erro ao cadastrar lavagem. Verifique os dados informados.");
					}
				} catch (Exception e) {
					System.out.println("Data inválida ou erro inesperado: " + e.getMessage());
				}
				break;
			case 2:
				List<Lavagem> tudo = lavagemController.findAll();
				if (tudo.isEmpty()) {
					System.out.println("Nenhuma lavagem cadastrada.");
				} else {
					tudo.forEach(
						x -> System.out.println(x.getId() + " | " + x.getData() + " | " + x.getOrdemServico() + " | " + x.getConsultor() + "|" + x.getValor()));
				}
				break;
			case 3:
			    System.out.print("ID Consultor: ");

			    List<Lavagem> lavagens = lavagemController.findByConsultorId(Long.parseLong(scanner.nextLine()));

			    if (lavagens.isEmpty()) {
			        System.out.println("Nenhuma lavagem para esse consultor.");
			    } else {
			        lavagens.forEach(x -> {
			            System.out.print(x.getId() + " | " + x.getData() + " | OS:" + x.getOrdemServico() + " | ");
			            System.out.print("Modelo: " + x.getCarro().getModelo() + "| Cor: " + x.getCarro().getCor());

			            if (x.getCarro() instanceof CarroNovo) {
			                CarroNovo c = (CarroNovo) x.getCarro();
			                System.out.println("| Chassi: " + c.getChassi());
			            } else if (x.getCarro() instanceof CarroSemiNovo) {
			                CarroSemiNovo c = (CarroSemiNovo) x.getCarro();
			                System.out.println("| Placa: " + c.getPlaca());
			            } else {
			                System.out.println("| Identificador desconhecido");
			            }
			        });
			    }
			    break;
			case 4: 
				System.out.print("ID: ");
				Long idAtt = Long.parseLong(scanner.nextLine());
				System.out.print("Nova ordem de serviço: ");
				lavagemDTO.setOrdemServico(scanner.nextLine());
				lavagemController.atualizarLavagem(lavagemDTO, idAtt);
				break;
			case 5: 
				System.out.print("ID: ");
				lavagemController.excluirLavagem(Long.parseLong(scanner.nextLine()));
				break;
			case 0:
				submenu = false;
				break;
			default:
				System.out.println("Opção inválida!");
			}
		}
	}
}
