//clase tokenizadora de expresiones lisp
package Tokens;

import java.lang.reflect.Array;
import java.util.ArrayList;
//import hash map
import java.util.HashMap;



public class tokenizer {

    private HashMap<String, ArrayList<String>> tokenMap; 
    private ArrayList<ArrayList<String>> Keys;

    //constructor de la clase que inicializa el hashmap y el arraylist
    public tokenizer() {
        tokenMap = new HashMap<String, ArrayList<String>>();
        Keys = new ArrayList<ArrayList<String>>();
    }
    
    //metodo que tokeniza una lista de tokens
    public void tokenize(ArrayList<String> tokens){
        int map = 0;
        ArrayList<String> tokened = new ArrayList<String>();
        for (int i = 0; i < tokens.size(); i++) {
            ArrayList<String> stuff = new ArrayList<String>();
            String key = "*h" + map;
            if (tokens.get(i).equals(")")){
                map++;
                int r = tokened.size() - 1;
                // regresar hasta encontrar el parentesis que abre y anadir los tokens al mapa
                
                
                while (r >= 0) {

                    if (tokened.get(r).equals("(")){
                        tokened.remove(r);
                        tokened.add(key);
                        break;
                    } else {
                        
                        stuff.add(0, tokened.get(r));
                        tokened.remove(r);
                        
                    }
                    r = r - 1;
                }
                //anadir el arraylist al hashmap
                tokenMap.put(key, stuff);
            } else{
                tokened.add(tokens.get(i));
            }
        }
        //anadir los tokens al arraylist
        for (int i = 0; i < tokened.size(); i++){
            Keys.add(tokenMap.get(tokened.get(i)));
        }
        
    
        
    }

    //metodo que devuelve el hashmap
    public HashMap<String, ArrayList<String>> getTokenMap() {
        return tokenMap;
    }

    //metodo que devuelve el arraylist de tokens
    public ArrayList<ArrayList<String>> getTokened() {
        return Keys;
    }

    
}
    