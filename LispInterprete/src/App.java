import java.util.ArrayList;
import java.util.HashMap;

import Tokens.LispReader;
import Tokens.tokenizer;

public class App {
    public static void main(String[] args) throws Exception {
        LispReader lisp = new LispReader();
        ArrayList<String> tokens = lisp.LispFile("C:\\Users\\javib\\OneDrive\\Documentos\\GitHub\\Proyecto-1-\\LispInterprete\\Farenheit.lsp");

        tokenizer token = new tokenizer();
        token.tokenize(tokens);

        // Obtener los datos tokenizados
        ArrayList<ArrayList<String>> datosTokenizados = token.getTokened();

        // Obtener el mapa de tokens
        HashMap<String, ArrayList<String>> tokenMap = token.getTokenMap();

        // Reordenar la expresión
        ArrayList<String> expression = datosTokenizados.get(0); // Se asume que solo hay una expresión
        ArrayList<String> reorderedExpression = reorderExpression(expression, tokenMap);

        // Imprimir la expresión reordenada
        System.out.println("Expresión reordenada:");
        System.out.println(reorderedExpression);
    }

    // Método para reordenar la expresión
    private static ArrayList<String> reorderExpression(ArrayList<String> expression, HashMap<String, ArrayList<String>> tokenMap) {
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
