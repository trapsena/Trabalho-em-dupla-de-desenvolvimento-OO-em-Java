import java.util.Scanner;

public class Carro {
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String ano;
    protected double kWh; //maximo de energia do carro
    protected double atualKM;
    protected double atualKwh; //energia atual do carro
    protected double maxKM;

    public Carro(String ano, String modelo, String marca, String placa,double atualKM, double kWh, double atualKwh,double maxKM) {
        this.ano = ano;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.atualKM = atualKM;
        this.kWh = kWh;
        this.atualKwh = atualKwh;
        this.maxKM= maxKM;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getAno() { return ano; }
    public String getPlaca() { return placa; }
    public double getkWh() { return kWh; }
    public double getAtualKM() { return atualKM; }
    public double getAtualKwh() { return atualKwh; }
    public double getmaxKM() { return maxKM; }
    public void setAtualKM(double atualKM) { this.atualKM = atualKM; }
    public void setAtualKwh(double atualKwh) { this.atualKwh = atualKwh; }

    public static Carro criarCarro() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a placa do carro: ");
        String placa = scanner.nextLine();
        
        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();
        
        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();
        
        System.out.print("Digite o ano do carro: ");
        String ano = scanner.nextLine();

        System.out.print("Digite a capacidade máxima de km do carro: ");
        double atualKM = scanner.nextDouble();
        double maxKM = atualKM;

        System.out.print("Digite a capacidade de bateria do carro: ");
        double kWh = scanner.nextDouble();
        double atualKwh = kWh;

        Carro carro;
        if (atualKM <= 200) {
            carro = new Compacto(ano, modelo, marca, placa,atualKM, kWh, atualKwh, maxKM);
            System.out.println("Carro classificado como Compacto.");
        } else if (atualKM <= 400) {
            carro = new Sedan(ano, modelo, marca, placa,atualKM, kWh, atualKwh, maxKM);
            System.out.println("Carro classificado como Sedan.");
        } else {
            carro = new Suv(ano, modelo, marca, placa,atualKM, kWh, atualKwh, maxKM);
            System.out.println("Carro classificado como SUV.");
        }

        System.out.println("Carro criado: " + carro.getModelo() + " - " + carro.getMarca()  + ", Placa: " + carro.getPlaca() + ", Ano: " + carro.getAno());
        System.out.println("Horas de bateria: " + carro.getkWh() + ", Máxima KM: " + carro.getmaxKM());

        return carro;
    }
}
