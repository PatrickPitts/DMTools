import java.util.ArrayList;
import java.util.Arrays;

//@SuppressWarnings("unused")

public class PlayerCharacter extends Creature {

    //Variable Initialization
    private String playerName = "";
    private String characterName = "";
    private int characterLevel = 0;
    private int inspiration = 0;
    private ArrayList<CharacterClass> characterClasses = new ArrayList<>();
    private int[] abilityScores = new int[]{0, 0, 0, 0, 0, 0};
    private int[] savingThrowsProficiency = new int[]{0, 0, 0, 0, 0, 0};
    private int[] skillProficiency = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private String background = "";
    private String alignment = "";
    private int experiencePoints = 0;
    private int speed = 0;
    private int hitPoints = 0; private int currentHitPoints = 0;
    private int temporaryHitPoints = 0;
    private String personalityTraits = ""; private String ideals = "";
    private String bonds = ""; private String flaws = "";
    private ArrayList<String> proficiencies = new ArrayList<>();
    private ArrayList<String> equipment = new ArrayList<>();
    private ArrayList<String> abilities = new ArrayList<>();
    private int[] currency = new int[]{0, 0, 0, 0, 0};
    private String race = "";
    private String partyName;
    private String backstory;

    //Basic Setter Methods
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public void setCharacterName(String characterName) {
        this.setName(characterName);
        this.characterName = characterName;
    }
    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }
    public void setCharacterLevel(){
        int totalLevel = 0;
        for(CharacterClass c : this.getCharacterClasses()){
            totalLevel += c.getClassLevel();
        }
        this.characterLevel = totalLevel;
    }
    public void setInspiration(int inspiration) {this.inspiration = inspiration;}
    public void setCharacterClasses(ArrayList<CharacterClass> characterClasses) {this.characterClasses = characterClasses;}
    public void setAbilityScores(int[] abilityScores) {this.abilityScores = abilityScores;}
    public void setSavingThrowsProficiency(int[] savingThrowsProficiency) {this.savingThrowsProficiency = savingThrowsProficiency;}
    public void setSkillProficiency(int[] skillProficiency) {this.skillProficiency = skillProficiency;}
    public void setBackground(String background) {this.background = background;}
    public void setAlignment(String alignment) {this.alignment = alignment;}
    public void setExperiencePoints(int experiencePoints) {this.experiencePoints = experiencePoints;}
    public void setSpeed(int speed) {this.speed = speed;}
    public void setSpeed(){
        //FIXME Only contains core classes, doesn't allow for custom classes
        String[] slow = new String[]{"Dwarf", "Halfling", "Gnome"};//25
        this.speed = (Arrays.asList(slow).contains(this.getRace())) ? 25 : 30;
    }
//    public void setHitPoints(int hitPoints) {this.hitPoints = hitPoints;}
//    public void setCurrentHitPoints(int currentHitPoints) {this.currentHitPoints = currentHitPoints;}
    public void setTemporaryHitPoints(int temporaryHitPoints) {this.temporaryHitPoints = temporaryHitPoints;}
    public void setPersonalityTraits(String personalityTraits) {this.personalityTraits = personalityTraits;}
    public void setIdeals(String ideals) {this.ideals = ideals;}
    public void setBonds(String bonds) {this.bonds = bonds;}
    public void setFlaws(String flaws) {this.flaws = flaws;}
    public void setProficiencies(ArrayList<String> proficiencies) {this.proficiencies = proficiencies;}
    public void setEquipment(ArrayList<String> equipment) {this.equipment = equipment;}
    public void setAbilities(ArrayList<String> abilities) {this.abilities = abilities;}
    public void setCurrency(int[] currency) {this.currency = currency;}
    public void setRace(String race) {this.race = race;}
    public void setPartyName(String partyName) {this.partyName = partyName;}
    public void setBackstory(String backstory) {this.backstory = backstory;}


    //Basic Getter Methods
    public int getCharacterLevel() {
        return characterLevel;
    }
    public int getInspiration() {
        return inspiration;
    }
    public ArrayList<CharacterClass> getCharacterClasses() {
        return characterClasses;
    }
    public int[] getAbilityScores() {
        return abilityScores;
    }
    public int[] getSavingThrowsProficiency() {
        return savingThrowsProficiency;
    }
    public int[] getSkillProficiency() {return skillProficiency;}
    public String getBackground() {return background;}
    public String getAlignment() {return alignment;}
    public int getExperiencePoints() {return experiencePoints;}
    public int getSpeed() {return speed;}
