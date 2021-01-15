package negocio;

import java.util.ArrayList;
import static java.lang.Thread.sleep;

public class Usuario {
    private String UserId;
    private String contrasenia;
    private String descripcion;
    private ListaDeChat chats;
    private ArrayList<Usuario> ListaDeAmigos;
    private ArrayList<Solicitud> ListaDeSolicitudes;
    private ManejadorSolicitud manejadorSolicitud;

    public Usuario(String identificador, String passwd, String desc){
        this.UserId = identificador;
        this.contrasenia = passwd;
        this.descripcion = desc;
        this.chats = new ListaDeChat();
        this.ListaDeAmigos= new ArrayList<Usuario>();
        this.ListaDeSolicitudes=new ArrayList<Solicitud>();
    }
    public Usuario(String userId, String contrasenia, ArrayList<Usuario> listaDeAmigos, ArrayList<Solicitud> listaDeSolicitudes) {
        this.UserId = userId;
        this.contrasenia = contrasenia;
        this.ListaDeAmigos = listaDeAmigos;
        this.ListaDeSolicitudes = listaDeSolicitudes;
        this.chats=new ListaDeChat();
        this.descripcion="";

    }
    public Usuario(String userId, String contrasenia){
        this.UserId = userId;
        this.contrasenia = contrasenia;
        this.descripcion="";
        this.chats=new ListaDeChat();
        this.ListaDeAmigos = new ArrayList<Usuario>();
        this.ListaDeSolicitudes = new ArrayList<Solicitud>();
    }


    public String getUserId() {
        return UserId;
    }
    public String getContrasenia(){
        return contrasenia;
    }
    public void setManejadorSolicitud(ManejadorSolicitud m){
        this.manejadorSolicitud = m;
    }

    public ArrayList<ChatRoom> getChats(){
        return this.chats.getLista();
    }
    public void unirseAlChat(ChatRoom chat){
        this.chats.añadirChat(chat);
        chat.anadirUsuario(this);
    }
    public ManejadorSolicitud.respuesta actualizar(){
        String remitente = this.manejadorSolicitud.getSolicitud().getEmisorSolicitud().getUserId();
        for (Solicitud s: this.ListaDeSolicitudes){
            String emisor = s.getEmisorSolicitud().getUserId();
            if (emisor.equals(remitente)){
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return ManejadorSolicitud.respuesta.reenvio;
            }
        }
        for (Usuario u: this.ListaDeAmigos){
            if(u.getUserId().equals(remitente)){
                return ManejadorSolicitud.respuesta.amigos;
            }
        }
        this.ListaDeSolicitudes.add(this.manejadorSolicitud.getSolicitud());
        return ManejadorSolicitud.respuesta.ok;

    }

    public void addAmigo(Usuario nuevoAmigo){
        this.ListaDeAmigos.add(nuevoAmigo);

    }
    public void eliminarSolicitud(Solicitud solicitudAEliminar){
        this.ListaDeSolicitudes.remove(solicitudAEliminar);
    }

    public ArrayList<Solicitud> getListaDeSolicitudes() {
        return ListaDeSolicitudes;
    }

    public boolean elminiarAmigo(Usuario aEliminar){
        return this.ListaDeAmigos.remove(aEliminar);
    }


}