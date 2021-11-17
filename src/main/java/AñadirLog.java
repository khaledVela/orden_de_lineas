import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
public class AñadirLog {
    private final static Logger logger = (Logger) LogManager.getRootLogger();
    private String informacion;

    public AñadirLog() {
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
        logger.debug(informacion);
    }
}
