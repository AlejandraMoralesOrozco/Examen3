package uia.com.inventarios;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorApartado
{
    List<SolicitudSalidaMat> items = new ArrayList<SolicitudSalidaMat>();

    public GestorApartado() throws IOException {
        super();
    }

    public void agregaSolicitudMatApartado(SolicitudSalidaMat newSSM) throws IOException {
        //newSSM.setEstatus("Apartado");
        this.getItems().add(newSSM);
        this.serializa("SolicitudesApartadoMat-1.json");
    }

    public List<SolicitudSalidaMat> getItems() {
        return items;
    }

    public void setItems(List<SolicitudSalidaMat> items) {
        this.items = items;
    }

    protected void serializa(String nombre) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(nombre), this);
    }
}
