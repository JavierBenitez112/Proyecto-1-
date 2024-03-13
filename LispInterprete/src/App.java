import java.util.ArrayList;

import Tokens.LispReader;
import Tokens.tokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        LispReader lisp = new LispReader();
        ArrayList<String> tokens = lisp.LispFile("Farenheit.lsp");
        //System.out.println(tokens);
        tokenizer token = new tokenizer();
        token.tokenizer();
        token.tokenize(tokens);
        System.out.println(token.getTokenMap());
        System.out.println(token.getTokened());
    }
    
}
