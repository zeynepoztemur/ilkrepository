package araclar;

public class KaraTasiti extends Tasit{

	public void ücretHesaplakara(int ucret) {
		
		System.out.println("Tasitin Kiralama Ucreti : "+ (ucret+ ucret*10/100));
		
	}
	
	public  void ücretk(int ucret) {
		
		 System.out.println((ucret+ (ucret*10/100)));
		
	}
	
}
