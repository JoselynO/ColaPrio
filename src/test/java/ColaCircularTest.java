import org.example.ColaCircular;
import org.example.Proceso;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ColaCircularTest {

    @Test
    public void crearProcesosTest(){
        int tamanoEsperado = 50;
        ColaCircular cola = new ColaCircular();
        assertEquals(tamanoEsperado, cola.getTamano());
    }

    @Test
    public void ejecutarProcesosTest(){
        int tamanoEsperado = 0;
        ColaCircular cola = new ColaCircular();
        cola.ejecutarProcesos();
        assertEquals(tamanoEsperado, cola.getTamano());
    }

    @Test
    public void tiempoModificacionTest(){
        ColaCircular cola = new ColaCircular();
        Proceso p = cola.getProcesosOrdenados().get(0);
        LocalDateTime tiempoUltimaModificacionInicial = p.gettUltimaModificacion();
        p.ejecutar();
        assertNotSame(tiempoUltimaModificacionInicial, p.gettUltimaModificacion());
    }
}
