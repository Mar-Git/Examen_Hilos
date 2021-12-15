package ejercicio1;

public class Hilo implements Runnable{
private double[] vector;

    public Hilo(double[] vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        double suma=sumaVector();
        System.out.println(String.format("La suma es %f",suma));
    }

    private double sumaVector(){
        double suma=0.0;
        for(int i=0; i<vector.length; i++){
            suma+=vector[i];
        }
        return suma;
    }
}
