package negocio;
import java.util.ArrayList;


public class AplicationExecute {
    public static void main(String[] args){
        //creacion de usuarios
        Usuario mike = new Usuario("Mike#0001", "mike","usuario root");
        Usuario santiago = new Usuario("Santiago#0002", "xyz", "Otro usuario root");
        Usuario mahatma = new Usuario("Mahatma#0003", "priviet", "usuario normal");
        Usuario cesar = new Usuario("Cesar#0004", "rocket league", "usuario normal");
        Usuario carolina = new Usuario("Carolina#1005", "conejos", "usuario normal");
        Usuario adriana= new Usuario("Adriana#0006","manca","usuario:normal");
        Usuario richard= new Usuario("Richard#0007","manco","usuario:normal");

        //creacion de listas de chat
        ArrayList<Usuario> listaUsuariosB = new ArrayList<Usuario>();
        listaUsuariosB.add(cesar);
        listaUsuariosB.add(carolina);
        listaUsuariosB.add(mahatma);
        listaUsuariosB.add(mike);
        ArrayList<Usuario> listaUsuariosD = new ArrayList<Usuario>();
        listaUsuariosD.add(santiago);
        listaUsuariosD.add(adriana);
        listaUsuariosD.add(richard);
        //creacion de salas de chat
        ChatRoom sala2 = new ChatRoom("B", listaUsuariosB);
        ChatRoom sala4 = new ChatRoom("F", listaUsuariosD);
        //anadir sala de chat a la lista de chats del usuario mike
        mike.unirseAlChat(sala2);
        System.out.println(sala2.imprimirMensajes());
        Buscador barra = new Buscador(mike.getChats());
        ChatRoom salaDestino = barra.buscar("B");
        Mensaje msj1 = new Mensaje("Que te parece esta nueva app?", false, mike);
        System.out.print(msj1.enviarMensaje(salaDestino));
        Mensaje msj2 = new Mensaje("Espera, te añado como amigo",false, santiago);
        System.out.print(msj2.enviarMensaje(salaDestino));
        ManejadorSolicitud m = new ManejadorSolicitud();
        mike.setManejadorSolicitud(m);
        santiago.setManejadorSolicitud(m);
        m.generarSolicitud(santiago,mike);
        ArrayList<Solicitud> s = new ArrayList<>();
        s.add(m.getSolicitud());
        if (mike.getListaDeSolicitudes().equals(s)){
            System.out.println("SERVER: El usuario: "+santiago.getUserId()+" te ha enviado una solicitud de amistad");
        }

    }
}
