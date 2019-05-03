import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
class Bard extends CharacterClass {
    Map<Integer, ArrayList<String>> COLoreAList = new HashMap<>();
    Map<Integer, ArrayList<String>> COValorAList = new HashMap<>();

    Bard(){
        this.setClassName("Bard");
        this.addSubclassChoice("College of Lore");
        this.addSubclassChoice("College of Valor");
        this.setHitDieValue(8);

        classFeatures.put(1, new ArrayList<>(List.of("Bardic Inspiration", "Spellcasting") ) );
        classFeatures.put(2, new ArrayList<>(List.of("Jack of All Trades", "Song of Rest") ) );
        classFeatures.put(4, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(5, new ArrayList<>(List.of("Font of Inspiration", "Bardic Inspiration+") ) );
        classFeatures.put(7, new ArrayList<>(List.of() ) );
        classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(9, new ArrayList<>(List.of("Song of Rest+") ) );
        classFeatures.put(10, new ArrayList<>(List.of("Magical Secrets", "Expertise", "Bardic Inspiration++") ) );
        classFeatures.put(11, new ArrayList<>(List.of() ) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(13, new ArrayList<>(List.of("Song of Rest++") ) );
        classFeatures.put(15, new ArrayList<>(List.of("Bardic Inspiration+++") ) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(17, new ArrayList<>(List.of("Song of Rest+++") ) );
        classFeatures.put(18, new ArrayList<>(List.of("Magical Secrets") ) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(20, new ArrayList<>(List.of("Superior Inspiration") ) );

        COLoreAList.put(3, new ArrayList<>(List.of("Bonus Proficiencies", "Expertise", "Cutting Words") ) );
        COLoreAList.put(6, new ArrayList<>(List.of("Magical Secrets", "Countercharm") ) );
        COLoreAList.put(14, new ArrayList<>(List.of("Magical Secrets", "Peerless Skill") ) );


        COValorAList.put(3, new ArrayList<>(List.of("Bonus Proficiencies","Combat Inspiration", "Expertise") ) );
        COValorAList.put(6, new ArrayList<>(List.of("Countercharm", "Extra Attack") ) );
        COValorAList.put(14, new ArrayList<>(List.of("Magical Secrets", "Battle Magic") ) );
    }

    Bard(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split("~");
        setSubclass(vals[1]);
        setClassLevel(Integer.parseInt(vals[2]));
    }

    public void setSubclass(String str){

        if(str.equals("College of Lore")){
            classFeatures.put(3,COLoreAList.get(3));
            classFeatures.put(6,COLoreAList.get(6));
            classFeatures.put(14,COLoreAList.get(14));
        } else if(str.equals("College of Valor")){
            classFeatures.put(3,COValorAList.get(3));
            classFeatures.put(6,COValorAList.get(6));
            classFeatures.put(14,COValorAList.get(14));
        }
    }
}
