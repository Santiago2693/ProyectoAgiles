package negocio;
import java.util.ArrayList;


public class Buscador {
    private ArrayList<ChatRoom> listaBusqueda;
    public Buscador(ArrayList<ChatRoom> m){
        this.listaBusqueda = m;
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