package financeiro;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ProcessaPagamento {
	
	public List<Pagamento> pagamentos;
	public List<Fatura> faturas_pagas;
	public List<Fatura> faturas_pendentes;

	public static void main(String[] args) {
		
		Caso1();
		Caso2();
		Caso3();
	}
	
	// Caso de Teste 1 - Valor Fatura = Somatório dos Boletos
	public static void Caso1()
	{
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
	}
	
	// Caso de Teste 2 - Valor Fatura < Somatório dos Boletos
	public static void Caso2()
	{
		Fatura fatura_caso2 = new Fatura();
		List<Boleto> boletos_caso2 = new ArrayList<Boleto>();
		
		fatura_caso2.valor_total = 1500.0f;
		boletos_caso2.add(
				new Boleto(3, "00004", Date.valueOf(LocalDate.now()), 1000.0f)
				);
		boletos_caso2.add(
				new Boleto(4, "00005", Date.valueOf(LocalDate.now()), 500.0f)
				);
		boletos_caso2.add(
				new Boleto(5, "00006", Date.valueOf(LocalDate.now()), 250.0f)
				);
	}
	
	// Caso de Teste 3 - Valor Fatura > Somatório dos Boletos
	public static void Caso3()
	{
		Fatura fatura_caso3 = new Fatura();
		List<Boleto> boletos_caso3 = new ArrayList<Boleto>();
		
		fatura_caso3.valor_total = 2000.0f;
		boletos_caso3.add(
				new Boleto(6, "00007", Date.valueOf(LocalDate.now()), 500.0f)
				);
		boletos_caso3.add(
				new Boleto(7, "00008", Date.valueOf(LocalDate.now()), 400.0f)
				);
	}
	
	/* 
	 * Cenário onde o somatório dos boletos é igual ao valor da Fatura
	 */
	@Test
	void somatorioBoletosEquivaleFatura(List<Boleto> lista_boletos, Fatura fatura)
	{
		assertNotNull(lista_boletos);
		assertNotNull(fatura);
		assertNotNull(fatura.valor_total);
		
		Pagamento atual;
		float soma_total = 0.0f;
		
		for (Boleto boleto : lista_boletos) {
			assertNotNull(boleto.valor_pago);
			assertTrue(boleto.valor_pago > 0);
			
			soma_total += boleto.valor_pago;
			atual = new Pagamento(boleto.valor_pago, Date.valueOf(LocalDate.now()));
			
			assertTrue(pagamentos.contains(atual));
		}
		assertEquals(fatura.valor_total, soma_total);
		faturas_pagas.add(fatura);
		assertTrue(faturas_pagas.contains(fatura));
		
	}
	
	/*
	 * Cenário onde o somatório dos boletos é superior ao valor da Fatura
	 */
	@Test
	void somatorioBoletosMaiorQueFatura(List<Boleto> lista_boletos, Fatura fatura)
	{
		assertNotNull(lista_boletos);
		assertNotNull(fatura);
		assertNotNull(fatura.valor_total);
		
		Pagamento atual;
		float soma_total = 0.0f;
		
		for (Boleto boleto: lista_boletos) {
			assertNotNull(boleto.valor_pago);
			assertTrue(boleto.valor_pago > 0);
			
			soma_total += boleto.valor_pago;
			atual = new Pagamento(boleto.valor_pago, Date.valueOf(LocalDate.now()));
			
			assertTrue(pagamentos.contains(atual));
		}
		
		assertTrue(pagamentos.size() == lista_boletos.size());
		assertTrue(soma_total > fatura.valor_total);
		
		faturas_pagas.add(fatura);
		assertTrue(faturas_pagas.contains(fatura));
	}
	
	/*
	 * Cenário onde o somatório dos boletos é inferior ao valor da fatura
	 */
	@Test
	void somatorioBoletoMenorQueFatura(List<Boleto> lista_boletos, Fatura fatura)
	{
		assertNotNull(lista_boletos);
		assertNotNull(fatura);
		assertNotNull(fatura.valor_total);
		
		Pagamento atual;
		float soma_total = 0.0f;
		
		for (Boleto boleto: lista_boletos) {
			assertNotNull(boleto.valor_pago);
			assertTrue(boleto.valor_pago > 0);
			
			soma_total += boleto.valor_pago;
			atual = new Pagamento(boleto.valor_pago, Date.valueOf(LocalDate.now()));
			
			assertTrue(pagamentos.contains(atual));
		}
		
		assertTrue(pagamentos.size() == lista_boletos.size());
		assertTrue(soma_total < fatura.valor_total);
		
		faturas_pendentes.add(fatura);
		assertTrue(faturas_pagas.contains(fatura));
	}

}
