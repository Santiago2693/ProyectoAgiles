package negocio;

import java.util.ArrayList;

public class Usuario {
    private String id;
    private String contraseña;
    private String descripcion;
    private ListaDeChat chats;

    public Usuario(String identificador, String passwd, String desc){
        this.id = identificador;
        this.contraseña = passwd;
        this.descripcion = desc;
        this.chats = new ListaDeChat();
    }

    public String getId() {
        return id;
    }
    public String getContraseña(){
        return contraseña;
    }
    public ArrayList<ChatRoom> getChats(){
        return this.chats.getLista();
    }
    public void unirseAlChat(ChatRoom chat){
        this.chats.añadirChat(chat);
        chat.anadirUsuario(this);
    }
}