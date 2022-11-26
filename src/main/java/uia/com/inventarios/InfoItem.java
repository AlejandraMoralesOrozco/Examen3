package uia.com.inventarios;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PartidaInventario.class, name = "Partida"),
        @JsonSubTypes.Type(value = SubpartidaInventario.class, name = "Subpartida"),
        @JsonSubTypes.Type(value = CategoriaInventario.class, name = "Categoria"),
        @JsonSubTypes.Type(value = SolicitudRetiroMat.class, name = "SEM")
        })



public class InfoItem extends InfoUIA{
    private HashMap<String, InfoItem> items = new HashMap<String, InfoItem>();
    private Ubicacion ubicacion = new Ubicacion();
    private Lote lote = new Lote();
    private int minimoNivel = -1;
    private int cantidadRetiro = -1;


    public InfoItem(String clase, String id, String name, String estatus, String cantidad, String ubic) {
        super(clase, id, name, cantidad, estatus);
        ubicacion.setPosicion(ubic);
    }


    public InfoItem(String clase, String id, String name, String categoria, String cantidad, String idPartida, String idSubpartida, String idCategoria,
                        String idLote, String lote, String fechaIngreso, String idProveedor, String proveedor)
    {
        super(clase, id, name, cantidad, "SinEstatus");
        this.lote.setName(lote);
        this.lote.setId(idLote);
        this.lote.setFechaIngreso(fechaIngreso);
        this.lote.getProveedor().setName(idProveedor);
        this.lote.getProveedor().setId(proveedor);
        //this.partida = partida;
        //this.subpartida = subpartida;
        //this.categoria = categoria;
    }


    public InfoItem(String clase, String id, String name, String categoria, String idPartida, String idSubpartida, String idCategoria,
                    Lote lote, int minimoNivel)
    {
        super(clase, id, name, -1, "SinEstatus");
        this.setLote(lote);
        this.minimoNivel=minimoNivel;

        //this.partida = partida;
        //this.subpartida = subpartida;
        //this.categoria = categoria;
    }

    public InfoItem() {
    }


    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }


    public HashMap<String, InfoItem> getItems() {
        return items;
    }

    public void setItems(HashMap<String, InfoItem> items) {
        this.items = items;
    }




    public void print()
    {
        if (this.getItems().size() > 0)
        {
            System.out.println("----- Items List -----");

            for (Map.Entry<String, InfoItem> item : this.getItems().entrySet())
            {
                InfoItem nodo =  item.getValue();
                nodo.print();
            }
        }
        else {
            System.out.println(this);
            System.out.println("Id:\t" + this.getId());
            System.out.println("Name:\t" + this.getName());
            System.out.println("Estatus:\t" + this.getEstatus());
        }

    }

    public List<InfoItem> getItems(String cantidad)
    {
        int cantidadInt = Integer.parseInt(cantidad);

        List<InfoItem> itemsTemp = new ArrayList<InfoItem>();
        for (Map.Entry<String, InfoItem> item : this.getItems().entrySet())
        {
            InfoItem nodo =  item.getValue();
            if(nodo.getEstatus().contentEquals("SinEstatus") && cantidadInt>0)
            {
                nodo.setEstatus("Apartado");
                itemsTemp.add(nodo);
                --cantidadInt;
            }
            nodo.print();
        }
        return itemsTemp;
    }


    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public int getMinimoNivel() {
        return minimoNivel;
    }

    public void setMinimoNivel(int minimoNivel) {
        this.minimoNivel = minimoNivel;
    }

    public int getCantidadRetiro() {
        return cantidadRetiro;
    }

    public void setCantidadRetiro(int cantidadRetiro) {
        this.cantidadRetiro = cantidadRetiro;
    }
}
