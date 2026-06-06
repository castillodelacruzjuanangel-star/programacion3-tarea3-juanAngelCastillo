import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) throws Exception {
        //Usuario juan = new Usuario();
        Scanner leer = new Scanner(System.in); 
        boolean salir = true;

        while (salir) {
            System.out.println("""
                ===================================
                        REGISTRO DE USUARIO       
                ===================================

                1. registrar
                2. salir
                """);

            System.out.print("Ingrese la opcion deseada: ");
            int opcion = leer.nextInt(); //lee la opcion seleciona por el usuario

            switch (opcion) {
                case 1:
                    try {
                        leer.nextLine(); //limpia el buffer antes de pasar a ingresar los datos
                        System.out.print("Nombre: ");
                        String nombre = leer.nextLine();
                        nombre = (nombre.trim().isEmpty()) ? null : nombre; //elimina espacios para evitar que ingresen unicamente espacios como caracteres

                        System.out.print("Edad: ");
                        int edad = leer.nextInt();
                        
                        leer.nextLine();
                        System.out.print("Correo electronico: ");
                        String correo = leer.nextLine();

                        System.out.print("Salario: ");
                        double salario = leer.nextDouble();

                        Usuario.validarUsuario(nombre, edad, correo, salario); //valida los datos ingresados

                        System.out.println("Usuario registrado correctamente.");

                    } catch (NombreInvalidoException nombre) {
                        System.out.println(nombre.getMessage());

                    } catch (EdadInvalidaException edad){
                        System.out.println(edad.getMessage());

                    } catch (InputMismatchException edad){ //catch para capturar que no se ingrese otro tipo de dato como entrada en el campo de edad
                        System.out.println("ERROR: Debe ingresar un numero valido.");
                        leer.nextLine();

                    } catch (CorreoInvalidoException correo){
                        System.out.println(correo.getMessage());

                    } catch (SalarioInvalidoException salario){
                        System.out.println(salario.getMessage());
                    }
                    finally{
                        System.out.println("Proceso finalizado.");
                    }
                    break;

                case 2:
                    salir = false; //cambia a falso para salir del while
                    break;
            
                default:
                    System.out.println("Seleccione una opcion valida.");
                    break;
            }
        }
        leer.close();
    }
}
