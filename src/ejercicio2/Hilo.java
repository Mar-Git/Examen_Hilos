package ejercicio2;

import java.util.Random;

public class Hilo implements Runnable{
    private static final int MAXIMO_IMPORTE = 50;
    Tarjeta tarjeta;

    public Hilo(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public void run() {
        Random random = new Random();
        boolean hayPasta = true;
        double gasto = 0.0;
        double importe = 0.0;
        do{
            importe = (random.nextDouble() * MAXIMO_IMPORTE) + 1.0;
            hayPasta = tarjeta.comprar (importe);
            if (hayPasta){
                gasto += importe;
            }
        } while (hayPasta);
        System.out.println(String.format("Importe gastado: %f", gasto));
    }
}
