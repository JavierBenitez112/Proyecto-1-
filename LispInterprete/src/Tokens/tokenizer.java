//clase tokenizadora de expresiones lisp
package Tokens;

import java.lang.reflect.Array;
import java.util.ArrayList;
//import hash map
import java.util.HashMap;



public class tokenizer {
    
    public ArrayList<> tokenize(ArrayList<String> tokens){
        tokens.remove(0);
        tokens.remove(tokens.size()-1);
        HashMap<String, String> tokenMap = new HashMap<String, String>();
        ArrayList<> tokened = new ArrayList<>();

        for (String token : tokens) {
            if (token.equals("(")){
                int r = tokened.size() - 1;
                // return in the tokenMap till find "("
                while (r > 0) {
                    if (tokened.get(r) == "(") {
                        tokened.remove(r);
                        break;
                    } else {
                        tokenMap.put(tokened.get(r), tokened.get(r));
                        tokened.remove(r);
                    }
                    r--;
                }
            } else{
                tokened.add(token);
            }
        }
        return tokened;
    }
}
    