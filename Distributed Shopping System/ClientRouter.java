import java.io.*;
import java.net.*;
import java.util.*;


import java.net.InetAddress;

public class ClientRouter {

   

    
    public static String routerID = "";
    public static ArrayList<String> temp = new ArrayList<>();
    public static void main(String args[]) throws IOException{


        InetAddress address= InetAddress.getLocalHost();
        Socket socket = new Socket(address,11573);
        System.out.println("Welcome- We are Connected to Server..");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        

        String totalrouter="";
        Boolean value = true;
        while(value == true){
            String input = in.readLine();
            if (input.equals("quit")) break;
        
            
          
            if(input.split(" ").length<15){
                totalrouter = input;
            }
            else {
                routerID = input.split(" ")[15];
                System.out.println(input);
            }
            value = false;
        }

       
        System.out.println(in.readLine());

        System.out.println("Please Enter your's Username: \n");
        String username = br.readLine();
                
                
        System.out.println("Please Enter your's Password: \n");
        String password = br.readLine();
        out.println(username);
        out.println(password);

        String input = in.readLine();
        System.out.println("[Server Message]: "+ input);


        String Group_name = in.readLine();
        System.out.println("You are a member of Group: "+ Group_name);

        String Credit_points = in.readLine();
        
        System.out.println("You have this Credit points available: "+ Credit_points);

        int credits =Integer.parseInt(Credit_points);
        

        if(Group_name.equals("Platinum"))
        {
            Socket socket1 = new Socket(address,11);
            //ServerSocket plat = socket1.accept();
            //platThread platthread = new platThread(socket1);
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader in1 = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true);

            System.out.println("connected with Platinum Server" );
        
            out1.println("Platinum Server connected with the Client");

    
            String item =  in1.readLine();
            String[] arrOfStr = item.split(",");
            System.out.println("Items are: ");
            for (int i = 0; i < arrOfStr.length; i++){
               
                System.out.println(arrOfStr[i]+"\n");
    
            }
            System.out.println("\n");
            

            String price =  in1.readLine();
            String[] arrOfStr_price = price.split(",");
            System.out.println("Prices of each respective item: ");
            for (int i = 0; i < arrOfStr_price.length; i++){
               
                System.out.println(arrOfStr_price[i]+"\n");
    
            }
            System.out.println("\n");
           

            String quantity =  in1.readLine();
            String[] arrOfStr_quantity = quantity.split(",");
            System.out.println("Quantity of each respective item :");
            for (int i = 0; i < arrOfStr_quantity.length; i++){
               
                System.out.println(arrOfStr_quantity[i]+"\n");
    
            }

            System.out.println("\n");
            

            System.out.println("Choose one of the Items listed:\n");
            String choose_item = br.readLine();


            
             
            if(choose_item.equals(arrOfStr[0]))
            {
                int price_amnt1 =Integer.parseInt(arrOfStr_price[0]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt1) );
            }
            else if (choose_item.equals(arrOfStr[1]))
            {
                int price_amnt2 =Integer.parseInt(arrOfStr_price[1]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt2) );;

            }
            else if (choose_item.equals(arrOfStr[2]))
            {
                int price_amnt3 =Integer.parseInt(arrOfStr_price[2]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt3) ); 
            }
            else if (choose_item.equals(arrOfStr[3]))
            {
                int price_amnt4 =Integer.parseInt(arrOfStr_price[3]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt4) );
            }
            else if (choose_item.equals(arrOfStr[4]))
            {
                int price_amnt5 =Integer.parseInt(arrOfStr_price[4]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt5) );
            }
            else if (choose_item.equals(arrOfStr[5]))
            {
                int price_amnt6 =Integer.parseInt(arrOfStr_price[5]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt6) );
            }
            else 
            {

                System.out.println("Not choosed yet, please choose an item" );
            }


    
        }
        else if (Group_name.equals("Gold"))
        {
            Socket socket2 = new Socket(address,12);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader in2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
            PrintWriter out2 = new PrintWriter(socket2.getOutputStream(), true);

            System.out.println("connected with Gold Server" );
            
            out2.println("Gold Server connected with the Client");

            String item =  in2.readLine();
            String[] arrOfStr = item.split(",");
            System.out.println("Items are: ");
            for (int i = 0; i < arrOfStr.length; i++){
               
                System.out.println(arrOfStr[i]+"\n");
    
            }
            System.out.println("\n");
            

            String price =  in2.readLine();
            String[] arrOfStr_price = price.split(",");
            System.out.println("Prices of each respective item: ");
            for (int i = 0; i < arrOfStr_price.length; i++){
               
                System.out.println(arrOfStr_price[i]+"\n");
    
            }
            System.out.println("\n");
           

            String quantity =  in2.readLine();
            String[] arrOfStr_quantity = quantity.split(",");
            System.out.println("Quantity of each respective item :");
            for (int i = 0; i < arrOfStr_quantity.length; i++){
               
                System.out.println(arrOfStr_quantity[i]+"\n");
    
            }

            System.out.println("\n");
            

            System.out.println("Choose one of the Items listed:\n");
            String choose_item = br.readLine();

            if(choose_item.equals(arrOfStr[0]))
            {
                int price_amnt1 =Integer.parseInt(arrOfStr_price[0]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt1) );
            }
            else if (choose_item.equals(arrOfStr[1]))
            {
                int price_amnt2 =Integer.parseInt(arrOfStr_price[1]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt2) );;

            }
            else if (choose_item.equals(arrOfStr[2]))
            {
                int price_amnt3 =Integer.parseInt(arrOfStr_price[2]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt3) ); 
            }
            else if (choose_item.equals(arrOfStr[3]))
            {
                int price_amnt4 =Integer.parseInt(arrOfStr_price[3]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt4) );
            }
            else if (choose_item.equals(arrOfStr[4]))
            {
                int price_amnt5 =Integer.parseInt(arrOfStr_price[4]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt5) );
            }
            else if (choose_item.equals(arrOfStr[5]))
            {
                int price_amnt6 =Integer.parseInt(arrOfStr_price[5]); 
                System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt6) );
            }
            else 
            {

                System.out.println("Not choosed yet, please choose an item" );
            }
            

        }
        else
        {
            try (Socket socket3 = new Socket(address,13)) {
                BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));

                BufferedReader in3 = new BufferedReader(new InputStreamReader(socket3.getInputStream()));
                PrintWriter out3 = new PrintWriter(socket3.getOutputStream(), true);

                
                System.out.println("connected with Silver Server" );
                
                out3.println("Silver Server connected with the Client");
                
                String item =  in3.readLine();
                String[] arrOfStr = item.split(",");
                System.out.println("Items are: ");
                for (int i = 0; i < arrOfStr.length; i++){
                   
                    System.out.println(arrOfStr[i]+"\n");
   
                }
                System.out.println("\n");
                

                String price =  in3.readLine();
                String[] arrOfStr_price = price.split(",");
                System.out.println("Prices of each respective item: ");
                for (int i = 0; i < arrOfStr_price.length; i++){
                   
                    System.out.println(arrOfStr_price[i]+"\n");
   
                }
                System.out.println("\n");
         

                String quantity =  in3.readLine();
                String[] arrOfStr_quantity = quantity.split(",");
                System.out.println("Quantity of each respective item :");
                for (int i = 0; i < arrOfStr_quantity.length; i++){
                   
                    System.out.println(arrOfStr_quantity[i]+"\n");
   
                }

                System.out.println("\n");
                

                System.out.println("Choose one of the Items listed:\n");
                String choose_item = br.readLine();

                if(choose_item.equals(arrOfStr[0]))
                {
                    int price_amnt1 =Integer.parseInt(arrOfStr_price[0]); 
                    System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt1) );
                }
                else if (choose_item.equals(arrOfStr[1]))
                {
                    int price_amnt2 =Integer.parseInt(arrOfStr_price[1]); 
                    System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt2) );;
    
                }
                else if (choose_item.equals(arrOfStr[2]))
                {
                    int price_amnt3 =Integer.parseInt(arrOfStr_price[2]); 
                    System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt3) ); 
                }
                else if (choose_item.equals(arrOfStr[3]))
                {
                    int price_amnt4 =Integer.parseInt(arrOfStr_price[3]); 
                    System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt4) );
                }
                else if (choose_item.equals(arrOfStr[4]))
                {
                    int price_amnt5 =Integer.parseInt(arrOfStr_price[4]); 
                    System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt5) );
                }
                else if (choose_item.equals(arrOfStr[5]))
                {
                    int price_amnt6 =Integer.parseInt(arrOfStr_price[5]); 
                    System.out.println("Remaining Credits after this shopping is :"+ (credits-price_amnt6) );
                }
                else 
                {
    
                    System.out.println("Not choosed yet, please choose an item" );
                }
            }

        }
        
      

        try{
            socket.close();
        }
        catch(Exception e){
            System.out.println(e);
        }


    }

    
                
                  
}
