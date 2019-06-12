import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


 public class ChatServer {
    
	 // Server soket
    private static ServerSocket serverSocket = null;
    
    // Client soket
    private static Socket clientSocket = null;
    
    // Maximum bağlantı sayısı
    private static final int maxClientSayisi = 10;
    
    // Her bir client için oluşturlacak Thread dizisi
    private static final ClientThread[] threads = new ClientThread[maxClientSayisi];
    
    
    public static void main(String args[]) {
    
    	int portNo = 3333;
        if (args.length < 1) {
            System.out.println("Port Numarası: " + portNo);
        } else {
            portNo = Integer.valueOf(args[0]).intValue();
        }
        
        try {
            serverSocket = new ServerSocket(portNo); //Serverın soketini oluşturuyoruz.
        } catch (IOException e) {
            System.out.println(e);
        }
        
        /*
         * Client sayısı kadar her bir client için ayrı soketler ve threadlerin oluşturulması
         */
        while (true) {
            try {
                clientSocket = serverSocket.accept();
                int i = 0;
                for (i = 0; i < maxClientSayisi; i++) {
                    if (threads[i] == null) {
                        (threads[i] = new ClientThread(clientSocket, threads)).start();
                        break;
                    }
                }
                if (i == maxClientSayisi) {
                    PrintStream ps = new PrintStream(clientSocket.getOutputStream());
                    ps.println("Server maksimum kapasiteye ulasti.");
                    ps.close();
                    clientSocket.close(); //Client kapasitesi doludugu için client soketi kapatılır.
                }
            } catch (IOException e) {
                System.out.println(e);
            	}
        }
    }
}
 /*
 * Client soketler için oluşturulmuş Thread sınıfı
 * Her bir Client ile Thread eşleştirilmesi ile Multithread uygulama
 */
class ClientThread extends Thread {
    
	private DataInputStream dis = null;
    private PrintStream ps = null;
    private Socket clientSocket = null;
    private final ClientThread[] threads;
    private int maxClientSayisi;
    
    public ClientThread(Socket clientSocket, ClientThread[] threads) {
      this.clientSocket = clientSocket;
      this.threads = threads;
      maxClientSayisi = threads.length;
    }
     @Override
    public void run() {
        int maxClientSayisi = this.maxClientSayisi; 
        ClientThread[] threads = this.threads;
        
        try {
            dis = new DataInputStream(clientSocket.getInputStream());
            ps = new PrintStream(clientSocket.getOutputStream());
            ps.println("Bir nickname gir: ");
            String name = dis.readLine().trim();
            ps.println("Merhaba " + name + "*** Çevrimiçi Sohbet uygulamasina hosgeldiniz. Uygulamadan cikmak icin '/quit' yazip enter'a basabilirsiniz.");
          
            for (int i = 0; i < maxClientSayisi; i++) { // Bulunan her bir Clienta uygulamaya baglanan kisiyi anons ediyor.
                if (threads[i] != null && threads[i] != this) {
                    threads[i].ps.println(name + " adli kisi odaya baglandi.");
                }
            }
            while (true) {
                String satir = dis.readLine();
                if (satir.startsWith("/quit")) { //Clientın yazdıgını okur ve cıkıs komutu olup olmadıgını sonsuz döngü ile kontrol eder.
                    break;
                }
                for (int i = 0; i < maxClientSayisi; i++) {
                    if (threads[i] != null) {
                        threads[i].ps.println("<" + name + ">: " + satir); //i inci clientin mesajını diger clientlara anons eder.
                    }
                }
            }
            
            for (int i = 0; i < maxClientSayisi; i++) {
                if (threads[i] != null && threads[i] != this) {
                    threads[i].ps.println(name + " adlı kisi odadan ayrildi.");
                }
            }
            ps.println(name + " Odadan ayrıldınız.");
            
             /*
             * Yeni bir Clientın bağlanabilmesi için aktif olan Client null yapılır
             */
            for (int i = 0; i < maxClientSayisi; i++) {
                if (threads[i] == this) {
                    threads[i] = null;
                }
            }
            dis.close();
            ps.close();
            clientSocket.close();
        } catch (IOException e) {
        }
    }
}