import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class CharacterSheet {

    private static GridBagConstraints geometry = new GridBagConstraints();
    private static ArrayList<JCheckBox> saveBoxes = new ArrayList<>();
    private static ArrayList<JCheckBox> skillBoxes = new ArrayList<>();
    private static ArrayList<JTextArea> personalityAreas = new ArrayList<>();
    private static CompoundBorder cBorder = new CompoundBorder(new EmptyBorder(5,5,5,5), BorderFactory.createLineBorder(Color.BLACK));

    private static String[] skillTags  = new String[]{"Acrobatics", "Animal Handling",
            "Arcana", "Athletics", "Deception", "History", "Insight", "Intimidation", "Investigation",
            "Medicine", "Nature", "Perception", "Performance", "Persuasion", "Religion", "Sleight of Hand",
            "Stealth", "Survival"};
    private static String[] abilityTags = new String[]{"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
    private static String[] personalityTags = new String[]{"Personality Traits", "Ideals", "Bonds", "Flaws"};

    public static void buildShowSheet(PlayerCharacter p){
        JFrame window = new JFrame(p.getName());

        JPanel canvas = new JPanel();

        JPanel topPanel = buildTopPanel(p);
        JPanel abilitiesPanel = buildAbilitiesPanel(p);
        JPanel savesPanel = buildSavesPanel(p);
        JPanel skillPanel = buildSkillsPanel(p);
        JPanel combatPanel = new JPanel();
        JPanel personalityPanel = buildPersonalityPanel(p);
        JPanel otherProfPanel = new JPanel();
        JPanel equipmentPanel = new JPanel();
        JPanel featuresPanel = new JPanel();

        window.setLayout(new GridBagLayout());
        canvas.setLayout(new GridBagLayout());
        //topPanel.setLayout(new GridBagLayout());
//        abilitiesPanel.setLayout(new GridBagLayout());
//        savesPanel.setLayout(new GridBagLayout());
//        skillPanel.setLayout(new GridBagLayout());
//        combatPanel.setLayout(new GridBagLayout());
//        personalityPanel.setLayout(new GridBagLayout());
//        otherProfPanel.setLayout(new GridBagLayout());
//        equipmentPanel.setLayout(new GridBagLayout());
//        featuresPanel.setLayout(new GridBagLayout());

        geometry.gridx=0; geometry.gridy = 0; geometry.gridwidth = 6;
        canvas.add(topPanel, geometry);

        geometry.gridy = 1; geometry.gridheight = 4; geometry.gridwidth = 1;
        canvas.add(abilitiesPanel, geometry);

        geometry.gridx = 1; geometry.gridheight = 1;
        canvas.add(savesPanel, geometry);

        geometry.gridy = 2;
        canvas.add(skillPanel, geometry);

        geometry.gridx = 4; geometry.gridy = 1; geometry.gridheight = 4;
        canvas.add(personalityPanel, geometry);

        geometry.gridx = 0; geometry.gridy = 0;
        window.add(canvas);

        Dimension windowSize = window.getPreferredSize();
        window.setSize((int) (windowSize.getWidth() + 25), (int) (windowSize.getHeight() + 50));

        //JPanel glass = buildGlass();

        window.getGlassPane().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                e.consume();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                e.consume();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                e.consume();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                e.consume();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                e.consume();
            }
        });
        window.getGlassPane().setVisible(true);


        window.repaint();
        window.revalidate();
        window.setVisible(true);
    }
    private static JPanel buildGlass(){
        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());

        ret.setOpaque(true);
        ret.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me)
            {
                me.consume();
            }
        });
        ret.setVisible(true);
        return ret;
    }

    private static JPanel buildTopPanel(PlayerCharacter p){
        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());

        JPanel cNamePanel = new JPanel();
        cNamePanel.setLayout(new GridBagLayout());

        geometry.anchor = GridBagConstraints.WEST;
        geometry.gridx = 0; geometry.gridy = 0;
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

    private static JPanel buildAbilitiesPanel(PlayerCharacter p){

        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());
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
            abilityPanels.get(i).add(GUIBuilder.labelGenSubtle(Integer.toString(p.getAbilityScores()[i]), GUIBuilder.MAIN_FONT), geometry);

            abilityPanels.get(i).setBorder(cBorder);

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

    private static JPanel buildSavesPanel(PlayerCharacter p){
        UIManager.getDefaults().put("Checkbox.disabledText", Color.BLACK);


        JPanel ret = new JPanel();
        JPanel inspirationPanel = new JPanel();
        JPanel profPanel = new JPanel();

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

    private static JPanel buildSkillsPanel(PlayerCharacter p){
        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());



        for(int i = 0; i < skillTags.length; i++){
            geometry.gridy = i;
            skillBoxes.add( new JCheckBox("" + p.getSkillsAsStrings()[i]+ "   "+skillTags[i]));
            skillBoxes.get(i).setSelected(p.getSkillProficiency()[i] == 1);
            ret.add(skillBoxes.get(i), geometry);
        }
        ret.setBorder(GUIBuilder.bufferBoarder);
        return ret;
    }

    private static JPanel buildCombatPanel(PlayerCharacter p){
        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());
        int ac = 10 + p.getDexMod() + p.getOtherACMods();


        return ret;
    }

    private static JPanel buildPersonalityPanel(PlayerCharacter p){

        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());

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
}
