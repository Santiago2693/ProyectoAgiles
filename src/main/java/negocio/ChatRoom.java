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
    public void renombrar(String nuevoNombre){
        this.idChat = nuevoNombre;
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
                msj+= getFromMsgList(i);
                //no falta poner la logica de imprimir mensaje + usuario?
            }
        }
        else{
            msj = "Esta sala de chat esta vacia";
        }
        return msj;
    }

    public String getID(){
        return this.idChat;
    }

    public String enviarMensaje(Mensaje mensaje){
        anadirMensaje(mensaje);
        int ultimoMsj = this.mensajes.size() - 1;
        return getFromMsgList(ultimoMsj);
    }

    public void elmininarMensaje(Mensaje mensaje){
        this.mensajes.remove(mensaje);
    }

    public String getFromMsgList(int index) {
        return this.mensajes.get(index).getInformacion();
    }
}