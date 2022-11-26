package uia.com.inventarios;

import java.io.IOException;

public class SolicitudMatApartado extends SolicitudSalidaMat
{
    public SolicitudMatApartado(RegistroItem sm) throws IOException {
        super(sm);
    }

    public SolicitudMatApartado(int id, String name, String categoria, String cantidad, String idPartida, String idSubpartida, String idCategoria) {
        super(id, name, categoria, cantidad, idPartida, idSubpartida, idCategoria);
    }

    public void serializa(String nombre) throws IOException {
        super.serializa(nombre);
    }
}
