package metier.entities;

public class Stock {
	private int idstock;
	private int qttestock;
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(int idstock, int qttestock) {
		super();
		this.qttestock = qttestock;
	}
	public int getIdstock() {
		return idstock;
	}
	public void setIdstock(int idstock) {
		this.idstock = idstock;
	}
	public int getQttestock() {
		return qttestock;
	}
	public void setQttestock(int qttestock) {
		this.qttestock = qttestock;
	}
	@Override
	public String toString() {
		return "Stock [idstock=" + idstock + ", qttestock=" + qttestock + "]";
	}
	
	

}
