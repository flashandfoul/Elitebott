
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
    static ArrayList<String> neutralresponse=new ArrayList();
    private static int arrayterms;
    
    //initialize array for use in random responses
    public static void initializearray()throws IOException{
        if(!hasinitted){
        Scanner filereader=new Scanner(new File("randomresponses.txt"));
            while(filereader.hasNext()){
            neutralresponse.add(filereader.nextLine());
        }
        hasinitted=true;
        }
    }
    
    public static String getNonCommitalResponse(String statement)throws IOException{
        initializearray();
        int responsenumber=dumbo.nextInt(arrayterms);
        String tehresponse=neutralresponse.get(responsenumber);
        return tehresponse;
    }
}