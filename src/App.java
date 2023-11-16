import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;


public class App 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter("..\\testCharmander.txt"));
        URL url = new URL("https://www.serebii.net/pokedex-rs/193.shtml");
        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            writer.write(line);
            writer.newLine();
        } 

        writer.close();
        sc.close();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Projects\\Personal\\PokeMoves\\testCharmander.txt"));
        String[] importantArray;
        String[] moveSections = {
            "Ruby/Sapphire/Emerald/Colosseum/XD Level Up",
            "Fire Red/Leaf Green Level Up",
            "TM & HM Attacks",
            "Fire Red/Leaf Green/Emerald Tutor Attacks",
            "Emerald Tutor Attacks",
            "Egg Moves",
            "Special Attacks"};
        boolean sectionMatch = false;
        int endIndex;
        String currentSection = "none";
        String level = "0";


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
                    importantLine = importantArray[i];
                    System.out.printf("%nNow starting section for %s%n", importantLine);
                    currentSection = importantLine;
                }
                else if (importantArray[i].contains("href=\"/attackdex/")){
                    endIndex = importantArray[i].indexOf(".");
                    importantLine = importantArray[i].substring(19, endIndex);
                    level = importantArray[i-5];
                    if (importantArray[i-5].contains("&#8212")){
                        level = "0";
                    }
                    if (currentSection.equals(moveSections[0]) || currentSection.equals(moveSections[1])){
                        System.out.printf("%s at level %s%n", importantLine, level);
                    }
                    else if (currentSection.equals(moveSections[2])){
                        System.out.printf("%s from %s%n", importantLine, level);
                    }
                    else if (currentSection.equals(moveSections[3]) || currentSection.equals(moveSections[4]) || currentSection.equals(moveSections[5]) || currentSection.equals(moveSections[6])){
                        System.out.printf("%s%n", importantLine);
                    }
                }
                sectionMatch = false;
            }
        }
        reader.close();
    }
}
