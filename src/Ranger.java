import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Ranger extends CharacterClass {
    Ranger(){
        this.setClassName("Ranger");
        this.addSubclassChoice("Hunter");
        this.addSubclassChoice("Beast Master");
        this.setHitDieValue(10);

        classFeatures.put(1, new ArrayList<>(List.of("Favored Enemy", "Natural Explorer") ) );
        classFeatures.put(2, new ArrayList<>(List.of("Fighting Style", "Spellcasting") ) );
        classFeatures.put(4, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(5, new ArrayList<>(List.of("Extra Attack") ) );
        classFeatures.put(6, new ArrayList<>(List.of("Favored Enemy+", "Natural Explorer+") ) );
        classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement", "Land's Stride") ) );
        classFeatures.put(9, new ArrayList<>(List.of() ) );
        classFeatures.put(10, new ArrayList<>(List.of("Natural Explorer++", "Hide in Plain Sight") ) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(13, new ArrayList<>(List.of() ) );
        classFeatures.put(14, new ArrayList<>(List.of("Favored Enemy++", "Vanish") ) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(17, new ArrayList<>(List.of() ) );
        classFeatures.put(18, new ArrayList<>(List.of("Feral Senses") ) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(20, new ArrayList<>(List.of("Foe Slayer") ) );
    }

    Ranger(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split(Del.CLASS_DEL);
        this.setSubclass(vals[1]);
        this.setClassLevel(Integer.parseInt(vals[2]));
    }

    public void setSubclass(String str){
        switch(str){
            case "Hunter":
                this.setSubclassName("Hunter");
                classFeatures.put(3, new ArrayList<>(List.of("Primeval Awareness", "Hunter's Prey") ) );
                classFeatures.put(7, new ArrayList<>(List.of("Defensive Tactics") ) );
                classFeatures.put(11, new ArrayList<>(List.of("Multiattack") ) );
                classFeatures.put(15, new ArrayList<>(List.of("Superior Hunter's Defense") ) );
                break;
            case "Beast Master":
                this.setSubclassName("Beast Master");
                classFeatures.put(3, new ArrayList<>(List.of("Primeval Awareness", "Ranger's Companion") ) );
                classFeatures.put(7, new ArrayList<>(List.of("Exceptional Training") ) );
                classFeatures.put(11, new ArrayList<>(List.of("Bestial Fury") ) );
                classFeatures.put(15, new ArrayList<>(List.of("Share Spells") ) );
                break;
        }
    }
}
