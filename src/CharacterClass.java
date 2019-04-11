import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("unused")
class CharacterClass {

    //stores all subclass options for the class, populated in classes than inherit from this
    private ArrayList<String> subclassChoices = new ArrayList<>();

    //stores all class features, depending on the chosen subclass
    Map<String, Map<Integer, ArrayList<String>>> classFeatures = new HashMap<>();

    private String className = "";
    CharacterClass(){
        int classLevel = 1;
    }

    void setClassName(String str){this.className = str;}

    void addSubclassChoice(String str){
        this.subclassChoices.add(str);
    }
    public String getClassName(){return this.className;}
    public ArrayList<String> getSubclassChoices(){return this.subclassChoices;}

    void printClassName(){
        System.out.println(getClassName());
    }

    //prints all the class features for all subclasses of the character class
    void showClassFeatures(){
        for(Map.Entry<String, Map<Integer, ArrayList<String>>> sub : classFeatures.entrySet()){
            Map<Integer, ArrayList<String>> x = sub.getValue();
            System.out.println(sub.getKey());
            for(Map.Entry<Integer, ArrayList<String>> featureSet : x.entrySet()){
                System.out.println( featureSet.getKey() + " " + featureSet.getValue());
            }

        }
    }

    void printSubClasses() {

        for(String str : subclassChoices){
            System.out.println(str);
        }

    }

}
