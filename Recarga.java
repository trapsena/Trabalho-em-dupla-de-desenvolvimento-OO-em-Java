import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Recarga {
    private LocalDateTime data;
    private String placa;
    private String eletroposto;
    private double energiaCarregada;

    public Recarga(String placa, String eletroposto, LocalDateTime data) {
        this.placa = placa
        this.eletroposto = eletroposto;
        this.data = data
        this.energiaCarregada = energiaCarregada;
        
    }
    

    List<Carro> carros = Main.getCarros();

    public LocalDateTime getData() { return data; }
    public double getEnergiaCarregada() { return energiaCarregada; }
    public String getEletroposto() { return eletroposto; }

    public static void registrarRecarga(String placa, String eletroposto) {

        Carro carroEncontrado = null;
        for (Carro carro : carros) {
            if (carro.getPlaca().equalsIgnoreCase(placa)) {
                carroEncontrado = carro;
                break;
            }
        }

        System.out.print("Digite o nome do eletroposto: ");
        String eletroposto = scanner.nextLine();

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String data = agora.format(formatter);


        double energiaCarregada = carroEncontrado.kWh() - carroEncontrado.getAtualKwh()
        carroEncontrado.setAtualKwh(carroEncontrado.kWh());
        System.out.println("Recarga registrada com sucesso.");
        
        return new Recarga(placa, eletroposto, energiaCarregada, data);

        
        }
      
    }

    
