import javax.swing.*;
import java.awt.*;
import java.lang.reflect.GenericArrayType;
import java.security.Guard;

public class CharacterSheet {

    private static GridBagConstraints geometry = new GridBagConstraints();

    public static void buildShowSheet(PlayerCharacter p){

        JFrame window = new JFrame(p.getName());



        JPanel topPanel = buildTopPanel(p);
        JPanel abilitiesPanel = new JPanel();
        JPanel savesPanel = new JPanel();
        JPanel skillPanel = new JPanel();
        JPanel combatPanel = new JPanel();
        JPanel personalityPanel = new JPanel();
        JPanel otherProfPanel = new JPanel();
        JPanel equipmentPanel = new JPanel();
        JPanel featuresPanel = new JPanel();

        window.add(topPanel);

        Dimension windowSize = window.getPreferredSize();
        window.setSize((int) (windowSize.getWidth() + 25), (int) (windowSize.getHeight() + 50));

        window.repaint();
        window.revalidate();
        window.setVisible(true);
    }

    private static JPanel buildTopPanel(PlayerCharacter p){
        JPanel ret = new JPanel();
        ret.setLayout(new GridBagLayout());

        JPanel cNamePanel = new JPanel();
        cNamePanel.setLayout(new GridBagLayout());

        geometry.anchor = GridBagConstraints.WEST;
        geometry.gridx = 0; geometry.gridy = 0;
        cNamePanel.add(GUIBuilder.labelGenSolid("<HTML><U>" + p.getName() + "</U></HTML>", GUIBuilder.LARGE_FONT), geometry);

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

        geometry.gridy++;
        ret.add(GUIBuilder.labelGenSolid("Class & Level", GUIBuilder.SUB_FONT), geometry);

        geometry.gridy++;
        ret.add(GUIBuilder.labelGenSolid("<HTML><U>" + (p.getRace()) + "</U></HTML>", GUIBuilder.MAIN_FONT), geometry);

        geometry.gridy++;
        ret.add(GUIBuilder.labelGenSolid("Race", GUIBuilder.SUB_FONT), geometry);



        return ret;
    }
}
