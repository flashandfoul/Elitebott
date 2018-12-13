import java.util.*;

public class Conversation
{
    static ArrayList<String> stuff = new ArrayList();
    static String currentConvo;
    
    static boolean inConvo = false;
    
    public static boolean inConversation() { 
        return inConvo; 
    }
    
    public static String getResponse() { 
        stuff.add("\\Conversations\\cars");
        return "wip"; 
    }
    
    public static void startConversation(String s) {
        currentConvo = s;
        inConvo = true;
    }
    
    public static void endConversation() {
        inConvo = false;
    }
}
