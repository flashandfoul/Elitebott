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
        int spacePsn = statement.indexOf(" ");
        int lastPsn = 0;
        longWord = "";
        while (spacePsn != -1){
            lastPsn = spacePsn;
            
            spacePsn = statement.indexOf(" ");
            
        }
        return "wip";
    }
    
    public static void sendToDocument(String longWord) throws IOException{
        PrintWriter writer = new PrintWriter(new File("DefinedWords.txt"));
        writer.println(longWord);
        writer.close();
    }
}
