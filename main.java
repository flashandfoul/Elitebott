// this is the main class
// pretty much our only class
import java.util.Scanner;


public class main
{
    public static void main(String [] args)
    {
        
        final String sentinal = "Bye";      //  final sentinal value
        
        String response;                    //  the response that they'll have each
                                            //  time, used to pass into our methods
                                            
        Scanner reader = new Scanner(System.in);
        
        //  prints out a default greeting used by the EliteBot.
        system.out.println(Methods.getOpener());
        
        //  gets the client's response
        response = reader.nextLine();
        
        //  while loop keeps processing until the user enters the pre-
        //  set sentinal value
        while(!(response.equals(sentinal)))
        {
            System.out.println(Methods.getResponse(response));
            response = reader.nextLine;
        }
    }
}
