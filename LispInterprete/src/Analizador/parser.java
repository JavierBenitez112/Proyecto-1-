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
        // Crear el árbol con la raíz actual
        AST<ArrayList<String>> arbol = new AST<>(listaAnidada);

        // Recorrer los elementos restantes de la lista actual
        for (int i = 1; i < listaAnidada.size(); i++) {
            String elemento = listaAnidada.get(i);

            // Verificar si el elemento es una clave en el mapa de tokens
            if (tokenMap.containsKey(elemento)) {
                // Obtener la lista asociada con la clave
                ArrayList<String> listaHija = tokenMap.get(elemento);

                // Crear un nuevo árbol para la lista hija
                AST<ArrayList<String>> arbolHijo = createTree(listaHija, tokenMap);

                // Agregar el árbol hijo como hijo de la raíz actual
                arbol.addHijo(arbolHijo);
            } else {
                // Si el elemento no es una clave en el mapa de tokens, simplemente agregarlo como dato del árbol actual
                ArrayList<String> dato = new ArrayList<>();
                dato.add(elemento);
                arbol.addHijo(new AST<>(dato));
            }
        }

        return arbol;
    }

// Método recursivo para imprimir el árbol
    
    
}
