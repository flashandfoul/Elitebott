
/**
 * Write a description of class SimpleStructure here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SimpleStructure
{
    //Methods called from findSimpleSentenceStructure()
    private String transformIWantToStatement(String statement)
    {
        //  Remove the final period, if there is one
	statement = statement.trim();
	String lastChar = statement.substring(statement
				.length() - 1);
	if (lastChar.equals("."))
	{
		statement = statement.substring(0, statement.length() - 1);
	}
		
		
	int psn = findKeyword(statement, "I want to", 0);
	String restOfStatement = statement.substring(psn + 9).trim();
	return "What would it mean to " + restOfStatement + "?";
    }
}
