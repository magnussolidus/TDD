package financeiro;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ProcessaPagamento {
	
	public List<Boleto> entrada;
	public Fatura fatura_atual;

	public static void main(String[] args) {
		// Caso de Teste 1 - Valor Fatura = Somatório dos Boletos
		Fatura fatura_caso1 = new Fatura();
		List<Boleto> boletos_caso1 = new ArrayList<Boleto>();
		
		fatura_caso1.valor_total = 1500.0f;
		boletos_caso1.add(
				new Boleto(0, "00001", Date.valueOf(LocalDate.now()), 500.0f)
				);
		boletos_caso1.add(
				new Boleto(1, "00002", Date.valueOf(LocalDate.now()), 400.0f)
				);
		boletos_caso1.add(
				new Boleto(2, "00003", Date.valueOf(LocalDate.now()), 600.0f)
				);
		// Fim do Caso de Teste 1
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
