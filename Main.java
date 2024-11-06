import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Carro> carros = new ArrayList<>();
    private static List<Motorista> motoristas = new ArrayList<>();
    private static List<Eletroposto> eletropostos = new ArrayList<>();
    private static List<Viagem> viagens = new ArrayList<>();
    private static List<Recarga> historicoRecargas = new ArrayList<>();
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        boolean loop = true;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Registrar Carro");
            System.out.println("2 - Remover Carro");
            System.out.println("3 - Listar Todos os Carros");
            System.out.println("4 - Registrar Motirista");
            System.out.println("5 - Listar motoristas");
            System.out.println("6 - Registrar Elotoposto");
            System.out.println("7 - Listar os Eletropostos");
            System.out.println("8 - Registrar Viagens");
            System.out.println("9 - Listar Viagens");
            System.out.println("10 - Listar Carros com baixa Bateria");
            System.out.println("11 - Listar historico de carregamento");
            System.out.println("12 - Registrar Recarga");
            System.out.println("99 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    Carro carro = Carro.criarCarro();
                    carros.add(carro);
                    System.out.println("Carro adicionado à lista.");
                }

                case 2 -> removerCarro();

                case 3 -> listarCarros();

                case 4 -> {
                    Motorista motorista = Motorista.criarMotorista();
                    motoristas.add(motorista);
                    System.out.println("Motorista adicionado à lista.");
                }
                
                case 5 -> listarMotoristas();

                case 6 -> {
                    Eletroposto eletroposto = Eletroposto.registrarEletroposto();
                    eletropostos.add(eletroposto);
                    System.out.println("Eletroposto adicionado à lista.");
                }

                case 7 -> listarEletropostos();

                case 8 -> registrarViagens();

                case 9 -> listarViagens();

                case 10 -> BateriaBaixa();

                case 11 -> consultarHistoricoCarga();

                case 12 -> registrarRecarga();


                case 99 -> {
                    System.out.println("Saindo do sistema.");
                    loop = false;
                }
                
                
                    
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (loop);
        scanner.close();
        
    }

    static List<Carro> getCarros() { return carros; }
    static List<Motorista> getMotoristas() { return motoristas; }
    static List<Eletroposto> getEletropostos() { return eletropostos; }


    public static void removerCarro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a placa do carro a ser removido: ");
        String placa = scanner.nextLine();

        Carro carroARemover = null;
        for (Carro carro : carros) {
            if (carro.getPlaca().equalsIgnoreCase(placa)) {
                carroARemover = carro;
                break;
            }
        }

        if (carroARemover != null) {
            carros.remove(carroARemover);
            System.out.println("Carro removido com sucesso.");
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    public static void listarCarros() {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            System.out.println("\nLista de carros cadastrados:");
            for (Carro c : carros) {
                System.out.println(c.getModelo() + " - " + c.getMarca() + "/ Ano: " + c.getAno() + "/ Placa: " + c.getPlaca() +
                        "/ Horas de bateria: " + c.getkWh() + "/ Máxima KM: " + c.getmaxKM());
            }
        }
    }

    public static void listarMotoristas() {
        if (motoristas.isEmpty()) {
            System.out.println("Nenhum motorista cadastrado.");
        } else {
            System.out.println("\nLista de motoristas cadastrados:");
            for (Motorista m : motoristas) {
                System.out.println("Nome: " + m.getNome() + "/ Identificação: " + m.getnIdentific() +
                        "/ Habilitação: " + m.getnHabilitacao() + "/ Experiência: " + getXpDescricao(m.getxp()));
            }
        }
    }

    // Método auxiliar para descrever o nível de experiência
    public static String getXpDescricao(int xp) {
        return switch (xp) {
            case 0 ->  "Iniciante";
            case 1 -> "Intermediário";
            case 2 -> "Avançado";
            default -> "Desconhecido";
        };
    }

    public static void listarEletropostos() {
        if (eletropostos.isEmpty()) {
            System.out.println("Nenhum eletroposto cadastrado.");
        } else {
            System.out.println("\nLista de Eletropostos cadastrados:");
            for (Eletroposto e : eletropostos) {
                System.out.println("ID: " + e.getId() + "/ Local: " + e.getLocal() +
                        "/ Vagas: " + e.getVagas() + "/ Horas de Carregamento: " + e.getCarregamento());
            }
        }
    }

    public static void registrarViagens(){ 
        if (motoristas.isEmpty() || carros.isEmpty() || eletropostos.isEmpty()){
            System.out.println("Um dos requerimentos de viagem está faltando.");
        } else {
            Viagem viagem = Viagem.registrarViagem();
            viagens.add(viagem);
        }
    }       


    public static void BateriaBaixa() {
            for (Carro carro : carros) {
                double energiaPorcent = (carro.getAtualKwh() * 100) / carro.getkWh();
                if (energiaPorcent <= 20) {
                    System.out.println("Carro com baixa energia:");
                    System.out.println("Placa: " + carro.getPlaca());
                    System.out.println("Marca: " + carro.getMarca());
                    System.out.println("Modelo: " + carro.getModelo());
                    System.out.println("Ano: " + carro.getAno());
                    System.out.println("Energia atual: " + energiaPorcent + "%");
                    System.out.println("------------------------");
                }
            }
        
        }
        public static void listarViagens() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o número de identificação do motorista para listar suas viagens: ");
            int nIdentific = scanner.nextInt();
    
            boolean encontrou = false;
    
            for (Viagem viagem : viagens) {
                if (viagem.getNome() == nIdentific) {
                    System.out.println("Local: " + viagem.getLocal() + ", Distância: " + viagem.getDistancia() +
                                       " km, Consumo: " + viagem.getConsumo() + " kWh, Veículo: " + viagem.getVeiculo() +
                                       ", Eletroposto: " + viagem.getEletroposto());
                    encontrou = true;
                }
            }
    
            if (!encontrou) {
                System.out.println("Nenhuma viagem encontrada para o motorista com identificação " + nIdentific);
            }
        }

        public static void consultarHistoricoCarga() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a placa do carro para consultar o histórico de recargas: ");
            String placa = scanner.nextLine();
    
            Carro encontrado = null;
    
            // Procura o carro na lista pela placa
            for (Carro carro : carros) {
                if (carro.getPlaca().equalsIgnoreCase(placa)) {
                    encontrado = carro;
                    break;
                }
            }
    
            // Se o carro foi encontrado, exibe o histórico de recargas
            if (encontrado != null) {
                System.out.println("Histórico de recargas para o carro com placa " + placa + ":");
                if (historicoRecargas.isEmpty()) {
                    System.out.println("Nenhuma recarga registrada.");
                    return;
                }
                for (Recarga recarga : historicoRecargas) {
                    System.out.println("Data: " + recarga.getData() +
                                       ", Energia Carregada: " + recarga.getEnergiaCarregada() +
                                       " kWh, Eletroposto: " + recarga.getEletroposto());
                }
            } else {
                System.out.println("Carro com a placa " + placa + " não encontrado.");
            }
        }

        public static void registrarRecarga() {
        






