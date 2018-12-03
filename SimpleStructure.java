
/**
 * Class SimpleStructure is a compilation of methods that
 * the Methods.findSimpleSentenceStructure() calls for in
 * order to form simple sentence structures.
 * 
 * @aj
 * @version (a version number or a date)
 */
public class SimpleStructure
{
    //Methods called from findSimpleSentenceStructure()
    
    
    private String transformIWantToStatement(String statement)
    {
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
    
    private String transformIWantStatement(String statement)
    {
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
}
