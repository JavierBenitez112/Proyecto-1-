package Analizador;

import java.util.ArrayList;

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

    // Método para imprimir el árbol de manera recursiva
    public void imprimirArbol(int nivel) {
        // Imprimir datos del nodo con indentación según el nivel
        for (int i = 0; i < nivel; i++) {
            System.out.print("  ");
        }
        imprimirArrayList(this.datos);

        // Imprimir hijo izquierdo recursivamente
        if (this.hijoIzquierdo != null) {
            this.hijoIzquierdo.imprimirArbol(nivel + 1);
        }

        // Imprimir hijo derecho recursivamente
        if (this.hijoDerecho != null) {
            this.hijoDerecho.imprimirArbol(nivel + 1);
        }
    }

    // Método para imprimir un ArrayList
    private void imprimirArrayList(ArrayList<String> lista) {
        if (lista != null) {
            for (String elemento : lista) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        } else {
            System.out.println("La lista proporcionada es null");
        }
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
