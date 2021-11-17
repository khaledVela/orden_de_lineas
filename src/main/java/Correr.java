import javax.swing.*;
import java.awt.*;

public class Correr extends JFrame {
    private Visual panel_dibujo=new Visual();
    AñadirLog log = new AñadirLog();
    public Correr() {
        super("Practico 1");
        log.setInformacion("Corro el programa");
        setSize(615, 440);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel_dibujo.setPreferredSize(new Dimension(800,400));
        add(panel_dibujo,BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Correr();
    }

}