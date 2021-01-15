package negocio;

public class Mensaje {
    private String contenido;
    private boolean estado;
    private Usuario propietario;

    public Mensaje(String contenido, boolean estado,Usuario propietario) {
        this.contenido = contenido;
        this.estado = estado;
        this.propietario=propietario;
    }

    public String getInformacion() {
        String id = this.propietario.getUserId();
        String contenido = this.contenido;
        return id + ":\n "+ contenido +"\n";
    }

    public String enviarMensaje(ChatRoom chatroom){
        return chatroom.enviarMensaje(this);
    }
}