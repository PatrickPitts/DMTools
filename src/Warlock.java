import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Warlock extends CharacterClass {
    Warlock(){
        this.setClassName("Warlock");
        this.addSubclassChoice("The Archfey");
        this.addSubclassChoice("The Great Old One");
        this.addSubclassChoice("The Fiend");


        classFeatures.put(2, new ArrayList<>(List.of("Eldritch Invocations") ) );
        classFeatures.put(3, new ArrayList<>(List.of("Pact Boon") ) );
        classFeatures.put(4, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(5, new ArrayList<>(List.of() ) );
        classFeatures.put(7, new ArrayList<>(List.of() ) );
        classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(9, new ArrayList<>(List.of() ) );
        classFeatures.put(11, new ArrayList<>(List.of("Mystic Arcanum (6th)") ) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(13, new ArrayList<>(List.of("Mystic Arcanum (7th)") ) );
        classFeatures.put(15, new ArrayList<>(List.of("Mystic Arcanum (8th)") ) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(17, new ArrayList<>(List.of("Mystic Arcanum (9th)") ) );
        classFeatures.put(18, new ArrayList<>(List.of() ) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(20, new ArrayList<>(List.of("Eldritch Master") ) );
    }

    Warlock(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split(Del.CLASS_DEL);
        this.setSubclass(vals[1]);
        this.setClassLevel(Integer.parseInt(vals[2]));
    }

    public void setSubclass(String str){
        switch(str){
            case "The Archfey":
                this.setSubclassName("The Archfey");
                classFeatures.put(1, new ArrayList<>(List.of("Pact Magic", "Expanded Spell List: Archfey", "Fey Presence") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Misty Escape") ) );
                classFeatures.put(10, new ArrayList<>(List.of("Beguiling Defenses") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Derk Delirium") ) );
                break;
            case "The Great Old One":
                this.setSubclassName("The Great Old One");
                classFeatures.put(1, new ArrayList<>(List.of("Pact Magic", "Expanded Spell List: Old One", "Awakened Mind") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Entropic Ward") ) );
                classFeatures.put(10, new ArrayList<>(List.of("Thought Shield") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Create Thrall") ) );
                break;
            case "The Fiend":
                this.setSubclassName("The Fiend");
                classFeatures.put(1, new ArrayList<>(List.of("Pact Magic", "Expanded Spell List: Fiend", "Dark One's Blessing") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Dark One's Own Luck") ) );
                classFeatures.put(10, new ArrayList<>(List.of("Fiendish Resilience") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Hurl Through Hell") ) );
                break;
        }
    }
}
