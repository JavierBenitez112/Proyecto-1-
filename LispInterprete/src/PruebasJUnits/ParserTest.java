package PruebasJUnits;

import Analizador.Node;
import Tokens.tokenizer;

import java.util.ArrayList;
import Tokens.LispReader;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParserTest {

    @Test
    public void testNodeConstruction() {
        // Crear instancia de tokenizer
        tokenizer tokenizer = new tokenizer();
        
        // Crear datos de ejemplo para el tokenizer
        LispReader lisp = new LispReader();
        ArrayList<String> tokens = lisp.LispFile("C:\\Users\\javib\\OneDrive\\Documentos\\GitHub\\Proyecto-1-\\LispInterprete\\Farenheit.lsp");
        //System.out.println(tokens);
        tokenizer token = new tokenizer();
        token.tokenize(tokens); // Fix: Pass the 'tokens' ArrayList as an argument
        
        // Tokenizar los datos
        tokenizer.tokenize(tokens);
        
        // Obtener los datos tokenizados
        ArrayList<ArrayList<String>> datosTokenizados = tokenizer.getTokened();
        

        token.tokenize(tokens); // Fix: Pass the 'tokens' ArrayList as an argument
        System.out.println(token.getTokenMap());
        System.out.println(token.getTokened());

        // Verificar si datosTokenizados es null
        if (datosTokenizados != null) {
            // Verificar si hay al menos un dato
            if (!datosTokenizados.isEmpty()) {
                // Crear el nodo con el primer conjunto de datos tokenizados
                Node nodo = new Node(datosTokenizados.get(0));

                // Imprimir los datos almacenados en el nodo
                System.out.println("Datos almacenados en el nodo:");
                imprimirArrayList(nodo.getDatos());

                // Verificar que los datos se hayan almacenado correctamente
                assertNotNull(nodo);
                assertEquals(datosTokenizados.get(0), nodo.getDatos());
            } else {
                System.out.println("No se encontraron datos tokenizados");
            }
        } else {
            System.out.println("La lista de datos tokenizados es null");
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
}
