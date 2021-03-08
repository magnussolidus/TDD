package financeiro;

import java.time.LocalDate;
import java.sql.Date;

public class Boleto {
	
	public int id; 
	public String codigo_boleto;
	public Date data;
	public float valor_pago;
	
	public Boleto()
	{
		this.id = -1; // id negativo representa erro/ausência de id
		this.codigo_boleto = null;
		this.data = Date.valueOf(LocalDate.now());
		this.valor_pago = 0.0f;
	}
	
	public Boleto(int id, String cod, Date data, float val)
	{
		this.id = id;
		this.codigo_boleto = cod;
		this.data = data;
		this.valor_pago = val;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getCodigo()
	{
		return this.codigo_boleto;
	}
	
	public Date getData()
	{
		return this.data;
	}
	
	public float getValor()
	{
		return this.valor_pago;
	}
	
	public void setId(int id)
	{
		if(this.id != id)
			this.id = id;
	}
	
	public void setCodigo(String codigo)
	{
		if(this.codigo_boleto != codigo)
			this.codigo_boleto = codigo;
	}
	
	public void setData(Date date)
	{
		if(this.data != date)
			this.data = date;
	}
	
	public void setValor(float val)
	{
		if(this.valor_pago != val)
			this.valor_pago = val;
	}

}
