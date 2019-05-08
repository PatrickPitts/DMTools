import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class BasicPCDisplayPanel {

    static void build(JPanel canvas, PlayerCharacter pc){

        canvas.setLayout(new GridBagLayout());
        GridBagConstraints geometry = new GridBagConstraints();

        EmptyBorder border = new EmptyBorder(10,10,10,10);
        canvas.setBorder(border);

        int[] stats = pc.getAbilityScores();
        String[] mods = pc.getAbilityModsAsString();
        String[] saves = pc.getSavesAsStrings();

        geometry.weightx = 10;
        geometry.fill = GridBagConstraints.HORIZONTAL;
        //Displays Character and Player names
        geometry.gridy = 0;
        geometry.gridx = 0;
        geometry.gridwidth = 5;
        canvas.add(labelGenSolid(pc.getName(), GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 4;
        canvas.add(labelGenSubtle("("+pc.getPlayerName()+")", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridy = 1;
        canvas.add(labelGenSolid("   ", GUIBuilder.MAIN_FONT), geometry);

        //Displays Armor class, and hitpoints
        geometry.gridwidth = 1;

        geometry.gridy = 2;
        geometry.gridx = 0;

        canvas.add(labelGenSubtle("AC: ", GUIBuilder.MAIN_FONT), geometry);


        geometry.gridx = 1;
        canvas.add(labelGenSolid("" + pc.getArmorClass(), GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 2;
        canvas.add(labelGenSubtle("HP: ", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 3;
        canvas.add(labelGenSolid(pc.getCurrentHP() + " / " + pc.getMaxHP(), GUIBuilder.MAIN_FONT), geometry);

        if(pc.getTemporaryHitPoints() > 0){
            
            geometry.gridx = 4;
            canvas.add(labelGenSolid("( +"+pc.getTemporaryHitPoints()+" )", GUIBuilder.MAIN_FONT, Color.BLUE), geometry);
        }

        geometry.gridy = 3;
        canvas.add(labelGenSolid("    ", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridy = 4;
        geometry.gridx = 0;
        canvas.add(labelGenSubtle("Stats", GUIBuilder.HEADER_FONT), geometry);

        //Displays Character Ability scores
        geometry.gridx = 1;
        canvas.add(labelGenSubtle("Str: " + stats[0], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 2;
        canvas.add(labelGenSubtle("Dex: " + stats[1], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 3;
        canvas.add(labelGenSubtle("Con: " + stats[2], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 4;
        canvas.add(labelGenSubtle("Int: " + stats[3], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 5;
        canvas.add(labelGenSubtle("Wis: " + stats[4], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 6;
        canvas.add(labelGenSubtle("Cha: " + stats[5], GUIBuilder.MAIN_FONT), geometry);

        //Displays Ability Score modifiers
        geometry.gridy = 5;

        geometry.gridx = 0;
        canvas.add(labelGenSubtle("Mods: ", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 1;
        canvas.add(labelGenSolid("   " + mods[0], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 2;
        canvas.add(labelGenSolid("   " + mods[1], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 3;
        canvas.add(labelGenSolid("   " + mods[2], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 4;
        canvas.add(labelGenSolid("   " + mods[3], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 5;
        canvas.add(labelGenSolid("   " + mods[4], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 6;
        canvas.add(labelGenSolid("   " + mods[5], GUIBuilder.MAIN_FONT), geometry);

        //Displays saving throw mods
        geometry.gridy = 6;
        geometry.gridx = 0;
        canvas.add(labelGenSubtle("Saves:", GUIBuilder.HEADER_FONT), geometry);

        geometry.gridx = 1;
        canvas.add(labelGenSolid("   " + saves[0], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 2;
        canvas.add(labelGenSolid("   " + saves[1], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 3;
        canvas.add(labelGenSolid("   " + saves[2], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 4;
        canvas.add(labelGenSolid("   " + saves[3], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 5;
        canvas.add(labelGenSolid("   " + saves[4], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 6;
        canvas.add(labelGenSolid("   " + saves[5], GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 0;
        geometry.gridy = 7;

        canvas.add(labelGenSolid("   ", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridy = 8;
        canvas.add(labelGenSubtle("Perception: ", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 1;
        int i = 10 + pc.getStatModifier(pc.getWisdom()) + pc.getSkillProficiency()[11]*pc.getProficiencyBonus();
        canvas.add(labelGenSolid("   " + i, GUIBuilder.MAIN_FONT), geometry); //perception is index 11

        geometry.gridy = 9;
        geometry.gridx = 0;
        canvas.add(labelGenSubtle("Speed", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 1;
        canvas.add(labelGenSolid("   "+pc.getSpeed(), GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 2;
        canvas.add(labelGenSolid("  ( "+(pc.getSpeed()/5)+" )", GUIBuilder.MAIN_FONT), geometry);

        canvas.repaint();
        canvas.revalidate();
    }

    static void buildHighlight(JPanel canvas, PlayerCharacter pc){
        canvas.removeAll();
        canvas.setBackground(Color.CYAN);
        build(canvas, pc);
    }

    static void buildBasic(JPanel canvas, PlayerCharacter pc){
        canvas.removeAll();
        canvas.setBackground(Color.LIGHT_GRAY);
        build(canvas, pc);
    }

    private static JLabel labelGenSubtle(String str, Font f){

        JLabel l = new JLabel(str);
        EmptyBorder border = new EmptyBorder(2,5,2,5);

        l.setBorder(border);
        l.setForeground(Color.GRAY);
        l.setFont(f);
        return l;
    }

    private static JLabel labelGenSolid(String str, Font f){

        JLabel l = new JLabel(str);
        EmptyBorder border = new EmptyBorder(2,5,2,5);

        l.setBorder(border);
        l.setFont(f);
        return l;
    }

    private static JLabel labelGenSolid(String str, Font f, Color c){
        JLabel l = new JLabel(str);
        EmptyBorder border = new EmptyBorder(2,5,2,5);

        l.setFont(f);
        l.setBorder(border);
        l.setForeground(c);

        return l;
    }



}
