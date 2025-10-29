package model;

public class CuentaAhorro extends Cuenta {
    private double porcentajeInteres;
    public static final double SALDO_MINIMO = 100.0;

    public CuentaAhorro(Cliente titular, double saldoInicial, double porcentajeInteres) {
        super(titular, saldoInicial);
        if (saldoInicial < SALDO_MINIMO)
            throw new IllegalArgumentException("CuentaAhorro debe crearse con al menos " + SALDO_MINIMO);
        this.porcentajeInteres = porcentajeInteres;
    }

    public boolean depositar(double monto) {
        if (!isActiva() || monto <= 0) return false;
        saldo += monto;
        return true;
    }

    @Override
    public boolean retirar(double monto) {
        if (!isActiva() || monto <= 0) return false;
        double nuevoSaldo = saldo - monto;
        if (nuevoSaldo < SALDO_MINIMO) return false;
        saldo = nuevoSaldo;
        return true;
    }

    public boolean generarInteres() {
        if (!isActiva() || saldo <= 0) return false;
        saldo += saldo * porcentajeInteres;
        return true;
    }
}