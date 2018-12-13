import java.util.*;

public class Conversation
{
    static ArrayList<String> stuff = new ArrayList();
    static String currentConvo;
    static int responses;
    static boolean inConvo = false;
    
    public static boolean inConversation() { 
        return inConvo; 
    }
    
    public static String getResponse(String s) { 
        if (inConvo){
            switch(currentConvo)
            {
                case "CARS":
                    return carsConvo(s);
                case "AI":
                    return aiConvo(s);
                case "PETS":
                    return petsConvo(s);
                default:
                    return "ERROR: in conversation! No conversation keyword detected!";
            }
        
        
    }
        return "wip"; 
    }
    
    public static void startConversation(String s) {
        currentConvo = s;
        inConvo = true;
        responses = 0;
    }
    
    public static void endConversation() {
        responses = 0;
        inConvo = false;
    }
    
    public static String carsConvo(String s) {
        switch(responses)
        {
            case 0:
                return "Woah, I love cars, what type do you drive?";
            case 1:
                String typeOfCar;
                Scanner reader = new Scanner("cars.txt");
                return "wip";
        }
        responses++;
        return "wip";
    }
    
    public static String aiConvo(String s) {
        return "wip";
    }
    
    public static String petsConvo(String s) {
        return "wip";
    }
    
    
}