//    public int getHitPoints() {return hitPoints;}
//    public int getCurrentHitPoints() {return currentHitPoints;}
    public int getTemporaryHitPoints() {return temporaryHitPoints;}
    public String getPersonalityTraits() {return personalityTraits;}
    public String getIdeals() {return ideals;}
    public String getBonds() {return bonds;}
    public String getFlaws() {return flaws;}
    public ArrayList<String> getProficiencies() {return proficiencies;}
    public ArrayList<String> getEquipment() {return equipment;}
    public int[] getCurrency() {return currency;}
    public String getRace() {return race;}
    public ArrayList<String> getAbilities() {return abilities;}
    public String getPartyName() {return partyName;}
    public String getBackstory() {return backstory;}
    //Data-as-String Getter Methods

    public String getProficienciesString(){
        String str = "";
        ArrayList<String> prof = this.getProficiencies();
        int i;
        for(i = 0; i < prof.size()-1; i++){
            str += prof.get(i) + ",";
        }
        str += prof.get(i);
        return str;
    }

    public String getEquipmentString(){
        String str = "";
        ArrayList<String> eq = this.getEquipment();
        int i;
        for(i = 0; i < eq.size()-1; i++){
            str += eq.get(i) + ",";
        }
        str += eq.get(i);
        return str;
    }

    public String getAbilitiesString(){
        String str = "";
        ArrayList<String> ab = this.getAbilities();
        int i;
        for(i=0; i <ab.size()-1; i++){
            str += ab.get(i) + ",";
        }str+= ab.get(i);
        return str;
    }

    public String[] getAbilityModsAsString(){
        String[] mods = new String[6];
        int val;
        for(int i = 0; i < mods.length; i++){
            val = (getAbilityScores()[i]-10)/2;

            if(val > 0) {
                mods[i] = "+" + val;
            }else if (val == 0){
                mods[i] = "  " + val;
            } else {
                mods[i] = "" + val;
            }
        }
        return mods;
    }

    public String getAbilityScoresString(){
        return this.abilityScores[0] + "," + this.abilityScores[1] + ","
                + this.abilityScores[2] + "," +this.abilityScores[3] + ","
                + this.abilityScores[4] + "," +this.abilityScores[5];
    }

    public String[] getSavesAsStrings(){
        String[] mods = new String[6];
        int val;
        for(int i = 0; i < mods.length; i++){
            val = getAbilityMods()[i] + getSavingThrowsProficiency()[i]*getProficiencyBonus();
            if(val > 0){
                mods[i] = "+" + val;
            }else if (val == 0){
                mods[i] = "  " + val;
            } else {
                mods[i] = "" + val;
            }
        }
        return mods;
    }

    public String[] getSkillsAsStrings(){
        String[] mods = new String[18];
        int[] abilityAsc = new int[]{2,4,3,0,5,3,4,5,3,4,3,4,5,5,3,1,1,4};
        for(int i = 0; i < abilityAsc.length; i++){
            int val = getSkillProficiency()[i]*getProficiencyBonus() + getStatModifier(getAbilityScores()[abilityAsc[i]]);
            if(val > 0){
                mods[i] = "+" + val;
            } else if (val == 0){
                mods[i] = "  " + val;
            } else {
                mods[i] = "" + val;
            }
        }
        return mods;
    }
    public String getCurrencyString() {
        String str = "";
        int[] cur = this.getCurrency();
        int i;
        for(i = 0; i < cur.length-1; i++){
            str += cur[i] + ",";
        }str += cur[i];
        return str;
    }

    public String getSavingThrowProficiencyString(){
        String str = "";
        int[] sThrows = this.getSavingThrowsProficiency();
        int i;
        for(i = 0; i< sThrows.length-1; i++){
            str += sThrows[i] + ",";
        } str += sThrows[i];
        return str;
    }

    public String getSkillProficiencyString(){
        String str = "";
        int[] sProf = this.getSkillProficiency();
        int i;
        for(i = 0; i < sProf.length - 1; i++){
            str += sProf[i] + ",";
        } str += sProf[i];

        return str;
    }

    public String getHitDieAsString(){
        StringBuilder ret = new StringBuilder();
        int[] dieCount = new int[]{0,0,0,0};
        int[] dieVals = new int[]{6,8,10,12};
        for(CharacterClass c : getCharacterClasses()){
            if(c.getHitDieValue() == dieVals[0]){
                dieCount[0] += c.getClassLevel();
            } else if(c.getHitDieValue() == dieVals[1]){
                dieCount[1] += c.getClassLevel();
            } else if(c.getHitDieValue() == dieVals[2]){
                dieCount[2] += c.getClassLevel();
            } else if(c.getHitDieValue() == dieVals[3]) {
                dieCount[3] += c.getClassLevel();
            }
        }

        for(int i = 0; i < dieCount.length; i++){
            if (dieCount[i] != 0) {
                ret.append(dieCount[i]).append("d").append(dieVals[i]).append(" + ");

            }
        }
        return ret.substring(0, ret.length()-3);
    }

    public int[] getAbilityMods(){
        int[] mods = new int[6];
        for(int i = 0; i < mods.length; i++){
            mods[i] = (int) (getAbilityScores()[i]-10)/2;
        }
        return mods;
    }

    public int getProficiencyBonus(){
        return this.characterLevel/4+2;
    }

    public int getArmorClass(){
        return 10 + getAbilityMods()[1];
    }

    public void setFieldsFromFile(String str) {

        /*
        0 --> CharacterName, 1 --> PlayerName, 2 --> Inspiration, 3 --> AbilityScores, 4 --> SavingThrowProf,
        5 --> SkillProficiencies, 6 --> Background, 7 --> Alignment, 8 --> EXP, 9 --> Speed, 10 --> MaxHP,
        11 --> CurrentHP, 12 --> TempHP, 13 --> Personality, 14 --> Ideals, 15 --> Bonds, 16 --> Flaws,
        17 --> OtherProficiencies, 18 --> Equipment, 19 --> ListOfAbilities, 20 --> Currency, 21 --> Classes
        22 --> Race, 23 --> Party name, 24 --> backstory
        */

        String[] values = str.split(Del.MAIN_DEL);

        this.setPlayerName(values[0]);
        this.setCharacterName(values[1]);
        this.setInspiration(Integer.parseInt(values[2]));

        String[] abilityScoresAsStrings = values[3].split(",");

        int[] scoresToPass = new int[6];

        for (int i = 0; i < abilityScoresAsStrings.length; i++) {
            scoresToPass[i] = Integer.parseInt(abilityScoresAsStrings[i]);
        }
        this.setAbilityScores(scoresToPass);

        String[] savingThrowsAsStrings = values[4].split(",");
        int[] savingThrowsToPass = new int[savingThrowsAsStrings.length];

        for (int i = 0; i < savingThrowsAsStrings.length; i++) {
            savingThrowsToPass[i] = Integer.parseInt(savingThrowsAsStrings[i]);
        }
        this.setSavingThrowsProficiency(savingThrowsToPass);

        String[] skillProficienciesAsStrings = values[5].split(",");
        int[] skillProficienciesToPass = new int[skillProficienciesAsStrings.length];

        for(int i = 0; i < skillProficienciesAsStrings.length; i++){
            skillProficienciesToPass[i] = Integer.parseInt(skillProficienciesAsStrings[i]);
        }
        setSkillProficiency(skillProficienciesToPass);

        this.setBackground(values[6]);
        this.setAlignment(values[7]);
        this.setExperiencePoints(Integer.parseInt(values[8]));
        this.setSpeed(Integer.parseInt(values[9]));
        this.setMaxHP(Integer.parseInt(values[10]));
        this.setCurrentHP(Integer.parseInt(values[11]));
        this.setTemporaryHitPoints(Integer.parseInt(values[12]));

        this.setPersonalityTraits(values[13]);
        this.setIdeals(values[14]);
        this.setBonds(values[15]);
        this.setFlaws(values[16]);

        this.setProficiencies(new ArrayList<>(Arrays.asList(values[17].split(","))));

        this.setEquipment(new ArrayList<>(Arrays.asList(values[18].split(","))));
        this.setAbilities(new ArrayList<>(Arrays.asList(values[19].split(","))));

        String[] currencyAsString = values[20].split(",");
        int[] currencyToPass = new int[currencyAsString.length];
        for(int i = 0; i < currencyAsString.length; i++){
            currencyToPass[i] = Integer.parseInt(currencyAsString[i]);
        }

        this.setCurrency(currencyToPass);

        String[] listOfClasses = values[21].split(",");

        for(String classString : listOfClasses){
            //classString should be "CharacterClass~SubClass~ClassLevel"

            switch(classString.split(Del.CLASS_DEL)[0]){
                case "Barbarian":
                    characterClasses.add(new Barbarian(classString));
                    break;
                case "Bard":
                    characterClasses.add(new Bard(classString));
                    break;
                case "Cleric":
                    characterClasses.add(new Cleric(classString));
                    break;
                case "Druid":
                    characterClasses.add(new Druid(classString));
                    break;
                case "Fighter":
                    characterClasses.add(new Fighter(classString));
                    break;
                case "Monk":
                    characterClasses.add(new Monk(classString));
                    break;
                case "Paladin":
                    characterClasses.add(new Paladin(classString));
                    break;
                case "Ranger":
                    characterClasses.add(new Ranger(classString));
                    break;
                case "Rogue":
                    characterClasses.add(new Rogue(classString));
                    break;
                case "Sorcerer":
                    characterClasses.add(new Sorcerer(classString));
                    break;
                case "Warlock":
                    characterClasses.add(new Warlock(classString));
                    break;
                case "Wizard":
                    characterClasses.add(new Wizard(classString));
                    break;
                default:
                    System.out.println("No Class added!");

            }
        }
        this.setCharacterLevel();
        this.setRace(values[22]);
        this.setSpeed();
        this.setPartyName(values[23]);
        this.setBackstory(values[24]);
    }

    public void printAllFields(){

        System.out.println(this.getCharacterName());
        //System.out.println(this.getCharacterClass());
        System.out.println(this.getAbilities());
        System.out.println(this.getBonds());
    }

    public String exportDataString(){
        String str = "";

        str += this.getPlayerName() + Del.MAIN_DEL;
        str += this.getCharacterName() + Del.MAIN_DEL;
        str += this.getInspiration() + Del.MAIN_DEL;
        str += this.getAbilityScoresString() + Del.MAIN_DEL;
        str += this.getSavingThrowProficiencyString() + Del.MAIN_DEL;
        str += this.getSkillProficiencyString() + Del.MAIN_DEL;
        str += this.getBackground() + Del.MAIN_DEL;
        str += this.getAlignment() + Del.MAIN_DEL;
        str += this.getExperiencePoints() + Del.MAIN_DEL;
        str += this.getSpeed() + Del.MAIN_DEL;
        str += this.getMaxHP() + Del.MAIN_DEL;
        str += this.getCurrentHP() + Del.MAIN_DEL;
        str += this.getTemporaryHitPoints() + Del.MAIN_DEL;
        str += this.getPersonalityTraits() + Del.MAIN_DEL;
        str += this.getIdeals() + Del.MAIN_DEL;
        str += this.getBonds() + Del.MAIN_DEL;
        str += this.getFlaws() + Del.MAIN_DEL;
        str += this.getProficienciesString() + Del.MAIN_DEL;
        str += this.getEquipmentString() + Del.MAIN_DEL;
        str += this.getAbilitiesString() + Del.MAIN_DEL;
        str += this.getCurrencyString() + Del.MAIN_DEL;


        for(CharacterClass c : this.characterClasses){
            str += c.getClassString() + Del.MAIN_DEL;
        }

        str += this.getRace() + Del.MAIN_DEL;
        str += this.getPartyName() + Del.MAIN_DEL;
        str += this.getBackstory() + Del.MAIN_DEL;
        return str;
    }

    PlayerCharacter(CharacterClass c, String playerName, String characterName){
        characterClasses.add(c);
        this.playerName = playerName;
        this.characterName = characterName;
        characterLevel = 1;
    }

    PlayerCharacter(String savedData){

        setFieldsFromFile(savedData);
    }

    public CharacterClass getCharacterClass(){
        return this.characterClasses.get(0);
    }

    public void addCharacterClass(CharacterClass ch){
        characterClasses.add(ch);
    }


    public String getCharacterName(){
        return characterName;
    }

    public String getPlayerName(){
        return playerName;
    }
    //FIXME Armor, Feats, and other features impact AC<
    public int getOtherACMods(){
        return 0;
    }

}
