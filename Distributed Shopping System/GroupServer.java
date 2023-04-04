import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class GroupServer extends Thread {

    
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{


        String points = "";
        int val1 = 0; 
        int val2 = 0; 
        int val3 = 0; 
    
        System.out.print("Its the Group Server \n");

        ArrayList<PlatinumserverThread> PlatinumserverArr = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ServerSocket listener1 = new ServerSocket(11);
        val1 = 1;
        Socket Platinum = null;

        if(val1 == 1)
        {

            Platinum = listener1.accept();
            System.out.println("Platinum Server\n");
            PlatinumserverThread Platinumserverthread = new PlatinumserverThread(Platinum);
            PrintWriter Platinum_out = new PrintWriter(Platinum.getOutputStream(), true);
            PlatinumserverArr.add(Platinumserverthread);
            executor.execute(Platinumserverthread);  
            listener1.close();
        }

        
        ArrayList<GoldserverThread> GoldserverArr = new ArrayList<>();
        ExecutorService executor2 = Executors.newFixedThreadPool(10);
        ServerSocket listener2 = new ServerSocket(12);
        val2 = 2;
        Socket Gold = null;
        if(val2 == 2)
        {

            Gold = listener2.accept();
            System.out.println("Gold Server\n");
            GoldserverThread Goldserverthread = new GoldserverThread(Gold);
            PrintWriter Gold_out = new PrintWriter(Gold.getOutputStream(), true);
            GoldserverArr.add(Goldserverthread);
            executor2.execute(Goldserverthread); 
            listener2.close();
        }

        
        
        

        

       

        ArrayList<SilverserverThread> SilverserverArr = new ArrayList<>();
        ExecutorService executor3 = Executors.newFixedThreadPool(10);
        ServerSocket listener3 = new ServerSocket(13);
        val3 = 3;
        Socket Silver = null;
        if(val3 == 3)
        {
            Silver = listener3.accept();
            System.out.println("Silver Server\n");
            SilverserverThread Silverserverthread = new SilverserverThread(Silver);
            PrintWriter Silver_out = new PrintWriter(Silver.getOutputStream(), true);
            SilverserverArr.add(Silverserverthread);
            executor3.execute(Silverserverthread); 
            listener3.close();      

        }

        
        
      
}


       
}
// Platinum Group server Thread class - To recieve the messages from the Middle server side.
class PlatinumserverThread implements Runnable{
    Socket Platinum;
    BufferedReader in1;
    PrintWriter out;

    public PlatinumserverThread(Socket Platinum) throws IOException{
        this.Platinum = Platinum;
        in1 = new BufferedReader(new InputStreamReader(Platinum.getInputStream()));
        out = new PrintWriter(Platinum.getOutputStream(), true);
    }
    public void run(){
        try
        {
            int val = 1;
            while(val!=0){
                String input1 = in1.readLine();
                System.out.println(input1);
                
                
            
            
                String[] items = {"Bread","butter","toast","coke","noodles","cookies"};
                String item = String.join(",", items);
                out.println(item);

                String[] items_prices = {"20","40","55","56","60","75"};
                String item_prices = String.join(",", items_prices);
                out.println(item_prices);


                String[] items_quantity = {"5","10","50","87","90","16"};
                String item_quantity = String.join(",", items_quantity);
                out.println(item_quantity);

                String input2 = in1.readLine();
                System.out.println(input2);
                
                     
                val--;

    
            }
        }
        
        catch(Exception e){
            
        }
        finally{
            try{
                Platinum.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        }
    }


// Gold Group server Thread class - To recieve the messages from the Middle server side.
class GoldserverThread implements Runnable{
    Socket Gold;
    BufferedReader in1;
    PrintWriter out;

    public GoldserverThread(Socket Gold) throws IOException{
        this.Gold = Gold;
        in1 = new BufferedReader(new InputStreamReader(Gold.getInputStream()));
        out = new PrintWriter(Gold.getOutputStream(), true);
    }
    public void run(){
        try
        {
            int val = 1;
            while(val!=0){
                String input1 = in1.readLine();
                System.out.println(input1);

                
                
                
                String[] items = {"Bread","butter","toast","coke","noodles","cookies"};
                String item = String.join(",", items);
                out.println(item);

                String[] items_prices = {"20","40","55","56","60","75"};
                String item_prices = String.join(",", items_prices);
                out.println(item_prices);


                String[] items_quantity = {"5","10","50","87","90","16"};
                String item_quantity = String.join(",", items_quantity);
                out.println(item_quantity);

                String input2 = in1.readLine();
                System.out.println(input2);
                val--;
    
            }
        }
        
        catch(Exception e){
            
        }
        finally{
            try{
                Gold.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        }
    }



// Silver Group server Thread class - To recieve the messages from the Middle server side.
class SilverserverThread implements Runnable{
    Socket Silver;
    BufferedReader in1;
    PrintWriter out;
    



    public SilverserverThread(Socket Silver) throws IOException{
        this.Silver = Silver;
        in1 = new BufferedReader(new InputStreamReader(Silver.getInputStream()));
        out = new PrintWriter(Silver.getOutputStream(), true);
    }
    public void run(){
        try
        {
            int val = 1;
            while(val!=0){
                String input1 = in1.readLine();
                System.out.println(input1);

                String[] items = {"Bread","butter","toast","coke","noodles","cookies"};
                String item = String.join(",", items);
                out.println(item);

                String[] items_prices = {"20","40","55","56","60","75"};
                String item_prices = String.join(",", items_prices);
                out.println(item_prices);


                String[] items_quantity = {"5","10","50","87","90","16"};
                String item_quantity = String.join(",", items_quantity);
                out.println(item_quantity);

                String input2 = in1.readLine();
                System.out.println(input2);
                
                val--;
    
            }
        }
        
        catch(Exception e){
            
        }
        finally{
            try{
                Silver.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        }
    }




   
    


