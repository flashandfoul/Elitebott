/**
 * Write a description of class Gavin_and_Joe_Special_Project here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
public class GavinAndJoeSpecialProject
{
    static String longWord;
    //Finds longest word.
    public static String findLongestWord(String statement){
        int lastSpace = 0;
        int spacePsn = statement.indexOf(" ");
        longWord = statement.substring(0,spacePsn);
        int longLength = longWord.length();
        while (spacePsn != -1){
            lastSpace = spacePsn;
            spacePsn = statement.indexOf(" ", spacePsn+1);
            if (spacePsn - lastSpace > longLength)
                longWord = statement.substring(lastSpace, spacePsn);
                longLength = longWord.length();
        }
        return longWord;
    }
    
    public static void sendToDocument(String longWord) throws IOException{
        PrintWriter writer = new PrintWriter(new File("DefinedWords.txt"));
        writer.println(longWord);
        writer.close();
    }
}
