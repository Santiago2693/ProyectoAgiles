package negocio;

import java.util.ArrayList;
import org.mockito.Mockito;

public class AppSprint {
    private static Usuario mike = new Usuario("Mikkel14#1111","patronEstrategia",null);
    public static void main(String[] args){
        System.out.println("Busqueda del usuario Mikkel14#1111");
        Usuario encontrado = AppSprint.buscar("Mikkel14#1111");
        if(encontrado != null) {
            System.out.println("[SERVER] El usuario encontrado es:" + encontrado.getUserId());
        }
        System.out.println("Enviando solicitud de amistad al usuario enontrado");

        ArrayList<Usuario> amigos = new ArrayList<>();
        ManejadorSolicitud p = new ManejadorSolicitud();
        amigos.add(new Usuario("Stryder#2693", "procesoUnificado"));
        Usuario emisor = new Usuario("Cesar#5555", "Iscariote",amigos, new ArrayList<Solicitud>());
        mike.setManejadorSolicitud(p);
        emisor.setManejadorSolicitud(p);
        p.generarSolicitud(emisor,mike);
        if(mike.getListaDeSolicitudes().size() != 0){
            System.out.println("[SERVIDOR] Se ha enviado la solicitud de amistad a "+mike.getUserId());
        }
        p.procesarSolicitud(mike.getListaDeSolicitudes().get(0), mike, true);
        if (amigos.size() == 2){
            System.out.println("[SERVIDOR] El usuario ha aceptado la solicitud de amistad. Ya sois amigos!");
        }
        System.out.println("Creacion de salas de chat");
        ArrayList<Usuario> integrantes = new ArrayList<Usuario>();
        integrantes.add(emisor);
        ChatRoom c = new ChatRoom("A",integrantes);
        if(c!=null) {
            System.out.println("[SERVIDOR] La sala de chat " + c.getID() + " ha sido creada exitosamente");
            System.out.println(c.imprimirMensajes());
        }
        System.out.println("Añadiendo usuarios a la sala de chat");
        c.anadirUsuario(mike);
        if (integrantes.size() ==2){
            System.out.println("[SERVIDOR] Se ha añadido un nuevo usuario a la sala de chat " + c.getID());
        }
        System.out.println("Envio de mensajes");
        Mensaje mensaje1= new Mensaje("Hola a todos", false, emisor);
        c.enviarMensaje(mensaje1);
        System.out.println(c.imprimirMensajes());
        Mensaje mensaje2 =new Mensaje("Hola que tal!", true, mike);

        System.out.println(c.enviarMensaje(mensaje2));
        /*--------PARTE 2----------*/
        System.out.println("Eliminar Mensaje");
        c.elmininarMensaje(mensaje1);
        System.out.println("[SERVIDOR] El mensaje ha sido eliminado con exito ");
        System.out.println(c.imprimirMensajes());

        System.out.println("Editar Mensaje");
        mensaje2.editarIndormacion("Ya nada, Hola jajaja");
        System.out.println("[SERVIDOR] El mensaje ha sido modifcao exitosamente");
        System.out.println(c.imprimirMensajes());

        System.out.println("Renombrar sala de chat");
        System.out.println("Nombre antiguo"+ c.getID());
        c.renombrar("Cuatro emperadores");
        System.out.println("Nombre nuevo"+ c.getID());

        System.out.println("Eliminar al usuario mike de mi lista de amigos");
        emisor.elminiarAmigo(mike);
        if (amigos.size() == 1){
            System.out.println("[SERVIDOR] El usuario mi ha sido eliminado de la lista de amigos!");
        }

        System.out.println("Rechazar solicitud de ammistad");
        Usuario kevin= new Usuario("Kevin#1531","123",null);
        kevin.setManejadorSolicitud(p);
        p.generarSolicitud(emisor , kevin);
        p.procesarSolicitud(kevin.getListaDeSolicitudes().get(0), kevin, false);
        if (kevin.getListaDeSolicitudes().size()==0){
            System.out.println("[SERVIDOR] El usuario Kevin a rechazado tu solictud de amistad");
        }


        System.out.println("Eliminar solicitud de ammistad");

        p.generarSolicitud(kevin, emisor);
        p.eliminarSolicitud(emisor.getListaDeSolicitudes().get(0),emisor);
        if (emisor.getListaDeSolicitudes().size()==0){
            System.out.println("[SERVIDOR] El usuario Kevin a eliminado la solicitud de amistad");
        }

        System.out.println("Eliminar sala de chat ");
        c= null;
        System.out.println("[SERVIDOR] La sala de chat ha sido eliminada ");

    }

    public static Usuario buscar(String id){
        IConectorBD c= Mockito.mock(IConectorBD.class);
        BuscadorUsuario b1 = new BuscadorUsuario(c);
        Mockito.when(c.query("Mikkel14#1111")).thenReturn(mike);
        return b1.buscar(id);
    }

}
