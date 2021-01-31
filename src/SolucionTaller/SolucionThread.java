package SolucionTaller;

import java.util.Scanner;

public class SolucionThread {
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
        SolucionThread.EvenThread evenThread = new SolucionThread(). new EvenThread(start,end);
        SolucionThread.OddThread oddThread = new SolucionThread(). new OddThread(start,end);
        evenThread.start();
        oddThread.setPriority(7);
        oddThread.start();
    }
    private class EvenThread extends Thread{
        private int min;
        private int max;
        private int delay;
        public EvenThread(int min,int max){
            message("Creando thread que imprime numeros pares");
            this.min = min;
            this.max = max;
            this.delay = (int) Math.sqrt(Math.pow(min,2)+Math.pow(max,2));
        }
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
    private class OddThread extends Thread{
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
