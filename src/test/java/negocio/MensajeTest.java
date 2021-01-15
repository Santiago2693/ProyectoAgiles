package negocio;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MensajeTest {
    private Usuario u1;
    private Usuario u2;
    private ChatRoom c;

    @Before
    public void setUp(){
        u1 = new Usuario("006","manca","usuario:normal");
        u2 = new Usuario("005", "mechas", "usuario normal");
        ArrayList<Usuario> lista = new ArrayList<>();
        c = new ChatRoom("M", lista);
    }

    @Test
    public void given_ChatRoom_when_sendNewMsg_then_ok(){
        Mensaje m2 = new Mensaje("Saquen una hojita",false,u1);
        assertEquals(m2.getInformacion(),m2.enviarMensaje(c));
    }
}