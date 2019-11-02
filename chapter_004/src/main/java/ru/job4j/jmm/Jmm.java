package ru.job4j.jmm;

public class Jmm implements Runnable {

    private String name = "поток";

    @Override
    public void run() {
        this.name = "thread";
        System.out.println("name в потоке: " + this.name);
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args){
        Jmm jmm = new Jmm();
        new Thread(jmm).start();
        new Thread(jmm).start();
        System.out.println(jmm.getName());
    }


}
