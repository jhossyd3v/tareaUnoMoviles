package sv.edu.uesocc.ingenieria.ipam2017.firsthomework;

/**
 * Created by Jhossymar on 13/04/2017.
 */

public class Cliente {
    private int Codigo;
    private String Nombre;
    private String Apellido;
    private String Tipo;
    private String FormaPago;
    private String DUI;

    public Cliente(int codigo, String nombre, String apellido, String tipo, String formaPago, String dui){
        Codigo = codigo;
        Nombre = nombre;
        Apellido = apellido;
        Tipo = tipo;
        FormaPago = formaPago;
        DUI = dui;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getFormaPago() {
        return FormaPago;
    }

    public void setFormaPago(String formaPago) {
        FormaPago = formaPago;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }
}
