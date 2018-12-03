import java.util.Scanner;
import java.util.Random;
import java.io.*;

/**
 * Write a description of class methods here.
 *
 * @We did it!
 * @version (a version number or a date)
 */
public class Methods
{
    //main method that will be called, has several stages
    public static String getResponse(String statement)
    {
        // CONVERSATION CLASS WIP
        if(Conversation.inConversation())
            return maybeAddName(Conversation.getCurrentConversation().getResponse());
        Methods.remember(statement);
        return maybeAddName(findHighPriority(statement));
    }
    
    private static String findHighPriority(String statement)
    {
        return "wip";
    }
    
    private static String findLowPriority(String statement)
    {
        return "wip";
    }
    
    private static void remember(String statement)
    {
        //Look for "My name is ".
        //namePsn will be zero if the statement starts with "my name is ".
        int namePsn = findKeyword(statement,"My name is ", 0);
        
        //Finds the position of characters that might come after the name.
        int spacePsn = findKeyword(statement, " ",10);
        int periodPsn = findKeyword(statement, ".",10);
        int exclamPsn = findKeyword(statement, "!",10);
        int commaPsn = findKeyword(statement, ",",10);
        int dashPsn = findKeyword(statement, "-",10);
        
        //Here we find the first of these things to appear.
        int lowest = statement.length();
        if (spacePsn > 0)
        lowest = spacePsn;
        if (periodPsn > 0 && periodPsn < lowest)
        lowest = periodPsn;
        if (exclamPsn > 0 && exclamPsn < lowest)
        lowest = exclamPsn;
        if (commaPsn > 0 && commaPsn < lowest)
        lowest = commaPsn;
        if (dashPsn > 0 && exclamPsn < lowest)
        lowest = dashPsn;
        
        String name = statement.substring(11,lowest);
    }
    
    public static String findSimpleSentenceStructure(String statement)
    {
       return "wup";   
    }
    
    private static String maybeAddName(String statement)
    {
        return "wip";
    }
    
    public static int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(
                        psn + goal.length(),
                        psn + goal.length() + 1);
            }

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                                            // letter
                    && ((after.compareTo("a") < 0) || (after
                            .compareTo("z") > 0)))
            {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal, psn + 1);

        }

        return -1;
    }
}