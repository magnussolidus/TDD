package financeiro;

import java.util.Random;
import java.time.LocalDate;
import java.sql.Date;

public class Fatura {
	
	public int id_fatura; 
	public Date data;
	public float valor_total;
	public String nome_cliente;

	public Fatura(int id, Date date, float value, String client)
	{
		id_fatura = id;
		data = date;
		valor_total = value;
		nome_cliente = client;
	}
	
	public Fatura()
	{
		Random rnd = new Random();
		id_fatura = rnd.nextInt();
		data = Date.valueOf(LocalDate.now());
		nome_cliente = "Desconhecido";
	}
	
	public void setId(int new_id)
	{
		if(this.id_fatura != new_id)
			this.id_fatura = new_id;
	}
	
	public int getId()
	{
		return this.id_fatura;
	}
	
	public void setData(Date new_date)
	{
		if(this.data != new_date)
			this.data = new_date;
	}
	
	public Date getData()
	{
		return this.data;
	}
	
	public void setValor(float new_val)
	{
		if(this.valor_total != new_val)
			this.valor_total = new_val;
	}
	
	public float getValor()
	{
		return this.valor_total;
	}
	
	public void setNome(String new_name)
	{
		if(this.nome_cliente != new_name)
			this.nome_cliente = new_name;
	}
	
	public String getNome()
	{
		return this.nome_cliente;
	}
	
}
