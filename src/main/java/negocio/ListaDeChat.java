package negocio;

import java.util.ArrayList;

public class ListaDeChat {
    private ArrayList<ChatRoom> chats;
    public ListaDeChat(){
        this.chats = new ArrayList<ChatRoom>();
    }
    public void añadirChat(ChatRoom chat){
        chats.add(chat);
    }
    public void eliminarChat(ChatRoom e){
        chats.remove(e);
    }
    public ArrayList<ChatRoom> getLista(){
        return this.chats;
    }
}
