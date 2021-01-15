package negocio;

public class ManejadorSolicitud {
    private Solicitud solicitud;
    enum respuesta {ok, amigos, reenvio, fallo};
    enum resultadoSolicitud{aceptada,rechazada,fallo};

    public respuesta generarSolicitud(Usuario origen,Usuario target){
        this.solicitud = new Solicitud(origen, false);
        return this.notify(target);
    }
    public respuesta notify(Usuario target){
        return target.actualizar();
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }
    public resultadoSolicitud procesarSolicitud(Solicitud s, Usuario solicitado, boolean respuesta){
        if (respuesta){
            solicitado.addAmigo(s.getEmisorSolicitud());
            solicitado.eliminarSolicitud(s);
            return resultadoSolicitud.aceptada;
        }
        else{
            solicitado.eliminarSolicitud(s);
            return resultadoSolicitud.rechazada;
        }

    }

}