import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;

public class TooltipTest extends JList {

    public TooltipTest() {
        super(new String[]{ "A", "B", "C", "D", "E", "F", "G", "H" });
        ToolTipManager.sharedInstance().registerComponent(this);
    }

    public String getToolTipText(MouseEvent event) {
        Point p = event.getPoint();
        int location = locationToIndex(p);
        String tip = (String) getModel().getElementAt(location);
        return tip;
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame("Custom Tip Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TooltipTest list = new TooltipTest();

        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}