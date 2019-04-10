public class CharacterClass {
    private String className = "";
    public CharacterClass(){
        int classLevel = 1;
    }
    public String getClassName(){return this.className;}
    public void setClassName(String str){this.className = str;}

    public void printClassName(){
        System.out.println(getClassName());
    }

}
