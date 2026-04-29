import dao.UsuarioDAO;
import dao.ClienteDAO;
import model.Cliente;
import utils.Validador;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println(" THE BUG FIXER BARBERS - SYSTEM LOGIN");
        System.out.println("==========================================");

        System.out.print("Usuario: ");
        String user = teclado.nextLine();

        System.out.print("Contrasena: ");
        String pass = teclado.nextLine();

        String rol = UsuarioDAO.hacerLogin(user, pass);

        if (rol != null) {
            if (rol.equals("ADMIN")) {
                menuAdmin(teclado);
            } else if (rol.equals("CLIENTE")) {
                System.out.println("\nAbriendo Portal del Cliente...");
            }
        } else {
            System.out.println("Acceso denegado: Usuario o contrasena incorrectos.");
        }

        teclado.close();
    }

    public static void menuAdmin(Scanner teclado) {
        int opcion = 0;

        do {
            System.out.println("\n--- PANEL DE ADMINISTRADOR ---");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Ver todos los clientes");
            System.out.println("3. Modificar un cliente");
            System.out.println("4. Borrar un cliente");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");

            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombre = teclado.nextLine();

                    String email;
                    do {
                        System.out.print("Email (debe contener @ y .): ");
                        email = teclado.nextLine();
                        if (!Validador.esEmailValido(email)) {
                            System.out.println("Error: Formato de email incorrecto.");
                        }
                    } while (!Validador.esEmailValido(email));

                    String telefono;
                    do {
                        System.out.print("Telefono (9 digitos sin espacios): ");
                        telefono = teclado.nextLine();
                        if (!Validador.esTelefonoValido(telefono)) {
                            System.out.println("Error: El telefono debe tener 9 numeros.");
                        }
                    } while (!Validador.esTelefonoValido(telefono));

                    Cliente nuevoCliente = new Cliente(nombre, email, telefono);

                    if (ClienteDAO.registrarCliente(nuevoCliente)) {
                        System.out.println("Cliente guardado en la base de datos.");
                    } else {
                        System.out.println("Fallo al guardar el cliente.");
                    }
                    break;
                case 2:
                    ClienteDAO.listarClientes();
                    break;
                case 3:
                    System.out.print("Introduce el ID del cliente a modificar: ");
                    try {
                        int idModificar = Integer.parseInt(teclado.nextLine());

                        System.out.print("Nuevo nombre: ");
                        String nuevoNombre = teclado.nextLine();

                        String nuevoEmail;
                        do {
                            System.out.print("Nuevo Email (debe contener @ y .): ");
                            nuevoEmail = teclado.nextLine();
                            if (!Validador.esEmailValido(nuevoEmail)) {
                                System.out.println("Error: Formato de email incorrecto.");
                            }
                        } while (!Validador.esEmailValido(nuevoEmail));

                        String nuevoTelefono;
                        do {
                            System.out.print("Nuevo Telefono (9 digitos): ");
                            nuevoTelefono = teclado.nextLine();
                            if (!Validador.esTelefonoValido(nuevoTelefono)) {
                                System.out.println("Error: El telefono debe tener 9 numeros.");
                            }
                        } while (!Validador.esTelefonoValido(nuevoTelefono));

                        if (ClienteDAO.modificarCliente(idModificar, nuevoNombre, nuevoEmail, nuevoTelefono)) {
                            System.out.println("Cliente modificado correctamente.");
                        } else {
                            System.out.println("No se encontro ningun cliente con ese ID o hubo un error.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID invalido. Debes introducir un numero.");
                    }
                    break;
                case 4:
                    System.out.print("Introduce el ID del cliente a borrar: ");
                    try {
                        int idBorrar = Integer.parseInt(teclado.nextLine());
                        if (ClienteDAO.borrarCliente(idBorrar)) {
                            System.out.println("Cliente borrado correctamente.");
                        } else {
                            System.out.println("No se encontro ningun cliente con ese ID.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID invalido. Debes introducir un numero.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del panel...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }
}