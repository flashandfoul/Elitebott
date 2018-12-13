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
                return "Woah, I love cars, what is your favorite type?";
            case 1:
                String typeOfCar = "", storage;
                boolean foundCar = false;
                Scanner reader = new Scanner("cars.txt");
                while(reader.hasNext())
                {
                    storage = reader.next();
                    if(Methods.findKeyword(s,storage,0) > -1)
                    {
                        foundCar = true;
                        typeOfCar = storage;
                    }
                }
                if(foundCar)
                {
                    return "What do you like about your " + typeOfCar + ".";
                }
                return "What do you like about that car?";
            case 2:
                return "wip";
        }
        responses++;
        return "wip";
    }
    
    public static String aiConvo(String s) {
        return "wip";
    }
    
    public static String petsConvo(String s) {
        
        switch(responses){
          case 0:
            return "Oh, you own other living beings? I do, too. What type of animal do you own?";
          case 1:
            return "wip";
        }
       
        responses++;
        return "wip";
    }
    
    
}
