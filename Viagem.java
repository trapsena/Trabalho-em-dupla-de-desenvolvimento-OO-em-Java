import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Viagem para armazenar informações da viagem
public class Viagem {

    private int nome;
    private String local;
    private double distanciaKM;
    private double consumoKWh;
    private String veiculo;
    private String eletroposto;
    private static ArrayList<Viagem> viagens = new ArrayList<>();
    private double rota;
    private double sobra;

    private static double atualKM;
    private static double atualKwh;
    // Outras listas e métodos




    // Construtor
    public Viagem(int nome, String local, double distanciaKM, double consumoKWh, String veiculo, String eletroposto) {
        this.nome = nome;
        this.local = local;
        this.distanciaKM = distanciaKM;
        this.consumoKWh = consumoKWh;
        this.veiculo = veiculo;
        this.eletroposto = eletroposto;
    } 

    // Getters
    public String getLocal() { return local; }
    public double  getDistancia() { return distanciaKM; }
    public double getConsumo() { return consumoKWh; }
    public String getVeiculo() { return veiculo; }
    public String getEletroposto() { return eletroposto; }
    public int getNome() { return nome; }
    


    // Método para registrar uma nova viagem
    
    public static Viagem registrarViagem(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o local da viagem: ");
        String local = scanner.nextLine();

        System.out.print("Digite a distância em km: ");
        double distanciaKM = scanner.nextDouble();


        
        Motorista nome = null;
        List<Motorista> motoristas = Main.getMotoristas();

        while (nome == null) { 
            System.out.print("Digite o nome do Motorista: ");
            String tempor = scanner.nextLine();

            for (Motorista motorista : motoristas) {
                if (motorista.getNome().equalsIgnoreCase(tempor)){
                    nome = motorista;
                    System.out.println("Motorista Valido para Registro!");
                    break;
                }
            }
            
            if (nome == null) {
                System.out.println("Matorista não encontrado. Tente novamente");
            }
        }

       // Variável para armazenar o veículo
        Carro veiculo = null;
        List<Carro> carros = Main.getCarros();
        // Loop para garantir que o usuário insira um veículo válido
        while (veiculo == null) {
            System.out.print("Digite a placa do veículo: ");
            String temp = scanner.nextLine();

            // Busca o carro na lista
            for (Carro carro : carros) {
                if (carro.getPlaca().equalsIgnoreCase(temp)) {
                    veiculo = carro;
                    break;
                }
            }

            if (veiculo == null) {
                System.out.println("Veículo não encontrado. Tente novamente.");
            }
        }

        String eletroposto = "Nenhum";
        String ultimoPosto = "";
        double rota = veiculo.getmaxKM() - distanciaKM;
        do { 
            if (rota < 1){
                ultimoPosto = Eletroposto.validarPostos()
                if ("Nenhum".equals(eletroposto)){
                    eletroposto = ultimoPosto;
                }else{
                    eletroposto = eletroposto + "-" +  ultimoPosto;
                    Recarga.registrarRecarga(energiaNecessaria, eletroposto, veiculo);
                }
                //Preciso fazer recarga
                if (rota < 0){
                    rota = veiculo.getmaxKM() + rota;
                }
            }
        } while (rota < 0);

        double energiaPorcent = (veiculo.getAtualKwh() * 100)/ veiculo.getkWh();
        double energia = (rota * energiaPorcent) / veiculo.getmaxKM();
        double consumoKWh = energia;

        veiculo.setAtualKwh((veiculo.getkWh() * energia) / 100);
        veiculo.setAtualKM(rota);


        System.out.println("Valores do carro atualizados!");

        

        // Retornar a nova instância de 'Viagem'
        return new Viagem(nome.getnIdentific(), local, distanciaKM, consumoKWh, veiculo.getPlaca(), eletroposto);
    }
}
    
