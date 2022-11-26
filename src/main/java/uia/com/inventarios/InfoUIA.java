package uia.com.inventarios;

public class InfoUIA {
    private String id;
    private String clase;
    private String name;
    private String cantidad;
    private String estatus = "sinEstatus";
    private String fechaRevision = "";
    private int minimoNivel = -1;

    public InfoUIA(String clase, String id, String name, String cantidad, String estatus) {
        this.clase = clase;
        this.id = id;
        this.name = name;
        this.cantidad = cantidad;
        this.estatus = estatus;
    }

    public InfoUIA (String idPartida, String idSubpartida, String idCat, int minimoNivel, String fechaRevision)
    {
        this.clase = clase;
        this.id = id;
        this.name = name;
        this.cantidad = cantidad;
        this.estatus = estatus;
        this.minimoNivel = minimoNivel;
        this.fechaRevision = fechaRevision;
    }

    public InfoUIA() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }


}
