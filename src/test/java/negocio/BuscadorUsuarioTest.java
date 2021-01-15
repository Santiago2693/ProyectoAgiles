package negocio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class BuscadorUsuarioTest {
    private String userIdValido;
    private String userIdInvalido;
    private BuscadorUsuario b;

    public BuscadorUsuarioTest(String uid1, String uid2){
        this.userIdValido = uid1;
        this.userIdInvalido = uid2;
    }
    @Before
    public void setUp() {
        b = new BuscadorUsuario();
    }
    @Parameterized.Parameters
    public static  Iterable<Object[]> parameters(){
        List<Object[]> casos = new ArrayList<Object[]>();
        casos.add(new Object[]{"Mikkel#1111","@312Santiago"});
        casos.add(new Object[]{"C3sarAA#2101","##4557"});
        casos.add(new Object[]{"Crash#1411","crah#44"});
        casos.add(new Object[]{"Rose67#5487","War45"});
        casos.add(new Object[]{"Potacio#4708","Potacio0504"});
        casos.add(new Object[]{"Elward#4148","Cyhtia03"});
        casos.add(new Object[]{"Kenway#0905","Crash03"});
        casos.add(new Object[]{"Patricky#0905","SpyrJ"});
        return casos;
    }
    @Test
    public void given_userid_when_validarId_then_ok(){
        assertTrue(b.validarId(userIdValido));
    }

    @Test
    public void given_invalid_userid_when_validarId_then_ok(){
        assertFalse(b.validarId(userIdInvalido));
    }


}