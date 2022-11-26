package uia.com.inventarios;

public class Lote extends InfoUIA{

    private String fechaIngreso = "";
    private Proveedor proveedor = new Proveedor();

    public Lote() {
        super();
    }

    public Lote(String idLote, String descLote, String cantidad, String fechaIngreso, String idProv, String descProv)
    {
        super("Lote", idLote, descLote, cantidad, "Ingresado");
        this.fechaIngreso = fechaIngreso;
        proveedor.setName(descLote);
        proveedor.setId(idProv);
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }


    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
