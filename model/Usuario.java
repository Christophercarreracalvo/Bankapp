package model;

import java.util.Objects;

public abstract class Usuario {
    private String nombreCompleto;
    private String cedula;
    private String correoElectronico;
    private String contrasenia;

    public Usuario(String nombreCompleto, String cedula, String correoElectronico, String contrasenia) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(cedula, usuario.cedula);
    }

    @Override
    public int hashCode() { return Objects.hash(cedula); }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreCompleto='" + nombreCompleto + ''' +
                ", cedula='" + cedula + ''' +
                ", correoElectronico='" + correoElectronico + ''' +
                '}';
    }
}