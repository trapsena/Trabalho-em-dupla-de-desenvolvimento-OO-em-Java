import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Recarga {
    private LocalDateTime data;
    private double energiaCarregada;
    private String eletroposto;
;   private static List<Recarga> historicoRecargas = new ArrayList<>();

    public Recarga(double energiaCarregada, String eletroposto) {
        this.data = LocalDateTime.now();
        this.energiaCarregada = energiaCarregada;
        this.eletroposto = eletroposto;
    }
    

    List<Carro> carros = Main.getCarros();

    public LocalDateTime getData() { return data; }
    public double getEnergiaCarregada() { return energiaCarregada; }
    public String getEletroposto() { return eletroposto; }

    public static void registrarRecarga(double energiaCarregada, String eletroposto, Carro carro) {
        if (energiaCarregada <= 0 || (carro.getAtualKwh() + energiaCarregada) > carro.getkWh()) {
            System.out.println("Energia de recarga inválida.");
            return;
        }

        carro.setAtualKwh(carro.getAtualKwh() + energiaCarregada);
        historicoRecargas.add(new Recarga(energiaCarregada, eletroposto));
        System.out.println("Recarga registrada com sucesso.");
    }
}