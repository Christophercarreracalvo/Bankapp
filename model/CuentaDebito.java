package model;

public class CuentaDebito extends Cuenta {
    private double porcentajeInteres;

    public CuentaDebito(Cliente titular, double saldoInicial, double porcentajeInteres) {
        super(titular, saldoInicial);
        if (saldoInicial < 0)
            throw new IllegalArgumentException("CuentaDebito no puede iniciarse con saldo negativo");
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
        if (nuevoSaldo < 0) return false;
        saldo = nuevoSaldo;
        return true;
    }

    public boolean generarInteres() {
        if (!isActiva() || saldo <= 0) return false;
        saldo += saldo * porcentajeInteres;
        return true;
    }
}