import javax.swing.*;
import java.awt.*;

public class PopoutMonsterWindow extends JFrame {

    PopoutMonsterWindow(Monster m){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int monsterDisplayWidth = (int) (screenSize.getWidth() *0.4);
        int monsterDisplayHeight = (int) (screenSize.getHeight() * 0.8);

        setTitle(m.getName());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextPane monsterDisplay = new JTextPane();

        monsterDisplay.setContentType("text/html");
        monsterDisplay.setText(m.toString());
        JScrollPane monsterDisplayScroller = new JScrollPane(monsterDisplay);


        monsterDisplay.setPreferredSize(new Dimension(monsterDisplayWidth, 600));
        monsterDisplay.setCaretPosition(0);

        monsterDisplayScroller.setPreferredSize(new Dimension(monsterDisplayWidth, 600));
        add(monsterDisplayScroller);

        setSize(new Dimension(550, 600));
        setVisible(true);
    }
}
