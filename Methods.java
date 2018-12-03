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
            return Conversation.getCurrentConversation().getResponse();
        return "wip";
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
        
    }
    
    private static String getNonCommitalResponse(String statement)
    {
        return "wip";
    }
    
    private static String maybeAddName(String statement)
    {
        return "wip";
    }
    
    private int findKeyword(String statement, String goal, int startPos)
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