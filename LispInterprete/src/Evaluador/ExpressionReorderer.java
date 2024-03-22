package Evaluador;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpressionReorderer {
    public static ArrayList<String> reorderExpression(ArrayList<String> expression, HashMap<String, ArrayList<String>> tokenMap) {
        ArrayList<String> reorderedExpression = new ArrayList<>();

        for (String token : expression) {
            if (token.startsWith("*")) {
                // Procesar la subexpresión asociada con la clave "*h"
                ArrayList<String> subExpression = processSubExpression(token, tokenMap);
                // Agregar la subexpresión procesada a la expresión reordenada
                reorderedExpression.addAll(subExpression);
            } else {
                // Agregar el token a la expresión reordenada
                reorderedExpression.add(token);
            }
        }

        return reorderedExpression;
    }

    private static ArrayList<String> processSubExpression(String key, HashMap<String, ArrayList<String>> tokenMap) {
        ArrayList<String> subExpression = new ArrayList<>();
        ArrayList<String> subExpressionData = tokenMap.get(key);

        for (String token : subExpressionData) {
            if (token.startsWith("*")) {
                // Procesar subexpresión anidada recursivamente
                ArrayList<String> nestedSubExpression = processSubExpression(token, tokenMap);
                // Agregar la subexpresión anidada a la subexpresión actual
                subExpression.addAll(nestedSubExpression);
            } else {
                // Agregar el token a la subexpresión actual
                subExpression.add(token);
            }
        }

        return subExpression;
    }
}
