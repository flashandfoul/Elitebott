
/**
 * last choice response
 * Aidan's terribly disfigured class
 */
import java.util.*;
import java.io.*;
public class gottacommit{
    private String response=""; private int x=0;
    public static boolean hasinitted=false;
    static Random dumbo=new Random();
    static ArrayList neutralresponse=new ArrayList();
    private static int arrayterms;
    static Scanner filereader=new Scanner(new File("randomresponses.txt"));
    //initialize array for use in random responses
    public static void initializearray(){
        if(!hasinitted){
            while(filereader.hasNext()){
            neutralresponse.add(filereader.nextLine());
        }
        hasinitted=true;
        }
    }
    
    public static String getNonCommitalResponse(String statement){
        initializearray();
        String tehresponse=neutralresponse.get(dumbo.nextInt(arrayterms));
        return tehresponse;
    }
}