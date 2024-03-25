package Analizador;

import java.util.ArrayList;
import java.util.List;

//Como se planteo, todos los elementos van a ser nodos que tengan hijos

public class Node<T> {
    private T data;
    private List<Node<T>> children;

    public Node(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public List<Node<T>> getHijos() {
        return children;
    }

    public void addHijo(Node<T> child) {
        children.add(child);
    }

    public Node<T> getHijo(int index) {
        return children.get(index);
    }

    public void changedata(T data) {
        this.data = data;
    }


}