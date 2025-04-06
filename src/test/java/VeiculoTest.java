import org.junit.Test;
import static org.junit.Assert.*;

public class VeiculoTest {

    @Test
    public void testeCalcularAluguelSemDesconto() {
        Veiculo veiculo = new Veiculo("Astra", 120.00, 2001);
        assertEquals("Astra", veiculo.getModelo());
        assertEquals(120.00, veiculo.getValorDiaria(), 0.001);
        assertEquals(2001, veiculo.getAno());

        double valorEsperado = 120.00 * 3;
        assertEquals(valorEsperado, Custos.calcularAluguel(veiculo, 3), 0.001);
    }

    @Test
    public void testCalcularAluguelComDesconto() {
        Veiculo v = new Veiculo("Gol", 120.00, 2020);
        double valorEsperado = (120.00 * 7) * 0.9;
        assertEquals(valorEsperado, Custos.calcularAluguel(v, 7), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularAluguelDiasInvalidos() {
        Veiculo veiculo = new Veiculo("Gol", 120.00, 2020);
        Custos.calcularAluguel(veiculo, -2);
    }

    @Test
    public void testCalcularMulta() {
        Veiculo v = new Veiculo("Gol", 120.00, 2020);
        // Multa para 2 dias: 120 * 1.5 * 2 = 360
        double valorEsperado = 120.00 * 1.5 * 2;
        assertEquals(valorEsperado, Custos.calcularMulta(v, 2), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularMultaDiasInvalidos() {
        Veiculo v = new Veiculo("Gol", 120.00, 2020);
        Custos.calcularMulta(v, -1);
    }

    @Test
    public void testCalcularCustoTotal() {
        Veiculo v = new Veiculo("Gol", 120.00, 2020);
        // Aluguel 5 dias: 120 * 5 = 600
        // Multa 2 dias: 120 * 1.5 * 2 = 360
        // Total: 600 + 360 = 960
        double valorEsperado = (120.00 * 5) + (120.00 * 1.5 * 2);
        assertEquals(valorEsperado, Custos.calcularCustoTotal(v, 5, 2), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testVeiculoDiariaNegativa() {
        new Veiculo("Gol", -120.00, 2020);
    }
}