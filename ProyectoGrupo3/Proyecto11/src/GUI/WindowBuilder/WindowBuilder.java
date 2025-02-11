import javax.swing.*;
import java.awt.Color;
import helper_classes.*;

public class WindowBuilder {
  public static void main(String[] args) {

     JFrame frame = new JFrame("My Awesome Window");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(826, 445);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#eeeeee"));

     JButton element1 = new JButton("Generar Codigo de Barras");
     element1.setBounds(266, 303, 255, 41);
     element1.setBackground(Color.decode("#ffffff"));
     element1.setForeground(Color.decode("#1b1b1b"));
     element1.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element1.setBorder(new RoundedBorder(4, Color.decode("#626262"), 1));
     element1.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element1, Color.decode("#c2c2c2"), Color.decode("#ffffff"));
     panel.add(element1);

     JLabel element2 = new JLabel("Usuario:");
     element2.setBounds(166, 169, 106, 18);
     element2.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element2.setForeground(Color.decode("#1b1b1b"));
     panel.add(element2);

     JLabel element3 = new JLabel("Contraseña:");
     element3.setBounds(167, 217, 106, 18);
     element3.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element3.setForeground(Color.decode("#1b1b1b"));
     panel.add(element3);

     JPasswordField element4 = new JPasswordField("1234");
     element4.setBounds(266, 214, 255, 24);
     element4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element4.setBackground(Color.decode("#ffffff"));
     element4.setForeground(Color.decode("#737674"));
     element4.setBorder(new RoundedBorder(2, Color.decode("#626262"), 1));
     OnFocusEventHelper.setOnFocusText(element4, "******", Color.decode("#1b1b1b"),   Color.decode("#737674"));
     panel.add(element4);

     JTextField element5 = new JTextField("");
     element5.setBounds(265, 160, 254, 24);
     element5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     element5.setBackground(Color.decode("#ffffff"));
     element5.setForeground(Color.decode("#737674"));
     element5.setBorder(new RoundedBorder(2, Color.decode("#626262"), 1));
     OnFocusEventHelper.setOnFocusText(element5, "", Color.decode("#1b1b1b"),   Color.decode("#737674"));
     panel.add(element5);

     frame.add(panel);
     frame.setVisible(true);

  }
}