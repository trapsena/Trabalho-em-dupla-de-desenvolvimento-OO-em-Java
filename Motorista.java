import java.util.Scanner;

public class Motorista{

    private String nome;
    private int nIdentific;
    private String nHabilitacao;
    private int xp; // 0 = iniciante, 1 = intermediário, 2 = avançado


    // Construtor
    public Motorista(String nome, int nIdentific, String nHabilitacao, int xp) {
        this.nome = nome;
        this.nIdentific = nIdentific;
        this.nHabilitacao = nHabilitacao;
        this.xp=xp;
    }
    // Getters e Setter
    public String getNome() { return nome; }
    public int getnIdentific() { return nIdentific; }
    public String getnHabilitacao() { return nHabilitacao; }
    public int getxp() { return xp; }
    

    public static Motorista criarMotorista() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o nome do motorista: ");
    String nome = scanner.nextLine();

    System.out.print("Digite o número de identificação do motorista: ");
    int nIdentific = scanner.nextInt();
    scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

    System.out.print("Digite o número da habilitação do motorista: ");
    String nHabilitacao = scanner.nextLine();

    int xp;
    do {
        System.out.print("Digite o nível de experiência do motorista \n|0 = iniciante| |1 = intermediário| |2 = avançado|\n- ");
        xp = scanner.nextInt();
        if (xp < 0 || xp > 2) {
            System.out.println("Nível inválido. Insira um valor entre 0 e 2.");
        }
    } while (xp < 0 || xp > 2);

    Motorista motorista = new Motorista(nome, nIdentific, nHabilitacao, xp);

    System.out.println("Motorista criado: " + motorista.getNome() + "\n Identificação: " + motorista.getnIdentific() +
            "\n Habilitação: " + motorista.getnHabilitacao() + "\n Experiência: " + motorista.getxp());

    return motorista;
}



}