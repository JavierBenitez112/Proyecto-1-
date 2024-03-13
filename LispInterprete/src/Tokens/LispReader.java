package Tokens;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LispReader {
    
    public ArrayList<String> LispFile(String path){
        ArrayList<String> tokens = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineTokens = line.split(" ");
                for (String tokenl : lineTokens) {
                    if (tokenl.equals("")) continue;
                    // TODO: dejar que pedro haga comandos
                    // add parenthesis to the tokens as separate tokens
                    if (tokenl.contains("(") || tokenl.contains(")")) {
                        String[] parenthesis = tokenl.split("");
                        for (String p : parenthesis) {
                            if (p.equals("(") || p.equals(")")) {
                                
                                // remove p from tokenl
                                tokenl = tokenl.replace(p, "");
                                tokens.add(p);
                            }
                        }
                        
                        
                    }
                    tokens.add(tokenl);
                }
                
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return tokens;
    }


    public static void main(String[] args) {
        LispReader lisp = new LispReader();
        ArrayList<String> tokens = lisp.LispFile("Farenheit.lsp");
        System.out.println(tokens);
    }
}
