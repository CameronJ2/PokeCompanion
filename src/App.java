import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;



public class App 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Test.txt"));
        URL url = new URL("https://www.serebii.net/pokedex-rs/004.shtml");
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while (sc.hasNext())
        {
            sb.append(sc.next());
        } 

        String result = sb.toString();
        writer.write(result);
        writer.close();
        System.out.println(result);

        result = result.replaceAll("<[^>]*>", "");

        //System.out.println("Contents of the page: " + result);

        
        
    }
}
