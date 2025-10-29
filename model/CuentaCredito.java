package model;

public class CuentaCredito extends Cuenta {
    private double limiteCredito;
    private String tipo;

    public CuentaCredito(Cliente titular, double limiteCredito, String tipo) {
        super(titular, 0.0);
        if (limiteCredito <= 0) throw new IllegalArgumentException("limiteCredito debe ser > 0");
        this.limiteCredito = limiteCredito;
        this.tipo = tipo;
    }

    @Override
    public boolean retirar(double monto) {
        if (!isActiva() || monto <= 0) return false;
        double nuevoSaldo = saldo - monto;
        if (nuevoSaldo < -limiteCredito) return false;
        saldo = nuevoSaldo;
        return true;
    }

    public boolean abonar(double monto) {
        if (!isActiva() || monto <= 0) return false;
        double nuevoSaldo = saldo + monto;
        if (nuevoSaldo > 0) return false;
        saldo = nuevoSaldo;
        return true;
    }

    @Override
    public boolean pagar(double monto) { return retirar(monto); }

    @Override
    public String toString() {
        return String.format("%s{id=%s, titular=%s, activa=%b, saldo=%.2f, limite=%.2f, tipo=%s}",
                this.getClass().getSimpleName(), getId(), getTitular().getNombreCompleto(), isActiva(), saldo, limiteCredito, tipo);
    }
}