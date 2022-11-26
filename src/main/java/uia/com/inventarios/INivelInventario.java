package uia.com.inventarios;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface INivelInventario {
    public void cargaInventario(String nombre);
    public List<InfoItem> busca(int id, String descripcion, String categoria, String cantidad, String idPartida, String idSubpartida, String idCategoria);
    public void serializa() throws IOException;
    public void print();
}
