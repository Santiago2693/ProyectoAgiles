package negocio;

import java.util.ArrayList;

public class ChatRoom {
    private String idChat;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Mensaje> mensajes;

    public ChatRoom(String idChat, ArrayList<Usuario> users) {
        this.idChat= idChat;
        this.usuarios = users;
        this.mensajes = new ArrayList<Mensaje>();
    }

    public void anadirUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void anadirMensaje(Mensaje nuevoMensaje){
        mensajes.add(nuevoMensaje);
    }
    public String imprimirMensajes(){
        String msj ="";
        if (!this.mensajes.isEmpty()) {
            for (int i = 0; i < this.mensajes.size(); i++) {
                msj+=mensajes.get(i).getInformacion();
                //no falta poner la logica de imprimir mensaje + usuario?
            }
        }
        else{
            msj = "Esta sala de chat esta vacia";
        }
        return msj;
    }
    public String actualizar(){
        // solo imprime el ultimo mensaje
        return this.mensajes.get(this.mensajes.size()-1).getInformacion();
    }

    public String getID(){
        return this.idChat;
    }

}