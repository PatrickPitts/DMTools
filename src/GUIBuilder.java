import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class GUIBuilder {

    public static final Font HEADER_FONT = new Font("Helvetica", Font.BOLD, 14);
    public static final Font MAIN_FONT = new Font("Helvetica",Font.BOLD, 12);
    public static final Font NAME_FONT = new Font("Helvetica",Font.BOLD, 10);
    public static final Font SUB_FONT = new Font("Helvetica",Font.BOLD, 8);
    public static final Font LARGE_FONT = new Font("Helvetica",Font.BOLD, 18);

    public static final CompoundBorder bufferBoarder = new CompoundBorder(new EmptyBorder(5,5,5,5), BorderFactory.createLineBorder(Color.BLACK));


    public static JLabel labelGenSolid(String str, Font f){

        JLabel l = new JLabel(str);
        EmptyBorder border = new EmptyBorder(2,5,2,5);

        l.setBorder(border);
        l.setFont(f);
        return l;
    }

    public static JLabel labelGenSubtle(String str, Font f){

        JLabel l = new JLabel(str);
        EmptyBorder border = new EmptyBorder(2,5,2,5);

        l.setBorder(border);
        l.setForeground(Color.GRAY);
        l.setFont(f);

        return l;
    }

    public static JTextField presentationField(String str, Font f){
        JTextField t = new JTextField(str);
        t.setFont(f);
        t.setColumns(str.length()+1);
        t.setFocusable(false);

        return t;
    }
}
