import java.util.*;

public class Monster extends Creature{

    public String getTraits() {
        return traits;
    }

    public String getActions() {
        return actions;
    }

    public String getArmorClass() {
        return armorClass;
    }

    public String getHpRoll() {
        return hpRoll;
    }

    public void setSpeed(ArrayList<String> speed) {
        this.speed = speed;
        for(int i = 0; i < this.speed.size(); i++){
            if(!this.speed.get(i).contains("ft.")){
                this.speed.set(i, this.speed.get(i) + "ft.");
            }
        }
    }

    public int getPassivePerception() {
        return passivePerception;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public double getChallengeRating() {
        return challengeRating;
    }

    public int getProficiencyBonus(){
        return ((int) getChallengeRating()) / 4 + 2;
    }

    public void setTraits(String traits) {

        this.traits = traits;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public void setChallengeRating(double challengeRating) {
        this.challengeRating = challengeRating;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
        for(int i = 0; i <this.skills.size(); i++){
            this.skills.set(i, this.skills.get(i).replace("\"", ""));
        }
    }

    public void setPassivePerception(int passivePerception) {
        this.passivePerception = passivePerception;
    }

    public void setHpRoll(String hpRoll){
        this.hpRoll = hpRoll;
    }

    public void setArmorClass(String armorClass) {
        this.armorClass = armorClass;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public int getArmorClassValue(){
        String[] acArray = getArmorClass().split("\\(");
        try{
            return Integer.parseInt(acArray[0]);
        } catch (Exception e){
            return(10);
        }
    }

    public String[] getAbilityModifiersStrings(){
        String[] ret = new String[6];
        for(int i = 0; i < 6; i++){
            int val = (getStats()[i] - 10) / 2;
            StringBuilder str = new StringBuilder();
            str.append(" ").append(getStats()[i]).append(" (");
            if(val > 0){
                str.append("+");
            }
            str.append(val).append(")");
            ret[i] = str.toString();
        }
        return ret;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public ArrayList<String> getDamageResists() {
        return damageResists;
    }

    public void setDamageResists(ArrayList<String> damageResists) {
        this.damageResists = damageResists;
    }

    public ArrayList<String> getDamageImmunities() {
        return damageImmunities;
    }

    public void setDamageImmunities(ArrayList<String> damageImmunities) {
        this.damageImmunities = damageImmunities;
    }

    public ArrayList<String> getConditionImmunities() {
        return conditionImmunities;
    }

    public void setConditionImmunities(ArrayList<String> conditionImmunities) {
        this.conditionImmunities = conditionImmunities;
    }

    public ArrayList<String> getSenses() {
        return senses;
    }

    public void setSenses(ArrayList<String> senses) {
        this.senses = senses;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    private String traits = "";
    private String monsterType = "";
    private String alignment = "";
    private ArrayList<String> damageVulnerabilities = new ArrayList<>();

    public ArrayList<String> getDamageVulnerabilities() {
        return damageVulnerabilities;
    }

    public void setDamageVulnerabilities(ArrayList<String> damageVulnerabilities) {
        this.damageVulnerabilities = damageVulnerabilities;
    }

    private ArrayList<String> damageResists = new ArrayList<>();
    private ArrayList<String> damageImmunities = new ArrayList<>();
    private ArrayList<String> conditionImmunities = new ArrayList<>();
    private ArrayList<String> senses = new ArrayList<>();
    private ArrayList<String> languages = new ArrayList<>();
    private String actions = "";
    private ArrayList<String> savingThrows = new ArrayList<>();
    private String armorClass = "10";
    private String hpRoll = "1d6";
    private ArrayList<String> speed = new ArrayList<>();
    private int passivePerception = 10;
    private ArrayList<String> skills = new ArrayList<>();
    private double challengeRating = 0.0;

    public ArrayList<String> getSavingThrowsStrings() {
        return savingThrows;
    }

    public void setSavingThrows(ArrayList<String> savingThrows) {
        String[] abs = new String[]{"Str", "Dex", "Con", "Int", "Wis", "Cha"};
        Map<String, String> map = new HashMap<>();
        for(String str : savingThrows){
            switch (str.substring(0,3)){
                case "Str":
                    map.put("Str", str.replace("\"", ""));
                    break;
                case "Dex":
                    map.put("Dex", str.replace("\"", ""));
                    break;
                case "Con":
                    map.put("Con", str.replace("\"", ""));
                    break;
                case "Int":
                    map.put("Int", str.replace("\"", ""));
                    break;
                case "Wis":
                    map.put("Wis", str.replace("\"", ""));
                    break;
                case "Cha":
                    map.put("Cha", str.replace("\"", ""));
                    break;
            }
        }
        for(int i = 0; i < 6; i++){
            String str = abs[i];
            if(!map.containsKey(str)){
                StringBuilder saveString = new StringBuilder(str);
                int abMod = (getStats()[i] - 10) / 2;
                if(abMod > 0){
                    saveString.append(" +").append(abMod);
                } else {
                    saveString.append(" ").append(abMod);
                }
                map.put(str, saveString.toString());
            }
            this.savingThrows.add(map.get(str));
        }
        //this.savingThrows = savingThrows;
    }

    public ArrayList<String> getSpeed() {
        return speed;
    }

    Monster(String[] dataStringArrayFromFile){
        /*
        * 0 -> Name, 1 -> Type, 2 -> Alignment, 3 -> AC, 4 -> HP, 5 -> HP Roll, 6 -> Speed,
        * 7 -> Ability Scores, 8 -> Saves, 9 -> Skills, 10 -> Damage Resist, 11 -> Damage Immunities
        * 12 -> Condition Immunities, 13 -> Passive Per, 14 -> Senses, 15 -> Languages
        * 16 -> CR, 17 -> Traits, 18 -> Actions
         */

        setName(dataStringArrayFromFile[0].replace("\"", ""));
        setMonsterType(dataStringArrayFromFile[1].replace("\"", ""));
        setAlignment(dataStringArrayFromFile[2].replace("\"", ""));
        setArmorClass(dataStringArrayFromFile[3].replace("\"", ""));
        setMaxHP(Integer.parseInt(dataStringArrayFromFile[4].replace("\"", "")));
        setHpRoll(dataStringArrayFromFile[5].replace("\"", ""));
        setSpeed(new ArrayList<>(Arrays.asList(dataStringArrayFromFile[6].replace("\"", "").split(","))));

        int[] newStats = new int[6];
        String[] statStrings = dataStringArrayFromFile[7].replace("\"", "").split(",");
        for(int i = 0; i < 6; i++){

            newStats[i] = Integer.parseInt(statStrings[i].replace("\"",""));
        }
        setStats(newStats);

        setSavingThrows(new ArrayList<>(Arrays.asList(dataStringArrayFromFile[8].replace("\"", "").split(","))));
        setSkills(new ArrayList<>(Arrays.asList(dataStringArrayFromFile[9].replace("\"", "").split(","))));
        setDamageVulnerabilities(new ArrayList<>(Arrays.asList(dataStringArrayFromFile[10].replace("\"", "").split(","))));
        setDamageResists(new ArrayList<>(Arrays.asList(dataStringArrayFromFile[11].replace("\"", "").split(","))));
        setDamageImmunities(new ArrayList<>(Arrays.asList(dataStringArrayFromFile[12].replace("\"", "").split(","))));
        setConditionImmunities(new ArrayList<>(Arrays.asList(dataStringArrayFromFile[13].replace("\"", "").split(","))));
        setPassivePerception(Integer.parseInt(dataStringArrayFromFile[14].replace("\"", "")));
        setSenses(new ArrayList<>(Arrays.asList(dataStringArrayFromFile[15].replace("\"", "").split(","))));
        setLanguages(new ArrayList<>(Arrays.asList(dataStringArrayFromFile[16].replace("\"", "").split(","))));
        setChallengeRating(Double.parseDouble(dataStringArrayFromFile[17]));
        setTraits(dataStringArrayFromFile[18].replace("\"", ""));
        setActions(dataStringArrayFromFile[19].replace("\"", ""));
    }

    @Override
    public String toString() {
        //.append("<>")
        int counter = 0;
        StringBuilder text = new StringBuilder();
        text.append("<HTML>");
        text.append("<b><h1>").append(getName()).append("</b></h1>");
        text.append("<i>").append(getMonsterType()).append(" ").append(getAlignment()).append("</i>");
        text.append("<hr>");
        text.append("<b>Armor class </b>").append(getArmorClass()).append("<br>");
        text.append("<b> Hit Points </b>").append(getMaxHP()).append(" (").append(getHpRoll()).append(")").append("<br>");
        text.append("<b> Speed </b>");
        for(counter = 0; counter < getSpeed().size() - 1; counter++){
            text.append(getSpeed().get(counter)).append(",");
        }
        text.append(getSpeed().get(counter)).append("<br>");
        text.append("<hr>");

        text.append("<h3>").append("Str ").append(getAbilityModifiersStrings()[0]).append("\t&nbsp;|\t&nbsp;Dex ").append(getAbilityModifiersStrings()[1]);
        text.append("\t&nbsp;|\t&nbsp;Con ").append(getAbilityModifiersStrings()[2]).append("\t&nbsp;|\t&nbsp;Int ").append(getAbilityModifiersStrings()[3]).append("\t&nbsp;|\t&nbsp;Wis ");
        text.append(getAbilityModifiersStrings()[4]).append("\t&nbsp;|\t&nbsp; Cha ").append(getAbilityModifiersStrings()[5]).append("</h3>");

        text.append("<b>Saving Throws: </b> ").append(getSavingThrowsStrings().get(0)).append(",  ").append(getSavingThrowsStrings().get(1));
        text.append(",  ").append(getSavingThrowsStrings().get(2)).append(",  ").append(getSavingThrowsStrings().get(3)).append(",  ");
        text.append(getSavingThrowsStrings().get(4)).append(",  ").append(getSavingThrowsStrings().get(5)).append("<br>");
        text.append("<hr>");
        if(getSkills().size()> 0 && !getSkills().get(0).equals("None")) {
            text.append("<b>").append("Skills ").append("</b>");
            for (counter = 0; counter < getSkills().size() - 1; counter++) {
                text.append(getSkills().get(counter)).append(", ");
            }
            text.append(getSkills().get(counter)).append("<br>");
        }
        if(getDamageVulnerabilities().size()>0 && !getDamageVulnerabilities().get(0).equals("None")){
            text.append("<b>").append("Damage Vulnerabilities ").append("</b>");
            for(counter = 0; counter < getDamageResists().size() - 1; counter++){
                text.append(getDamageVulnerabilities().get(counter)).append(", ");
            }
            text.append(getDamageVulnerabilities().get(counter)).append("<br>");
        }

        if(getDamageResists().size()>0&& !getDamageResists().get(0).equals("None")){
            text.append("<b>").append("Damage Resistances ").append("</b>");
            for(counter = 0; counter < getDamageResists().size() - 1; counter++){
                text.append(getDamageResists().get(counter)).append(", ");
            }
            text.append(getDamageResists().get(counter)).append("<br>");
        }
        if(getDamageImmunities().size()>0 && !getDamageImmunities().get(0).equals("None")){
            text.append("<b>").append("Damage Immunities ").append("</b>");
            for(counter = 0; counter < getDamageImmunities().size() - 1; counter++){
                text.append(getDamageImmunities().get(counter)).append(", ");
            }
            text.append(getDamageImmunities().get(counter)).append("<br>");
        }
        if(getConditionImmunities().size()>0 && !getConditionImmunities().get(0).equals("None")){
            text.append("<b>").append("Condition Immunities ").append("</b>");
            for(counter = 0; counter < getConditionImmunities().size() - 1; counter++){
                text.append(getConditionImmunities().get(counter)).append(", ");
            }
            text.append(getConditionImmunities().get(counter)).append("<br>");
        }
        if(getSenses().size()>0 && !getSenses().get(0).equals("None")){
            text.append("<b>").append("Senses ").append("</b>");
            for(counter = 0; counter < getSenses().size() - 1; counter++){
                text.append(getSenses().get(counter)).append(", ");
            }
            text.append(getSenses().get(counter)).append("<br>");
        }
        text.append("<hr>");
        if(!getTraits().equals("None")){
            text.append(getTraits()).append("<br>");
        }

        String normalActions = "";
        String legendaryActions = "";
        String reactions = "";

        String[] testSplit = getActions().split("(\\(L\\)|\\(R\\))");
        //Here, we assume that actions come first, then reactions, then legendary actions
        if(getActions().contains("(R)") && getActions().contains("(L)")){
            normalActions = testSplit[0];
            reactions = testSplit[1];
            legendaryActions = testSplit[2];
        } else if(getActions().contains("(R)")){
            normalActions = testSplit[0];
            reactions = testSplit[1];
        } else if(getActions().contains("(L)")){
            normalActions = testSplit[0];
            legendaryActions = testSplit[1];
        } else {
            normalActions = testSplit[0];
        }

        text.append("<h2>").append("Actions").append("</h2>").append("<hr>");
        text.append(normalActions);
        if(reactions.length()>0){
            text.append("<h2>").append("Reactions").append("</h2>").append("<hr>");
            text.append(reactions);
        }
        if(legendaryActions.length()>0){
            text.append("<h2>").append("Legendary Actions").append("</h2>").append("<hr>");
            text.append(legendaryActions);
        }

        text.append("</HTML>");
        return text.toString();
    }


}
