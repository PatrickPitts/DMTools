import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class GUIBuilder {

    public static final Font HEADER_FONT = new Font("TimesRoman", Font.BOLD, 14);
    public static final Font MAIN_FONT = new Font("TimesRoman",Font.BOLD, 12);
    public static final Font NAME_FONT = new Font("TimesRoman",Font.BOLD, 10);
    public static final Font SUB_FONT = new Font("TimesRoman",Font.BOLD, 8);
    public static final Font LARGE_FONT = new Font("TimesRoman",Font.BOLD, 18);

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

//    public static JLabel labelGenSolidUnderline(String str, Font f){
//
//        AttributedString txt = new AttributedString(str);
//        txt.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
//        txt.addAttribute(TextAttribute.FONT, f);
//        JLabel l = new JLabel((String) txt);
//        EmptyBorder border = new EmptyBorder(2,5,2,5);
//
//        l.setBorder(border);
//        return l;
//    }
}
