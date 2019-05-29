import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MonsterReader {

    private static Map<String, Monster> monsterDict = new HashMap<>();

    public static void read(){
        ArrayList<String> monsterStrings = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File("monstermanual.csv"))) {
            while(scanner.hasNextLine()){
                monsterStrings.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String tableHeaders = monsterStrings.get(0);
        monsterStrings.remove(0);

        for(String str: monsterStrings){
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
            String[] mInfoArray = stringToSplit.toString().split(",");
            for(int i = 0; i < mInfoArray.length; i++){
                mInfoArray[i] = mInfoArray[i].replace("^", ",");
            }

            monsterDict.put(mInfoArray[0], new Monster(mInfoArray));
        }


    }

    public static Map<String, Monster> getMonsterDict() {
        return monsterDict;
    }
}
