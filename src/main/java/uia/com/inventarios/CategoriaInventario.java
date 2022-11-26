package uia.com.inventarios;

public class CategoriaInventario extends InfoItem{

    public CategoriaInventario(String clase, String idCat, String descCat, String sinEstatus, String cantidad, String ubic) {
        super(clase, idCat, descCat, sinEstatus, cantidad, ubic);
    }

    public CategoriaInventario()
    {}

    public CategoriaInventario(String clase, String idCat, String descCat, String sinEstatus, String cantidad, String ubic, int minimoNivel)
    {
        super(clase, idCat, descCat, sinEstatus, cantidad, ubic);
        this.setMinimoNivel(minimoNivel);
    }
}
