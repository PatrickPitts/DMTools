import java.io.*;

public class FileSaver{

    public static void main(String[] args) throws IOException{

        String filename = "data.txt";

        String toSave = "";

        toSave += "Bob" + Del.MAIN_DEL;//PlayerName String
        toSave += "Bob, destroyer of worlds" + Del.MAIN_DEL;//CharacterName String
        toSave += "0" + Del.MAIN_DEL;//Inspiration int
        toSave += "10,10,10,10,10,10" + Del.MAIN_DEL;//AbilityScores int[]
        toSave += "0,0,0,0,0,0" + Del.MAIN_DEL;//SavingThrowProficiency int[]
        toSave += "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0" + Del.MAIN_DEL;//SkillProficiency int[]
        toSave += "Nerd" + Del.MAIN_DEL;//Background String
        toSave += "CN" + Del.MAIN_DEL;//Alignment String
        toSave += "1000" + Del.MAIN_DEL;//Experience int
        toSave += "30" + Del.MAIN_DEL;//speed int
        toSave += "30" + Del.MAIN_DEL;//MaxHP int
        toSave += "25" + Del.MAIN_DEL;//CurrentHP int
        toSave += "5" + Del.MAIN_DEL;//TempHP
        toSave += "Boring" + Del.MAIN_DEL;//PersonalityTraits
        toSave += "Cool Stuff" + Del.MAIN_DEL;//Ideals
        toSave += "Cats" + Del.MAIN_DEL;//Bonds
        toSave += "Really, really boring" + Del.MAIN_DEL;//Flaws
        toSave += "Spoons,Short Sword,Simple Weapons" + Del.MAIN_DEL;//OtherProficiencies
        toSave += "3 Spoons,Rubber Ducky" + Del.MAIN_DEL;//Equipment
        toSave += "Interpretive Dance,Clogging" + Del.MAIN_DEL;//Abilities
        toSave += "10,20,30,40,50" + Del.MAIN_DEL;//Money
        toSave += "Barbarian~Path of the Totem Warrior~5" + Del.MAIN_DEL;//Classes
        toSave += "Dwarf"+Del.MAIN_DEL; //Race
        toSave += "Test" + Del.MAIN_DEL; // Party
        toSave += "Chosen one, or some other such BS.";

        toSave += Del.CHAR_DEL;

        toSave += "Charlie" + Del.MAIN_DEL;//PlayerName String
        toSave += "Charlene" + Del.MAIN_DEL;//CharacterName String
        toSave += "0" + Del.MAIN_DEL;//Inspiration int
        toSave += "20,20,20,20,20,20" + Del.MAIN_DEL;//AbilityScores int[]
        toSave += "0,0,0,0,0,0" + Del.MAIN_DEL;//SavingThrowProficiency int[]
        toSave += "0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0" + Del.MAIN_DEL;//SkillProficiency int[]
        toSave += "Dork" + Del.MAIN_DEL;//Background String
        toSave += "LG" + Del.MAIN_DEL;//Alignment String
        toSave += "1000" + Del.MAIN_DEL;//Experience int
        toSave += "25" + Del.MAIN_DEL;//speed int
        toSave += "45" + Del.MAIN_DEL;//MaxHP int
        toSave += "15" + Del.MAIN_DEL;//CurrentHP int
        toSave += "20" + Del.MAIN_DEL;//TempHP
        toSave += "Boring" + Del.MAIN_DEL;//PersonalityTraits
        toSave += "Cool Stuff" + Del.MAIN_DEL;//Ideals
        toSave += "Cats" + Del.MAIN_DEL;//Bonds
        toSave += "Really, really boring" + Del.MAIN_DEL;//Flaws
        toSave += "Spoons,Short Sword,Simple Weapons" + Del.MAIN_DEL;//OtherProficiencies
        toSave += "3 Spoons,Rubber Ducky" + Del.MAIN_DEL;//Equipment
        toSave += "Interpretive Dance,Clogging" + Del.MAIN_DEL;//Abilities
        toSave += "10,20,30,40,50" + Del.MAIN_DEL;//Money
        toSave += "Cleric~Divine Domain of Knowledge~10" + Del.MAIN_DEL;//Classes
        toSave += "Elf" + Del.MAIN_DEL; //Race
        toSave += "Test" + Del.MAIN_DEL; //Party
        toSave += "Something horribly tragic, I'm sure.";


        System.out.println(toSave);

        BufferedWriter out = new BufferedWriter( new FileWriter(filename));
        out.write(toSave);
        out.close();

    }

    public static void saveData(String saveString) throws IOException {
        String filename = "data.txt";

        BufferedWriter out = new BufferedWriter( new FileWriter(filename));
        out.write(saveString);
        out.close();
    }

}
