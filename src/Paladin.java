import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Paladin extends CharacterClass{
    Paladin(){
        this.setClassName("Paladin");
        this.addSubclassChoice("Oath of Devotion");
        this.addSubclassChoice("Oath of the Ancients");
        this.addSubclassChoice("Oath of Vengeance");
        this.setHitDieValue(10);


        classFeatures.put(1, new ArrayList<>(List.of("Divine Sense", "Lay on Hands")) );
        classFeatures.put(2, new ArrayList<>(List.of("Fighting Style", "Spellcasting", "Divine Smite")) );
        classFeatures.put(4, new ArrayList<>(List.of("Ability Score Improvement")) );
        classFeatures.put(5, new ArrayList<>(List.of("Extra Attack")) );
        classFeatures.put(6, new ArrayList<>(List.of("Aura of Protection")) );
        classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement")) );
        classFeatures.put(9, new ArrayList<>(List.of()) );
        classFeatures.put(10, new ArrayList<>(List.of("Aura of Courage")) );
        classFeatures.put(11, new ArrayList<>(List.of("Improved Divine Smite")) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement")) );
        classFeatures.put(13, new ArrayList<>(List.of()) );
        classFeatures.put(14, new ArrayList<>(List.of("Cleansing Touch")) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement")) );
        classFeatures.put(17, new ArrayList<>(List.of()) );
        classFeatures.put(18, new ArrayList<>(List.of("Aura Improvements")) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement")) );
    }

    Paladin(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split(Del.CLASS_DEL);
        this.setSubclass(vals[1]);
        this.setClassLevel(Integer.parseInt(vals[2]));
    }

    public void setSubclass(String str){
        switch(str){
            case "Oath of Devotion":
                this.setSubclassName("Oath of Devotion");
                classFeatures.put(3, new ArrayList<>(List.of("Channel Divinity Effect: Devotion", "Devotion Spells")) );
                classFeatures.put(7, new ArrayList<>(List.of("Aura of Devotion")) );
                classFeatures.put(15, new ArrayList<>(List.of("Purity of Spirit")) );
                classFeatures.put(18, new ArrayList<>(List.of("Aura of Devotion+")) );
                classFeatures.put(20, new ArrayList<>(List.of("Holy Nimbus")) );
                break;
            case "Oath of Vengeance":
                this.setSubclassName("Oath of Vengeance");
                classFeatures.put(3, new ArrayList<>(List.of("Channel Divinity Effect: Vengeance", "Vengeance Spells")) );
                classFeatures.put(7, new ArrayList<>(List.of("Relentless Avenger")) );
                classFeatures.put(15, new ArrayList<>(List.of("Soul of Vengeance")) );
                classFeatures.put(18, new ArrayList<>(List.of()) );
                classFeatures.put(20, new ArrayList<>(List.of("Avenging Angel")) );
                break;
            case "Oath of the Ancients":
                this.setSubclassName("Oath of the Ancients");
                classFeatures.put(3, new ArrayList<>(List.of("Channel Divinity Effect: Ancients", "Ancient Spells")) );
                classFeatures.put(7, new ArrayList<>(List.of("Aura of Warding")) );
                classFeatures.put(15, new ArrayList<>(List.of("Undying Sentinel")) );
                classFeatures.put(18, new ArrayList<>(List.of("Aura of Warding+")) );
                classFeatures.put(20, new ArrayList<>(List.of("Elder Champion")) );
                break;
        }
    }

    public ArrayList<String> getClassFeatures(){
        ArrayList<String> featuresAlist = new ArrayList<>();
        for(int i = 1; i < this.getClassLevel(); i++){
            featuresAlist.addAll(classFeatures.get(i));
        }
        return featuresAlist;
    }
}

