

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.Test;

import com.Analizador.AST;
import com.Analizador.Node;
import com.Evaluador.Evaluador;


public class PruebaSetq {
    
    @Test
    public void testSetq() {
        Node<String> n1 = new Node<>("2");
        Node<String> n2 = new Node<>("SetQ");
        Node<String> n3 = new Node<>("x");
        Node<String> n4 = new Node<>("4");
        Node<String> n5 = new Node<>("x");
        Node<String> n6 = new Node<>("x");
        
        n1.addHijo(n5);
        n3.addHijo(n4);
        n2.addHijo(n3);
        n1.addHijo(n2);
        n1.addHijo(n6);

        AST<String> tree = new AST<>(n1);

        // Probar el evaluador
        Evaluador evaluator = new Evaluador();
        AST<String> newtree = evaluator.setq(tree);
        String resultado = newtree.getRaiz().getHijo(0).getData();
        assertEquals(resultado, "4");
    }

}
