import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Wizard extends CharacterClass {
    Wizard(){
        this.setClassName("Wizard");
        this.addSubclassChoice("Abjuration");
        this.addSubclassChoice("Conjuration");
        this.addSubclassChoice("Divination");
        this.addSubclassChoice("Enchantment");
        this.addSubclassChoice("Evocation");
        this.addSubclassChoice("Illusion");
        this.addSubclassChoice("Necromancy");
        this.addSubclassChoice("Transmutation");

        classFeatures.put(1, new ArrayList<>(List.of("Spellcasting", "Arcane Recovery") ) );
        classFeatures.put(3, new ArrayList<>(List.of() ) );
        classFeatures.put(4, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(5, new ArrayList<>(List.of() ) );
        classFeatures.put(7, new ArrayList<>(List.of() ) );
        classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(9, new ArrayList<>(List.of() ) );
        classFeatures.put(11, new ArrayList<>(List.of() ) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(13, new ArrayList<>(List.of() ) );
        classFeatures.put(15, new ArrayList<>(List.of() ) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(17, new ArrayList<>(List.of() ) );
        classFeatures.put(18, new ArrayList<>(List.of("Spell Mastery") ) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(20, new ArrayList<>(List.of("Signature Spell") ) );
    }
    Wizard(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split(Del.CLASS_DEL);
        this.setSubclass(vals[1]);
        this.setClassLevel(Integer.parseInt(vals[2]));
    }
    public void setSubclass(String str){
        switch(str){
            case "Abjuration":
                this.setSubclassName("Abjuration");
                classFeatures.put(2, new ArrayList<>(List.of("Abjuration Savant", "Arcane Ward") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Projected Ward") ) );
                classFeatures.put(10, new ArrayList<>(List.of("Improved Abjuration") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Spell Resistance") ) );
                break;
            case "Conjuration":
                this.setSubclassName("Conjuration");
                classFeatures.put(2, new ArrayList<>(List.of("Conjuration Savant", "Minor Conjuration") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Benign Transposition") ) );
                classFeatures.put(10, new ArrayList<>(List.of("Focused Conjuration") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Durable Summons") ) );
                break;
            case "Divination":
                this.setSubclassName("Divination");
                classFeatures.put(2, new ArrayList<>(List.of("Divination Savant", "Portent") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Expert Divination") ) );
                classFeatures.put(10, new ArrayList<>(List.of("The Third Eye") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Greater Portent") ) );
                break;
            case "Enchantment":
                this.setSubclassName("Enchantment");
                classFeatures.put(2, new ArrayList<>(List.of("Enchantment Savant", "Hypnotic Gaze") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Instinctive Charm") ) );
                classFeatures.put(10, new ArrayList<>(List.of("Split Enchantment") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Alter Memories") ) );
                break;
            case "Evocation":
                this.setSubclassName("Evocation");
                classFeatures.put(2, new ArrayList<>(List.of("Evocation Savant", "Sculpt Spells") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Potent Cantrip") ) );
                classFeatures.put(10, new ArrayList<>(List.of("Empowered Evocations") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Overchannel") ) );
                break;
            case "Illusion":
                this.setSubclassName("Illusion");
                classFeatures.put(2, new ArrayList<>(List.of("Illusion Savant", "Improved Minor Illusion") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Malleable Illusions") ) );
                classFeatures.put(10, new ArrayList<>(List.of("Illusory Self") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Illusory Reality") ) );
                break;
            case "Necromancy":
                this.setSubclassName("Necromancy");
                classFeatures.put(2, new ArrayList<>(List.of("Necromancy Savant", "Grim Harvest") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Undead Thralls") ) );
                classFeatures.put(10, new ArrayList<>(List.of("Inured to Undeath") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Command Undead") ) );
                break;
            case "Transmutation":
                this.setSubclassName("Transmutation");
                classFeatures.put(2, new ArrayList<>(List.of("Transmutation Savant", "Minor Alchemy") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Transmuter's Stone") ) );
                classFeatures.put(10, new ArrayList<>(List.of("Shapechanger") ) );
                classFeatures.put(14, new ArrayList<>(List.of("Master Transmuter") ) );
                break;
        }
    }
}
