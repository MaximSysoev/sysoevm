package ru.job4j.gc;

public class User {
    String name;
    int age;

    public User() {

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }

    public static void main(String[] args) {
        System.out.println("Start");
        info();
        User[] user = new User[1000000];

        System.out.println("---------------------");
        for (int i = 0; i < user.length; i++) {
            user[i] = new User("User"+i, i);
            // user[i] = new User();
        }

        for (int i = 0; i < user.length; i++) {
            user[i] = null;
        }

       // System.gc();
        System.out.println("Finish");
    }

    public static void info() {
        int mb = 1024 * 1024;

        Runtime runtime = Runtime.getRuntime();
        System.out.println("##### Heap utilization statistics [MB] #####");

        System.out.println("Used Memory: " +
                (runtime.totalMemory() - runtime.freeMemory()) / mb);

        System.out.println("Free Memory: " + runtime.freeMemory() / mb);
        System.out.println("Total memory: " + runtime.totalMemory() / mb );
        System.out.println("Max memory: " + runtime.maxMemory() / mb);
    }
}
