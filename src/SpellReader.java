import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SpellReader {

    public static Map<String, Spell> getSpellMap() {
        return spellMap;
    }

    private static ArrayList<String[]> spellStrings = new ArrayList<>();
    private static Map<String, Spell> spellMap = new HashMap<>();

    public static void read(){

        ArrayList<String> records = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File("DNDSpells.csv"))) {
            while(scanner.hasNextLine()){
                records.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(String str : records){

            System.out.println(str);

            StringBuilder stringToSplit = new StringBuilder(str);
            boolean inQuotes = false;

            for(int i = 0; i < stringToSplit.length(); i++){
                if(stringToSplit.charAt(i) == '\"'){
                    inQuotes = !inQuotes;
                }
                if(stringToSplit.charAt(i) == ',' && inQuotes){
                    stringToSplit.setCharAt(i, '^');
                }
            }
            String[] spellInfo = stringToSplit.toString().split(",");
            spellInfo[spellInfo.length - 1] = spellInfo[spellInfo.length - 1].replace("^", ",");
            spellStrings.add(spellInfo);
            spellMap.put(spellInfo[0], new Spell(spellInfo));
        }
    }
}
