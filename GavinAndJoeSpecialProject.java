//this doesn't work :(





/**
 * This deals with the chatbot's ability to learn and recite new words.
 *
 * -Joe and Gavin
 * 
 */

import java.io.*;
import java.util.Scanner;

public class GavinAndJoeSpecialProject
{
    static String longWord;
    
    //Finds longest word in the user's statement.
    public static String findLongestWord(String statement){
        //Finds longest word.
        int lastSpace = 0;
        int spacePsn = statement.indexOf(" ");
        longWord = statement.substring(0,spacePsn);
        int longLength = longWord.length();
        while (spacePsn != -1){
            lastSpace = spacePsn;
            spacePsn = statement.indexOf(" ", spacePsn+1);
            if (spacePsn - lastSpace > longLength)
                longWord = statement.substring(lastSpace+1, spacePsn);
            longLength = longWord.length();
        }
        if (statement.substring(lastSpace+1).length() > longWord.length())
            longWord = statement.substring(lastSpace+1);
        
        //Removes punctuation.
        if (longWord.indexOf(".") == 0)
            longWord = longWord.substring(1);
        if (longWord.indexOf(".") > 0)
            longWord = longWord.substring(0,longWord.indexOf("."));
        if (longWord.indexOf(",") == 0)
            longWord = longWord.substring(1);
        if (longWord.indexOf(",") > 0)
            longWord = longWord.substring(0,longWord.indexOf(","));
        if (longWord.indexOf("(") == 0)
            longWord = longWord.substring(1);
        if (longWord.indexOf("(") > 0)
            longWord = longWord.substring(0,longWord.indexOf("("));
        if (longWord.indexOf(")") == 0)
            longWord = longWord.substring(1);
        if (longWord.indexOf(")") > 0)
            longWord = longWord.substring(0,longWord.indexOf(")"));
        if (longWord.indexOf("?") == 0)
            longWord = longWord.substring(1);
        if (longWord.indexOf("?") > 0)
            longWord = longWord.substring(0,longWord.indexOf("?"));
        if (longWord.indexOf("!") == 0)
            longWord = longWord.substring(1);
        if (longWord.indexOf("!") > 0)
            longWord = longWord.substring(0,longWord.indexOf("!"));
        if (longWord.indexOf(";") == 0)
            longWord = longWord.substring(1);
        if (longWord.indexOf(";") > 0)
            longWord = longWord.substring(0,longWord.indexOf(";"));
        if (longWord.indexOf("{") == 0)
            longWord = longWord.substring(1);
        if (longWord.indexOf("{") > 0)
            longWord = longWord.substring(0,longWord.indexOf("{"));
        if (longWord.indexOf("}") == 0)
            longWord = longWord.substring(1);
        if (longWord.indexOf("}") > 0)
            longWord = longWord.substring(0,longWord.indexOf("}"));
        if (longWord.indexOf("\"") == 0)
            longWord = longWord.substring(1);
        if (longWord.indexOf("\"") > 0)
            longWord = longWord.substring(0,longWord.indexOf("\""));
        if (longWord.indexOf("-") == 0)
            longWord = longWord.substring(1);
        if (longWord.indexOf("-") > 0)
            longWord = longWord.substring(0,longWord.indexOf("-"));

        return longWord;
    }
    public static void appendStrToFile(String fileName, 
                                       String str) 
    { 
        try { 
  
            // Open given file in append mode. 
            BufferedWriter writer = new BufferedWriter( 
                   new FileWriter("DefinedWords.txt", true)); 
            writer.write(str); 
            writer.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
    } 
    //Sends longest word to a text document for storage
    public static void sendToDocument(String longWord) throws IOException{
        Scanner reader = new Scanner(new File("DefinedWords.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("DefinedWords.txt"));
        String document = longWord;
        writer.write(document);
        writer.close();

        appendStrToFile("DefinedWords.txt", longWord); 
        

    }
}
