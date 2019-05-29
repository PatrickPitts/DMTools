public class Spell {

    private String name = "";
    private String page = "";
    private String school = "";
    private String level = "";
    private String castingTime = "";
    private String range = "";
    private String componants = "";
    private String duration = "";
    private String body = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(String castingTime) {
        this.castingTime = castingTime;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getComponants() {
        return componants;
    }

    public void setComponants(String componants) {
        this.componants = componants;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    Spell(String[] dataStringsFromFile){
        setName(dataStringsFromFile[0]);

        try{
            setPage(dataStringsFromFile[1].replace("\"", ""));
            setSchool(dataStringsFromFile[2].replace("\"", ""));
            setLevel(dataStringsFromFile[3].replace("\"", ""));
            setCastingTime(dataStringsFromFile[4].replace("\"", ""));
            setRange(dataStringsFromFile[5].replace("\"", ""));
            setComponants(dataStringsFromFile[6].replace("\"", ""));
            setDuration(dataStringsFromFile[7].replace("\"", ""));
            setBody(dataStringsFromFile[8].replace("\"", ""));
        } catch (IndexOutOfBoundsException e){
            //System.out.println("Incomplete Spell");
        }

    }
}
