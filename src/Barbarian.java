import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("unused")
public class Barbarian  extends CharacterClass{


    Barbarian() {
        this.setClassName("Barbarian");
        this.addSubclassChoice("Path of the Berserker");
        this.addSubclassChoice("Path of the Totem Warrior");

        // Populates the classFeatures Map for Barbarian class features
        Map<Integer, ArrayList<String>> POTBerserkerAList = new HashMap<>();
        Map<Integer, ArrayList<String>> POTTotemWarriorAList = new HashMap<>();

        POTBerserkerAList.put(1, new ArrayList<>(List.of("Rage", "Unarmored Defense") ) );
        POTTotemWarriorAList.put(1, new ArrayList<>(List.of("Rage", "Unarmored Defense") ) );

        POTBerserkerAList.put(2,new ArrayList<>(List.of("Reckless Attack", "Danger Sense") ) );
        POTTotemWarriorAList.put(2,new ArrayList<>(List.of("Reckless Attack", "Danger Sense") ) );

        POTBerserkerAList.put(3, new ArrayList<>(List.of("Primal Path", "Frenzy") ) );
        POTTotemWarriorAList.put(3, new ArrayList<>(List.of("Primal Path", "Spirit Seeker", "Totem Spirit") ) );

        POTBerserkerAList.put(4 ,new ArrayList<>(List.of("Ability Score Improvement") ) );
        POTTotemWarriorAList.put(4, new ArrayList<>(List.of("Ability Score Improvement") ) );

        POTBerserkerAList.put(5, new ArrayList<>(List.of("Extra Attack", "Fast Movement") ) );
        POTTotemWarriorAList.put(5, new ArrayList<>(List.of("Extra Attack", "Fast Movement") ) );

        POTBerserkerAList.put(6, new ArrayList<>(List.of("Mindless Rage") ) );
        POTTotemWarriorAList.put(6, new ArrayList<>(List.of("Aspect of the Beast") ) );

        POTBerserkerAList.put(7, new ArrayList<>(List.of("Feral Instinct") ) );
        POTTotemWarriorAList.put(7, new ArrayList<>(List.of("Feral Instinct") ) );

        POTBerserkerAList.put(8, new ArrayList<>(List.of("Ability Score Improvement") ) );
        POTTotemWarriorAList.put(8, new ArrayList<>(List.of("Ability Score Improvement") ) );

        POTBerserkerAList.put(9, new ArrayList<>(List.of("Brutal Critical") ) );
        POTTotemWarriorAList.put(9, new ArrayList<>(List.of("Brutal Critical") ) );

        POTBerserkerAList.put(10, new ArrayList<>(List.of("Intimidating Presence") ) );
        POTTotemWarriorAList.put(10, new ArrayList<>(List.of("Spirit Walker") ) );

        POTBerserkerAList.put(11, new ArrayList<>(List.of("Relentless Rage") ) );
        POTTotemWarriorAList.put(11, new ArrayList<>(List.of("Relentless Rage") ) );

        POTBerserkerAList.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );
        POTTotemWarriorAList.put(12, new ArrayList<>(List.of("Ability Score Improvement") ) );

        POTBerserkerAList.put(13, new ArrayList<>(List.of("Brutal Critical+") ) );
        POTTotemWarriorAList.put(13, new ArrayList<>(List.of("Brutal Critical+") ) );

        POTBerserkerAList.put(14, new ArrayList<>(List.of("Retaliation") ) );
        POTTotemWarriorAList.put(14, new ArrayList<>(List.of("Totemic Attunement") ) );

        POTBerserkerAList.put(15, new ArrayList<>(List.of("Persistent Rage") ) );
        POTTotemWarriorAList.put(15, new ArrayList<>(List.of("Persistent Rage") ) );

        POTBerserkerAList.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );
        POTTotemWarriorAList.put(16, new ArrayList<>(List.of("Ability Score Improvement") ) );

        POTBerserkerAList.put(17, new ArrayList<>(List.of("Brutal Critical++") ) );
        POTTotemWarriorAList.put(17, new ArrayList<>(List.of("Brutal Critical++") ) );

        POTBerserkerAList.put(18, new ArrayList<>(List.of("Indomitable Might") ) );
        POTTotemWarriorAList.put(18, new ArrayList<>(List.of("Indomitable Might") ) );

        POTBerserkerAList.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );
        POTTotemWarriorAList.put(19, new ArrayList<>(List.of("Ability Score Improvement") ) );

        POTBerserkerAList.put(20, new ArrayList<>(List.of("Primal Champion") ) );
        POTTotemWarriorAList.put(20, new ArrayList<>(List.of("Primal Champion") ) );




        classFeatures.put("Path of the Berserker", POTBerserkerAList);
        classFeatures.put("Path of the Totem Warrior", POTTotemWarriorAList);




    }
}
