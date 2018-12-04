
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
	return "What would it mean to " + restOfStatement + "?";
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
	if (restOfStatement.equals("you")){
		restOfStatement = "me";
	}
	return "Would you really be happy if you had " + restOfStatement + "?";  
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
	return "What makes you think that I " + restOfStatement + " you?";
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
	return "Why do you " + restOfStatement + " me?";
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
	return "Why are you going to " + restOfStatement + "?";
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
	return "Why do you like " + restOfStatement + "?";
    }
}
