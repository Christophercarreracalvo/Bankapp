package model;

import java.util.Objects;
import java.util.UUID;

public abstract class Cuenta {
    private String id;
    private Cliente titular;
    private boolean activa;
    protected double saldo;

    public Cuenta(Cliente titular, double saldoInicial) {
        this.id = UUID.randomUUID().toString();
        this.titular = titular;
        this.activa = true;
        this.saldo = saldoInicial;
    }

    public String getId() { return id; }
    public Cliente getTitular() { return titular; }
    public boolean isActiva() { return activa; }
    public void activar() { this.activa = true; }
    public void desactivar() { this.activa = false; }
    public double getSaldo() { return saldo; }

    public abstract boolean retirar(double monto);
    public boolean pagar(double monto) { return retirar(monto); }

    @Override
    public String toString() {
        return String.format("%s{id=%s, titular=%s, activa=%b, saldo=%.2f}",
                this.getClass().getSimpleName(), id, titular.getNombreCompleto(), activa, saldo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cuenta)) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(id, cuenta.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}