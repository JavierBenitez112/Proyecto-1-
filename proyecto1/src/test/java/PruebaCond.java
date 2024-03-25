

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.Test;

import com.Analizador.AST;
import com.Analizador.Node;
import com.Evaluador.Evaluador;


public class PruebaCond {
    
    @Test
    public void testequal() {
        Node<String> n1 = new Node<>("2");
        Node<String> n2 = new Node<>("Cond");
        Node<String> n3 = new Node<>("=");
        Node<String> n4 = new Node<>("4");
        Node<String> n5 = new Node<>("4");
        Node<String> n6 = new Node<>("True");
        Node<String> n7 = new Node<>("False");
        
        
        n3.addHijo(n4);
        n3.addHijo(n5);
        n3.addHijo(n6);
        n3.addHijo(n7);
        n2.addHijo(n3);
        n1.addHijo(n2);



        

        AST<String> tree = new AST<>(n1);

        // Probar el evaluador
        Evaluador evaluator = new Evaluador();
        String resultado = evaluator.cond(tree);
        assertEquals(resultado, "True");
    }

    @Test
    public void testmay() {
        Node<String> n1 = new Node<>("2");
        Node<String> n2 = new Node<>("Cond");
        Node<String> n3 = new Node<>(">");
        Node<String> n4 = new Node<>("5");
        Node<String> n5 = new Node<>("4");
        Node<String> n6 = new Node<>("True");
        Node<String> n7 = new Node<>("False");
        
        
        n3.addHijo(n4);
        n3.addHijo(n5);
        n3.addHijo(n6);
        n3.addHijo(n7);
        n2.addHijo(n3);
        n1.addHijo(n2);



        

        AST<String> tree = new AST<>(n1);

        // Probar el evaluador
        Evaluador evaluator = new Evaluador();
        String resultado = evaluator.cond(tree);
        assertEquals(resultado, "True");
    }

    @Test
    public void testmen() {
        Node<String> n1 = new Node<>("2");
        Node<String> n2 = new Node<>("Cond");
        Node<String> n3 = new Node<>("<");
        Node<String> n4 = new Node<>("3");
        Node<String> n5 = new Node<>("4");
        Node<String> n6 = new Node<>("True");
        Node<String> n7 = new Node<>("False");
        
        
        n3.addHijo(n4);
        n3.addHijo(n5);
        n3.addHijo(n6);
        n3.addHijo(n7);
        n2.addHijo(n3);
        n1.addHijo(n2);



        

        AST<String> tree = new AST<>(n1);

        // Probar el evaluador
        Evaluador evaluator = new Evaluador();
        String resultado = evaluator.cond(tree);
        assertEquals(resultado, "True");
    }
}
