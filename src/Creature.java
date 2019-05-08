@SuppressWarnings("unused")
public class Creature {

    Creature(){

    }

    private int[] stats = {10,10,10,10,10,10};

    private int maxHP = 1;
    private int currentHP = 1;
    private String name;

    private int rolledInitiative = 0;

    public void setStrength(int i){this.stats[0] = i;}
    public void setDexterity(int i){this.stats[1] = i;}
    public void setConstitution(int i){this.stats[2] = i;}
    public void setIntelligence(int i){this.stats[3] = i;}
    public void setWisdom(int i){this.stats[4] = i;}
    public void setCharisma(int i){this.stats[5] = i;}

    public int getStrength(){return this.stats[0];}
    public int getDexterity(){return this.stats[1];}
    public int getConstitution(){return this.stats[2];}
    public int getIntelligence(){return this.stats[3];}
    public int getWisdom(){return this.stats[4];}
    public int getCharisma(){return this.stats[5];}

    public int getStrMod(){return (this.stats[0] - 10) / 2;}
    public int getDexMod(){return (this.stats[1] - 10) / 2;}
    public int getConMod(){return (this.stats[2] - 10) / 2;}
    public int getIntMod(){return (this.stats[3] - 10) / 2;}
    public int getWisMod(){return (this.stats[4] - 10) / 2;}
    public int getChaMod(){return (this.stats[5] - 10) / 2;}

    public void setMaxHP(int maxHP) {this.maxHP = maxHP;}
    public void setCurrentHP(int currentHP) {this.currentHP = currentHP;}
    public void setName(String str){this.name = str;}

    public int getMaxHP() {return maxHP;}
    public int getCurrentHP() {return currentHP;}
    public String getName() {return this.name;}

    public int getStatModifier(int i){
        return (i - 10) / 2;
    }

    public void setRolledInitiative(int i) {this.rolledInitiative = this.getInitiativeMod() + i;}
    public int getRolledInitiative(int i) {
        return this.getStatModifier(this.getDexterity()) + i;
    }
    public int getRolledInitiative() {return this.rolledInitiative; }

    //FIXME needs more in depth calculation of all initiative modifiers
    public int getInitiativeMod() {return this. getDexMod();}


}
