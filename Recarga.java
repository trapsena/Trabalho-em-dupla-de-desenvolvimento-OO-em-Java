import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Recarga {
    private String data;
    private String placa;
    private String eletroposto;
    private String energiaCarregada;

    public Recarga(String placa, String eletroposto, String data, String energiaCarregada) {
        this.placa = placa;
        this.eletroposto = eletroposto;
        this.data = data;
        this.energiaCarregada = energiaCarregada;
    }

    static List<Carro> carros = Main.getCarros();
    
        public String getData() { return data; }
        public String getEnergiaCarregada() { return energiaCarregada; }
        public String getEletroposto() { return eletroposto; }
    
        public static Recarga registrarRecarga(String placa, String eletroposto) { 
    
            Carro carroEncontrado = null;
            for (Carro carro : carros) {
            if (carro.getPlaca().equalsIgnoreCase(placa)) {
                carroEncontrado = carro;
                break;
            }
        }
        
        if (carroEncontrado == null) {
            System.out.println("Carro não encontrado.");
            return null;  
        }

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String data = agora.format(formatter);

        double energia = carroEncontrado.getkWh() - carroEncontrado.getAtualKwh();
        if (energia==0){
            energia = carroEncontrado.getkWh();
        }
        String energiaCarregada = String.format("%.2f", energia);
        carroEncontrado.setAtualKwh(carroEncontrado.getkWh());
        System.out.println("Recarga registrada com sucesso.");

        return new Recarga(placa, eletroposto, data, energiaCarregada);  
    }
}
