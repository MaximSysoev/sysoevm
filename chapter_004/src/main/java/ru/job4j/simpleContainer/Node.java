package ru.job4j.simpleContainer;

public class Node<E> {
    //содержимое текущего элемента списка
    private E element;
    //указатель на следующий элемент списка
    private Node next;
    //вывод содержимого текущего элемента
    public E getElement(){
        return element;
    }
    //установка содержимого для текущего элемента списка
    public void setElement(E e){
        element = e;
    }
    //получение указателя на следующий элемент списка
    public Node getNext() {
        return next;
    }
    //установка следующего элемента списка
    public void setNext(Node n) {
        next = n;
    }
}
