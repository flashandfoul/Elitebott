//typey like person
public class timerStuff{
    public static void printLikeHuman(String s) throws InterruptedException{
        for(int i = 0; i < s.length(); i++)
        {
            Thread.sleep(100);
            if(s.substring(i,i+1).equals("\\"))
            {
                System.out.println();
                i++;
            }
            System.out.print(s.substring(i,i+1));
        }
    }
}
