package Analizador;

import java.util.ArrayList;

// Clase para representar un nodo del árbol
public class Node {
    private ArrayList<String> datos;
    private Node hijoIzquierdo;
    private Node hijoDerecho;

    // Constructor
    public Node(ArrayList<String> datos) {
        this.datos = datos;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    // Método para agregar un hijo izquierdo
    public void agregarHijoIzquierdo(Node nodo) {
        this.hijoIzquierdo = nodo;
    }

    // Método para agregar un hijo derecho
    public void agregarHijoDerecho(Node nodo) {
        this.hijoDerecho = nodo;
    }

    // Getters y Setters
    public ArrayList<String> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<String> datos) {
        this.datos = datos;
    }

    public Node getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Node hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Node getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Node hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}
