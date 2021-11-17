import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Visual extends JPanel implements ActionListener, PropertyChangeListener,Runnable {
    private ArrayList<Rectangulos> lista = new ArrayList();
    private JButton nuevo = new JButton("Nuevo Conjunto");
    private JButton menor = new JButton("Menor a Mayor");
    private JButton mayor = new JButton("Mayor a Menor");
    AñadirLog log = new AñadirLog();

    public Visual() {
        log.setInformacion("Creo una ventana negra y en esta añado menu");
        setBackground(Color.BLACK);
        menu();
    }

    public void menu() {
        setLayout(null);
        setBackground(Color.BLACK);
        nuevo.setBounds(0, 0, 200, 20);
        menor.setBounds(200, 0, 200, 20);
        menor.setVisible(false);
        mayor.setBounds(400, 0, 200, 20);
        mayor.setVisible(false);
        add(nuevo);
        nuevo.addActionListener(this);
        add(menor);
        menor.addActionListener(this);
        add(mayor);
        mayor.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nuevo) {
            menor.setVisible(true);
            mayor.setVisible(true);
            log.setInformacion("Creo un nuevo orden de rectangulos");
            int x = 0;
            lista.clear();
            for (int i = 0; i < 300; i++) {
                int altura = (int) (Math.random() * (400 - 1));
                Rectangulos rectangulos = new Rectangulos(altura, x);
                rectangulos.addObserver(this);
                lista.add(rectangulos);
                log.setInformacion("Añado rectangulo a la cola Lista");
                x = x + 2;
            }
            repaint();
        }
        if (e.getSource() == mayor) {
            log.setInformacion("Ordenando Mayor a Menor");
            Collections.sort(lista, new Comparator<Rectangulos>() {
                @Override
                public int compare(Rectangulos r1, Rectangulos r2) {
                    return new Integer(r1.getAlto()).compareTo(new Integer(r2.getAlto()));
                }
            });
            int a = 0;
            for (int i = 0; i < 300; i++) {
                lista.get(i).setX(a);
                lista.get(i).setColor(Color.BLUE);
                a += 2;
            }
        }
        if (e.getSource() == menor) {
            log.setInformacion("Ordenando de Menor a Mayor");
            Collections.sort(lista, new Comparator<Rectangulos>() {
                @Override
                public int compare(Rectangulos r1, Rectangulos r2) {
                    return new Integer(r2.getAlto()).compareTo(new Integer(r1.getAlto()));
                }
            });
            int a = 0;
            for (int i = 0; i < 300; i++) {
                lista.get(i).setX(a);
                lista.get(i).setColor(Color.GREEN);
                a += 2;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).dibujar(g);
        }
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        run();
        repaint();
    }
    @Override
    public void run() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
