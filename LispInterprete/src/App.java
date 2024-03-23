import java.util.ArrayList;

import Tokens.LispReader;
import Tokens.tokenizer;

public class App {

    // Metodo main que corre el programa
    public static void main(String[] args) throws Exception {
        LispReader lisp = new LispReader();
        ArrayList<String> tokens = lisp.LispFile("C:\\Users\\javib\\OneDrive\\Documentos\\GitHub\\Proyecto-1-\\LispInterprete\\Farenheit.lsp");
        //System.out.println(tokens);
        tokenizer token = new tokenizer();
        token.tokenize(tokens); // Fix: Pass the 'tokens' ArrayList as an argument
        System.out.println(token.getTokenMap());
        System.out.println(token.getTokened());
    }
    
}
