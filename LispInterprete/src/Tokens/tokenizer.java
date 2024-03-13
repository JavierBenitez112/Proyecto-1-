//clase tokenizadora de expresiones lisp
package Tokens;

import java.lang.reflect.Array;
import java.util.ArrayList;
//import hash map
import java.util.HashMap;



public class tokenizer {

    private HashMap<String, ArrayList<String>> tokenMap; 
    private ArrayList<String> Keys;

    public void tokenizer() {
        tokenMap = new HashMap<String, ArrayList<String>>();
        Keys = new ArrayList<String>();
    }
    
    public void tokenize(ArrayList<String> tokens){
        int map = 0;
        ArrayList<String> tokened = new ArrayList<String>();
        for (int i = 0; i < tokens.size(); i++) {
            ArrayList<String> stuff = new ArrayList<String>();
            String key = "*h" + map;
            if (tokens.get(i).equals(")")){
                map++;
                int r = tokened.size() - 1;
                // return in the tokenMap till find "("
                
                
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
                
                tokenMap.put(key, stuff);
            } else{
                tokened.add(tokens.get(i));
            }
        }
        Keys = tokened;
        
    }

    public HashMap<String, ArrayList<String>> getTokenMap() {
        return tokenMap;
    }

    public ArrayList<String> getTokened() {
        return Keys;
    }

    
}
    