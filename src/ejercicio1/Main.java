package ejercicio1;
/*

 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int NUMERO_HILOS=10;
    private static final int LONGITUD_VECTOR=100000;

    public static void main(String[] args) {
        double[] vector= crearVector();
        List<Thread> hilos=crearHilos(vector);
        iniciarHilos(hilos);
        esperar(hilos);
    }

    private static List<Thread> crearHilos(double[] vector){
        List<Thread> hilos = new ArrayList<Thread>();
        for (int i = 0; i < NUMERO_HILOS; i++) {
            hilos.add(new Thread(new Hilo(vector)));
        }
        return hilos;
    }
    private static void iniciarHilos(List<Thread> hilos) {
        for (Thread hilo : hilos) {
            hilo.start();
        }
    }
    private static double[] crearVector(){
        double[] vector=new double[LONGITUD_VECTOR];
        Random random=new Random();
        for (int i = 0; i < LONGITUD_VECTOR; i++) {
            vector[i]=random.nextDouble();//da un valor entre 0 y 1
        }
        return vector;
    }
    private static void esperar(List<Thread> hilos){
        boolean isVivo=false;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<hilos.size()&&!isVivo;i++){
            isVivo=hilos.get(i).isAlive();
        }
        if(isVivo){
            System.out.println("Hilos lentos");
        }else{
            System.out.println("Hilos finalizados");
        }
    }
    /*
    for(int i=0;i<hilos.size()&&!vivos;i++){
            vivos=hilos.get(i).isAlive();
        }
        if(vivos){
            System.out.println("Hilos lentos");
        }else{
            System.out.println("Hilos finalizados");
        }
     */
}
