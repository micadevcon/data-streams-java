import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
 

public class Client {
 
    public static void main(String args[]) throws Exception {
      
        int portNumber = 1777;
    
        String str = "1";

        System.out.println("Запуск клиента");
 
    
        Socket socket = new Socket("127.0.0.1", portNumber);
 
       
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 
        // Создать поток для записи символов в сокет
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
 

        pw.println(str);
 
        // Входим в цикл чтения, что нам ответил сервер
        while ((str = br.readLine()) != null) {
           
            System.out.println(str);
                break;
        }
 
        br.close();
        pw.close();
        socket.close();
    }
}