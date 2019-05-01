import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Druid extends CharacterClass {
    Druid(){
        this.setClassName("Druid");
        this.addSubclassChoice("Circle of the Land");
        this.addSubclassChoice("Circle of the Moon");

        classFeatures.put(1, new ArrayList<>(List.of("Druidic", "Spellcasting") ) );
        classFeatures.put(2, new ArrayList<>(List.of("Wild Shape", "Druid Circle") ) );
        classFeatures.put(3, new ArrayList<>(List.of() ) );
        classFeatures.put(4, new ArrayList<>(List.of("Wild Shape Improvement", "Ability Score Improvement") ) );
        classFeatures.put(5, new ArrayList<>(List.of() ) );
        classFeatures.put(7, new ArrayList<>(List.of() ) );
        classFeatures.put(8, new ArrayList<>(List.of("Wild Shape Improvement", "Ability Score Improvement") ) );
        classFeatures.put(9, new ArrayList<>(List.of() ) );
        classFeatures.put(11, new ArrayList<>(List.of() ) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(13, new ArrayList<>(List.of() ) );
        classFeatures.put(15, new ArrayList<>(List.of() ) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(17, new ArrayList<>(List.of() ) );
        classFeatures.put(18, new ArrayList<>(List.of("Timeless Body", "Beast Spells") ) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(20, new ArrayList<>(List.of("Archdruid") ) );
    }

    Druid(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split("~");
        this.setSubclass(vals[1]);
        this.setClassLevel(Integer.parseInt(vals[2]));
    }


    public void setSubclass(String str){

        if(str.equals("Circle of the Land")){
            this.setSubclassName("Circle of the Land");
            classFeatures.put(2, new ArrayList<>(List.of("Bonus Cantrip", "Natural Recovery") ) );
            classFeatures.put(3, new ArrayList<>(List.of("Circle Spells") ) );
            classFeatures.put(5, new ArrayList<>(List.of("Circle Spells") ) );
            classFeatures.put(6, new ArrayList<>(List.of("Land's Stride") ) );
            classFeatures.put(7, new ArrayList<>(List.of("Circle Spells") ) );
            classFeatures.put(9, new ArrayList<>(List.of("Circle Spells") ) );
            classFeatures.put(10, new ArrayList<>(List.of("Nature's Ward") ) );
            classFeatures.put(14, new ArrayList<>(List.of("Nature's Sanctuary") ) );

        }else if (str.equals("Circle of the Moon")){
            this.setSubclassName("Circle of the Moon");
            classFeatures.put(2, new ArrayList<>(List.of("Combat Wild Shape", "Circle Forms") ) );
            classFeatures.put(6, new ArrayList<>(List.of("Improved Circle Forms", "Primal Strike") ) );
            classFeatures.put(10, new ArrayList<>(List.of("Elemental Wild Shape") ) );
            classFeatures.put(14, new ArrayList<>(List.of("Thousand Forms") ) );
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
