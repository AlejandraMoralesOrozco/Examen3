package uia.com.inventarios;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class SolicitudRetiroMat extends RegistroItem implements IRetiroInventario
{
    private String id="";
    private  NivelInventario inventario = null;
    private String fechaRevision="";
    private String minimoNivel;

    public SolicitudRetiroMat()
    {
    }

    public SolicitudRetiroMat(NivelInventario inventario, String id, String solicitante, String categoria)
    {
        this.inventario = inventario;
        this.id = id;
    }

    @Override
    public void cargaInventario(String nombre) {

    }


    @Override
    public List<InfoItem> busca(int id, String descripcion, String categoria, String cantidad, String idPartida, String idSubpartida, String idCategoria) {
        return null;
    }

    @Override
    public void serializa() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(id), this);
    }



    @Override
    public void print() {
        super.print();
    }





    public void serializa(SolicitudRetiroMat sem) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(id), sem);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NivelInventario getInventario() {
        return inventario;
    }

    public void setInventario(NivelInventario inventario) {
        this.inventario = inventario;
    }

    @Override
    public void agrega(String idPartida, String descPartida, String idSubpartida, String descSubpartida, String idCat, String descCat,
                       Lote lote, int cantidadRetiro)
    {
        InfoItem item;
        item = this.inventario.agrega("Item", idPartida,descPartida, idSubpartida, descSubpartida, idCat, descCat,  lote, cantidadRetiro);
    }
}