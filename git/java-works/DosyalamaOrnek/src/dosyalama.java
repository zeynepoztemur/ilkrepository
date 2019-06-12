
import java.io.*;


public class dosyalama {

	public static void main(String[] args) throws Exception {
		
		
		FileInputStream fileinputstream = null ;
		FileOutputStream fileoutputstream = null ;
		
		FileReader inputstream = null ;
		FileWriter outputstream = null ;
		
		
		
		
		
		
		try {
			
			inputstream = new FileReader("zey.txt");
			outputstream = new FileWriter("yeniout.txt");
			
			byte b;
			while((b = (byte) inputstream.read()) != -1) {
				outputstream.write(b);
			}
		
						
				
			}catch(Exception e) {
			e.printStackTrace();								
			}finally {
				
					inputstream.close();		
					outputstream.close();
				
			}

	
	}

}
