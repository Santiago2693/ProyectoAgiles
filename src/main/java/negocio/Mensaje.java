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
        return this.propietario.getUserId() + ":\n "+this.contenido+"\n";
    }

    public String enviarMensaje(ChatRoom chatroom){
        return chatroom.enviarMensaje(this);
    }
}