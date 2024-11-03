import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeCarros {
    private List<Carro> carros = new ArrayList<>();


    // Adiciona um carro à lista
    public void adicionarCarro(Carro carro) {
        carros.add(carro);
        System.out.println("Carro adicionado à lista.");
    }

    // Remove um carro da lista com base na placa
    public void removerCarro() {
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

    // Lista todos os carros na lista
    public void listarCarros() {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            System.out.println("\nLista de carros cadastrados:");
            for (Carro c : carros) {
                System.out.println(c.getModelo() + " - " + c.getMarca() + ", Ano: " + c.getAno() + ", Placa: " + c.getPlaca() +
                        ", Horas de bateria: " + c.getAtualKwh() + ", Máxima KM: " + c.getmaxKM());
            }
        }
    }

        
}

