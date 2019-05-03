import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Barbarian  extends CharacterClass{


    Barbarian() {
        this.setClassName("Barbarian");
        this.addSubclassChoice("Path of the Berserker");
        this.addSubclassChoice("Path of the Totem Warrior");
        this.setHitDieValue(12);
        // Populates the classFeatures Map for Barbarian class features


        classFeatures.put(1, new ArrayList<>(List.of("Rage", "Unarmored Defense") ) );
        classFeatures.put(2,new ArrayList<>(List.of("Reckless Attack", "Danger Sense") ) );
        classFeatures.put(4 ,new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(5, new ArrayList<>(List.of("Extra Attack", "Fast Movement") ) );
        classFeatures.put(7, new ArrayList<>(List.of("Feral Instinct") ) );
        classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(9, new ArrayList<>(List.of("Brutal Critical") ) );
        classFeatures.put(11, new ArrayList<>(List.of("Relentless Rage") ) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(13, new ArrayList<>(List.of("Brutal Critical+") ) );
        classFeatures.put(15, new ArrayList<>(List.of("Persistent Rage") ) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(17, new ArrayList<>(List.of("Brutal Critical++") ) );
        classFeatures.put(18, new ArrayList<>(List.of("Indomitable Might") ) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(20, new ArrayList<>(List.of("Primal Champion") ) );
    }

    /**
     * Constructor who is intended to only be called when building the CharacterClass
     * object from saved data. Sets relevant fields based on the passed String
     * @param saved
     */
    Barbarian(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split("~");
        this.setSubclass(vals[1]);
        this.setClassLevel(Integer.parseInt(vals[2]));
    }

    public void setSubclass(String str){

        if(str.equals("Path of the Berserker")){
            this.setSubclassName("Path of the Berserker");

            classFeatures.put(3, new ArrayList<>(List.of("Frenzy") ) );
            classFeatures.put(6, new ArrayList<>(List.of("Mindless Rage") ) );
            classFeatures.put(10, new ArrayList<>(List.of("Intimidating Presence") ) );
            classFeatures.put(14, new ArrayList<>(List.of("Retaliation") ) );

        } else if(str.equals("Path of the Totem Warrior")){
            this.setSubclassName("Path of the Totem Warrior");

            classFeatures.put(3, new ArrayList<>(List.of("Spirit Seeker", "Totem Spirit") ) );
            classFeatures.put(6, new ArrayList<>(List.of("Aspect of the Beast") ) );
            classFeatures.put(10, new ArrayList<>(List.of("Spirit Walker") ) );
            classFeatures.put(14, new ArrayList<>(List.of("Totemic Attunement") ) );
        }
    }


    /**This method loops across the classFeatures ArrayList, up to the
     * set classLevel for this characterClass. The elements of the classFeatures
     * ArrayList are appended to featuresAList, which is then returned
     *
     * TL;DR, returns all level appropriate class features
    */
    public ArrayList<String> getClassFeatures(){
        ArrayList<String> featuresAlist = new ArrayList<>();
        for(int i = 1; i < this.getClassLevel(); i++){
            for(String f : classFeatures.get(i)){
                featuresAlist.add(f);
            }
        }
        return featuresAlist;
    }
}
