import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;



public class App 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Test.txt"));  // Changed file extension to .html
        URL url = new URL("https://www.serebii.net/pokedex-rs/004.shtml");
        Scanner sc = new Scanner(url.openStream());
        StringBuilder sb = new StringBuilder();  // Using StringBuilder for efficiency
        while (sc.hasNextLine())  // Read line by line to preserve formatting
        {
            sb.append(sc.nextLine());  // Append the entire line
            sb.append(System.lineSeparator());  // Append a newline character
        } 

        String result = sb.toString();
        writer.write(result);
        writer.close();
        System.out.println("HTML content saved to Test.txt");
    }
}
