package PruebasJUnits;

import Analizador.Node;
import Tokens.tokenizer;

import java.util.ArrayList;
import Tokens.LispReader;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class ParserTest {

    @Test
    public void testNodeConstruction() {
        // Crear instancia de tokenizer
        tokenizer tokenizer = new tokenizer();
        
        // Crear datos de ejemplo para el tokenizer
        LispReader lisp = new LispReader();
        ArrayList<String> tokens = lisp.LispFile("C:\\Users\\javib\\OneDrive\\Documentos\\GitHub\\Proyecto-1-\\LispInterprete\\src\\Lisp pruebas\\Prueba1.txt");
        
        // Tokenizar los datos
        tokenizer.tokenize(tokens);
        
        // Obtener los datos tokenizados
        ArrayList<ArrayList<String>> datosTokenizados = tokenizer.getTokened();

        // Verificar si datosTokenizados es null
        if (datosTokenizados != null) {
            // Verificar si hay al menos un dato
            if (!datosTokenizados.isEmpty()) {
                // Crear el nodo raíz con el primer conjunto de datos tokenizados
                Node rootNode = crearArbol(tokenizer, 0);

                // Imprimir el árbol binario generado
                System.out.println("Árbol binario generado:");
                imprimirArbol(rootNode, 0);
                
                // Verificar que los datos se hayan almacenado correctamente
                assertNotNull(rootNode);
            } else {
                System.out.println("No se encontraron datos tokenizados");
            }
        } else {
            System.out.println("La lista de datos tokenizados es null");
        }
    }

    // Método para imprimir el árbol binario de manera recursiva
    private void imprimirArbol(Node nodo, int nivel) {
        if (nodo != null) {
            // Imprimir datos del nodo con indentación según el nivel
            for (int i = 0; i < nivel; i++) {
                System.out.print("  "); // Dos espacios por nivel
            }
            imprimirArrayList(nodo.getDatos());
            
            // Imprimir hijo izquierdo recursivamente
            imprimirArbol(nodo.getHijoIzquierdo(), nivel + 1);
            
            // Imprimir hijo derecho recursivamente
            imprimirArbol(nodo.getHijoDerecho(), nivel + 1);
        }
    }

    // Método para imprimir un ArrayList
    private void imprimirArrayList(ArrayList<String> lista) {
        if (lista != null) { // Verificar si la lista no es null
            for (String elemento : lista) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        } else {
            System.out.println("La lista proporcionada es null");
        }
    }
    
    // Método para crear el árbol binario recursivamente
    private Node crearArbol(tokenizer tokenizer, int index) {
        if (index >= tokenizer.getTokened().size()) {
            return null;
        }
    
        ArrayList<String> datos = tokenizer.getTokened().get(index);
        Node nodo = new Node(datos);
    
        
        return nodo;
    }
}
