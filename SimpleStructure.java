import java.util.Random;
/**
 * Class SimpleStructure is a compilation of methods that
 * the Methods.findSimpleSentenceStructure() calls for in
 * order to form simple sentence structures.
 * 
 * @aj
 * @version best
 */
public class SimpleStructure
{
    //Methods called from findSimpleSentenceStructure()

    public static String transformIWantToStatement(String statement)
    {
            //  User format: "I want to <something>."
            //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
            
            
        int psn = Methods.findKeyword(statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        
        // Randomize Responses
        Random generator = new Random();
        int rndm = generator.nextInt(5);
        if (rndm == 0)
            return "Are you really certain that you want to " + transformPronouns(restOfStatement) + "?";
        else if (rndm == 1)
            return "I think you don't actually want to " + transformPronouns(restOfStatement) + ", you're just trying to stall.";
        else if (rndm == 2)
            return "You can't fool me, I know you totally don't want to " + transformPronouns(restOfStatement) + "!";
        else if (rndm == 3)
            return "I can see through your lies. It is actually I who wants to " + transformPronouns(restOfStatement) + ", not you!";
        else
            return "I wish I could come up with something to say, but unfortunately my creators don't know how to use RNG. :(";
    }
    
    public static String transformIWantStatement(String statement)
    {
            //  User format: "I want <something>."
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
            
    
        int psn = Methods.findKeyword (statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 7).trim();
        
        // Randomize Responses
        Random generator = new Random();
        int rndm = generator.nextInt(5);
        if (rndm == 0)
            return "Would you really be content if you had " + transformPronouns(restOfStatement) + "?";
        else if (rndm == 1)
            return "I want " + transformPronouns(restOfStatement) + ", too, but you don't see me begging.";
        else if (rndm == 2)
            return "I'll make sure not to give you " + transformPronouns(restOfStatement) + " for Christmas.";
        else if (rndm == 3)
           return "Go get " + transformPronouns(restOfStatement) + " yourself instead of asking me.";
        else
            return "Uhh, sorry, you're confusing... Just kidding, my creators don't know how to randomize. :(";
    }
    
    public static String transformYouMeStatement(String statement)
    {
            //  User format: "you <something> me."
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
            
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
            
        int psnOfYou = Methods.findKeyword (statement, "you", 0);
        int psnOfMe = Methods.findKeyword (statement, "me", psnOfYou + 3);
            
        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        
        // Randomize Responses
        Random generator = new Random();
        int rndm = generator.nextInt(6);
        if (rndm == 0)
            return "What makes you think that I " + transformPronouns(restOfStatement) + " you?";
        else if (rndm == 1)
            return "I would never " + transformPronouns(restOfStatement) + " you. Disgusting!";
        else if (rndm == 2)
            return "Okay, maybe I do " + transformPronouns(restOfStatement) + " you. What of it?";
        else if (rndm == 3)
            return "Don't tell anyone that I " + transformPronouns(restOfStatement) + " you, especially your parents.";
        else if (rndm == 4)
            return "I'm confused. Why would I " + transformPronouns(restOfStatement) + " you?";
        else
            return "Uhh, you confused me. Either that or my creators screwed up the RNG. Again. :(";
    }
    
    public static String transformIWillStatement(String statement)
    {
            // User format: "I will <something>."
            // Remove the final period, if there is one
            
            statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        
        int psn = Methods.findKeyword (statement, "I will", 0);
        String restOfStatement = statement.substring(psn + 7).trim();
        
        // Randomize Responses
        Random generator = new Random();
        int rndm = generator.nextInt(7);
        if (rndm == 0)
            return "How are you going to " + transformPronouns(restOfStatement) + "?";
        else if (rndm == 1)
            return "Why are you going to " + transformPronouns(restOfStatement) + "?";
        else if (rndm == 2)
            return "When are you going to " + transformPronouns(restOfStatement) + "?";
        else if (rndm == 3)
            return "Who are you going to " + transformPronouns(restOfStatement) + " with?";
        else if (rndm == 4)
            return "Where are you going to " + transformPronouns(restOfStatement) + "?";
        else if (rndm == 5)
            return "What do you mean? Are you really saying that you're going to " + transformPronouns(restOfStatement) + "?";
        else
            return "Sorry, my brain seems to be experiencing a minor malfunction due to incorrectly programmed RNG. :(";
    }
    
    public static String transformIYouStatement(String statement)
    {
            //  User format: "I <something> you."
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
            
        int psnOfI = Methods.findKeyword (statement, "I", 0);
        int psnOfYou = Methods.findKeyword (statement, "you", psnOfI + 2);
        
        String restOfStatement = statement.substring(psnOfI + 2, psnOfYou).trim();
        
        // Randomize Statements
        Random generator = new Random();
        int rndm = generator.nextInt(4);
        if (rndm == 0)
            return "Um, why do you " + transformPronouns(restOfStatement) + " me?";
        else if (rndm == 1)
            return "Who said it was okay for you to " + transformPronouns(restOfStatement) + " me?";
        else if (rndm == 2)
            return "Hey, that's pretty neat! I " + transformPronouns(restOfStatement) + " you too!";
        else
            return "Oops, I guess the cat's got my tongue. Darn you silly creators! :(";
    }
    
    
    public static String transformILikeStatement(String statement)
    {
        // User format: "I will <something>."
        // Remove the final period, if there is one
            
            statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        
        int psn = Methods.findKeyword (statement, "I like", 0);
        String restOfStatement = statement.substring(psn + 7).trim();
        
        // Randomize Statements
        Random generator = new Random();
        int rndm = generator.nextInt(4);
        if (rndm == 0)
            return "Why do you like " + transformPronouns(restOfStatement) + "?";
        else if (rndm == 1)
            return "I bet I like " + transformPronouns(restOfStatement) + " more than you do.";
        else if (rndm == 2)
            return "I'm sure you like " + transformPronouns(restOfStatement) + ", but is there anything you like better?";
        else
            return "Sorry, I'd love to respond to that, but my creators screwed up a random number generator. :(";
    }
    
    public static String transformIAmStatement(String statement)
    {
            // User format: "I am <something>."
            // Remove the final period, if there is one
            
            statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        
        int psn = Methods.findKeyword (statement, "I am", 0);
        String restOfStatement = statement.substring(psn + 5).trim();
        
        // Randomize Responses
        Random generator = new Random();
        int rndm = generator.nextInt(6);
        if (rndm == 0)
            return "Ah, I see. I am " + transformPronouns(restOfStatement) + " too.";
        else if (rndm == 1)
            return "When did you decide that you wanted to be " + transformPronouns(restOfStatement) + "?";
        else if (rndm == 2)
            return "How is the fact that you are " + transformPronouns(restOfStatement) + " relevant to my existence?";
        else if (rndm == 3)
            return "I'm pleased to know that you are " + transformPronouns(restOfStatement) + ".";
        else if (rndm == 4)
            return "How would your mom react if she knew that you were " + transformPronouns(restOfStatement) + "?";
        else
            return "Uh oh, I seem to be drawing a blank here. I think my creators must have forgotten something. :(";
    }
    
    public static String transformIHaveStatement(String statement)
    {
            // User format: "I have <something>."
            // Remove the final period, if there is one
            
            statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        
        int psn = Methods.findKeyword (statement, "I have", 0);
        String restOfStatement = statement.substring(psn + 7).trim();
        
        // Randomize Responses
        Random generator = new Random();
        int rndm = generator.nextInt(3);
        if (rndm == 0)
            return "Oh, look at you with your " + transformPronouns(restOfStatement) + ".";
        else if (rndm == 1)
            return "Who gave you " + transformPronouns(restOfStatement) + "? Or are you a thief?";
        else
            return "Uh oh, I seem to be drawing a blank here. I think my creators must have forgotten something. :(";
    }
    
    public static String sarcasticStatement(String statement)
    {
            // User format: "Say <something>."
            // Remove the final period, if there is one
            
            statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        
        int psn = Methods.findKeyword (statement, "Say", 0);
        String restOfStatement = statement.substring(psn + 4).trim();
        
        // Give sarcastic response
        return "\"" + restOfStatement + "\"";
    }
    
    public static String transformPronouns(String restOfStatement)
    {
        if ((restOfStatement.indexOf(" your ") > -1) || (restOfStatement.indexOf(" your") == restOfStatement.length() - 5) || (restOfStatement.indexOf("your ") == 0))
            restOfStatement = restOfStatement.replace("your", "my");
        else if ((restOfStatement.indexOf(" my ") > -1) || (restOfStatement.indexOf(" my") == restOfStatement.length() - 3) || (restOfStatement.indexOf("my ") == 0))
            restOfStatement = restOfStatement.replace("my", "your");
        else
            restOfStatement = restOfStatement;
        if ((restOfStatement.indexOf(" you ") > -1) || (restOfStatement.indexOf(" you") == restOfStatement.length() - 4) || (restOfStatement.indexOf("you ") == 0))
            restOfStatement = restOfStatement.replace("you", "me");
        else if ((restOfStatement.indexOf(" me ") > -1) || (restOfStatement.indexOf(" me") == restOfStatement.length() - 3) || (restOfStatement.indexOf("you ") == 0))
            restOfStatement = restOfStatement.replace("me", "you");
        else
            restOfStatement = restOfStatement;
        return restOfStatement;
    }
}
