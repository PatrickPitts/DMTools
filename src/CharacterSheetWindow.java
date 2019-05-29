import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class CharacterSheetWindow extends JFrame {

    private static GridBagConstraints geometry = new GridBagConstraints();
    private ArrayList<JCheckBox> saveBoxes;
    private ArrayList<JCheckBox> skillBoxes;
    private ArrayList<JTextArea> personalityAreas;

    // 0 --> AC, 1 --> Init, 2 --> Speed, 3 --> Current HP
    private ArrayList<JTextField> combatFields;
    private ArrayList<JTextField> headerFields;

    private static String[] skillTags  = new String[]{"Acrobatics", "Animal Handling",
            "Arcana", "Athletics", "Deception", "History", "Insight", "Intimidation", "Investigation",
            "Medicine", "Nature", "Perception", "Performance", "Persuasion", "Religion", "Sleight of Hand",
            "Stealth", "Survival"};
    private static String[] abilityTags = new String[]{"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
    private static String[] personalityTags = new String[]{"Personality Traits", "Ideals", "Bonds", "Flaws"};

    CharacterSheetWindow(PlayerCharacter p){

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

        geometry.gridy = 0; geometry.gridx = 0; geometry.gridheight = 1; geometry.gridwidth = 1;
        saveBoxes = new ArrayList<>();
        skillBoxes = new ArrayList<>();
        combatFields = new ArrayList<>();
        headerFields = new ArrayList<>();
        personalityAreas = new ArrayList<>();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(p.getName());
        setLayout(new GridBagLayout());

        JTabbedPane characterPageTabs = new JTabbedPane();
        //characterPageTabs.setLayout(new GridBagLayout());

        JPanel page1Canvas = new JPanel();
        JPanel page2Canvas = new JPanel();
        JPanel page3Canvas = new JPanel();
        page1Canvas.setLayout(new GridBagLayout());
        page2Canvas.setLayout(new GridBagLayout());
        page3Canvas.setLayout(new GridBagLayout());

        JPanel topPanel = buildTopPanel(p);
        JPanel abilitiesPanel = buildAbilityScorePanel(p);
        JPanel savesPanel = buildSavesPanel(p);
        JPanel skillsPanel = buildSkillsPanel(p);
        JPanel combatPanel = buildCombatPanel(p);
        JPanel personalityPanel = buildPersonalityPanel(p);
        JPanel featuresAndTraitsPanel = buildFeaturesAndTraitsPanel(p);
        JPanel spellsPanel = buildSpellPanel(p);

        //Builds page 1 of the tabbed character display
        geometry.gridwidth = 7; geometry.gridx = 0; geometry.gridy = 0;
        page1Canvas.add(topPanel, geometry);

        geometry.gridwidth = 1; geometry.gridheight = 4; geometry.gridx = 0 ;geometry.gridy = 1;
        page1Canvas.add(abilitiesPanel, geometry);

        geometry.gridheight = 2; geometry.gridwidth = 1; geometry.gridx = 1; geometry.gridy = 1;
        page1Canvas.add(savesPanel, geometry);

        geometry.gridheight = 2; geometry.gridwidth = 1; geometry.gridx = 1; geometry.gridy = 3;
        page1Canvas.add(skillsPanel, geometry);

        geometry.gridheight = 2; geometry.gridwidth = 2; geometry.gridx = 2; geometry.gridy = 1;
        page1Canvas.add(combatPanel, geometry);

        geometry.gridheight = 2; geometry.gridwidth = 2; geometry.gridx = 4; geometry.gridy = 1;
        page1Canvas.add(personalityPanel, geometry);

        geometry.gridheight = 2; geometry.gridx = 5; geometry.gridy = 3;
        page1Canvas.add(featuresAndTraitsPanel, geometry);

        resetGeometry();
        page2Canvas.add(spellsPanel, geometry);

        //fixme needs 2nd and 3rd panels so far
        characterPageTabs.addTab("Page 1", page1Canvas);
        characterPageTabs.addTab("Page 2", page2Canvas);
        characterPageTabs.addTab("Page 3", page3Canvas);

        getContentPane().add(characterPageTabs);
        pack();
        revalidate();
        setSize(screensize);
        //setSize(getPreferredSize().width + 25, screensize.height);
        setVisible(true);
    }

    private void resetGeometry(){
        geometry.gridx = 0;
        geometry.gridy = 0;
        geometry.gridheight = 1;
        geometry.gridwidth = 1;
    }

    private JPanel buildTopPanel(PlayerCharacter p){
        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());

        JPanel cNamePanel = new JPanel();
        cNamePanel.setLayout(new GridBagLayout());

        resetGeometry();

        geometry.anchor = GridBagConstraints.WEST;

        cNamePanel.add(GUIBuilder.presentationField( p.getName(), GUIBuilder.LARGE_FONT), geometry);

        geometry.gridy = 1;
        cNamePanel.add(GUIBuilder.labelGenSolid("Character Name", GUIBuilder.SUB_FONT), geometry);

        StringBuilder classLvlString = new StringBuilder();
        for(CharacterClass c : p.getCharacterClasses()){
            classLvlString.append(c.getClassName()).append(" ");
            if(!c.getSubClassName().equals("None")){
                classLvlString.append("(").append(c.getSubClassName()).append(") ");
            }
            classLvlString.append(c.getClassLevel()).append(" ");
        }

        geometry.gridheight = 4;
        geometry.gridx = 0; geometry.gridy = 0;
        ret.add(cNamePanel, geometry);

        geometry.gridheight = 1;
        geometry.gridx = 1; geometry.gridy = 0;
        ret.add(GUIBuilder.labelGenSolid("<HTML><U>" + (classLvlString) + "</U></HTML>", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridy = 1;
        ret.add(GUIBuilder.labelGenSolid("Class & Level", GUIBuilder.SUB_FONT), geometry);

        geometry.gridy = 2;
        ret.add(GUIBuilder.labelGenSolid("<HTML><U>" + (p.getRace()) + "</U></HTML>", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridy = 3;
        ret.add(GUIBuilder.labelGenSolid("Race", GUIBuilder.SUB_FONT), geometry);

        geometry.gridx = 2; geometry.gridy = 0;
        ret.add(GUIBuilder.labelGenSolid("<HTML><U>" + (p.getBackground()) + "</U></HTML>", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridy++;
        ret.add(GUIBuilder.labelGenSolid("Background", GUIBuilder.SUB_FONT), geometry);

        geometry.gridy++;
        ret.add(GUIBuilder.labelGenSolid("<HTML><U>" + (p.getAlignment()) + "</U></HTML>", GUIBuilder.MAIN_FONT), geometry);
        //"<HTML><U>" + () + "</U></HTML>"
        geometry.gridy++;
        ret.add(GUIBuilder.labelGenSolid("Alignment", GUIBuilder.SUB_FONT), geometry);

        geometry.gridx++; geometry.gridy = 0;
        ret.add(GUIBuilder.labelGenSolid("<HTML><U>" + (p.getPlayerName()) + "</U></HTML>", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridy++;
        ret.add(GUIBuilder.labelGenSolid("Player Name", GUIBuilder.SUB_FONT), geometry);

        geometry.gridy++;
        ret.add(GUIBuilder.labelGenSolid("<HTML><U>" + (p.getExperiencePoints()) + "</U></HTML>", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridy++;
        ret.add(GUIBuilder.labelGenSolid("Experience Points", GUIBuilder.SUB_FONT), geometry);

        return ret;
    }

    private JPanel buildAbilityScorePanel(PlayerCharacter p){

        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());

        resetGeometry();

        String[] abHeaders = new String[]{"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};

        ArrayList<JPanel> abilityPanels = new ArrayList<>();

        for(int i = 0; i < 6; i++){
            abilityPanels.add(new JPanel());
            abilityPanels.get(i).setLayout(new GridBagLayout());
        }
        int maxBoxWidth = 0;
        geometry.anchor = GridBagConstraints.CENTER;
        geometry.gridx = 0;

        for(int i = 0; i < 6; i++){
            geometry.gridy = 0;
            abilityPanels.get(i).add(GUIBuilder.labelGenSolid(abHeaders[i], GUIBuilder.SUB_FONT), geometry);

            geometry.gridy++;
            abilityPanels.get(i).add(GUIBuilder.labelGenSolid(p.getAbilityModsAsString()[i], GUIBuilder.LARGE_FONT), geometry);

            geometry.gridy++;
            abilityPanels.get(i).add(GUIBuilder.presentationField(Integer.toString(p.getAbilityScores()[i]), GUIBuilder.SUB_FONT), geometry);

            abilityPanels.get(i).setBorder(GUIBuilder.bufferBoarder);

            if(abilityPanels.get(i).getPreferredSize().width > maxBoxWidth){
                maxBoxWidth = abilityPanels.get(i).getPreferredSize().width;
            }
        }

        for(int i = 0; i < 6; i++){
            abilityPanels.get(i).setPreferredSize(new Dimension(maxBoxWidth, abilityPanels.get(i).getPreferredSize().height));
            geometry.gridy = i;
            ret.add(abilityPanels.get(i), geometry);
        }
        return ret;
    }

    private JPanel buildSavesPanel(PlayerCharacter p){
        JPanel ret = new JPanel();
        JPanel inspirationPanel = new JPanel();
        JPanel profPanel = new JPanel();

        saveBoxes.clear();
        resetGeometry();

        ret.setLayout(new GridBagLayout());
        inspirationPanel.setLayout(new GridBagLayout());
        profPanel.setLayout(new GridBagLayout());

        geometry.anchor = GridBagConstraints.WEST;
        geometry.gridx = 0; geometry.gridy = 0;
        inspirationPanel.add(GUIBuilder.presentationField(""+p.getInspiration(), GUIBuilder.LARGE_FONT), geometry);

        geometry.gridx++;
        inspirationPanel.add(GUIBuilder.labelGenSolid("Inspiration", GUIBuilder.NAME_FONT), geometry);
        inspirationPanel.setBorder(GUIBuilder.bufferBoarder);
        geometry.gridx = 0;
        profPanel.add(GUIBuilder.presentationField(""+p.getProficiencyBonus(), GUIBuilder.LARGE_FONT), geometry);

        geometry.gridx++;
        profPanel.add(GUIBuilder.labelGenSolid("Proficiency Bonus", GUIBuilder.NAME_FONT), geometry);
        profPanel.setBorder(GUIBuilder.bufferBoarder);

        geometry.gridx=0;
        ret.add(inspirationPanel, geometry);
        geometry.gridy++;
        ret.add(profPanel, geometry);

        for(int i = 0; i < 6; i++) {
            geometry.gridy = i+2;
            geometry.anchor = GridBagConstraints.WEST;
            String tag = p.getSavesAsStrings()[i];
            tag += "  " + abilityTags[i];
            saveBoxes.add( new JCheckBox(tag));
            saveBoxes.get(i).setSelected(p.getSavingThrowsProficiency()[i] == 1);
            ret.add(saveBoxes.get(i), geometry);
        }
        ret.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return ret;
    }

    private JPanel buildSkillsPanel(PlayerCharacter p){
        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());

        skillBoxes.clear();

        for(int i = 0; i < skillTags.length; i++){
            geometry.gridy = i;
            skillBoxes.add( new JCheckBox("" + p.getSkillsAsStrings()[i]+ "   "+skillTags[i]));
            skillBoxes.get(i).setSelected(p.getSkillProficiency()[i] == 1);
            ret.add(skillBoxes.get(i), geometry);
        }
        ret.setBorder(GUIBuilder.bufferBoarder);
        return ret;
    }

    private JPanel buildCombatPanel(PlayerCharacter p){
        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());
        resetGeometry();

        String[] combatLabels = new String[]{"Armor Class", "Initiative", "Speed", "Hit Points", "Temporary HP"};
        String[] fieldData = new String[]{Integer.toString(p.getArmorClass() + p.getOtherACMods()),
                " " + p.getInitiativeMod(), " " + p.getSpeed()};
        JPanel[] panels = new JPanel[]{new JPanel(), new JPanel(), new JPanel(), new JPanel(), new JPanel()};
        for(JPanel j : panels){
            j.setLayout(new GridBagLayout());
        }
        combatFields.clear();

        geometry.anchor = GridBagConstraints.CENTER;

        //builds AC, Initiative, and Speed panels
        for(int i = 0; i < 3; i++){
            geometry.gridx = i; geometry.gridy = 0;

            combatFields.add(new JTextField());
            combatFields.get(i).setText(fieldData[i]);
            combatFields.get(i).setFont(GUIBuilder.LARGE_FONT);

            panels[i].add(combatFields.get(i), geometry);
            geometry.gridy++;
            panels[i].add(GUIBuilder.labelGenSolid(combatLabels[i], GUIBuilder.SUB_FONT), geometry);
            panels[i].setBorder(GUIBuilder.bufferBoarder);

            geometry.gridx = i; geometry.gridy = 0;
            ret.add(panels[i], geometry);
        }
        ret.setBorder(GUIBuilder.bufferBoarder);

        int width = ret.getPreferredSize().width;

        //builds HP Panel
        combatFields.add(new JTextField());
        combatFields.get(3).setText(""+p.getCurrentHP());
        combatFields.get(3).setFont(GUIBuilder.LARGE_FONT);
        geometry.gridx = 0; geometry.gridy = 0;
        panels[3].setSize(new Dimension(width, panels[3].getPreferredSize().height));
        panels[3].setBorder(GUIBuilder.bufferBoarder);
        panels[3].add(combatFields.get(3), geometry);
        geometry.gridx++;
        panels[3].add(GUIBuilder.labelGenSolid((" / " + p.getMaxHP()), GUIBuilder.LARGE_FONT), geometry);
        geometry.gridx = 0; geometry.gridy = 1; geometry.gridwidth = 2;
        panels[3].add(GUIBuilder.labelGenSolid(combatLabels[3], GUIBuilder.SUB_FONT), geometry);

        //builds Temp HP Panel
        combatFields.add(new JTextField());
        combatFields.get(4).setText(""+p.getTemporaryHitPoints());
        combatFields.get(4).setFont(GUIBuilder.LARGE_FONT);
        geometry.gridx = 0; geometry.gridy = 0; geometry.gridwidth = 1;
        panels[4].setSize(new Dimension(width, panels[4].getPreferredSize().height));
        panels[4].setBorder(GUIBuilder.bufferBoarder);
        panels[4].add(combatFields.get(4), geometry);
        geometry.gridx = 0; geometry.gridy = 1;
        panels[4].add(GUIBuilder.labelGenSolid(combatLabels[4], GUIBuilder.SUB_FONT), geometry);


        geometry.gridx=0; geometry.gridy = 1; geometry.gridwidth = 3;
        ret.add(panels[3], geometry);
        geometry.gridy++;
        ret.add(panels[4], geometry);
        geometry.gridwidth = 1;

        JPanel hitDiePanel = new JPanel();
        geometry.gridx = 0; geometry.gridy = 0;
        hitDiePanel.add(GUIBuilder.textFieldwithSubscript(p.getHitDieAsString(), "Hit Die"), geometry);
        String[] die = new String[]{"d6", "d8", "d10", "d12"};
        geometry.gridy = 1;
        for(String d : die){
            if(p.getHitDieAsString().contains(d)){
                hitDiePanel.add(GUIBuilder.textFieldwithSubscript("", d), geometry);
                geometry.gridx++;
            }
        }

        geometry.gridx = 0; geometry.gridy = 3;
        ret.add(hitDiePanel, geometry);
        return ret;
    }

    private JPanel buildPersonalityPanel(PlayerCharacter p){

        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());
        resetGeometry();
        personalityAreas.clear();

        geometry.anchor = GridBagConstraints.CENTER;
        geometry.gridx = 0; geometry.gridy = 0;
        for(int i = 0; i < 5; i++){
            personalityAreas.add(new JTextArea(3,20));
            personalityAreas.get(i).setFont(GUIBuilder.MAIN_FONT);
            personalityAreas.get(i).setLineWrap(true);
            personalityAreas.get(i).setWrapStyleWord(true);
            personalityAreas.get(i).setSize(new Dimension(40,10));
        }
        personalityAreas.get(0).setText(p.getPersonalityTraits());
        personalityAreas.get(1).setText(p.getIdeals());
        personalityAreas.get(2).setText(p.getBonds());
        personalityAreas.get(3).setText(p.getFlaws());
        for(int i = 0; i < 4; i++){
            ret.add(personalityAreas.get(i), geometry);
            geometry.gridy++;
            ret.add(GUIBuilder.labelGenSolid(personalityTags[i], GUIBuilder.SUB_FONT), geometry);
            geometry.gridy++;
        }
        return ret;
    }

    private JPanel buildFeaturesAndTraitsPanel(PlayerCharacter p){
        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());
        resetGeometry();

        String[] featureNameArray = new String[p.getAbilities().size()];
        for(int i = 0; i < featureNameArray.length; i++){
            featureNameArray[i] = p.getAbilities().get(i);
        }

        JList<String> featureNameList = new JList<>(featureNameArray) {
            public String getToolTipText(MouseEvent event){
                int index = locationToIndex(event.getPoint());
                String selectedFeature = (String) getModel().getElementAt(index);
                return AbilityReader.getFeatBody(selectedFeature);
            }

        };
        featureNameList.setVisibleRowCount(10);

        JScrollPane featureScrollPane = new JScrollPane(featureNameList);
        ret.add(featureScrollPane, geometry);
        geometry.gridy++;

        ret.add(GUIBuilder.labelGenSolid("Features and Traits", GUIBuilder.SUB_FONT), geometry);


        return ret;
    }

    private JPanel buildSpellPanel(PlayerCharacter p){

        resetGeometry();

        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());

        JPanel col1 = new JPanel();
        JPanel col2 = new JPanel();
        JPanel col3 = new JPanel();

        col1.setLayout(new GridBagLayout());
        col2.setLayout(new GridBagLayout());
        col3.setLayout(new GridBagLayout());


        String[] l = new String[]{"a","b","c","d","e","f","g","h","i"};

        JList level0Spells = new JList();
        JList level1Spells = new JList();
        JList level2Spells = new JList();
        JList level3Spells = new JList();
        JList level4Spells = new JList();
        JList level5Spells = new JList();
        JList level6Spells = new JList();
        JList level7Spells = new JList();
        JList level8Spells = new JList();
        JList level9Spells = new JList();

        level0Spells.setVisibleRowCount(8);
        level1Spells.setVisibleRowCount(13);
        level2Spells.setVisibleRowCount(13);
        level3Spells.setVisibleRowCount(13);
        level4Spells.setVisibleRowCount(13);
        level5Spells.setVisibleRowCount(9);
        level6Spells.setVisibleRowCount(9);
        level7Spells.setVisibleRowCount(9);
        level8Spells.setVisibleRowCount(7);
        level9Spells.setVisibleRowCount(7);

        col1.add(GUIBuilder.labelGenSolid("Cantrips", GUIBuilder.MAIN_FONT), geometry);
        geometry.gridy++;
        col1.add(new JScrollPane(level0Spells), geometry);

        geometry.gridy++;
        col1.add(GUIBuilder.labelGenSolid("1", GUIBuilder.MAIN_FONT), geometry);
        geometry.gridy++;
        col1.add(new JScrollPane(level1Spells), geometry);

        geometry.gridy++;
        col1.add(GUIBuilder.labelGenSolid("2", GUIBuilder.MAIN_FONT), geometry);
        geometry.gridy++;
        col1.add(new JScrollPane(level2Spells), geometry);

        resetGeometry();

        col2.add(GUIBuilder.labelGenSolid("3", GUIBuilder.MAIN_FONT), geometry);
        geometry.gridy++;
        col2.add(new JScrollPane(level3Spells), geometry);

        geometry.gridy++;
        col2.add(GUIBuilder.labelGenSolid("4", GUIBuilder.MAIN_FONT), geometry);
        geometry.gridy++;
        col2.add(new JScrollPane(level4Spells), geometry);

        geometry.gridy++;
        col2.add(GUIBuilder.labelGenSolid("5", GUIBuilder.MAIN_FONT), geometry);
        geometry.gridy++;
        col2.add(new JScrollPane(level5Spells), geometry);

        resetGeometry();

        col3.add(GUIBuilder.labelGenSolid("6", GUIBuilder.MAIN_FONT), geometry);
        geometry.gridy++;
        col1.add(new JScrollPane(level6Spells), geometry);

        geometry.gridy++;
        col1.add(GUIBuilder.labelGenSolid("7", GUIBuilder.MAIN_FONT), geometry);
        geometry.gridy++;
        col1.add(new JScrollPane(level7Spells), geometry);

        geometry.gridy++;
        col1.add(GUIBuilder.labelGenSolid("8", GUIBuilder.MAIN_FONT), geometry);
        geometry.gridy++;
        col1.add(new JScrollPane(level8Spells), geometry);

        geometry.gridy++;
        col1.add(GUIBuilder.labelGenSolid("9", GUIBuilder.MAIN_FONT), geometry);
        geometry.gridy++;
        col1.add(new JScrollPane(level9Spells), geometry);

        resetGeometry();

        ret.add(col1, geometry);
        geometry.gridx++;
        ret.add(col2, geometry);
        geometry.gridx++;
        ret.add(col3, geometry);

        return ret;
    }

    private ArrayList<JTextField> findJTextFields(JPanel j){
        ArrayList<JTextField> textFieldArrayList = new ArrayList<>();
        for(Component c : j.getComponents()){
            if(c.getClass().equals(JTextField.class)){
                textFieldArrayList.add((JTextField) c);
            } else if(c.getClass().equals(JPanel.class)){
                textFieldArrayList.addAll(findJTextFields((JPanel)c));
            }
        }
        return textFieldArrayList;
    }


}
