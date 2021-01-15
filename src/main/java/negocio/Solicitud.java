package negocio;

public class Solicitud {
    private Usuario emisorSolicitud;
    private boolean estado;

    public Solicitud(Usuario emisorSolicitud ,boolean estado){
        this.emisorSolicitud=emisorSolicitud;
        this.estado=estado;
    }

    public Usuario getEmisorSolicitud() {
        return emisorSolicitud;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}