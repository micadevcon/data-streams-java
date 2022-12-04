import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Server {
    public static void main(String args[]) {
        
        int port = 1777;
 
        try {
            
            ServerSocket servSocket = new ServerSocket(port);
 
            
            while (true) {
                System.out.println("Сервер работает на порте " + port);
 

                Socket fromClientSocket = servSocket.accept();
 
                // Работаем с потоками ввода-вывода
                try (Socket localSocket = fromClientSocket;
                     PrintWriter pw = new PrintWriter(localSocket.getOutputStream(), true);
                     BufferedReader br = new BufferedReader(new InputStreamReader(localSocket.getInputStream()))) {
 
                
                    String str;
                    while ((str = br.readLine()) != null) {
                      
                        File file = new File("D://"+str+".txt");
        FileReader fr = new FileReader(file);
        BufferedReader br1 = new BufferedReader(fr);
        String line1="";
        String line;
        while((line = br1.readLine()) != null){
            
           line1+=line;
        }
        br1.close();
        fr.close();
                        System.out.println("Содержимое файла "+str+" : " + line1);
 
                            pw.println("Содержимое файла "+str+" : " + line1);
                        
                    }
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}