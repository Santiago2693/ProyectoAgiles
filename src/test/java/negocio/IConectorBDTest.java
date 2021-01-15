package negocio;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IConectorBDTest {
    @Test
    public void given_userId_when_is_found_then_ok(){
        IConectorBD c= Mockito.mock(IConectorBD.class);
        BuscadorUsuario b1 = new BuscadorUsuario(c);
        ArrayList<Usuario> amigos = new ArrayList<>();
        amigos.add(new Usuario("Stryder#2693", "procesoUnificado"));
        amigos.add(new Usuario("Cesar#5555", "Iscariote"));
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia", amigos, new ArrayList<Solicitud>());
        Mockito.when(c.query("Mikkel14#1111")).thenReturn(mike);
        assertEquals(mike, b1.buscar("Mikkel14#1111"));
    }
    @Test
    public void given_userId_when_not_found_then_ok() {
        IConectorBD c = Mockito.mock(IConectorBD.class);
        BuscadorUsuario b1 = new BuscadorUsuario(c);
        ArrayList<Usuario> amigos = new ArrayList<>();
        Mockito.when(c.query("MahatmaQ#1872")).thenReturn(null);
        assertEquals(null, b1.buscar("MahatmaQ#1872"));
    }
}