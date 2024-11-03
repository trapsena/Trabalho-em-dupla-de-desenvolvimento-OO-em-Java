import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Eletroposto {
    private static List<Eletroposto> eletropostos = new ArrayList<>();
    private int id;
    private String local;
    private int vagas;
    private int carregamento;

    // Construtor
    public Eletroposto(int id, String local, int vagas, int carregamento) {
        this.id = id;
        this.local = local;
        this.vagas = vagas;
        this.carregamento = carregamento;
    }

    // Getters
    public int getId() { return id; }
    public String getLocal() { return local; }
    public int getVagas() { return vagas; }
    public int getCarregamento() { return carregamento; }

    public static Eletroposto registrarEletroposto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do eletroposto: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

        System.out.print("Digite o local do eletroposto: ");
        String local = scanner.nextLine();

        System.out.print("Digite o número de vagas do eletroposto: ");
        int vagas = scanner.nextInt();

        System.out.print("Digite as horas de carregamento do eletroposto: ");
        int horasCarregamento = scanner.nextInt();

        System.out.println("Eletroposto registrado com sucesso.");
        return new Eletroposto(id, local, vagas, horasCarregamento);
    }

    public static String validarPostos() {
        Scanner scanner = new Scanner(System.in);

        String posto = null;
        List<Eletroposto> eletropostos = Main.getEletropostos();
        // Loop para garantir que o usuário insira um veículo válido
        while (posto == null) {
            System.out.print("Digite a placa do veículo: ");
            String temp = scanner.nextLine();

            // Busca o carro na lista
            for (Eletroposto eletroposto : eletropostos) {
                if (String.valueOf(eletroposto.getId()).equalsIgnoreCase(temp)) {
                    posto = String.valueOf(eletroposto.getId());
                    break;
                }
            }

            if (posto == null) {
                System.out.println("Veículo não encontrado. Tente novamente.");
            }
        }
        return posto;
    }

}

