import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Rogue extends CharacterClass {
    Rogue(){
        this.setClassName("Rogue");
        this.addSubclassChoice("Thief");
        this.addSubclassChoice("Assassin");
        this.addSubclassChoice("Arcane Trickster");

        Map<Integer, ArrayList<String>> RAThief = new HashMap<>();
        Map<Integer, ArrayList<String>> RAAssassin = new HashMap<>();
        Map<Integer, ArrayList<String>> RATrickster = new HashMap<>();

        RAThief.put(1, new ArrayList<>(List.of("Expertise", "Sneak Attack", "Thieves' Cant") ) );
        RAAssassin.put(1, new ArrayList<>(List.of("Expertise", "Sneak Attack", "Thieves' Cant") ) );
        RATrickster.put(1, new ArrayList<>(List.of("Expertise", "Sneak Attack", "Thieves' Cant") ) );

        classFeatures.put("Thief", RAThief);
        classFeatures.put("Assassin", RAAssassin);
        classFeatures.put("Arcane Trickster" ,RATrickster);

    }
}
