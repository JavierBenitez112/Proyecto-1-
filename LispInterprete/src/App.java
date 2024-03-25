import java.util.ArrayList;
import java.util.Scanner;


import Tokens.LispReader;
import Tokens.tokenizer;
import Analizador.AST;
import Analizador.parser;
import Evaluador.Evaluador;

public class App {

    // Metodo main que corre el programa
    public static void main(String[] args) throws Exception {
        LispReader lisp = new LispReader();
        Scanner sc = new Scanner(System.in);


        System.out.println("ingrese la direccion del archivo lisp:");
        String path = sc.nextLine();
        
        path = path.replaceAll("\"", "");


        ArrayList<String> tokens = lisp.LispFile(path);
        //System.out.println(tokens);
        tokenizer token = new tokenizer();
        token.tokenize(tokens); // Fix: Pass the 'tokens' ArrayList as an argument
        System.out.println(token.getTokenMap());
        System.out.println(token.getTokened());
        

        //Prueba parser
        parser p = new parser(token.getTokenMap());
        p.parse(token.getTokened());

        p.printCurrentAST();

        Evaluador e = new Evaluador();
        
        for (AST<String> ast : p.getLogicalOrder()) {
            System.out.println(e.setq(ast));
        }
    }


    
}
