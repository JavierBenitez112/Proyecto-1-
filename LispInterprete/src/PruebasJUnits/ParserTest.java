package PruebasJUnits;

import Evaluador.Evaluador;
import Analizador.Node;
import Analizador.parser;
import Tokens.LispReader;
import Tokens.tokenizer;

import java.util.ArrayList;
import java.util.HashMap;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void testFarenheitToCelsius() {
        // Paso 1: Parseo del código Lisp
        LispReader lispReader = new LispReader();
        ArrayList<String> tokens = lispReader.LispFile("Farenheit.lsp");

        HashMap<String, ArrayList<String>> tokenMap = new HashMap<>();
        tokenMap.put("root", tokens);

        parser parser = new parser(tokenMap, new ArrayList<>(tokenMap.keySet()));
        Node root = parser.parse();

        // Paso 2: Evaluación del AST
        Evaluador evaluador = new Evaluador();
        int result = evaluador.evaluate(root);

        // Verificar el resultado de la conversión de Fahrenheit a Celsius
        assertEquals(0, result); // Ajusta este valor según el resultado esperado
    }
}
