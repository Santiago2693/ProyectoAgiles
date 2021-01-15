package negocio;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuscadorTest {
    private Usuario usr;
    private Usuario usr2;
    private Usuario usr3;
    private ChatRoom sala;
    private Buscador barraBusqueda;

    @Before
    public void setUp(){
        usr =new Usuario("001", "mike","usuario root");
        usr2 =new Usuario("002","santiago","usuario root");
        usr3 =new Usuario("003","kevin","usuario root");
        ArrayList<Usuario> listaUsuariosA = new ArrayList<Usuario>();
        listaUsuariosA.add(usr2);
        listaUsuariosA.add(usr3);
        sala = new ChatRoom("M",listaUsuariosA);
        ChatRoom salaB = new ChatRoom("B",new ArrayList<Usuario>());
        usr3.unirseAlChat(salaB);
        ChatRoom salaC  = new ChatRoom("C",new ArrayList<Usuario>());
        usr2.unirseAlChat(salaC);
        usr.unirseAlChat(sala);
        usr.unirseAlChat(salaB);
        usr.unirseAlChat(salaC);
        barraBusqueda = new Buscador(usr.getChats());
    }

    @Test
    public void given_chatID_when_buscarEnChatsUsuario_then_chatFound(){
        assertEquals(sala,barraBusqueda.buscar("M"));
    }
    @Test
    public void given_chatID_when_buscarEnChatsUsuario_then_chatNotFound(){
        assertEquals(null,barraBusqueda.buscar("D"));
    }
}