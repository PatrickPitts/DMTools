import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Rogue extends CharacterClass {
    Rogue(){

        this.setClassName("Rogue");
        this.addSubclassChoice("Thief");
        this.addSubclassChoice("Assassin");
        this.addSubclassChoice("Arcane Trickster");

        classFeatures.put(1, new ArrayList<>(List.of("Expertise", "Sneak Attack", "Thieve's Cant") ) );
        classFeatures.put(2, new ArrayList<>(List.of("Cunning Action") ) );
        classFeatures.put(4, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(5, new ArrayList<>(List.of("Uncanny Dodge") ) );
        classFeatures.put(6, new ArrayList<>(List.of("Expertise") ) );
        classFeatures.put(7, new ArrayList<>(List.of("Evasion") ) );
        classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(10, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(11, new ArrayList<>(List.of("Reliable Talent") ) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(14, new ArrayList<>(List.of("Blindsense") ) );
        classFeatures.put(15, new ArrayList<>(List.of("Slippery Mind") ) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(18, new ArrayList<>(List.of("Elusive") ) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(20, new ArrayList<>(List.of("Stroke of Luck") ) );
    }

    Rogue(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split(Del.CLASS_DEL);
        this.setSubclass(vals[1]);
        this.setClassLevel(Integer.parseInt(vals[2]));
    }




    public void setSubclass(String str){
        switch(str){
            case "Thief":
                this.setSubclassName("Thief");
                classFeatures.put(3, new ArrayList<>(List.of("Fast Hands", "Second-Story Work") ) );
                classFeatures.put(9, new ArrayList<>(List.of("Supreme Sneak") ) );
                classFeatures.put(13, new ArrayList<>(List.of("Use Magic Device") ) );
                classFeatures.put(17, new ArrayList<>(List.of("Thief's Reflexes") ) );
                break;
            case "Assassin":
                this.setSubclassName("Assassin");
                classFeatures.put(3, new ArrayList<>(List.of("Bonus Proficiencies", "Assassinate ") ) );
                classFeatures.put(9, new ArrayList<>(List.of("Infiltration Expertise") ) );
                classFeatures.put(13, new ArrayList<>(List.of("Impostor") ) );
                classFeatures.put(17, new ArrayList<>(List.of("Death Strike") ) );
                break;
            case "Arcane Trickster":
                this.setSubclassName("Arcane Trickster");
                classFeatures.put(3, new ArrayList<>(List.of("Spellcasting", "Mage Hand Legerdemain") ) );
                classFeatures.put(9, new ArrayList<>(List.of("Magical Ambush") ) );
                classFeatures.put(13, new ArrayList<>(List.of("Versatile Trickster") ) );
                classFeatures.put(17, new ArrayList<>(List.of("Spell Thief") ) );
                break;
        }
    }
}
