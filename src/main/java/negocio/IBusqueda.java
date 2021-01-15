package negocio;

public interface IBusqueda <T extends Object> {
    public T buscar(String key);
}
