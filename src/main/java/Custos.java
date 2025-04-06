public class Custos {
    public static double calcularAluguel(Veiculo veiculo, int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("Dias de aluguel devem ser positivos");
        }

        double valorBase = veiculo.getValorDiaria() * dias;

        // Aplica desconto de 10% para 7 dias ou mais
        if (dias >= 7) {
            return valorBase * 0.9;
        }
        return valorBase;
    }

    public static double calcularMulta(Veiculo veiculo, int diasAtraso) {
        if (diasAtraso < 0) {
            throw new IllegalArgumentException("Dias de atraso não podem ser negativos");
        }
        return veiculo.getValorDiaria() * diasAtraso * 1.5;
    }

    public static double calcularCustoTotal(Veiculo veiculo, int diasAluguel, int diasAtraso) {
        double aluguel = calcularAluguel(veiculo, diasAluguel);
        double multa = calcularMulta(veiculo, diasAtraso);
        return aluguel + multa;
    }
}