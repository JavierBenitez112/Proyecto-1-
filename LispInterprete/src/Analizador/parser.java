package Analizador;

import java.util.ArrayList;
import java.util.HashMap;

import Tokens.tokenizer;

public class parser {
    ArrayList<ArrayList<String>> arrayList;
    tokenizer token;
    ArrayList<String> tokens;
    public AST<ArrayList<String>> arbol;

    // Método para analizar y crear el árbol
    public void parse() {
        this.token = new tokenizer(); // Inicializar correctamente el tokenizer
        this.token.tokenize(tokens);
        ArrayList<ArrayList<String>> Lista = this.token.getTokened(); // Usar this.token
        HashMap<String, ArrayList<String>> tokenMap = this.token.getTokenMap(); // Usar this.token

        // Obtener la primera lista anidada
        ArrayList<String> primeraListaAnidada = Lista.get(0);

        // Verificar si la primera lista es una definición de función "defun"
        if (primeraListaAnidada.get(0).equals("defun")) {
            // Crear el árbol con la primera lista anidada como raíz
            arbol = createTree(primeraListaAnidada, tokenMap);
            System.out.println(arbol);
        } else {
            // Manejar otros tipos de expresiones o errores
            System.out.println("Error: La expresión no comienza con 'defun'");
        }
    }

    // Método recursivo para crear el árbol
    private AST<ArrayList<String>> createTree(ArrayList<String> listaAnidada, HashMap<String, ArrayList<String>> tokenMap) {
        

        return arbol;
    }

// Método recursivo para imprimir el árbol
    
    
}