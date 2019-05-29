import javax.swing.*;
import java.util.Arrays;

public class ViewAllSpellsWindow extends JFrame {

    ViewAllSpellsWindow(){
        String[] spellNameList = SpellReader.getSpellMap().keySet().toArray(new String[0]);
        Arrays.sort(spellNameList);

        JList spellNamesJlist = new JList(spellNameList);
        spellNamesJlist.setVisibleRowCount(20);
        JScrollPane scroller = new JScrollPane(spellNamesJlist);
        add(scroller);

        setVisible(true);
    }
}
