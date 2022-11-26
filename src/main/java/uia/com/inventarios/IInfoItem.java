package uia.com.inventarios;

import java.util.ArrayList;
import java.util.List;

public interface IInfoItem {
    public String getId();
    public String getCantidad();
    public String getDescripcionPartida();
    public String getDescripcionSubpartida();
    public String getIdPartida();
    public String getIdSubpartida();
    public String getDescripcionCategoria();
    public String getCategoria();
    List<RegistroItem> getItems();
    public String getEstatus();
    public Ubicacion getUbicacion();
}
