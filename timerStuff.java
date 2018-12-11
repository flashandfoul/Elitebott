//typey like person
import java.util.Random;
public class timerStuff{
    public static void printLikeHuman(String s) throws InterruptedException{
        Thread.sleep(1000);
        Random wobble=new Random();
        for(int i = 0; i < s.length(); i++)
        {
            Thread.sleep(0+wobble.nextInt(100)+1);
            if(s.substring(i,i+1).equals("\\"))
            {
                System.out.println();
                i++;
            }
            System.out.print(s.substring(i,i+1));
        }
    }
}
