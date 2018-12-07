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
    
    //Finds longest word in the user's statement
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
        
        return longWord;
    }
    
    //Sends longest word to a text document for storage
    public static void sendToDocument(String longWord) throws IOException{
        Scanner reader = new Scanner(new File("DefinedWords.txt"));
        PrintWriter writer = new PrintWriter(new File("DefinedWords.txt"));
        
        while (reader.hasNext()){
            String word = reader.nextLine();
            writer.println(word);
        }
        writer.println(longWord);
        writer.close();
    }
}
