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
        if (inConvo){
            switch(currentConvo)
            {
                case "CARS":
                    return carsConvo();
                case "AI":
                    return aiConvo();
                case "PETS":
                    return petsConvo();
                default:
                    return "ERROR: in conversation! No conversation keyword detected!";
            }
        
        
    }
        return "wip"; 
    }
    
    public static void startConversation(String s) {
        currentConvo = s;
        inConvo = true;
    }
    
    public static void endConversation() {
        inConvo = false;
    }
    
    public static String carsConvo() {
        return "wip";
    }
    
    public static String aiConvo() {
        return "wip";
    }
    
    public static String petsConvo() {
        return "wip";
    }
    
    
}
