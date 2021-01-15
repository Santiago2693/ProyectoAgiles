package negocio;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ChatRoomTest {

    @Test
    public void given_newChatRoom_when_imprimirMensajes_then_voidMessage(){
        ChatRoom c = new ChatRoom("A2", new ArrayList<Usuario>());
        assertEquals("Esta sala de chat esta vacia", c.imprimirMensajes());
    }

    @Test
    public void given_oldChatRoom_when_imprimirMensajes_then_Messages(){
        Usuario mahatma = new Usuario("003", "priviet", "usuario normal");
        Usuario cesar = new Usuario("004", "rocket league", "usuario normal");
        Usuario carolina = new Usuario("005", "conejos", "usuario normal");
        ArrayList<Usuario> listaUsuariosB = new ArrayList<Usuario>();
        listaUsuariosB.add(cesar);
        listaUsuariosB.add(carolina);
        listaUsuariosB.add(mahatma);
        ChatRoom c = new ChatRoom("A2",listaUsuariosB);
        Mensaje m1  = new Mensaje("Hola, como van",false,cesar);
        Mensaje m2 = new Mensaje("Todo bien y tu?", false, mahatma);
        Mensaje m3 = new Mensaje("Estoy haciendo el proyecto de agiles", false, carolina);
        c.anadirMensaje(m1);
        c.anadirMensaje(m2);
        c.anadirMensaje(m3);
        String respuesta = m1.getInformacion();
        respuesta += m2.getInformacion();
        respuesta += m3.getInformacion();
        assertEquals(respuesta, c.imprimirMensajes());
    }

}