import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

public class AddCharacterWindow {

    private static GridBagConstraints geometry = new GridBagConstraints();

    public static void build(){

        JFrame window = new JFrame("Create a New Character");

        JPanel topPanel = new JPanel();
        JPanel skillPanel = new JPanel();
        JPanel statsPanel = new JPanel();
        JPanel hpAndMoneyPanel = new JPanel();
        JPanel backstoryPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel partySelectPanel = new JPanel();


        JButton maxHPButton = new JButton("Max");
        maxHPButton.setEnabled(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(3*screenSize.width/4, screenSize.height);
        window.setLocation(screenSize.width/6,0);

        window.setLayout(new GridBagLayout());

        topPanel.setLayout(new GridBagLayout());
        skillPanel.setLayout(new GridBagLayout());
        statsPanel.setLayout(new GridBagLayout());
        hpAndMoneyPanel.setLayout(new GridBagLayout());
        backstoryPanel.setLayout(new GridBagLayout());
        buttonPanel.setLayout(new GridBagLayout());
        partySelectPanel.setLayout(new GridBagLayout());

        ArrayList<JTextField> textFieldArrayList = new ArrayList<>();
        ArrayList<JTextArea> textAreaArrayList = new ArrayList<>();
        ArrayList<JComboBox<String>> comboBoxArrayList = new ArrayList<>();
        ArrayList<JCheckBox> checkBoxArrayList = new ArrayList<>();

        ActionListener addSubclassActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String chrClass = (String) comboBoxArrayList.get(6).getSelectedItem();
                int lvl = Integer.parseInt((String) Objects.requireNonNull(comboBoxArrayList.get(8).getSelectedItem()));
                if(lvl >= 3){
                    comboBoxArrayList.get(10).removeAllItems();
                    ArrayList<String> subs = new ArrayList<>();
                    switch(chrClass){
                        case "Class...":
                            subs.add("Subclass...");
                            subs.add("No options yet!");
                            break;
                        case "Barbarian":
                            subs.addAll(new Barbarian().getSubclassChoices());
                            break;
                        case "Bard":
                            subs.addAll(new Bard().getSubclassChoices());
                            break;
                        case "Cleric":
                            subs.addAll(new Cleric().getSubclassChoices());
                            break;
                        case "Druid":
                            subs.addAll(new Druid().getSubclassChoices());
                            break;
                        case "Fighter":
                            subs.addAll(new Fighter().getSubclassChoices());
                            break;
                        case "Monk":
                            subs.addAll(new Monk().getSubclassChoices());
                            break;
                        case "Paladin":
                            subs.addAll(new Paladin().getSubclassChoices());
                            break;
                        case "Ranger":
                            subs.addAll(new Ranger().getSubclassChoices());
                            break;
                        case "Rogue":
                            subs.addAll(new Rogue().getSubclassChoices());
                            break;
                        case "Sorcerer":
                            subs.addAll(new Sorcerer().getSubclassChoices());
                            break;
                        case "Warlock":
                            subs.addAll(new Warlock().getSubclassChoices());
                            break;
                        case "Wizard":
                            subs.addAll(new Wizard().getSubclassChoices());
                            break;
                    }
                    for(String str : subs){
                        comboBoxArrayList.get(10).addItem(str);
                    }
                } else {
                    comboBoxArrayList.get(10).removeAllItems();
                    comboBoxArrayList.get(10).addItem("None");
                }
            }
        } ;

