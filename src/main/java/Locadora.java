import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("- - - Locadora de Veículos - - -");

        System.out.println("---Cadastro de Veiculo---");
        System.out.println("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.println("Ano:");
        int ano = scanner.nextInt();

        System.out.println("Valor da diaria:");
        double diaria = scanner.nextDouble();

        Veiculo veiculo = new Veiculo(modelo, diaria, ano);

        System.out.println("---Dados do aluguel---");
        System.out.println("Dias do aluguel:");
        int diasAluguel = scanner.nextInt();

        System.out.println("Dias atrasados(se houver):");
        int diasAtraso = scanner.nextInt();

        double valorAluguel = Custos.calcularAluguel(veiculo, diasAluguel);
        double valorMulta = Custos.calcularMulta(veiculo, diasAluguel);
        double valorTotal = Custos.calcularCustoTotal(veiculo, diasAluguel, diasAtraso);

        System.out.println("\n=== Relatório ===");
        System.out.println(veiculo);
        System.out.printf("Dias alugados: %d%n", diasAluguel);
        System.out.printf("Dias em atraso: %d%n", diasAtraso);
        System.out.printf("Valor do aluguel: R$%.2f%n", valorAluguel);
        System.out.printf("Valor da multa: R$%.2f%n", valorMulta);
        System.out.printf("TOTAL A PAGAR: R$%.2f%n", valorTotal);

        scanner.close();
    }
}