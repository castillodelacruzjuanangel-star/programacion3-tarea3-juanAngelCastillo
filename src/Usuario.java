
public class Usuario{

    private String nombre;
    private int edad;
    private String correoElectronico;
    private double salarioMensual;

    //metodo estatico para validar todas las entradas con Exceptions personalizados
    public static void validarUsuario(String nombre, int edad, String correoElectronico, double salarioMensual) throws Exception{
        if(nombre == null || nombre.length() < 3){
            throw new NombreInvalidoException("El nombre debe contener al menos 3 caracteres.");
        }
        if(edad < 18 || edad > 100){
            throw new EdadInvalidaException("La edad debe ser mayor o igual a 18.");
        }
        if(!correoElectronico.contains("@") || !correoElectronico.contains(".")){
            throw new CorreoInvalidoException("El correo electronico no es valido.");
        }
        if(salarioMensual <= 0){
            throw new SalarioInvalidoException("El salario debe ser mayor que 0.");
        }
    }

    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCorreo(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setSalario(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    //getters
    public String getNombre(){ return nombre; }

    public int getEdad(){ return edad; }

    public String getCorreo(){ return correoElectronico; }

    public double getSalario(){ return salarioMensual; }
}
