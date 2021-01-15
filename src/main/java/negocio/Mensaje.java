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
        return this.propietario.getId() + ":\n "+this.contenido+"\n";
    }
    public String enviarMensaje(ChatRoom chatRoom){
        chatRoom.anadirMensaje(this);
        return chatRoom.actualizar();
    }
}