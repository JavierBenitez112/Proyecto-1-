//clase tokenizadora de expresiones lisp
package Tokens;

import java.lang.reflect.Array;
import java.util.ArrayList;
//import hash map
import java.util.HashMap;



public class tokenizer {

    private HashMap<String, ArrayList<String>> tokenMap; 
    private ArrayList<String> tokened;

    public void tokenizer() {
        tokenMap = new HashMap<String, ArrayList<String>>();
        tokened = new ArrayList<String>();
    }
    
    public void tokenize(ArrayList<String> tokens){
        int map = 0;

        for (String token : tokens) {
            if (token.equals(")")){
                map++;
                int r = tokened.size() - 1;
                // return in the tokenMap till find "("
                ArrayList<String> stuff = new ArrayList<String>();
                while (r > 0) {

                    if (tokened.get(r) == "(") {
                        tokened.remove(r);
                        break;
                    } else {
                        

                        stuff.add(tokened.get(r));
                        tokened.remove(r);
                    }
                    r--;
                }
                String key = "*h" + map;
                tokenMap.put(key, stuff);
            } else{
                tokened.add(token);
            }
        }
        
    }

    public HashMap<String, ArrayList<String>> getTokenMap() {
        return tokenMap;
    }

    public ArrayList<String> getTokened() {
        return tokened;
    }


}
    