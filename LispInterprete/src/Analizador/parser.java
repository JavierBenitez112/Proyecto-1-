package Analizador;

import java.util.ArrayList;
import java.util.HashMap;
import Tokens.tokenizer;

public class parser {
    private tokenizer tokenizer;

    public parser(tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    public AST parse() {
        HashMap<String, ArrayList<String>> tokenMap = tokenizer.getTokenMap();
        if (tokenMap.isEmpty()) {
            return null; // No hay datos para analizar
        }

        Node raiz = null;
        for (String key : tokenMap.keySet()) {
            if (key.equals("defun")) {
                // Si encuentra una definición de función, crear un nodo raíz
                ArrayList<String> dato = tokenMap.get(key);
                raiz = new Node(dato);

                // Buscar y agregar los hijos de la definición de función
                agregarHijosRecursivamente(raiz, tokenMap, dato.get(0)); // Pass the first element of the dato ArrayList
            } else if (key.startsWith("*h")) {
                // Encontrado un nodo *h
                if (raiz == null) {
                    // No hay nodo raíz, no se puede continuar
                    System.err.println("Error: Nodo *h encontrado antes de la definición de la función.");
                    return null;
                }

                // Recursivamente agregar los hijos de *h al árbol
                agregarHijosRecursivamente(raiz, tokenMap, key);
            }
        }
        return new AST(raiz);
    }

    private void agregarHijosRecursivamente(Node nodo, HashMap<String, ArrayList<String>> tokenMap, String key) {
        ArrayList<String> datos = tokenMap.get(key);
        for (String dato : datos) {
            if (dato.startsWith("*")) { // Buscar solo claves que comiencen con *
                ArrayList<String> hijoData = tokenMap.get(dato);
                if (hijoData != null) {
                    // Crear nodo para el hijo
                    Node hijo = new Node(hijoData);
                    nodo.agregarHijoDerecho(hijo); // Agregar el hijo al nodo *h
    
                    // Si el hijo contiene más nodos *h, agregarlos recursivamente
                    agregarHijosRecursivamente(hijo, tokenMap, dato);
                }
            }
        }
    
        // Agregar todos los *h anidados al árbol
        for (String hijoKey : tokenMap.keySet()) {
            if (hijoKey.startsWith("*h")) {
                ArrayList<String> hijoData = tokenMap.get(hijoKey);
                if (hijoData != null && nodo.getHijoIzquierdo() == null) {
                    // Crear nodo para el hijo
                    Node hijo = new Node(hijoData);
                    nodo.setHijoIzquierdo(hijo); // Agregar el hijo al nodo *h
    
                    // Agregar los *h anidados recursivamente
                    agregarHijosRecursivamente(hijo, tokenMap, hijoKey);
                }
            }
        }
    }}
