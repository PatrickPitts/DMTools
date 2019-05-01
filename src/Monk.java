import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Monk extends CharacterClass {
    Monk(){
        this.setClassName("Monk");
        this.addSubclassChoice("Way of the Open Hand");
        this.addSubclassChoice("Way of Shadow");
        this.addSubclassChoice("Way of the Four Elements");


        classFeatures.put(1, new ArrayList<>(List.of("Unarmored Defense", "Martial Arts") ) );
        classFeatures.put(2, new ArrayList<>(List.of("Ki", "Unarmored Movement") ) );
        classFeatures.put(4, new ArrayList<>(List.of("Ability Score Improvement", "Slow Fall") ) );
        classFeatures.put(5, new ArrayList<>(List.of("Extra Attack", "Stunning Strike") ) );
        classFeatures.put(7, new ArrayList<>(List.of("Evasion", "Stillness of Mind") ) );
        classFeatures.put(8, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(9, new ArrayList<>(List.of("Unarmored Movement+") ) );
        classFeatures.put(10, new ArrayList<>(List.of("Purity of Body") ) );
        classFeatures.put(11, new ArrayList<>(List.of() ) );
        classFeatures.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(13, new ArrayList<>(List.of("Tongue of the Sun and Moon") ) );
        classFeatures.put(14, new ArrayList<>(List.of("Diamond Soul") ) );
        classFeatures.put(15, new ArrayList<>(List.of("Timeless Body") ) );
        classFeatures.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(18, new ArrayList<>(List.of("Empty Body") ) );
        classFeatures.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        classFeatures.put(20, new ArrayList<>(List.of("Perfect Self") ) );
    }

    Monk(String saved){
        this();
        //saved should look like "CharacterClass~SubClass~Level"
        String[] vals = saved.split(Del.CLASS_DEL);
        this.setSubclass(vals[1]);
        this.setClassLevel(Integer.parseInt(vals[2]));
    }

    //FIXME if you change the subclass, the .add methods wont clear out old data, only adds ontop
    public void setSubclass(String str){
        switch (str) {
            case "Way of the Open Hand":
                this.setSubclassName("Way of the Open Hand");
                classFeatures.put(3, new ArrayList<>(List.of("Deflect Missiles", "Open Hand Technique") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Ki-Empowered Strike", "Wholeness of Body") ) );
                classFeatures.put(11, new ArrayList<>(List.of("Tranquility")));
                classFeatures.put(17, new ArrayList<>(List.of("Quivering Palm")));
                break;
            case "Way of Shadow":
                this.setSubclassName("Way of Shadow");
                classFeatures.put(3, new ArrayList<>(List.of("Deflect Missiles", "Shadow Arts") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Ki-Empowered Strike", "Shadow Step") ) );
                classFeatures.put(11, new ArrayList<>(List.of("Cloak of Shadows")));
                classFeatures.put(17, new ArrayList<>(List.of("Opportunist")));
                break;
            case "Way of the Four Elements":
                this.setSubclassName("Way of the Four Elements");
                classFeatures.put(3, new ArrayList<>(List.of("Deflect Missiles", "Disciple of the Elements") ) );
                classFeatures.put(6, new ArrayList<>(List.of("Ki-Empowered Strike", "Disciple of the Elements") ) );
                classFeatures.put(11, new ArrayList<>(List.of("Disciple of the Elements")));
                classFeatures.put(17, new ArrayList<>(List.of("Disciple of the Elements")));
                break;
        }
    }

    public int getKiPoints(){
        if(this.getClassLevel()>1){
            return this.getClassLevel();
        } return 0;
    }
}
