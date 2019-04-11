import java.util.ArrayList;

@SuppressWarnings("unused")

public class PlayerCharacter extends Creature {

    private String playerName;
    private ArrayList<CharacterClass> characterClasses = new ArrayList<>();

    public PlayerCharacter(){

    }

    public void addCharacterClass(CharacterClass ch){
        characterClasses.add(ch);
    }


}
