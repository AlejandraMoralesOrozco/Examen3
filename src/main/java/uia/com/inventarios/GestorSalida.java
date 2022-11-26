package uia.com.inventarios;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorSalida extends ReporteNivelInventario {
    List<SolicitudSalidaMat> items = new ArrayList<SolicitudSalidaMat>();
    GestorApartado gestorApartado;


    public GestorSalida(INivelInventario inventario)
    {
        super(inventario);
        //this.gestorApartado = new GestorApartado();
    }

    public GestorSalida(String nombre)
    {
        super();
        //this.gestorApartado = new GestorApartado();
    }


    public void serializa(SolicitudSalidaMat newSSM) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("solicitudSalidaMat-5.json"), newSSM);
    }


    public void agregaSolicitudSalidaMat(String solicitante, String categoria, String nombre, String descripcion, String cantidad, String idPartida, String idSubpartida, String idCategoria) throws IOException
    {
        int id = this.getItems().size()+1;

        String existencia = "";
        List<InfoItem> items = busca(id, descripcion, categoria, cantidad, idPartida, idSubpartida, idCategoria);
        if(items.size() > 0)
        {
            System.out.println("Existen "+existencia+"  "+ categoria +"en inventario");
            SolicitudSalidaMat newSSM = new SolicitudSalidaMat(id, solicitante, categoria, "", "", "", "");
            newSSM.setItems(items);
            newSSM.setEstatus("Apartado");
            this.serializa(newSSM);
            if(this.gestorApartado == null)
                this.gestorApartado = new GestorApartado();
            gestorApartado.agregaSolicitudMatApartado(newSSM);

            serializa();
        }
    }



    public List<SolicitudSalidaMat> getItems()
    {
        return this.items;
    }


    public void setItems(List<SolicitudSalidaMat> items) {
        this.items = items;
    }

    public GestorApartado getGestorApartado() {
        return gestorApartado;
    }

    public void setGestorApartado(GestorApartado gestorApartado) {
        this.gestorApartado = gestorApartado;
    }


    @Override
    public void print() {
    }
}
