import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AbilityReader {

    private static ArrayList<String[]> featStrings = new ArrayList<>();
    private static ArrayList<String > featNames = new ArrayList<>();
    private static Map<String, String> nameToPageMap = new HashMap<>();
    private static Map<String, String> nameToBookMap = new HashMap<>();
    private static Map<String, String> nameToBodyMap = new HashMap<>();
    private static Map<String, String> nameToRequirementsMap = new HashMap<>();

    public static void read(){
        ArrayList<String> records = new ArrayList<>();
        //FIXME file that stores feats data is accessed here, may need to update file access
        try(Scanner scanner = new Scanner(new File("Feats.csv"))){
            while(scanner.hasNextLine()){
                records.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(String str : records){
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
            String[] featInfo = stringToSplit.toString().split(",");
            featInfo[featInfo.length - 1] = featInfo[featInfo.length - 1].replace("^", ",");
            featStrings.add(featInfo);
        }

        for(String[] listOfFeatData : featStrings){
            featNames.add(listOfFeatData[0]);
            nameToPageMap.put(listOfFeatData[0], listOfFeatData[2]);
            nameToBodyMap.put(listOfFeatData[0], listOfFeatData[4]);
            nameToBookMap.put(listOfFeatData[0], listOfFeatData[1]);
            nameToRequirementsMap.put(listOfFeatData[0], listOfFeatData[3]);

        }
        featNames.remove(0);


    }

    public static ArrayList<String> getFeatNames(){
        return featNames;
    }

    public static String getFeatBody(String featName){
        return nameToBodyMap.get(featName);
    }

    public static String getFeatRequirements(String featName){
        return nameToRequirementsMap.get(featName);
    }

    public static String getFeatPageNumber(String featName){
        return nameToPageMap.get(featName);
    }

    public static String getFeatBook(String featName){
        return nameToBookMap.get(featName);
    }
}
