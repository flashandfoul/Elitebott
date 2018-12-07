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
    //  init Statics
    static String name = "";
    //main method that will be called, has several stages
    public static String getResponse(String statement)
    {
        // CONVERSATION CLASS WIP, for now will never run because Conversation.inConversation will defaultly return 0.
        if(Conversation.inConversation())
            return maybeAddName(Conversation.getCurrentConversation().getResponse());
        Methods.remember(statement);
        
        // TRY CATCH STATEMENT WILL CATCH ANY EXCEPTIONS GIVEN OUT IN THE PROCESS
        // SPECIFICALLY LOOKING FOR IOExceptions FROM ACCESSING TXT DOCUMENTS
        try {
            return maybeAddName(findHighPriority(statement));
        } catch(IOException e) {
            return ("ERROR: " + e);
        } catch(Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
    
    public static String findDefinedWord(String statement)
    {
        return "wip";
    }
    
    private static String findHighPriority(String statement) throws IOException
    {
        // init local variables
        Scanner reader = new Scanner(new File("high.txt"));
        String curEntry, response;
        
        // reads the document, we assume that the document has pairs of information
        while(reader.hasNext())
        {
            // curEntry is the keyword that it's looking for
            curEntry = reader.next();
            if(findKeyword(statement, curEntry, 0) > -1)
            {
                response = reader.next();
                
                // replaces the underscores with spaces so it's outputtable
                response.replaceAll("_", " ");
                
                // WIP-this will eventually start a conversation about a topic, if it warrants
                if(findKeyword(response, "START CONVERSATION", 0) > -1)
                {
                    Conversation.startConversation(response.substring(19));
                    return Conversation.getResponse();
                }
                return response;
            } else
                reader.next();
        }
        return findSimpleSentenceStructure(statement);
    }
    
    private static String getOpener()
    {
        return "HELLO, I am ELITEBOT V1 \nSay anything to me!";
    }
    
    private static String findLowPriority(String statement)
    {
        // init local variables
        Scanner reader = new Scanner(new File("lough.txt"));
        String curEntry, response;
        
        // while loop reads the document and searches for keywords
        while(reader.hasNext())
        {
            // curEntry is the keyword that it's looking for
            curEntry = reader.next();
            if(findKeyword(statement, curEntry, 0) > -1)
            {
                response = reader.next();
                
                // replaces the underscores with spaces so it's outputtable
                response.replaceAll("_", " ");
                
                return response;
            } else {
                reader.next();
            }
        }
        return gottacommit.getNonCommitalResponse(statement);   
    }
    
    private static void remember(String statement)
    {
        //Look for "My name is ".
        //namePsn will be zero if the statement includes with "my name is ".
        int namePsn = findKeyword(statement,"My name is ", 0);
        if (namePsn > 0){
            //Finds the position of characters that might come after the name.
            int spacePsn = findKeyword(statement, " ",10);
            int periodPsn = findKeyword(statement, ".",10);
            int exclamPsn = findKeyword(statement, "!",10);
            int commaPsn = findKeyword(statement, ",",10);
            int dashPsn = findKeyword(statement, "-",10);
            int questPsn = findKeyword(statement, "?",10);
        
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
            if (questPsn > 0 && questPsn < lowest)
            lowest = questPsn;
            
            //name is a comma and a space and a name.
            name = ", "+statement.substring(11,lowest);
        }
    }
    
    public static String findSimpleSentenceStructure(String statement)
    {
        //initialize local variables
        String simpleResponse = "";
        int psnYou = findKeyword(statement, "you", 0);
        int psnI = findKeyword(statement, "I", 0);
        
        //search for simple sentence structures and set response accordingly
        if (findKeyword(statement, "I want to", 0) >= 0)
        {
            simpleResponse = SimpleStructure.transformIWantToStatement(statement);
        }
        else if (findKeyword(statement, "I want", 0) >= 0)
        {
            simpleResponse = SimpleStructure.transformIWantStatement(statement);
        }
        else if (psnYou >= 0 && findKeyword(statement, "me", psnYou) >= 0)
        {
            simpleResponse = SimpleStructure.transformYouMeStatement(statement);
        }
        else if (psnI >= 0 && findKeyword(statement, "you", psnI) >= 0)    
        {
            simpleResponse = SimpleStructure.transformIYouStatement(statement);
        }
        else if (findKeyword(statement, "I will", 0) >= 0)
        {
            simpleResponse = SimpleStructure.transformIWillStatement(statement);
        }
        else if (findKeyword(statement, "I like", 0) >= 0)
        {
            simpleResponse = SimpleStructure.transformILikeStatement(statement);
        }
        //return forumlated response
        return simpleResponse;
    }
    
    private static String maybeAddName(String response)
    {
        Random randy = new Random();
        // 1/7 of the time, Elitebott will add the user's name to the end of the response.
        if (randy.nextInt(7) == 6){
            //Checks to see if the statement ends in a punctuation mark.
            String endChar = response.substring(response.length()-1,response.length());
            Boolean endsPeriod = (endChar.equals("."));
            Boolean endsQuest = (endChar.equals("?"));
            Boolean endsExclam = (endChar.equals("!"));
            if (endsPeriod || endsQuest || endsExclam)
                response = response.substring(0,response.length()-1);
            if (endsPeriod)
                return response+name+".";
            else if (endsQuest)
                return response+name+"?";
            else if (endsExclam)
                return response+name+"!";
            else
                return response+name;
        }else
        return response;
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