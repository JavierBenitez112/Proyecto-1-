package Analizador;

import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
    
    private HashMap<String, ArrayList<String>> tokenMap;
    
    public Parser(HashMap<String, ArrayList<String>> tokenMap) {
        this.tokenMap = tokenMap;
    }
    
    public Node parse(ArrayList<String> tokens) {
        return parseExpression(tokens, 0);
    }
    
    private Node parseExpression(ArrayList<String> tokens, int index) {
        if (index >= tokens.size()) {
            return null;
        }
        
        String token = tokens.get(index);
        
        if (token.startsWith("*h")) {
            Node node = new Node();
            node.type = "Expression";
            node.children = new ArrayList<>();
            
            // Obtener la lista de tokens asociada a la clave
            ArrayList<String> childTokens = tokenMap.getOrDefault(token, new ArrayList<String>());
            
            // Convertir la lista de tokens a una cadena y asignarla como valor del nodo
            node.value = childTokens.toString();
            
            // Parsear los hijos de la expresión
            for (String childToken : childTokens) {
                node.children.add(parseExpression(childTokens, 0)); // Llamada recursiva con los tokens dentro del ciclo
            }
            
            return node;
        } else if (token.equals("(")) {
            Node node = new Node();
            node.type = "Expression";
            node.children = new ArrayList<>();
            
            // Parsear los hijos de la expresión
            index++;
            while (!tokens.get(index).equals(")")) {
                node.children.add(parseExpression(tokens, index));
                index++;
            }
            
            return node;
        } else {
            // Si es un número o un operador
            Node node = new Node();
            node.type = token;
            node.value = tokenMap.getOrDefault(token, new ArrayList<String>()).toString(); // Convertir la lista de tokens a una cadena
            return node;
        }
    }
    
    public static class Node {
        public String type;
        public String value;
        public ArrayList<Node> children;
    }
}
