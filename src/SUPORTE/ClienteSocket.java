package SUPORTE;  
  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
  
public class ClienteSocket extends Thread {  
  
    // parte que controla a recepção de mensagens do cliente  
    private Socket conexao;  
    public String textoChat;
    public Boolean mudou = false;

  
    // construtor que recebe o socket do cliente  
    public ClienteSocket(Socket socket) {  
        this.conexao = socket;  
    }  
  
  
    // execução da thread  
    public void run() {  
        try {  
  
            // recebe mensagens de outro cliente através do servidor  
            BufferedReader entrada = new BufferedReader(new InputStreamReader(  
                    this.conexao.getInputStream()));  
  
            // cria variavel de mensagem  
            String msg;  
            while (true) {  
  
                // pega o que o servidor enviou  
                msg = entrada.readLine();  
  
                // se a mensagem contiver dados, passa pelo if, caso contrario  
                // cai no break e encerra a conexao  
                if (msg == null) {  
                    System.out.println("Conexão encerrada!");  
//                    System.exit(0);  
//                    mudou = true;
//                    msg = "Técnico ocupado no momento, tente novamente mais tarde!";
//                    mudou = false;
                }  
                System.out.println();  
  
                // imprime a mensagem recebida  
                System.out.println(msg); 
                mudou = true;
                textoChat = msg;
  
                // cria uma linha visual para resposta  
                System.out.print("Responder > "); 
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ClienteSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
                mudou = false;
            }  
        } catch (IOException e) {  
  
            // caso ocorra alguma exceção de E/S, mostra qual foi.  
            System.out.println("Ocorreu uma Falha... .. ." + " IOException: "  
                    + e);  
        }  
    }  
    
    
}  