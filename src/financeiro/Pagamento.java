package financeiro;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import org.junit.Test;

public class Pagamento {
	
	@Test
	void hasValue(float valor_pago)
	{
		assertNotNull(valor_pago);
	}
	
	@Test
	void hasDate(Date data)
	{
		assertNotNull(data);
	}
	
	@Test
	void hasPaymentType(TipoPagamento tipo)
	{
		assertNotNull(tipo);
		assertEquals(tipo, TipoPagamento.BOLETO);
	}

}
