import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class GUIBuilder {

    public static final Font HEADER_FONT = new Font("Helvetica", Font.BOLD, 14);
    public static final Font MAIN_FONT = new Font("Helvetica", Font.BOLD, 12);
    public static final Font NAME_FONT = new Font("Helvetica", Font.BOLD, 10);
    public static final Font SUB_FONT = new Font("Helvetica", Font.BOLD, 8);
    public static final Font LARGE_FONT = new Font("Helvetica", Font.BOLD, 18);

    public static final CompoundBorder bufferBoarder = new CompoundBorder(new EmptyBorder(5, 5, 5, 5), BorderFactory.createLineBorder(Color.BLACK));


    public static JLabel labelGenSolid(String str, Font f) {

        JLabel l = new JLabel(str);
        EmptyBorder border = new EmptyBorder(2, 5, 2, 5);

        l.setBorder(border);
        l.setFont(f);
        return l;
    }

    public static JLabel labelGenSubtle(String str, Font f) {

        JLabel l = new JLabel(str);
        EmptyBorder border = new EmptyBorder(2, 5, 2, 5);

        l.setBorder(border);
        l.setForeground(Color.GRAY);
        l.setFont(f);

        return l;
    }

    public static JTextField presentationField(String str, Font f) {
        JTextField t = new JTextField(str);
        t.setFont(f);
        t.setHorizontalAlignment(JTextField.CENTER);
        t.setColumns(str.length() + 1);
        t.setFocusable(false);

        return t;
    }

    public static JPanel textFieldwithSubscript(String textFieldString, String subscriptString) {
        JPanel ret = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        ret.setLayout(new GridBagLayout());

        JTextField t = new JTextField(textFieldString);
        t.setFont(LARGE_FONT);

        c.gridx = 0;
        c.gridy = 0;
        ret.add(t, c);

        c.gridy = 1;
        ret.add(GUIBuilder.labelGenSolid(subscriptString, GUIBuilder.SUB_FONT), c);

        return ret;

    }

    public static String getFeatDisplayString(String selectedFeat) {

        StringBuilder ret = new StringBuilder();

        ret.append(selectedFeat).append("\n\n");

        ret.append("pg. ").append(AbilityReader.getFeatPageNumber(selectedFeat)).append(", ").append(AbilityReader.getFeatBook(selectedFeat));
        ret.append("\n\n");

        String[] featBodyText = AbilityReader.getFeatBody(selectedFeat).split("-");
        for (int i = 0; i < featBodyText.length; i++) {
            featBodyText[i] = featBodyText[i].replace("\"", "");
        }
        ret.append(featBodyText[0]).append("\n");

        if (featBodyText.length > 1) {
            for (int i = 1; i < featBodyText.length; i++) {
                ret.append("\n").append("-").append(featBodyText[i]).append("\n");
            }
        }

        if (!"None".equals(AbilityReader.getFeatRequirements(selectedFeat))) {
            ret.append("\n\n");
            ret.append("Requirements: ").append(AbilityReader.getFeatRequirements(selectedFeat));
        }

        return ret.toString();
    }

    public static JMenuBar getStandardMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu resourceMenu = new JMenu("Resources");
        JMenuItem seeFeats = new JMenuItem("Show Feats");
        seeFeats.addActionListener((event) -> new ViewAllFeatsWindow());

        //JMenu monsterMenu = new JMenu("Monsters");
        JMenuItem seeMonsters = new JMenuItem("View Monster Manual");
        seeMonsters.addActionListener((event) -> new ViewAllMonstersWindow());

        JMenuItem seeSpells = new JMenuItem("View Spell List");
        seeSpells.addActionListener((event) -> new ViewAllSpellsWindow());

        resourceMenu.add(seeFeats);
        resourceMenu.add(seeMonsters);
        resourceMenu.add(seeSpells);
        menuBar.add(resourceMenu);

        return menuBar;
    }
}
