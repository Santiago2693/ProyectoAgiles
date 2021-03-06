package negocio;
import java.util.ArrayList;


public class Buscador implements  IBusqueda<ChatRoom> {
    private ArrayList<ChatRoom> listaBusqueda;
    public Buscador(ArrayList<ChatRoom> listaChats){
        this.listaBusqueda = listaChats;
    }

    public ChatRoom buscar(String id){
        for (ChatRoom c: this.listaBusqueda){
            if (c.getID() == id){
                return c;
            }
        }
        return null;
    }
}