package Analizador;

import java.util.ArrayList;

public class Node<T> {
    private T data;
    public ArrayList<Node<T>> children;
    public Node<String> parent;

    public Node(T data) {
        this.data = data;
        children = new ArrayList<Node<T>>();
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        String nodeString = "Node<" + data.toString() + ">: ";
        for (Node<T> child : children) {
            nodeString += child.toString();
        }
        return nodeString;
    }

    public Node<ArrayList<ArrayList<String>>>[] getHijo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHijo'");
    }
}