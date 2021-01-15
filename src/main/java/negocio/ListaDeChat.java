package negocio;

import java.util.ArrayList;

public class ListaDeChat {
    private ArrayList<ChatRoom> chats;
    public ListaDeChat(){
        this.chats = new ArrayList<ChatRoom>();
    }
    public void añadirChat(ChatRoom nuevoChat){
        chats.add(nuevoChat);
    }
    public void eliminarChat(ChatRoom chatAEliminar){
        chats.remove(chatAEliminar);
    }
    public ArrayList<ChatRoom> getLista(){
        return this.chats;
    }
}
