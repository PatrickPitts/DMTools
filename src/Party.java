import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("unused")

public class Party {
    public ArrayList<PlayerCharacter> partyMembers = new ArrayList<>();
    public String partyName;

    Party(String saved){
        String[] characterData = saved.split(Del.CHAR_DEL);
        for(String str : characterData){
            partyMembers.add(new PlayerCharacter(str));
        }
        this.setPartyName(partyMembers.get(0).getPartyName());
    }

    Party(){}

    public void addPartyMember(PlayerCharacter p){
        partyMembers.add(p);
    }
    public void setPartyName(String str) {partyName = str;}
    public String getPartyName() {return this.partyName;}

    public ArrayList<PlayerCharacter> getPartyMembers(){
        return partyMembers;
    }

    public String[] getPartyMemberNames(){
        String[] namesToReturn = new String[partyMembers.size()];

        for(int i = 0; i < partyMembers.size(); i++){
            namesToReturn[i] = partyMembers.get(i).getName();
        }
        return namesToReturn;
    }

    public void exportSaveString() throws IOException {

        String saveString = "";
        int i;
        for(i = 0; i < partyMembers.size()-1; i++){
            saveString += partyMembers.get(i).exportDataString() + Del.CHAR_DEL;
        }
        saveString += partyMembers.get(i).exportDataString();
        FileSaver.saveData(saveString);
    }

    public int[] getDexMods(){
        int[] mods = new int[partyMembers.size()];
        for(int i = 0; i < partyMembers.size(); i++){
            mods[i] = partyMembers.get(i).getDexterity();
        }

        return mods;
    }
}
