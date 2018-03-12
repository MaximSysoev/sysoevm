package ru.job4j.listNode;



public class SimpleQueue<E> {

    private Container<E> container = new Container<>();
    private Object[] array = new Object[10];
    private int index = 0;

    public E poll() {
        E value = null;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i]!=null){
                value = (E) array[i];
                array[i] = null;
                break;
            }
        }
        return value;
    }

    public void push(E value) {
        container.add(value);
        array[index] = value;
        index++;
    }
}
