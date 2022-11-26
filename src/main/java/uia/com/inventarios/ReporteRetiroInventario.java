package uia.com.inventarios;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SolicitudRetiroMat.class, name = "SRM")
})

public class ReporteRetiroInventario implements IRetiroInventario {
    protected NivelInventario inventario;
    protected SolicitudRetiroMat sem;

    public ReporteRetiroInventario(IRetiroInventario inventario) {
        super();
        this.inventario = (NivelInventario) new NivelInventario();
    }

    public ReporteRetiroInventario() {
        super();
    }


    public void cargaSolicitudRetiro(String nombre) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            sem = mapper.readValue(new FileInputStream(nombre), SolicitudRetiroMat.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.sem.getInventario().print();
    }

    @Override
    public List<InfoItem> busca(int id, String descripcion, String categoria, String cantidad, String idPartida, String idSubpartida, String idCategoria) {
        return inventario.busca(id, descripcion, categoria, cantidad, idPartida, idSubpartida, idCategoria);
    }

    @Override
    public void serializa() {
    }

    @Override
    public void print() {

    }

    @Override
    public void agrega(String idPartida, String descPartida, String idSubpartida, String descSubpartida, String idCat, String descCat,
                       Lote lote, int minimoNivel) {
        InfoItem item = new InfoItem("Item", idPartida, descPartida, descCat, idPartida, idSubpartida, idCat,
                lote, minimoNivel);
    }


    public void cargaInventario(String nombre) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            inventario = mapper.readValue(new FileInputStream(nombre), NivelInventario.class);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.inventario.print();

    }

    public void cargaSolicitudRetiroToInventario() {
        String idpartida = null, idsubpartida = null, idcategoria = null;
        int catidadRetiro;
        for (String partida : this.sem.getInventario().getItems().keySet()) {
            for (String subpartida : this.sem.getInventario().getItems().get(partida).getItems().keySet()) {
                for (String categoria : this.sem.getInventario().getItems().get(partida).getItems().get(subpartida).getItems().keySet()) {
                    String idPartida = this.sem.getInventario().getItems().get(partida).getId();
                    String idSubpartida = this.sem.getInventario().getItems().get(partida).getItems().get(subpartida).getId();
                    String idCategoria = this.sem.getInventario().getItems().get(partida).getItems().get(subpartida).getItems().get(categoria).getId();
                    catidadRetiro = sem.getInventario().getItems().get(partida).getItems().get(subpartida).getItems().get(categoria).getCantidadRetiro();
                    //System.out.println(cantidaRetiro);

                    //this.inventario.agrega()
                }
            }
        }
    }


    public void serializaNivelInventario(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), this.inventario);
    }
}
