package app;

import model.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        BankSystem system = new BankSystem();
        Scanner sc = new Scanner(System.in);

        system.crearAdministrador("Admin Principal", "01010101", "admin@banco.com", "admin123");
        Cliente cliente1 = new Cliente("María Pérez", "12345678", "maria@example.com", "mariaPass", "F", "Ingeniera", "Calle 1");
        Cliente cliente2 = new Cliente("Juan Gómez", "87654321", "juan@example.com", "juanPass", "M", "Profesor", "Calle 2");
        system.registrarCliente(cliente1);
        system.registrarCliente(cliente2);

        CuentaAhorro ca1 = new CuentaAhorro(cliente1, 500.0, 0.02);
        cliente1.agregarCuenta(ca1);
        CuentaDebito cd1 = new CuentaDebito(cliente1, 200.0, 0.01);
        cliente1.agregarCuenta(cd1);
        CuentaCredito cc1 = new CuentaCredito(cliente1, 1000.0, "Cashback");
        cliente1.agregarCuenta(cc1);
        CuentaAhorro ca2 = new CuentaAhorro(cliente2, 150.0, 0.015);
        cliente2.agregarCuenta(ca2);

        System.out.println("\nClientes registrados:");
        for (Cliente c : system.listarClientes()) System.out.println(c);

        ca1.depositar(300); ca1.generarInteres(); cc1.retirar(200); cc1.abonar(50);

        System.out.println("\nReporte de cliente María:");
        System.out.println(cliente1.generarReporteCuentas());

        System.out.println("=== DEMO Autenticación de cliente ===");
        System.out.print("Correo: "); String correo = sc.nextLine();
        System.out.print("Contraseña: "); String pass = sc.nextLine();
        Optional<Cliente> opt = system.autenticarCliente(correo, pass);
        if (opt.isPresent()) {
            Cliente c = opt.get();
            System.out.println("Bienvenido " + c.getNombreCompleto());
            System.out.println(c.generarReporteCuentas());
        } else System.out.println("Credenciales inválidas.");

        sc.close();
    }
}