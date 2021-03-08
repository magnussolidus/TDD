package financeiro;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.Test;

public class ProcessaPagamento {
	
	public List<Boleto> entrada;
	public Fatura fatura_atual;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Cenário onde o valor total dos boletos é igual ao valor da Fatura
	 */
	@Test
	void somatorioBoletosEquivaleFatura(List<Boleto> lista_boletos, Fatura fatura)
	{
		assertNotNull(lista_boletos);
		assertNotNull(fatura);
		assertNotNull(fatura.valor_total);
		
		float soma_total = 0.0f;
		for (Boleto boleto : lista_boletos) {
			assertNotNull(boleto.valor_pago);
			soma_total += boleto.valor_pago;
		}
		assertEquals(fatura.valor_total, soma_total);
	}

}
