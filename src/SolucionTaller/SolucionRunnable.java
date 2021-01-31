package SolucionTaller;

import java.util.Scanner;

public class SolucionRunnable {
    public static void message(String msg){
        System.out.println(msg);
    }
    public static void main(String[] args){
        message("Digite el rango de impresion\n");
        Scanner reader = new Scanner(System.in);
        message("Minimo:\n");
        int start = reader.nextInt();
        message("Maximo:\n");
        int end = reader.nextInt();
        SolucionRunnable.EvenThread runnableEven =  new SolucionRunnable(). new EvenThread(start,end);
        SolucionRunnable.OddThread runnableOdd = new SolucionRunnable(). new OddThread(start,end);
        Thread t1 = new Thread(runnableEven);
        Thread t2 = new Thread(runnableOdd);
        t1.start();
        t2.setPriority(7);
        t2.start();
    }
    private class EvenThread implements Runnable{
        private int min;
        private int max;
        private int delay;
        public EvenThread(int min,int max){
            message("Creando thread que imprime numeros pares");
            this.min = min;
            this.max = max;
            this.delay = (int) Math.sqrt(Math.pow(min,2)+Math.pow(max,2));
        }
        @Override
        public void run() {
            int localMin;
            boolean mod = Math.floorMod(min,2) == 0;
            if(!mod) localMin = min + 1;
            else localMin = min;
            try {
                for (int i = localMin; i <= max; i = i + 2) {
                    message(Integer.toString(i));
                    Thread.sleep(delay);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private class OddThread implements Runnable{
        private int min;
        private int max;
        private int delay;
        public OddThread(int min,int max){
            message("Creando thread que imprime numeros impares");
            this.min = min;
            this.max = max;
            this.delay = (int) Math.sqrt(Math.pow(min,2)+Math.pow(max,2));
        }
        @Override
        public void run() {
            int localMin;
            boolean mod = Math.floorMod(min,2) == 1;
            if(!mod) localMin = min + 1;
            else localMin = min;
            try {
                for (int i = localMin; i <= max; i = i + 2) {
                    message(Integer.toString(i));
                    Thread.sleep(delay);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}