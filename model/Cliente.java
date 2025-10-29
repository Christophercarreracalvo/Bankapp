package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente extends Usuario {
    private String sexo;
    private String profesion;
    private String direccion;
    private List<Cuenta> cuentas;

    public Cliente(String nombreCompleto, String cedula, String correoElectronico, String contrasenia,
                   String sexo, String profesion, String direccion) {
        super(nombreCompleto, cedula, correoElectronico, contrasenia);
        this.sexo = sexo;
        this.profesion = profesion;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getProfesion() { return profesion; }
    public void setProfesion(String profesion) { this.profesion = profesion; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public List<Cuenta> getCuentas() { return cuentas; }

    public void agregarCuenta(Cuenta c) { if (c != null) cuentas.add(c); }
    public void eliminarCuenta(Cuenta c) { cuentas.remove(c); }

    public String generarReporteCuentas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte de cuentas para: ").append(getNombreCompleto()).append("\n");
        double consolidado = 0.0;
        for (Cuenta c : cuentas) {
            sb.append(c).append("\n");
            consolidado += c.getSaldo();
        }
        sb.append(String.format("Saldo consolidado: %.2f\n", consolidado));
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCompleto='" + getNombreCompleto() + ''' +
                ", cedula='" + getCedula() + ''' +
                ", correoElectronico='" + getCorreoElectronico() + ''' +
                ", sexo='" + sexo + ''' +
                ", profesion='" + profesion + ''' +
                ", direccion='" + direccion + ''' +
                ", cuentas=" + cuentas.size() +
                '}';
    }

    @Override
    public boolean equals(Object o) { return super.equals(o); }
    @Override
    public int hashCode() { return Objects.hash(getCedula()); }
}