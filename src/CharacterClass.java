import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("unused")
class CharacterClass {
    Scanner scnr = new Scanner(System.in);
    //stores all subclass options for the class, populated in classes than inherit from this
    private ArrayList<String> subclassChoices = new ArrayList<>();

    //stores all class features, depending on the chosen subclass
    Map<Integer, ArrayList<String>> classFeatures = new HashMap<>();


    private String className = "";
    private String subClassName;
    private int classLevel;

    CharacterClass(){
        classLevel = 1;
        subClassName = "None";
    }

    void setSubclassName(String str){this.subClassName = str;}
    void setClassName(String str){this.className = str;}

    void addSubclassChoice(String str){
        this.subclassChoices.add(str);
    }
    String getClassName(){return this.className;}
    public ArrayList<String> getSubclassChoices(){return this.subclassChoices;}

    void printClassName(){
        System.out.println(getClassName());
    }


    void setClassLevel(int n){
        classLevel = n;
    }
    int getClassLevel(){
        return classLevel;
    }
    String getSubClassName(){
        return this.subClassName;
    }
    void printSubClasses() {

        for(String str : subclassChoices){
            System.out.println(str);
        }
    }

    String getClassString(){
        return this.getClassName()+"~"+this.getSubClassName()+"~"+this.getClassLevel();
    }

    ArrayList<String> getAllClassFeatures(){
        ArrayList<String> allClassFeatures = new ArrayList<>();
        for(int i = 1; i <= this.classLevel; i++){
            allClassFeatures.addAll(this.classFeatures.get(i));
        }
        return allClassFeatures;
    }
    /*
    * MAY CAUSE PROBLEMS WITH INHERITED CHARACTER CLASS OBJECTS, AS THIS WAS ORIGINALLY IMPLEMENTED IN
    * EACH CLASS INDIVIDUALLY.
    * */
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
