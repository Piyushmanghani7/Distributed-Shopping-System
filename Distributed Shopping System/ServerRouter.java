import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class ServerRouter {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws IOException{

        
        ArrayList<clientThread> clientArr = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        

        System.out.print("This is TCP Middle Server \n");
        System.out.print("Please enter the Port number: ");
        int portnumber = Integer.parseInt( br.readLine());
        ServerSocket listener = new ServerSocket(portnumber);

        Socket client = null;
        
        System.out.print("Enter the clients count:");
        int totalclients = Integer.parseInt( br.readLine());
        int total = totalclients;

        String[] routes=null;

        try{
            while (total!=0) {
                System.out.println("TCP Middle Server is waiting for "+total+" clients to connect..\n");
                client = listener.accept();
                System.out.println("TCP Middle Server Client Connected..\n");
                clientThread clientthread = new clientThread(client);
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                clientArr.add(clientthread);
                out.println(totalclients);
                out.println("This is Router R"+(clientArr.indexOf(clientthread)+1));
                executor.execute(clientthread);
                total--;
                listener.close();
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println(totalclients + " routers are connected.\n");

   

 }

}

// TCP Group server Thread class - To recieve the messages from the client side.
class clientThread implements Runnable{
    Socket client;
    BufferedReader in;
    PrintWriter out;
  

    public clientThread(Socket client) throws IOException{
        this.client = client;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }
    public void run(){
        try{
            File file = new File("/Users/piyushmanghani/Desktop/userList.txt");
            Scanner scan = new Scanner(file);
            
            while(true){
                
                String username = in.readLine();
                String password = in.readLine();
                System.out.println("[Client Username]: "+ username + "  " + "[Client password]: " + password);
                
                String str = scan.nextLine();
                
                while(true){
                    String[] arrOfStr = str.split(" ");
                    
                    if(username.equals(arrOfStr[0]))
                    {
                        if(password.equals(arrOfStr[1]))
                        {
                            
                            System.out.println("Client is sucessfully login with Middle sever");
                            out.println("Yes, TCP Group Server verifies these credentials of client & You are successfully Login");
                            out.println(arrOfStr[2]);
                            out.println(arrOfStr[3]);
                          
                        }                            
                    }
                    
                    str = scan.nextLine();
                    if(str.equals(" "))
                    {
                        break;
                    }

                }
              
    
                
            } 
            
        }
        catch(Exception e){
            //System.out.println("except.....");
        }
        finally{
            try{
                client.close();
            }
            catch(Exception e){
               // System.out.println(e);
            }
        }
    }
}
