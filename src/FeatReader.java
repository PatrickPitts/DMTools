import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FeatReader {

    private static ArrayList<String[]> featStrings = new ArrayList<>();

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


    }
    public static ArrayList<String[]> getFeatStrings(){

        read();
        featStrings.remove(0);
        return featStrings;
    }
}
