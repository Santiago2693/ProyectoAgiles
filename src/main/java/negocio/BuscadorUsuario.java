package negocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuscadorUsuario implements  IBusqueda<Usuario>{
    private IConectorBD conexion;
    public BuscadorUsuario(IConectorBD conector){
        this.conexion = conector;
    }
    public BuscadorUsuario(){
        this.conexion= null;
    }
    public  Usuario buscar(String id){
        if (this.validarId(id)){
            if (this.conexion.query(id) != null){
                return this.conexion.query(id);
            }
            else{
                return null;
            }
        }
        return null;
    }
    public boolean validarId(String id){
        Pattern patron = Pattern.compile("^[A-Za-z0-9]{4,10}#[0-9]{4}");
        Matcher match = patron.matcher(id);
        return match.matches();
    }
}