package Tokens;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LispReader {
    
    public ArrayList<String> LispFile(String path){
        int s = 0;
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
                            if (p.equals(")")) {
                                
                                // remove p from tokenl
                                tokenl = tokenl.replace(p, "");
                                tokens.add(p);
                                s++;
                            } else if (p.equals("(")) {
                                tokenl = tokenl.replace(p, "");
                                tokens.add(p);
                                
                            }
                        }
                        
                        
                    }
                    
                    tokens.add(tokens.size() - s,tokenl);
                    s = 0;
                }
                
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return tokens;
    }


    
}
