import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Fighter extends CharacterClass {
    Fighter(){
        this.setClassName("Fighter");
        this.addSubclassChoice("Champion");
        this.addSubclassChoice("Battle Master");
        this.addSubclassChoice("Eldritch Knight");
        this.setHitDieValue(10);

        classFeatures.put(1, new ArrayList<>(List.of("Fighting Style", "Second Wind") ) );
        classFeatures.put(2, new ArrayList<>(List.of("Action Surge") ) );
        classFeatures.put(4, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(5, new ArrayList<>(List.of("Extra Attack") ) );
        classFeatures.put(6, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(9, new ArrayList<>(List.of("Indomitable") ) );
        classFeatures.put(11, new ArrayList<>(List.of("Extra Attack+") ) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(13, new ArrayList<>(List.of("Indomitable+") ) );
        classFeatures.put(14, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(17, new ArrayList<>(List.of("Action Surge+", "Indomitable++") ) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(20, new ArrayList<>(List.of("Extra Attack++") ) );
    }
    Fighter(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split(Del.CLASS_DEL);
        this.setSubclass(vals[1]);
        this.setClassLevel(Integer.parseInt(vals[2]));
    }

    public void setSubclass(String str){
        switch (str) {
            case "Champion":
                this.setSubclassName("Champion");
                classFeatures.put(3, new ArrayList<>(List.of("Improved Critical")));
                classFeatures.put(7, new ArrayList<>(List.of("Remarkable Athlete")));
                classFeatures.put(10, new ArrayList<>(List.of("Additional Fighting Style")));
                classFeatures.put(15, new ArrayList<>(List.of("Superior Critical")));
                classFeatures.put(18, new ArrayList<>(List.of("Survivor")));
                break;
            case "Battle Master":
                this.setSubclassName("Battle Master");
                classFeatures.put(3, new ArrayList<>(List.of("Combat Superiority", "Student of War")));
                classFeatures.put(7, new ArrayList<>(List.of("Add Superiority Die", "Add Maneuvers", "Know Your Enemy")));
                classFeatures.put(10, new ArrayList<>(List.of("Improved Combat Superiority", "Add Maneuvers")));
                classFeatures.put(15, new ArrayList<>(List.of("Add Superiority Die", "Add Maneuvers", "Relentless")));
                classFeatures.put(18, new ArrayList<>(List.of("Improved Combat Superiority+")));
                break;
            case "Eldritch Knight":
                this.setSubclassName("Eldritch Knight");
                classFeatures.put(3, new ArrayList<>(List.of("Spellcasting", "Weapon Bond")));
                classFeatures.put(7, new ArrayList<>(List.of("War Magic")));
                classFeatures.put(10, new ArrayList<>(List.of("Eldritch Strike")));
                classFeatures.put(15, new ArrayList<>(List.of("Arcane Charge")));
                classFeatures.put(18, new ArrayList<>(List.of("Improved War Magic")));
                break;
        }
    }



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
