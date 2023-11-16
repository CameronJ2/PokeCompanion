import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.LinkedList;



public class App 
{
    public static void main(String[] args) throws IOException 
    {
        /* BufferedWriter writer = new BufferedWriter(new FileWriter("..\\testCharmander.txt"));
        URL url = new URL("https://www.serebii.net/pokedex-rs/004.shtml");
        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            writer.write(line);
            writer.newLine();
        } 

        
        writer.close();
        sc.close(); */

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Projects\\Personal\\PokeMoves\\testCharmander.txt"));
        String regex = "rowspan=\"2\">([1-9])</td>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String[] importantArray;
        String foundNumber = "wasn't found";
        boolean matchFound;
        LinkedList<String> moveLevels = new LinkedList<>();
        LinkedList<String> RSECMoveNames = new LinkedList<>();
        LinkedList<String> FRLGMoveNames = new LinkedList<>();
        LinkedList<String> TMHMAttacks = new LinkedList<>();
        LinkedList<String> FRLGETutorAttacks = new LinkedList<>();
        LinkedList<String> emeraldTutorAttacks = new LinkedList<>();
        LinkedList<String> specialAttacks = new LinkedList<>();
        String[] moveSections = {
            "Ruby/Sapphire/Emerald/Colosseum/XD Level Up",
            "Fire Red/Leaf Green Level Up",
            "TM & HM Attacks",
            "Fire Red/Leaf Green/Emerald Tutor Attacks",
            "Emerald Tutor Attacks",
            "Egg Moves",
            "Special Attacks"};
        boolean sectionMatch = false;
        int startIndex;
        int endIndex;

        /* for (int i = 0; i < 1782; i++){
            reader.readLine();
        }
        String importantLine = reader.readLine(); */
        String importantLine = reader.readLine();
        importantLine = reader.readLine();
        while (importantLine != null){
            if (!importantLine.contains("</table><p><a name=\"attacks\"></a><table class=\"dextable\"")){
                importantLine = reader.readLine();
                continue;
            }
            importantArray = importantLine.split("[><]");
            for (int i = 0; i < importantArray.length; i++){
                for (int j = 0; j < moveSections.length; j++){
                    String checkString = importantArray[i];
                    String compareString = moveSections[j];
                    if (checkString.equals(compareString)){
                        sectionMatch = true;
                        break;
                    }
                }
                if (sectionMatch){
                    /* startIndex = importantArray[i].indexOf(">");
                    endIndex = importantArray[i].indexOf("<"); */
                    importantLine = importantArray[i];
                    System.out.printf("%nNow starting section for %s%n", importantLine);
                }
                else if (importantArray[i].contains("href=\"/attackdex/")){
                    endIndex = importantArray[i].indexOf(".");
                    importantLine = importantArray[i].substring(19, endIndex);
                    //moveNames.add(importantLine);
                    System.out.printf("%s%n", importantLine);
                }
                sectionMatch = false;
            }
                
            /* for (int i = 0; i < importantArray.length; i++){
                importantLine = importantArray[i];
                
                if (importantLine.contains("href=\"/attackdex/") && !importantLine.contains("Gen")){
                    dotIndex = importantLine.indexOf(".");
                    importantLine = importantLine.substring(17, dotIndex);
                    moveNames.add(importantLine);
                }
            } */
        }

        

        


        /* for (int i = 0; i < moveNames.size(); i++){
            System.out.printf("number at position %d is %s%n", i, moveNames.get(i));
        } */
        //System.out.printf("%s", foundNumber);
        reader.close();

        //result = result.replaceAll("<[^>]*>", "");

        //System.out.println("Contents of the page: " + result);

        
        
    }
}
