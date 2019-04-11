class CharacterClass {
    private String className = "";
    CharacterClass(){
        int classLevel = 1;
    }
    private String getClassName(){return this.className;}
    void setClassName(String str){this.className = str;}

    void printClassName(){
        System.out.println(getClassName());
    }

}
