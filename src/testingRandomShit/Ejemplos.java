package testingRandomShit;

public class Ejemplos {
    public static void main(String[] args){
        Ejemplos.EJThreads01 t1 = new Ejemplos().new EJThreads01(2,"Thread1");
        Ejemplos.EJThreads01 t3 = new Ejemplos().new EJThreads01(3,"Thread3");
        Ejemplos.EJThreads01 t4 = new Ejemplos().new EJThreads01(4,"Thread4");
        Ejemplos.EJThreads02 runnable1 = new Ejemplos().new EJThreads02(6,"runnable1");
        Ejemplos.EJThreads02 runnable2 = new Ejemplos().new EJThreads02(7,"runnable2");
        Ejemplos.EJThreads02 runnable3 = new Ejemplos().new EJThreads02(8,"runnable3");
        Thread t2 = new Thread(runnable1);
        Thread t5 = new Thread(runnable2);
        Thread t6 = new Thread(runnable3);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        System.out.println("prioridad del thread2: "+t2.getPriority());
    }
    private class EJThreads01 extends Thread{
        private int n;
        private String name;
        public EJThreads01(int n, String name){
            System.out.println("Extendiendo la clase Thread.");
            this.n = n;
            this.name = name;
        }
        public void run(){
            System.out.println("El valor inicial es: "+n);
            System.out.println("El nombre es: "+name);
            System.out.println("prioridad del thread1: "+this.getPriority());
        }
    }
    private class EJThreads02 implements Runnable{
        private int n;
        private String name;
        public EJThreads02(int n,String name){
            System.out.println("Implementado la interfaz Runnable.");
            this.n = n;
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println("El valor inicial es: "+n);
            System.out.println("El nombre es: "+name);
        }
    }
}
