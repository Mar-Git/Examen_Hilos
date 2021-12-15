package ejercicio2;

public class Tarjeta {
    private final double SALDO_INICIAL = 1000000;
    private double saldo;

    public Tarjeta (){
        this.saldo = SALDO_INICIAL;
    }

    public synchronized boolean comprar(double importe) {
        boolean compraCorrecta = true;
        if (importe < saldo) {
            saldo -= importe;
        }
        else{
            compraCorrecta = false;
        }
        return compraCorrecta;
    }
}
