

public class Conversation
{
    static boolean inConvo = false;
    
    public static boolean inConversation() { 
        return inConvo; 
    }
    
    public static String getResponse() { 
        return "wip"; 
    }
    
    public static void startConversation(String s) {
        inConvo = true;
    }
    
    public static void endConversation() {
        inConvo = false;
    }
}
