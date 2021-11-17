
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Rectangulos extends JPanel implements IDibujar{

    private int alto;
    private int x;
    private int y;
    private Color color =Color.red;
    private PropertyChangeSupport observed;
    AñadirLog log =new AñadirLog();
    public Rectangulos(int alto,int x) {
        log.setInformacion("Creo un nuevo recuadro "+alto+"-"+x);
        this.x=x;
        y = 400;
        this.alto=alto;
        observed = new PropertyChangeSupport(this);
    }
    public void addObserver(PropertyChangeListener observador) {
        observed.addPropertyChangeListener(observador);
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        int oldValue = this.x;
        this.x = x;
        int newValue = this.x;
        observed.firePropertyChange("CAMBIO", oldValue, newValue);
        log.setInformacion("Cambio la ubicacion del rectangulo "+alto+"-"+x);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        log.setInformacion("Cambio el color de mi linea");
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void dibujar (Graphics g) {
        g.setColor(color);
        g.drawLine(x,y,x,alto);
    }

}