import java.util.ArrayList;

import Analizador.parser;
import Tokens.LispReader;
import Tokens.tokenizer;
import Analizador.Node;
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

        // Parse the tokens to create the tree
        parser parserInstance = new parser();
        parserInstance.parse();

        
    }
    
}