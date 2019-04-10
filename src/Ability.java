import java.util.ArrayList;

public interface Ability {


    ArrayList<String> getRequirements();
    ArrayList<String> getEffects();
    int getLevelRequirement();

    void addRequirement(String str);
    void addEffect(String str);
    void setLevelRequirement(int n);

}
