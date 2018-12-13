/*
 * This is the main runner class, we will use this to run the
 * bot, this program executes through a sentinel controlled while
 * loop, and opens the conversation with a getOpener method.
 * After the conversation stops, the bot releases statistics for the
 * conversation.
 */

import java.util.*;
import java.io.*;

public class runner
{
    public static void main(String [] args)throws Exception
    {
        
        Scanner closerreader = new Scanner(new File("closingstatements.txt"));
        ArrayList<String> closers = new ArrayList();
        
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
        Methods.remember(response);
        //  while loop keeps processing until the user enters the pre-
        //  set sentinal value
        while(!closers.contains((response.replaceAll("_"," ")).toLowerCase()))
        {
            System.out.println();
            Methods.getResponse(response);
            System.out.println("\n");
            response = reader.nextLine();
            Methods.remember(response);
        }
        
        Methods.getCloser();
    }
}
