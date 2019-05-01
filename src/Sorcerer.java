import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Sorcerer extends CharacterClass {
    Sorcerer(){
        this.setClassName("Sorcerer");
        this.addSubclassChoice("Draconic Bloodline");
        this.addSubclassChoice("Wild Magic");

        classFeatures.put(2, new ArrayList<>(List.of("Font of Magic") ) );
        classFeatures.put(3, new ArrayList<>(List.of("Metamagic") ) );
        classFeatures.put(4, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(5, new ArrayList<>(List.of() ) );
        classFeatures.put(7, new ArrayList<>(List.of() ) );
        classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(9, new ArrayList<>(List.of() ) );
        classFeatures.put(10, new ArrayList<>(List.of("Metamagic") ) );
        classFeatures.put(11, new ArrayList<>(List.of() ) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(13, new ArrayList<>(List.of() ) );
        classFeatures.put(15, new ArrayList<>(List.of() ) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(17, new ArrayList<>(List.of("Metamagic") ) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(20, new ArrayList<>(List.of("Sorcerous Restoration") ) );
    }

    Sorcerer(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split(Del.CLASS_DEL);
        this.setSubclass(vals[1]);
        this.setClassLevel(Integer.parseInt(vals[2]));
    }

    public void setSubclass(String str){
        switch(str){
            case "Draconic Bloodline":
                this.setSubclassName("Draconic Bloodline");
                classFeatures.put(1, new ArrayList<>(List.of("Spellcasting", "Dragon Ancestor", "Draconic Resilience") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Elemental Affinity") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Dragon Wings") ) );
                classFeatures.put(18, new ArrayList<>(List.of("Draconic Presence") ) );
                break;
            case "Wild Magic":
                this.setSubclassName("Wild Magic");
                classFeatures.put(1, new ArrayList<>(List.of("Spellcasting", "Wild Magic Surge", "Tides of Chaos") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Bend Luck") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Controlled Chaos") ) );
                classFeatures.put(18, new ArrayList<>(List.of("Spell Bombardment") ) );
                break;
        }
    }

    public int getSorceryPoints(){
        if(this.getClassLevel()>1){
            return this.getClassLevel();
        } return 0;
    }
}
