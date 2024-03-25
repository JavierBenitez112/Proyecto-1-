

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.Analizador.AST;
import com.Analizador.Node;
import com.Evaluador.Evaluador;

public class PruebaAritmetica {
    @Test

    public void testAritmetica(){
                //Prueba Evaluador defun
                // Construir el árbol
                Node<String> n1 = new Node<>("2");
                Node<String> n2 = new Node<>("3");
                Node<String> n3 = new Node<>("4");
                Node<String> n4 = new Node<>("5");
                Node<String> n5 = new Node<>("+");
                Node<String> n6 = new Node<>("-");
                Node<String> n7 = new Node<>("-");
        
                n5.addHijo(n1);
                n5.addHijo(n2);
                n6.addHijo(n3);
                n6.addHijo(n4);
                n7.addHijo(n5);
                n7.addHijo(n6);
        
                AST<String> tree = new AST<>(n7);

                
        
        // Probar el evaluador
        Evaluador evaluator = new Evaluador();
        String resultado = evaluator.evaluate(tree);
        int resultadoEntero = Integer.parseInt(resultado);
        System.out.println("El resultado de la expresión es: " + resultado);
        assertEquals(6, resultadoEntero);
    }
}
