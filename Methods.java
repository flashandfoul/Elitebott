import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Methods
{
    //  init Statics
    static String name = "";
    //  These are all variables that will track various things going on in our
    //  program, they will be useful for debugging and some of them will be
    //  displayed to the user upon concluding the conversation through the
    //  getCloser() and remember() methods.
    public static int wordCount = 0, charCount = 0, backAndForths = 0, lowPriKeywords = 0,
                      highPriKeywords = 0, simpleSentStructures = 0, nonCommittalResponses = 0, 
                      namesRemembered = 0, namesAdded = 0, conversationsStarted = 0;
    
    
    public static String getOpener()
    {
        return "HELLO, I am ELITEBOT V1 \nSay anything to me!";
    }
    
    public static void getResponse(String statement)
    {
        String response;
        
        
        remember(statement);
        
        
        // CONVERSATION CLASS WIP, for now will never run because Conversation.inConversation will defaultly return 0.     
        if(Conversation.inConversation())
            response = maybeAddName(Conversation.getResponse());
            
        
        // TRY CATCH STATEMENT WILL CATCH ANY EXCEPTIONS GIVEN OUT IN THE PROCESS
        // SPECIFICALLY LOOKING FOR IOExceptions FROM ACCESSING TXT DOCUMENTS
        try {
        response =  maybeAddName(findHighPriority(statement).replaceAll("_"," "));
        } catch(IOException e) {
        response = ("ERROR: " + e);
        } catch(Exception e) {
        response = ("ERROR: " + e);
        }

        timerStuff.printLikeHuman(getLineBreaks(response));
    }
    
    private static String getLineBreaks(String s)
    {
        final int maxCharPerLine = 70;          // this is the maximum amount of chars we will include
                                                // in each line, it can be easily adjusted here
                                                
                                                
        String responseWithLineBreaks = "";     // these are little helper strings for the loop
        String cur;                             // execution
        
        Scanner reader = new Scanner(s);        // this Scannner object scans the inputted
                                                // String from the parameter and will seperated the
                                                // words to make it easier to handle
                                                
        int lastLineIndex;                      // another helper variable for program execution
        
        
        // Main whileLoop, will read through each seperate word, decide if there
        // is enough space on each line for it, if so it will add it, if not
        // it will create a new line and put it there
        while(reader.hasNext())
        {
            cur = reader.next();
            lastLineIndex = responseWithLineBreaks.lastIndexOf("\n") + 2;
            if(lastLineIndex == 1 && (responseWithLineBreaks.length() + cur.length()) < maxCharPerLine)
            {
                if(responseWithLineBreaks.length() == 0) {
                    responseWithLineBreaks += cur;
                } else {
                    responseWithLineBreaks += " " + cur;
                }
            } else if(lastLineIndex == 1)
            {
                responseWithLineBreaks = responseWithLineBreaks + "\n" + cur;
            } else if((responseWithLineBreaks.substring(lastLineIndex).length() + cur.length()) < maxCharPerLine)
            {
                responseWithLineBreaks += " " + cur;
            } else
            {
                responseWithLineBreaks = responseWithLineBreaks + "\n" + cur;
            }
        }
        
        // returns the final response with the line breaks now included
        return responseWithLineBreaks;
        
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
                    conversationsStarted++;
                    return Conversation.getResponse();
                }
                highPriKeywords++;
                return response;
            } else
                reader.next();
        }
        return findSimpleSentenceStructure(statement);
    }
    
   
    
    private static String findLowPriority(String statement)throws IOException
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
                
                lowPriKeywords++;
                return response;
            } else {
                reader.next();
            }
        }
        return gottacommit.getNonCommitalResponse(statement);   
    }
    
    private static void remember(final String statement)
    {
        //  remembers statistics about each run of the program
        Scanner s = new Scanner(statement);
        charCount += statement.length();
        while(s.hasNext())
        {
            wordCount++;
            s.next();
        }
        backAndForths++;
        
        
        //Look for "My name is ".
        //namePsn will be zero if the statement begins with "my name is ".
        int namePsn = findKeyword(statement,"My name is", 0);
        if (namePsn > 0){
            namesRemembered++;
            //Finds the position of characters that might come after the name.
            int spacePsn = findKeyword(statement, " ",11);
            int periodPsn = findKeyword(statement, ".",11);
            int exclamPsn = findKeyword(statement, "!",11);
            int commaPsn = findKeyword(statement, ",",11);
            int dashPsn = findKeyword(statement, "-",11);
            int questPsn = findKeyword(statement, "?",11);
        
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
            name = ", "+statement.substring(namePsn+11,lowest);
        }
    }
    
    public static String findSimpleSentenceStructure(String statement) throws IOException
    {
        //initialize local variables
        int psnYou = findKeyword(statement, "you", 0);
        int psnI = findKeyword(statement, "I", 0);
        
        //search for simple sentence structures and set response accordingly
        if (findKeyword(statement, "I want to", 0) >= 0)
        {
            simpleSentStructures++;
            return SimpleStructure.transformIWantToStatement(statement);
        }
        else if (findKeyword(statement, "I want", 0) >= 0)
        {
            simpleSentStructures++;
            return SimpleStructure.transformIWantStatement(statement);
        }
        else if (psnYou >= 0 && findKeyword(statement, "me", psnYou) >= 0)
        {
            simpleSentStructures++;
            return SimpleStructure.transformYouMeStatement(statement);
        }
        else if (findKeyword(statement, "I will", 0) >= 0)
        {
            simpleSentStructures++;
            return SimpleStructure.transformIWillStatement(statement);
        }
        else if (psnI >= 0 && findKeyword(statement, "you", psnI) >= 0)    
        {
            simpleSentStructures++;
            return SimpleStructure.transformIYouStatement(statement);
        }
        else if (findKeyword(statement, "I like", 0) >= 0)
        {
            simpleSentStructures++;
            return SimpleStructure.transformILikeStatement(statement);
        }
        return findLowPriority(statement);
    }
    
    private static String maybeAddName(String response)
    {
        Random randy = new Random();
        // 1/7 of the time, Elitebott will add the user's name to the end of the response.
        if (randy.nextInt(7) == 6){
            namesAdded++;
            //Checks to see if the statement ends in a punctuation mark.
            String endChar = response.substring(response.length()-1);
            Boolean endsPeriod = (endChar.equals("."));
            Boolean endsQuest = (endChar.equals("?"));
            Boolean endsExclam = (endChar.equals("!"));
            
            //Cuts off last character.
            if (endsPeriod || endsQuest || endsExclam)
                response = response.substring(0,response.length()-1);
            
            //Adds name and last character if neccesary.
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
    
    public static String getCloser()
    {
        String result = "\n" + String.format("%-50s%n","Oh, Goodbye then!");
        result += String.format("%-25s%-10d", "Total chars inputted:",charCount) + "\n";
        result += String.format("%-25s%-10d", "Total words inputted:",wordCount) + "\n";
        result += String.format("%-25s%-10d", "Total back-and-forths:",backAndForths);
        return result;
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