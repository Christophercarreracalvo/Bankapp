package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankSystem {
    private Administrador administrador;
    private List<Cliente> clientes;

    public BankSystem() {
        this.clientes = new ArrayList<>();
        this.administrador = null;
    }

    public boolean crearAdministrador(String nombre, String cedula, String correo, String contrasenia) {
        if (this.administrador != null) return false;
        this.administrador = new Administrador(nombre, cedula, correo, contrasenia);
        return true;
    }

    public boolean autenticarAdministrador(String correo, String contrasenia) {
        if (administrador == null) return false;
        return administrador.getCorreoElectronico().equals(correo) &&
               administrador.getContrasenia().equals(contrasenia);
    }

    public boolean registrarCliente(Cliente c) {
        if (administrador == null || c == null) return false;
        for (Cliente ex : clientes) {
            if (ex.getCedula().equals(c.getCedula()) ||
                ex.getCorreoElectronico().equals(c.getCorreoElectronico()))
                return false;
        }
        clientes.add(c);
        return true;
    }

    public Optional<Cliente> autenticarCliente(String correo, String contrasenia) {
        for (Cliente c : clientes) {
            if (c.getCorreoElectronico().equals(correo) && c.getContrasenia().equals(contrasenia))
                return Optional.of(c);
        }
        return Optional.empty();
    }

    public List<Cliente> listarClientes() { return new ArrayList<>(clientes); }

    public List<Cuenta> listarCuentasPorTipo(Class<? extends Cuenta> tipo) {
        List<Cuenta> resultado = new ArrayList<>();
        for (Cliente c : clientes)
            for (Cuenta ac : c.getCuentas())
                if (tipo.isInstance(ac)) resultado.add(ac);
        return resultado;
    }
}