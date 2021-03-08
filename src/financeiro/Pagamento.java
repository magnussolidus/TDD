package financeiro;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import org.junit.Test;

public class Pagamento {
	
	public enum TipoPagamento
	{
		BOLETO,
		OUTRO
	}
	
	public float valor_pago;
	public Date data;
	public TipoPagamento tipo;
	
	public Pagamento(float valor, Date date)
	{
		this.valor_pago = valor;
		this.data = date;
		this.tipo = TipoPagamento.BOLETO;
	}
	
	@Test
	void hasValue(float valor_pago)
	{
		assertNotNull(valor_pago);
	}
	
	@Test
	void hasDate(Date data)
	{
		assertNotNull(data);
		assertTrue(data.getClass() == Date.class);
	}
	
	@Test
	void hasPaymentType(TipoPagamento tipo)
	{
		assertNotNull(tipo);
		assertEquals(tipo, TipoPagamento.BOLETO);
	}
	
	public float getValor()
	{
		return this.valor_pago;
	}
	
	public Date getData()
	{
		return this.data;
	}
	
	public TipoPagamento getTipoPagamento()
	{
		return this.tipo;
	}

	public void setValor(float val)
	{
		if(this.valor_pago != val)
			this.valor_pago = val;
	}
	
	public void setData(Date date)
	{
		if(this.data != date)
			this.data = date;
	}
	
	public void setTipoPagamento(TipoPagamento type)
	{
		if(this.tipo != type)
			this.tipo = type;
	}
}