        ActionListener saveCharacter = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buildCharacter(textFieldArrayList,textAreaArrayList,comboBoxArrayList,checkBoxArrayList);
                    ChooseParty.build();
                    window.dispose();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };

        geometry.weightx = 10;
        geometry.fill = GridBagConstraints.HORIZONTAL;

        geometry.gridwidth = 1;
        geometry.gridheight = 1;
        geometry.gridx = 0;
        geometry.gridy = 0;
        /*
        ArrayList that holds all the JTextFields for the page
        0 --> Character Name, 1 --> Player Name, 2 --> Background
        3 --> Current XP, 4 --> HP,
        5 - 9 --> Currency, 10 --> New Party
        */
        for(int i = 0; i < 11; i++){
            textFieldArrayList.add(new JTextField());
        }
        textFieldArrayList.get(10).setColumns(32);
        /*
        ArrayList that stores all the JTextAreas
        0 --> Personality, 1 --> Ideals, 2 --> Bonds, 3 --> Flaws, 4 --> Total Backstory
        * */
        for(int i = 0; i < 5; i++){
            textAreaArrayList.add(new JTextArea(3, 20));
            textAreaArrayList.get(i).setLineWrap(true);
        }
        textAreaArrayList.get(4).setColumns(40);
        textAreaArrayList.get(4).setRows(10);
        /*
        ArrayList that holds all of the JComboBoxs for the page
        0 - 5 --> Ability Score boxes, 6 --> Class box, 7 --> Race box
        8 --> Character Level box, 9 --> Alignment, 10 --> Subclass, 11 --> Party
         */
        for(int i = 0; i < 12; i++){
            comboBoxArrayList.add(new JComboBox<>());
        }

        /*
        Sets the Combo Boxes for Ability Scores;
        Added to the StatsPanel, taking on values 1 - 20, in comboBoxArrayList
        **/
        for(int i = 0; i < 6; i++){
            //comboBoxArrayList.add(new JComboBox());
            for(int j = 1; j <= 20; j++){
                comboBoxArrayList.get(i).addItem(String.format("%d", j));
            }
            //comboBoxArrayList.get(i).setFont(GUIBuilder.MAIN_FONT);
            comboBoxArrayList.get(i).setSelectedIndex(9);
        }

        for(JComboBox<String> j : comboBoxArrayList){
            j.setFont(GUIBuilder.MAIN_FONT);
        }
        //Array that stores all the parties that the character could attach to.
        String[] partyNames = FileLoader.getAllPartyNamesAsArray();

        //Array that store the header labels for the backstory JTextAreas
        String[] backstoryLabels = new String[]{"Personality:", "Ideals:", "Bonds:", "Flaws:","Backstory:" };


        //Array that stores the text for the labels for currency JTextFields
        String[] currencyLabels = new String[]{"CP", "SP", "EP", "GP", "PP"};

        //Array that stores the text for the class combo box
        String[] classLabels = new String[]{"Class...", "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger",
                                            "Rogue", "Sorcerer", "Warlock", "Wizard"};

        //Array that stores the text for the race combo box
        String[] raceLabels = new String[]{"Race...", "Dwarf", "Elf", "Halfling", "Human", "Dragonborn", "Gnome", "Half-Elf",
                                            "Half-Orc", "Tiefling"};

        String[] alignmentLabels = new String[]{"Alignment...", "CG", "NG", "LG", "CN", "N", "LN", "CE", "NE", "LE"};

        //Array that stores the Check Box labels
        String[] chckLabels = new String[]{"Str", "Dex", "Con", "Int", "Wis", "Cha", "Acrobatics", "Animal Handling",
                                "Arcana", "Athletics", "Deception", "History", "Insight", "Intimidation", "Investigation",
                                "Medicine", "Nature", "Perception", "Performance", "Persuasion", "Religion", "Sleight of Hand",
                                "Stealth", "Survival"};
        /*
        ArrayList that stores the JCheckBoxs for the page
        0 - 5 --> Ability Save Proficiencies, 6 - 23 --> Skill Proficiencies
        * */
        for(String str : chckLabels){
            checkBoxArrayList.add(new JCheckBox(str));
        }

        for(JCheckBox c : checkBoxArrayList){
            c.setFont(GUIBuilder.MAIN_FONT);
        }

        for(JCheckBox j : checkBoxArrayList){
            j.setHorizontalAlignment(SwingConstants.LEFT);
        }

        //                                  populates topPanel

         /*
        ArrayList that holds all of the JComboBoxs for the page
        0 - 5 --> Ability Score boxes, 6 --> Class box, 7 --> Race box
        8 --> Character Level box, 9 --> Alignment, 10 --> Subclass
         */
        geometry.gridy = 0;
        geometry.gridx = 0;
        geometry.weightx = 0.1;
        topPanel.add(GUIBuilder.labelGenSolid("Character Name: ", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridy = 1;
        topPanel.add(GUIBuilder.labelGenSolid("Player Name: ", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 1;
        geometry.gridy = 0;
        textFieldArrayList.get(0).setColumns(24);
        topPanel.add(textFieldArrayList.get(0), geometry);

        geometry.gridy = 1;
        textFieldArrayList.get(1).setColumns(24);
        topPanel.add(textFieldArrayList.get(1), geometry);

        geometry.gridy = 0;
        geometry.gridx = 2;
        geometry.weightx = 0.4;
        for(String str : classLabels){
            comboBoxArrayList.get(6).addItem(str);
        }
        comboBoxArrayList.get(6).addActionListener(addSubclassActionListener);
        topPanel.add(comboBoxArrayList.get(6), geometry);

        geometry.gridy = 1;
        for(String str: raceLabels){
            comboBoxArrayList.get(7).addItem(str);
        }
        topPanel.add(comboBoxArrayList.get(7), geometry);

        //subclass combobox
        geometry.gridy = 0;
        geometry.gridx = 3;
        comboBoxArrayList.get(10).setPreferredSize(new Dimension(225,28));
        comboBoxArrayList.get(10).addItem("None");

        topPanel.add(comboBoxArrayList.get(10), geometry);

        geometry.gridx = 4;
        geometry.weightx = 0.20;
        topPanel.add(GUIBuilder.labelGenSolid("LVL:", GUIBuilder.MAIN_FONT), geometry);
        geometry.gridx = 5;

        //Level Combo box add
        comboBoxArrayList.get(8).addActionListener(addSubclassActionListener);
        for(int i =1; i <=20; i++){
            comboBoxArrayList.get(8).addItem(""+i);
        }
        topPanel.add(comboBoxArrayList.get(8), geometry);
        geometry.gridx = 3;
        geometry.gridy = 1;
        geometry.gridwidth=2;
        for(String str : alignmentLabels){
            comboBoxArrayList.get(9).addItem(str);
        }
        topPanel.add(comboBoxArrayList.get(9), geometry);
        geometry.gridwidth = 1;
        geometry.gridx = 6;
        geometry.gridy = 0;
        topPanel.add(GUIBuilder.labelGenSolid("Background: ", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridy = 1;
        topPanel.add(GUIBuilder.labelGenSolid("Exp. Points: ", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 7;
        geometry.gridy = 0;
        textFieldArrayList.get(2).setColumns(16);
        topPanel.add(textFieldArrayList.get(2), geometry);

        geometry.gridy = 1;
        textFieldArrayList.get(3).setColumns(8);
        topPanel.add(textFieldArrayList.get(3), geometry);

        //                              Populates statsPanel
        geometry.gridx = 0;
        geometry.gridy = 0;
        statsPanel.add(GUIBuilder.labelGenSolid("Ability Scores:", GUIBuilder.HEADER_FONT), geometry);
        geometry.gridy = 1;
        statsPanel.add(GUIBuilder.labelGenSolid("Save Proficiencies:", GUIBuilder.HEADER_FONT), geometry);

        for(int i = 1, j = 0; j < 6; i += 2, j++){
            geometry.gridy = 0;
            geometry.gridx = i;
            geometry.anchor = GridBagConstraints.LINE_END;
            statsPanel.add(GUIBuilder.labelGenSolid(chckLabels[j]+":", GUIBuilder.MAIN_FONT), geometry);

            geometry.anchor = GridBagConstraints.CENTER;
            geometry.gridx = i+1;
            statsPanel.add(comboBoxArrayList.get(j), geometry);

            geometry.gridy = 1;
            checkBoxArrayList.get(j).setHorizontalAlignment(SwingConstants.LEFT);
            statsPanel.add(checkBoxArrayList.get(j), geometry);
        }

        //Populates the Skill Check Panel
        geometry.gridy = 0;
        skillPanel.add(GUIBuilder.labelGenSolid("Skills:", GUIBuilder.HEADER_FONT), geometry);

        for(int i = 6; i < chckLabels.length; i++){
            geometry.gridy = i - 5;
            skillPanel.add(checkBoxArrayList.get(i), geometry);
        }
        //Populates the hpandcurrency pane

        geometry.gridx = 0;
        geometry.gridy = 0;
        geometry.weightx = 0.0;

        hpAndMoneyPanel.add(GUIBuilder.labelGenSolid("HP: ", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridx = 1;
        textFieldArrayList.get(4).setColumns(4);
        hpAndMoneyPanel.add(textFieldArrayList.get(4));

        geometry.gridx = 2;
        hpAndMoneyPanel.add(maxHPButton);

        geometry.gridy = 1;
        geometry.gridx = 0;
        geometry.gridwidth = 2;
        hpAndMoneyPanel.add(GUIBuilder.labelGenSolid("Currency: ", GUIBuilder.MAIN_FONT),geometry);

        geometry.gridwidth = 1;
        for(int i = 5, j = 2; i <=9; i++, j++){
            geometry.gridx = 0;
            geometry.gridy = j;
            hpAndMoneyPanel.add(GUIBuilder.labelGenSolid(currencyLabels[j-2], GUIBuilder.MAIN_FONT), geometry);

            geometry.gridx = 1;
            textFieldArrayList.get(i).setColumns(4);
            hpAndMoneyPanel.add(textFieldArrayList.get(i), geometry);
        }

        //    Populates the backstory panel textAreaArrayList

        geometry.gridx = 0;
        geometry.gridy = 0;

        for(int q = 0; q < 5; q++){
            backstoryPanel.add(GUIBuilder.labelGenSolid(backstoryLabels[q], GUIBuilder.MAIN_FONT), geometry);
            geometry.gridy++;

            backstoryPanel.add(new JScrollPane(textAreaArrayList.get(q)), geometry);
            geometry.gridy++;
        }

        //     Populates the button panel

        JButton saveButton = new JButton("Save Character");

        saveButton.addActionListener(saveCharacter);
        buttonPanel.add(saveButton);

        //           Populates the partySelect Panel

        for(String str : partyNames){
            comboBoxArrayList.get(11).addItem(str);
        }
        comboBoxArrayList.get(11).addItem("New...");

        comboBoxArrayList.get(11).setSelectedIndex(0);

        geometry.gridx = 0;
        geometry.gridy = 0;
        partySelectPanel.add(comboBoxArrayList.get(11));
        geometry.gridy++;
        partySelectPanel.add(textFieldArrayList.get(10));

        //Assembles the built panes into the main window
        geometry.gridx = 0;
        geometry.gridy = 0;
        geometry.ipady = 5;
        geometry.ipadx = 5;
        geometry.gridwidth = 3;
        window.add(topPanel, geometry);

        geometry.gridx = 0;
        geometry.gridy = 1;
        window.add(statsPanel, geometry);

        geometry.gridx = 0;
        geometry.gridy = 2;
        geometry.gridheight = 4;
        geometry.gridwidth = 1;
        window.add(skillPanel, geometry);

        geometry.gridx = 1;
        geometry.gridheight = 1;
        geometry.gridwidth = 1;
        window.add(hpAndMoneyPanel, geometry);

        geometry.gridx = 2;
        geometry.gridheight = 2;
        window.add(backstoryPanel, geometry);

        geometry.gridx = 0;
        geometry.gridy = 7;
        geometry.gridheight = 1;
        window.add(buttonPanel, geometry);

        geometry.gridy = 8;
        geometry.gridwidth = 2;
        window.add(partySelectPanel, geometry);

        window.repaint();
        window.revalidate();

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }

    /*
    This methods builds a String in the format of the saved data string used to build PlayerCharacter objects
    upon opening the program.
    */
    public static void buildCharacter(ArrayList<JTextField> textFieldArrayList, ArrayList<JTextArea> textAreaArrayList,
                                      ArrayList<JComboBox<String>> comboBoxArrayList, ArrayList<JCheckBox> checkBoxArrayList) throws IOException {
        Party p = Main.getP();
        //Array of strings that will be updated from the different Arraylists, then used to build the final String to build the character
        String[] stringsToAdd = new String[24];
        //the main string that will store the data for the new created character
        String str = "";
        /* These are the indices of the entries needed to build a new PlayerCharacter object
        0 --> CharacterName, 1 --> PlayerName, 2 --> Inspiration, 3 --> AbilityScores, 4 --> SavingThrowProf,
        5 --> SkillProficiencies, 6 --> Background, 7 --> Alignment, 8 --> EXP, 9 --> Speed, 10 --> MaxHP,
        11 --> CurrentHP, 12 --> TempHP, 13 --> Personality, 14 --> Ideals, 15 --> Bonds, 16 --> Flaws,
        17 --> OtherProficiencies, 18 --> Equipment, 19 --> ListOfAbilities, 20 --> Currency,
        21 --> Classes, 22 --> Race, 23 --> PartyName
        */
        /*
        ArrayList that holds all the JTextFields for the page, and their intended data variable association
        0 --> Character Name, 1 --> Player Name, 2 --> Background
        3 --> Current XP, 4 --> HP,
        5 - 9 --> Currency
        */

        if(textFieldArrayList.get(1).getText().equals("")){
            stringsToAdd[0] = "None";
        } else {
            stringsToAdd[0] = textFieldArrayList.get(1).getText();
        }

        if(textFieldArrayList.get(0).getText().equals("")){
            stringsToAdd[1] = "None";
        } else {
            stringsToAdd[1] = textFieldArrayList.get(0).getText();
        }

        stringsToAdd[2] = "0";

        stringsToAdd[3] = comboBoxArrayList.get(0).getSelectedItem().toString() + "," +
                comboBoxArrayList.get(1).getSelectedItem().toString() + "," +
                comboBoxArrayList.get(2).getSelectedItem().toString() + "," +
                comboBoxArrayList.get(3).getSelectedItem().toString() + "," +
                comboBoxArrayList.get(4).getSelectedItem().toString() + "," +
                comboBoxArrayList.get(5).getSelectedItem().toString();

        StringBuilder savesToSave = new StringBuilder();
        for(int i = 0; i < 5; i++){
            String s = (checkBoxArrayList.get(i).isSelected()) ? "1" : "0";
            savesToSave.append(s).append(",");
        }
        String s = (checkBoxArrayList.get(5).isSelected()) ? "1" : "0";
        savesToSave.append(s);

        stringsToAdd[4] = savesToSave.toString();

        StringBuilder skillsToSave = new StringBuilder();
        for(int i = 6; i < 22; i++){
            String k = (checkBoxArrayList.get(i).isSelected()) ? "1" : "0";
            skillsToSave.append(k).append(",");
        }
        String k = (checkBoxArrayList.get(23).isSelected()) ? "1" : "0";
        skillsToSave.append(k);
        stringsToAdd[5] = skillsToSave.toString();

        if(textFieldArrayList.get(2).getText().equals("")){
            stringsToAdd[6] = "None";
        } else {
            stringsToAdd[6] = textFieldArrayList.get(2).getText();
        }

        stringsToAdd[7] = Objects.requireNonNull(comboBoxArrayList.get(9).getSelectedItem()).toString();

        if(textFieldArrayList.get(3).getText().equals("")){
            stringsToAdd[8] = "0";
        } else {
            stringsToAdd[8] = textFieldArrayList.get(3).getText();
        }

        stringsToAdd[9] = "25";

        if(textFieldArrayList.get(4).getText().equals("")){
            stringsToAdd[10] = "0";
            stringsToAdd[11] = "0";
        } else {
            stringsToAdd[10] = textFieldArrayList.get(4).getText();
            stringsToAdd[11] = textFieldArrayList.get(4).getText();
        }
        stringsToAdd[12] = "0";

        //iterates through textAreaArrayList, and saves character background stuff
        //FIXME Never implements Backstory JTextArea. Must make adjustments to PlayerCharacter class first.
        for(int i = 13, j = 0; i <= 16; i++, j++){
            stringsToAdd[i] = textAreaArrayList.get(j).getText();
        }
        stringsToAdd[17] = "None";
        stringsToAdd[18] = "None";
        stringsToAdd[19] = "None";
        /*
        JComboBoxs for the page
        0 - 5 --> Ability Score boxes, 6 --> Class box, 7 --> Race box
        8 --> Character Level box, 9 --> Alignment, 10 --> Subclass
         */
        stringsToAdd[20] = textFieldArrayList.get(5).getText() + "," + textFieldArrayList.get(6).getText() +
                "," + textFieldArrayList.get(7).getText() + "," + textFieldArrayList.get(8).getText() +
                "," + textFieldArrayList.get(9).getText();


        stringsToAdd[21] = comboBoxArrayList.get(6).getSelectedItem().toString() + Del.CLASS_DEL +
                comboBoxArrayList.get(10).getSelectedItem().toString() + Del.CLASS_DEL +
                comboBoxArrayList.get(8).getSelectedItem().toString();

        stringsToAdd[22] = comboBoxArrayList.get(7).getSelectedItem().toString();

        /*
        JCheckBoxs for the page
        0 - 5 --> Ability Save Proficiencies, 6 - 23 --> Skill Proficiencies
        * */
        if(comboBoxArrayList.get(11).getSelectedItem().equals("New...")){
            stringsToAdd[23] = textFieldArrayList.get(10).getText();
        } else {
            stringsToAdd[23] = Objects.requireNonNull(comboBoxArrayList.get(11).getSelectedItem()).toString();
        }
        PlayerCharacter pc = new PlayerCharacter(String.join(Del.MAIN_DEL, stringsToAdd));
        p.addPartyMember(pc);
        Main.setP(p);
        Main.getP().exportSaveString();
    }
}
