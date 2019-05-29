import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileLoader {
    private static ArrayList<String> allPartyNames = new ArrayList<>();

    public static String getData() throws IOException{

        String path = "pc_data.txt";
        BufferedReader b = new BufferedReader( new FileReader(path) );

        return b.readLine();
    }

    public static Party getPartyFromFile() throws IOException {
        return new Party(getData());
    }

    public static Map<String, Party> getPartyMapFromFile() throws IOException {
        Map<String, Party> allParties = new HashMap<>();
        Party masterParty = new Party(getData());
        ArrayList<PlayerCharacter> allPCS = masterParty.getPartyMembers();

        allParties.put("All", masterParty);

        for(int i = 0; i < allPCS.size(); i++){
            String n = allPCS.get(i).getPartyName();
            if(!allPartyNames.contains(n)){
                allPartyNames.add(n);
            }
        }

        for(String name: allPartyNames){
            allParties.put(name, new Party());
            allParties.get(name).setPartyName(name);
        }

        for(PlayerCharacter p : allPCS){
            allParties.get(p.getPartyName()).addPartyMember(p);
        }
        return allParties;
    }

    public static String[] getAllPartyNamesAsArray(){
        String[] ret = new String[allPartyNames.size()];
        for(int i = 0; i < allPartyNames.size(); i++){
            ret[i] = allPartyNames.get(i);
        }
        return ret;
    }

}
