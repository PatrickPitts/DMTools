import java.util.ArrayList;

public class ClassAbility implements Ability {

    private int levelRequirement = 0;
    private ArrayList<String> requirements = new ArrayList<>();
    private ArrayList<String> effects = new ArrayList<>();

    public ArrayList<String> getRequirements(){
        return this.requirements;
    }

    public ArrayList<String> getEffects(){
        return this.effects;
    }

    public int getLevelRequirement(){
        return this.levelRequirement;
    }

    public void addRequirement(String str){
        this.requirements.add(str);
    }
    public void addEffect(String str){
        this.effects.add(str);
    }
    public void setLevelRequirement(int n){
        this.levelRequirement = n;
    }
}
