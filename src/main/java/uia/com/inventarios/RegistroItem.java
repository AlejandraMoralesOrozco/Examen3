package uia.com.inventarios;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = SolicitudSalidaMat.class, name = "SSM")
    })

    public class RegistroItem implements INivelInventario {
        private int id;
        private String name;
        private String descripcion;
        private String cantidad;
        private String partida;
        private String subpartida;
        private String categoria;
        private String estatus = "sinEstatus";
        private Ubicacion ubicacion = new Ubicacion();
        private List<InfoItem> items = new ArrayList<InfoItem>();

        public RegistroItem(int id, String name, String categoria, String cantidad, String idPartida, String idSubpartida, String idCategoria,
                            String idLote, String lote, String fechaIngreso, String idProveedor, String proveedor)
        {
            this.id = id;
            this.name = name;
            this.descripcion = descripcion;
            this.cantidad = cantidad;
            this.partida = partida;
            this.subpartida = subpartida;
            this.categoria = categoria;

            InfoItem item = new InfoItem("Item", String.valueOf(id), name, categoria, cantidad, idPartida, idSubpartida, idCategoria,
                    idLote,  lote,
                    fechaIngreso,
                    idProveedor,  proveedor);
        }

        public void setEstatus(String estatus) {
            this.estatus = estatus;
        }

        public Ubicacion getUbicacion() {
            return ubicacion;
        }

        public void setUbicacion(Ubicacion ubicacion) {
            this.ubicacion = ubicacion;
        }

        public RegistroItem(int id, String name, String descripcion, String cantidad, String partida, String subpartida, String categoria)
        {
            this.id = id;
            this.name = name;
            this.descripcion = descripcion;
            this.cantidad = cantidad;
            this.partida = partida;
            this.subpartida = subpartida;
            this.categoria = categoria;
        }

        public RegistroItem() {
        }

        public String getId() {
            return "";
        }

        public void setId(int id) {
            this.id = id;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getCantidad() {
            return cantidad;
        }

        public List<InfoItem> getItems() {
            return items;
        }

        public void setItems(List<InfoItem> items) {
            this.items = items;
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

        }

        @Override
        public void print() {

        }

    }
