//import java.util.ArrayList;
//
//@SuppressWarnings("ALL")
//public class PC {
//
//
//    public static class Creature{
//
//        private int hitPoints = 1;
//        private int maxHP = 1;
//        private int initiative = 0;
//        //Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma
//        private int[] stats = {10,10,10,10,10,10};
//        private String name;
//
//
//
//        public void setName(String str){this.name = str;}
//        public void setHitPoints(int i){this.hitPoints = i;}
//        public void setMaxHP(int i){this.maxHP = i;}
//        public void setStats(int[] i){this.stats = i;}
//        public void setInitiative(int i){this.initiative = i;}
//
//
//
//        public String getName(){return this.name;}
//        public int getHitPoints(){return this.hitPoints;}
//        public int getMaxHP(){return this.maxHP;}
//        public int getInitiative(){return this.initiative;}
//
//
//
//
////        public void setRolledInitiative(int i){
////            this.setInitiative(this.getStatModifier(this.getDexterity()) + i);
////        }
//
//
//
//        public void hit(int i){
//            int newVal = this.getHitPoints() - i;
//
//            if(newVal < 1 && this instanceof PlayerCharacter){
//                System.out.println(String.format("%s is knocked unconscious!", ((PlayerCharacter) this).getName()));
//                this.setHitPoints(0);
//            } else if(newVal < 1){
//                System.out.println("This Creature is dead!");
//                this.setHitPoints(0);
//            } else {
//                this.setHitPoints(newVal);
//            }
//        }
//    }
//    public static class PlayerCharacter extends Creature{
//        private int characterLevel;
//
//        private int playerLevel;
//        private String playerName;
//
//
//        public void setPlayerName(String str){this.playerName = str;}
//
//        public void setCharacterLevel(int i){this.characterLevel = i;}
//        public void setPlayerLevel(int i){this.playerLevel = i;}
//
//        public int getCharacterLevel(){return this.characterLevel;}
//
//        public int getPlayerLevel(){return this.playerLevel;}
//        public String getPlayerName(){return this.playerName;}
//
//        public PlayerCharacter(){
//            this.playerLevel = 1;
//        }
//
//        public int getProficiencyBonus(){
//            return (this.characterLevel - 1) / 4 + 2;
//        }
//
//    }
//    public static class Party{
//        private ArrayList<PlayerCharacter> pcList = new ArrayList<PlayerCharacter>();
//
//        public Party(){
//
//        }
//
//        public void addPlayerCharacter(PlayerCharacter p){
//            this.pcList.add(p);
//        }
//
//        public ArrayList<PlayerCharacter> getPcList() {return pcList;}
//
//        public void printPlayers(){
//            for(int i =0; i < this.pcList.size(); i++){
//                System.out.println(this.pcList.get(i).getPlayerName());
//            }
//        }
//
//        public String[] getCharacterNames(){
//
//            String[] returnArr = new String[this.getPcList().size()];
//
//            for(int i = 0; i < this.getPcList().size(); i++){
//                returnArr[i] = this.getPcList().get(i).getName();
//            }
//
//            return returnArr;
//        }
//
//        public void printInitiative(ArrayList<Creature> arr){
//            //prints initiative order in a fancy tabular format to the console
//            int longest = 0;
//
//            for(int i = 0; i < arr.size(); i++) {
//                if (arr.get(i).getName().length() > longest) {
//                    longest = arr.get(i).getName().length();
//                }
//            }
//            System.out.println("Initiative order:");
//            for(int i = 0; i < longest + 4; i++){System.out.print("-");}
//            System.out.println("-");
//
//            for(int i = 0; i < arr.size(); i++){
//                System.out.print(arr.get(i).getName());
//                for(int j = arr.get(i).getName().length(); j <= longest; j++){
//                    System.out.print(" ");
//                }
//                System.out.print("| ");
//                System.out.println(arr.get(i).getInitiative());
//            }
//        }
//
//        public ArrayList<Creature> initiativeSort(ArrayList<Creature> newArr){
//
//
//            int n = newArr.size();
//            for(int i = 1; i < n; i++){
//                Creature key = newArr.get(i);
//                int j = i - 1;
//                while(j >= 0 && newArr.get(j).getInitiative() > key.getInitiative()){
//                    newArr.set(j+1, newArr.get(j));
//                    j--;
//                }
//                newArr.set(j+1, key);
//            }
//
//            ArrayList<Creature> returnArr = new ArrayList<Creature>();
//            for(int i = n-1; i > -1; i--){
//                returnArr.add(newArr.get(i));
//            }
//
//            return returnArr;
//        }
//
//        public void printEssentialStats(ArrayList<Creature> monsters){
//
//            ArrayList<Creature> masterList = new ArrayList<Creature>();
//            masterList.addAll(monsters);
//            masterList.addAll(this.getPcList());
//
//            ArrayList<Creature> arr = this.initiativeSort(masterList);
//
//
//
//            int longest = 0;
//
//            for(int i = 0; i < arr.size(); i++) {
//                if (arr.get(i).getName().length() > longest) {
//                    longest = arr.get(i).getName().length();
//                }
//            }
//
//            String header = "Char.";
//            while(header.length() < longest + 1){
//                header += " ";
//            }
//            header += "| Init | Max HP | HP";
//            String dashes = "";
//            while(dashes.length() < header.length()){
//                dashes += "-";
//            }
//            System.out.println(header);
//            System.out.println(dashes);
//            for(int i = 0; i < arr.size(); i++){
//                String name = arr.get(i).getName();
//                String init = "  " + arr.get(i).getInitiative();
//                String maxHP = " " + arr.get(i).getMaxHP();
//                String hp = " " + arr.get(i).getHitPoints();
//
//                while(name.length() < longest + 1){
//                    name += " ";
//                }
//                while(init.length() < 6){
//                    init += " ";
//                }
//                while(maxHP.length() < 8){
//                    maxHP += " ";
//                }
//
//                System.out.println(name + "|" + init + "|" + maxHP + "|" + hp);
//
//            }
//
//
//        }
//
//        public void printEssentialStats(){
//
//            ArrayList<Creature> masterList = new ArrayList<Creature>();
//            masterList.addAll(this.getPcList());
//
//            ArrayList<Creature> arr = this.initiativeSort(masterList);
//
//
//
//            int longest = 0;
//
//            for(int i = 0; i < arr.size(); i++) {
//                if (arr.get(i).getName().length() > longest) {
//                    longest = arr.get(i).getName().length();
//                }
//            }
//
//            String header = "Char.";
//            while(header.length() < longest + 1){
//                header += " ";
//            }
//            header += "| Init | Max HP | HP";
//            String dashes = "";
//            while(dashes.length() < header.length()){
//                dashes += "-";
//            }
//            System.out.println(header);
//            System.out.println(dashes);
//            for(int i = 0; i < arr.size(); i++){
//                String name = arr.get(i).getName();
//                String init = "  " + arr.get(i).getInitiative();
//                String maxHP = " " + arr.get(i).getMaxHP();
//                String hp = " " + arr.get(i).getHitPoints();
//
//                while(name.length() < longest + 1){
//                    name += " ";
//                }
//                while(init.length() < 6){
//                    init += " ";
//                }
//                while(maxHP.length() < 8){
//                    maxHP += " ";
//                }
//
//                System.out.println(name + "|" + init + "|" + maxHP + "|" + hp);
//
//            }
//
//
//        }
//
//
//
//
//
//
//
//
//
//        private void initiativeSort(){
//            ArrayList<Creature> newArr = new ArrayList<Creature>();
//            newArr.addAll(this.getPcList());
//
//            //sorts newArr in ascending order
//            int n = newArr.size();
//            for(int i = 1; i < n; i++){
//                Creature key = newArr.get(i);
//                int j = i - 1;
//                while(j >= 0 && newArr.get(j).getInitiative() > key.getInitiative()){
//                    newArr.set(j+1, newArr.get(j));
//                    j--;
//                }
//                newArr.set(j+1, key);
//
//            }
//
//            ArrayList<Creature> returnArr = new ArrayList<Creature>();
//            int longest = 0;
//
//            //reverses newArr into descending order, and also finds the longest name String
//            for(int i = n-1; i > -1; i--){
//                returnArr.add(newArr.get(i));
//
//            }
//            this.printInitiative(returnArr);
//
//        }
//
//    }
//    public static class MonsterParty{
//
//        private ArrayList<Creature> monsters = new ArrayList<Creature>();
//
//        public ArrayList<Creature> getMonsters(){return this.monsters;}
//
//        public MonsterParty(){
//
//        }
//        public void addCreature(Creature c){
//            this.monsters.add(c);
//        }
//    }
//
//    public static Party getTheParty(){
//
//        Party p = new Party();
//
//        PlayerCharacter aoth = new PlayerCharacter();
//        PlayerCharacter selise = new PlayerCharacter();
//        PlayerCharacter kairon = new PlayerCharacter();
//        PlayerCharacter kara = new PlayerCharacter();
//        PlayerCharacter taman = new PlayerCharacter();
//        PlayerCharacter nala = new PlayerCharacter();
//
//        aoth.setPlayerName("Ting-Kai");
//        selise.setPlayerName("Lucy");
//        kairon.setPlayerName("Andrew");
//        kara.setPlayerName("Kara");
//        taman.setPlayerName("Ryan");
//        nala.setPlayerName("Danae");
////aoth, kairon, kara,
//        p.addPlayerCharacter(aoth); aoth.setName("Aoth");
//        p.addPlayerCharacter(kairon); kairon.setName("Kairon");
//        p.addPlayerCharacter(kara); kara.setName("Kara");
//        p.addPlayerCharacter(nala); nala.setName("Nala");
//        p.addPlayerCharacter(selise); selise.setName("Selise");
//        p.addPlayerCharacter(taman); taman.setName("Taman");
//
//        int[] i = new int[]{14,16,13,11,15,9}; aoth.setStats(i);
//        i = new int[]{10,16,9,14,12,15}; kara.setStats(i);
//        i = new int[]{9,15,11,16,14,13}; taman.setStats(i);
//        i = new int[]{9,14,12,11,13,17}; selise.setStats(i);
//        i = new int[]{16,8,10,13,12,16}; nala.setStats(i);
//        i = new int[]{10,10,10,10,10,10}; kairon.setStats(i);
//
//        aoth.setMaxHP(18); aoth.setHitPoints(17);
//        kairon.setMaxHP(12); kairon.setHitPoints(12);
//        taman.setMaxHP(12); taman.setHitPoints(12);
//        selise.setMaxHP(18); selise.setHitPoints(18);
//        kara.setMaxHP(14); kara.setHitPoints(12);
//        nala.setMaxHP(14); nala.setHitPoints(7);
//
//
//        //set_initiatives
////        aoth.setRolledInitiative(10);
////        kairon.setRolledInitiative(19);
////        kara.setRolledInitiative(14);
////        nala.setRolledInitiative(16);
////        selise.setRolledInitiative(12);
////        taman.setRolledInitiative(18);
//
//        return p;
//    }
//}
