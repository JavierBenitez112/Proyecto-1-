import java.util.ArrayList;

import Analizador.parser;
import Tokens.LispReader;
import Tokens.tokenizer;
import Analizador.Node;
import Analizador.AST;
import Evaluador.Evaluador;
import Analizador.parser;

public class App {

    // Metodo main que corre el programa
    public static void main(String[] args) throws Exception {
        // Leer los tokens del archivo Lisp
        LispReader lisp = new LispReader();
        ArrayList<String> tokens = lisp.LispFile("C:\\Users\\javib\\OneDrive\\Documentos\\GitHub\\Proyecto-1-\\LispInterprete\\src\\Lisp pruebas\\Prueba1.txt");

        // Crear una instancia de tokenizer y tokenizar los tokens
        tokenizer token = new tokenizer();
        token.tokenize(tokens);

        

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
                System.out.println("El resultado de la expresión es: " + resultado);
        

        
    }
    
}