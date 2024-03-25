

import Analizador.AST;
import Evaluador.Evaluador;
import Analizador.Node;

public class PruebaSetq {

    // Metodo main que corre el programa
    public static void main(String[] args) throws Exception {

                //Prueba Evaluador Setq
                // Construir el árbol
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
                String resultado = evaluator.setq(tree);
                System.out.println("El resultado de la expresión es: " + resultado);
    }

    
}
