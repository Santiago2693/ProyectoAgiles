package negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ManejadorSolicitudTest {
    private ArrayList<Usuario> amigos;
    private ManejadorSolicitud p;
    @Before
    public void config_test(){
        amigos = new ArrayList<>();
        p = new ManejadorSolicitud();
    }
    @Test
    public void given_newFriend_when_generarSolicitud_then_ok(){
        amigos.add(new Usuario("Stryder#2693", "procesoUnificado"));
        Usuario target = new Usuario("Cesar#5555", "Iscariote");
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia", amigos, new ArrayList<Solicitud>());
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        assertEquals(ManejadorSolicitud.respuesta.ok,p.generarSolicitud(mike,target));
    }

    @Test
    public void given_newFriend_when_generarSolicitud_then_addedToList(){
        amigos.add(new Usuario("Stryder#2693", "procesoUnificado"));
        Usuario target = new Usuario("Cesar#5555", "Iscariote");
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia", amigos, new ArrayList<Solicitud>());
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        p.generarSolicitud(target,mike);
        ArrayList<Solicitud> expected = new ArrayList<>();
        expected.add(p.getSolicitud());
        assertArrayEquals(expected.toArray(),mike.getListaDeSolicitudes().toArray());
    }
    @Test
    public void given_oldFriend_when_generarSolicitud_then_not_addedToList(){
        Usuario santiago=new Usuario("Stryder#2693", "procesoUnificado");
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        amigos.add(santiago);
        Usuario target = new Usuario("Cesar#5555", "Iscariote",amigos,solicitudes);
        santiago.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        p.generarSolicitud(santiago,target);
        assertArrayEquals(new ArrayList<Solicitud>().toArray(), target.getListaDeSolicitudes().toArray());

    }

    @Test
    public void given_oldFriend_when_generarSolicitud_then_amigos(){
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia");
        amigos.add(mike);
        Usuario target = new Usuario("Stryder#2693", "procesoUnificado", amigos, new ArrayList<Solicitud>());
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        assertEquals(ManejadorSolicitud.respuesta.amigos,p.generarSolicitud(mike,target));
    }


    @Test(timeout = 300)
    public void given_newFriend_when_generarSolicitud_then_reenvio() {
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        amigos.add(new Usuario("Stryder#2693", "procesoUnificado"));
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia");
        solicitudes.add(new Solicitud(mike, true));
        Usuario target = new Usuario("Cesar#5555", "Iscariote",amigos,solicitudes);
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        assertEquals(ManejadorSolicitud.respuesta.reenvio, p.generarSolicitud(mike, target));
    }
    @Test
    public void given_friendReq_when_accept_then_añadido(){
        amigos.add(new Usuario("Stryder#2693", "procesoUnificado"));
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia", amigos, new ArrayList<Solicitud>());
        Solicitud req = new Solicitud(mike,true);
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        solicitudes.add(req);
        Usuario target = new Usuario("Cesar#5555", "Iscariote", new ArrayList<Usuario>(), solicitudes);
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        assertEquals(ManejadorSolicitud.resultadoSolicitud.aceptada,p.procesarSolicitud(req,target,true));
    }

    @Test
    public void given_friendRequest_when_denied_then_rechazado(){
        amigos.add(new Usuario("Stryder#2693", "procesoUnificado"));
        Usuario mike = new Usuario("Mikkel14#1111", "patronEstrategia", amigos, new ArrayList<Solicitud>());
        Solicitud req = new Solicitud(mike,true);
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        solicitudes.add(req);
        Usuario target = new Usuario("Cesar#5555", "Iscariote", new ArrayList<Usuario>(), solicitudes);
        mike.setManejadorSolicitud(p);
        target.setManejadorSolicitud(p);
        assertEquals(ManejadorSolicitud.resultadoSolicitud.rechazada,p.procesarSolicitud(req,target,false));
    }

    @Test
    public void given_noFriend_when_removed_then_error(){
        Usuario santiago=new Usuario("Stryder#2693", "procesoUnificado");
        assertFalse(santiago.elminiarAmigo(new Usuario("Mikkel#1111","TDD")));
    }
}