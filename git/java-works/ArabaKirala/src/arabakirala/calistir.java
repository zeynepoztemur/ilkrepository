package arabakirala;
import araclar.*;
import musteri.* ;
import kiralama.Kiralama;

public class calistir {

	
	public static void main (String args[]) {
		
		
		musteri biri = new musteri();
		biri.setAd("Zeynep");
		biri.setSoyad("Oztemur");
		biri.setKimlikno("112344523");
		
		
		DenizTasiti yelkenli =  new DenizTasiti();
		yelkenli.setModel("MaviZeynep");
		yelkenli.setKm(0);
		yelkenli.setUcret(40000);
		
		KaraTasiti araba = new KaraTasiti();
		araba.setKm(10000);
		araba.setModel("Ford-Focus");
		araba.setUcret(35000);
		
		yelkenli.ücretHesapladeniz(yelkenli.getUcret()) ;
		araba.ücretHesaplakara(araba.getUcret()) ;
		
		yelkenli.kiralama(biri.getAd(), yelkenli.getModel(), yelkenli.getUcret());
		
		araba.kiralama(biri.getAd(), araba.getModel(), araba.getUcret());
	}
}
