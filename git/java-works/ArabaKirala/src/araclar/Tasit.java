package araclar;

public class Tasit {

	public String model ;
	int km ;
	int ucret;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public int getUcret() {
		return ucret;
	}
	public void setUcret(int ucret) {
		this.ucret = ucret;
	}
	
	public void kiralama(String ad , String tasit, int ucret) {
		
		System.out.println(ad+ " İsimli musteri " +  tasit + " tasitini  " + ucret + " tl ye  kiraladi.");
	}

	
	
}
