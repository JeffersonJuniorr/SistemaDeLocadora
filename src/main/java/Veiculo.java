import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private String modelo;
    private int ano;
    private Double valorDiaria;

    public Veiculo(String modelo, Double valorDiaria, int ano) {
        if (valorDiaria < 0) {
            throw new IllegalArgumentException("O valor da diária não pode ser negativo");
        }
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
    }


    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria < 0) {
            throw new IllegalArgumentException("O valor da diaria não pode ser negativado");
        }
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return modelo + "R$: " + valorDiaria + "Ano: " + ano;
    }
}