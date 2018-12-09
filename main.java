// this is the main class
// pretty much our only class
//in computer class
import java.util.*;
import java.io.*;
public class main
{
    public static void main(String [] args)throws IOException
    {
        Scanner closerreader=new Scanner(new File("closingstatements.txt"));
        ArrayList<String> closers=new ArrayList();
        
        while(closerreader.hasNext()){
            closers.add(closerreader.nextLine());
        }
        
        String response;                    //  the response that they'll have each
                                            //  time, used to pass into our methods
                                            
        Scanner reader = new Scanner(System.in);
        
        //  prints out a default greeting used by the EliteBot.
        System.out.println(Methods.getOpener() + "\n");
        
        //  gets the client's response
        response = reader.nextLine();
        
        //  while loop keeps processing until the user enters the pre-
        //  set sentinal value
        while(!closers.contains((response.replaceAll("_"," ")).toLowerCase()))
        {
            System.out.println("\n" + Methods.getResponse(response) + "\n");
            response = reader.nextLine();
        }
    }
}
