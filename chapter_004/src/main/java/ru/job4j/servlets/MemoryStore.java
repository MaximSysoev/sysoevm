package ru.job4j.servlets;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MemoryStore {
    public int id = 0;
    public  List<User> userStore = new CopyOnWriteArrayList<User>();
}
