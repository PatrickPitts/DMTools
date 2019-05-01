import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class Cleric extends CharacterClass {
    Map<Integer, ArrayList<String>> DDKnowledge = new HashMap<>();
    Map<Integer, ArrayList<String>> DDLife = new HashMap<>();
    Map<Integer, ArrayList<String>> DDLight = new HashMap<>();
    Map<Integer, ArrayList<String>> DDNature = new HashMap<>();
    Map<Integer, ArrayList<String>> DDTempest = new HashMap<>();
    Map<Integer, ArrayList<String>> DDTrickery = new HashMap<>();
    Map<Integer, ArrayList<String>> DDWar = new HashMap<>();


    Cleric() {
        this.setClassName("Cleric");
        this.addSubclassChoice("Divine Domain of Knowledge");
        this.addSubclassChoice("Divine Domain of Life");
        this.addSubclassChoice("Divine Domain of Light");
        this.addSubclassChoice("Divine Domain of Nature");
        this.addSubclassChoice("Divine Domain of Tempest");
        this.addSubclassChoice("Divine Domain of Trickery");
        this.addSubclassChoice("Divine Domain of War");

        classFeatures.put(3, new ArrayList<>(List.of() ) );
        classFeatures.put(4, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(5, new ArrayList<>(List.of("Destroy Undead(1/2)") ) );
        classFeatures.put(7, new ArrayList<>(List.of() ) );
        classFeatures.put(9, new ArrayList<>(List.of() ) );
        classFeatures.put(10, new ArrayList<>(List.of("Divine Intervention") ) );
        classFeatures.put(11, new ArrayList<>(List.of("Destroy Undead(2)") ) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(13, new ArrayList<>(List.of() ) );
        classFeatures.put(14, new ArrayList<>(List.of("Destroy Undead(3)") ) );
        classFeatures.put(15, new ArrayList<>(List.of() ) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(18, new ArrayList<>(List.of("Channel Divinity(3)") ) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(20, new ArrayList<>(List.of("Divine Intervention+") ) );

    }

    Cleric(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split("~");
        this.setSubclass(vals[1]);
        this.setClassLevel(Integer.parseInt(vals[2]));

    }

    public void setSubclass(String str){

        switch (str) {
            case "Divine Domain of Knowledge":
                this.setSubclassName("Divine Domain of Knowledge");
                classFeatures.put(1, new ArrayList<>(List.of("Spellcasting", "Blessing of Knowledge")));
                classFeatures.put(2, new ArrayList<>(List.of("Channel Divinity(1)", "CD: Knowledge of the Ages")));
                classFeatures.put(6, new ArrayList<>(List.of("Channel Divinity(2)", "CD: Read Thoughts")));
                classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement", "Destroy Undead(1)", "Potent Spell Casting")));
                classFeatures.put(17, new ArrayList<>(List.of("Destroy Undead(4)", "Visions of the Past")));
                break;
            case "Divine Domain of Life":
                this.setSubclassName("Divine Domain of Life");
                classFeatures.put(1, new ArrayList<>(List.of("Spellcasting", "Disciple of Life", "Bonus Heavy Armor Proficiency")));
                classFeatures.put(2, new ArrayList<>(List.of("Channel Divinity(1)", "CD: Preserve Life")));
                classFeatures.put(6, new ArrayList<>(List.of("Channel Divinity(2)", "Blessed Healer")));
                classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement", "Destroy Undead(1)", "Divine Strike")));
                classFeatures.put(17, new ArrayList<>(List.of("Destroy Undead(4)", "Supreme Healing")));
                break;
            case "Divine Domain of Light":
                this.setSubclassName("Divine Domain of Light");
                classFeatures.put(1, new ArrayList<>(List.of("Spellcasting", "Warding Flare", "Bonus Cantrip: Light")));
                classFeatures.put(2, new ArrayList<>(List.of("Channel Divinity(1)", "CD: Radiance of the Dawn")));
                classFeatures.put(6, new ArrayList<>(List.of("Channel Divinity(2)", "Improved Flare")));
                classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement", "Destroy Undead(1)", "Potent Spell Casting")));
                classFeatures.put(17, new ArrayList<>(List.of("Destroy Undead(4)", "Corona of Light")));
                break;
            case "Divine Domain of Nature":
                this.setSubclassName("Divine Domain of Nature");
                classFeatures.put(1, new ArrayList<>(List.of("Spellcasting", "Acolyte of Nature", "Bonus Cantrip: Druid")));
                classFeatures.put(2, new ArrayList<>(List.of("Channel Divinity(1)", "CD: Charm Animals and Plants")));
                classFeatures.put(6, new ArrayList<>(List.of("Channel Divinity(2)", "Dampen Elements")));
                classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement", "Destroy Undead(1)", "Divine Strike")));
                classFeatures.put(17, new ArrayList<>(List.of("Destroy Undead(4)", "Master of Nature")));
                break;
            case "Divine Domain of Tempest":
                this.setSubclassName("Divine Domain of Tempest");
                classFeatures.put(1, new ArrayList<>(List.of("Spellcasting", "Wrath of the Storm", "Bonus Heavy Armor Proficiency", "Bonus Martial Weapon Proficiency")));
                classFeatures.put(2, new ArrayList<>(List.of("Channel Divinity(1)", "CD: Destructive Wrath")));
                classFeatures.put(6, new ArrayList<>(List.of("Channel Divinity(2)", "Thunderbolt Strike")));
                classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement", "Destroy Undead(1)", "Divine Strike")));
                classFeatures.get(14).add("Divine Strike+");
                classFeatures.put(17, new ArrayList<>(List.of("Destroy Undead(4)", "Stormborn")));
                break;
            case "Divine Domain of Trickery":
                this.setSubclassName("Divine Domain of Trickery");
                classFeatures.put(1, new ArrayList<>(List.of("Spellcasting", "Blessing of the Trickster", "Bonus Heavy Armor Proficiency")));
                classFeatures.put(2, new ArrayList<>(List.of("Channel Divinity(1)", "CD: Invoke Duplicity")));
                classFeatures.put(6, new ArrayList<>(List.of("Channel Divinity(2)", "CD: Cloak of Shadows")));
                classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement", "Destroy Undead(1)", "Divine Strike")));
                classFeatures.get(14).add("Divine Strike+");
                classFeatures.put(17, new ArrayList<>(List.of("Destroy Undead(4)", "Improved Duplicity")));
                break;
            case "Divine Domain of War":
                this.setSubclassName("Divine Domain of War");
                classFeatures.put(1, new ArrayList<>(List.of("Spellcasting", "Disciple of Life", "Bonus Heavy Armor Proficiency", "Bonus Martial Weapon Proficiency", "War Priest")));
                classFeatures.put(2, new ArrayList<>(List.of("Channel Divinity(1)", "CD: Guided Strike")));
                classFeatures.put(6, new ArrayList<>(List.of("Channel Divinity(2)", "CD: War God's Blessing")));
                classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement", "Destroy Undead(1)", "Divine Strike")));
                classFeatures.get(14).add("Divine Strike+");
                classFeatures.put(17, new ArrayList<>(List.of("Destroy Undead(4)", "Supreme Healing")));
                break;
        }
    }

}
