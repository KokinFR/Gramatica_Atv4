import java.util.*;

import static java.util.regex.Pattern.matches;

/*
3 – Implemente um método em Java que recebe como parâmetros uma gramática e uma
cadeia e retorne se é essa cadeia pode ser gerada pela gramática informada.
*/
import java.util.HashMap;
import java.util.Map;

public class Qst3Gramatica {


    public static boolean pertenceLinguagem(Map<String, List<String>> gramatica, String simboloIni, String cadeia) {
        return verificaCadeia(gramatica, simboloIni, cadeia, 0);
    }

    private static boolean verificaCadeia(Map<String, List<String>> gramatica, String simbolo, String cadeia, int len) {

        if (len == cadeia.length() && simbolo.equals("")) {
            return true;
        }

        if (len == cadeia.length() || simbolo.equals("")) {
            return false;
        }


        if (gramatica.containsKey(simbolo)) {
            for (String producao : gramatica.get(simbolo)) {
                String novoSimbolo = producao + simbolo.substring(1);

                if (verificaCadeia(gramatica, novoSimbolo, cadeia, len)) {
                    return true;
                }
            }
        } else {

            if (cadeia.charAt(len) == simbolo.charAt(0)) {
                return verificaCadeia(gramatica, simbolo.substring(1), cadeia, len + 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Map<String, List<String>> gramatica = new HashMap<>();
        gramatica.put("S", List.of("aA", "bB", "c"));
        gramatica.put("A", List.of("aA", ""));
        gramatica.put("B", List.of("bB", ""));

        System.out.println(pertenceLinguagem(gramatica, "S", "aaa"));
        System.out.println(pertenceLinguagem(gramatica, "S", "bbb"));
        System.out.println(pertenceLinguagem(gramatica, "S", "aac"));
        System.out.println(pertenceLinguagem(gramatica, "S", "c"));
    }
}

