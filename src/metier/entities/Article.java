package metier.entities;

public class Article {
	private int idarticle;
	private String nomarticle;
	private String designation;
	private int qttestock;
	
	public int getQttestock() {
		return qttestock;
	}
	public void setQttestock(int qttestock) {
		this.qttestock = qttestock;
	}
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article( int qttestock, String nomarticle, String designation) {
		super();
		this.qttestock = qttestock;
		this.nomarticle = nomarticle;
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Article [idarticle=" + idarticle + ", qttestock=" + qttestock + ", nomarticle="
				+ nomarticle + ", designation=" + designation + "]";
	}
	public int getIdarticle() {
		return idarticle;
	}
	public void setIdarticle(int idarticle) {
		this.idarticle = idarticle;
	}
	public String getNomarticle() {
		return nomarticle;
	}
	public void setNomarticle(String nomarticle) {
		this.nomarticle = nomarticle;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

}
