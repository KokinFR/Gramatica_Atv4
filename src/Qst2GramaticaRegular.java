import java.util.ArrayList;
import java.util.List;

/*
2 – Implemente um método em Java que gere todas as cadeias de comprimento N que
podem ser geradas pela gramática regular abaixo:
Detalhes da Gramática:
• A gramática é definida pelas seguintes produções:
o S → aA | bB | c
o A → aA | ε
o B → bB | ε
*/
public class Qst2GramaticaRegular {
    public static List<String> gerarCadeias(int N) {
        List<String> cadeias = new ArrayList<>();
        gerandoCadeiasRecursivo("S", N, "", cadeias);
        return cadeias;
    }

    private static void gerandoCadeiasRecursivo(String simbolo, int N, String cadeiaAtual, List<String> cadeias) {

        if (cadeiaAtual.length() == N) {
            cadeias.add(cadeiaAtual);
            return;
        }


        switch (simbolo) {
            case "S":

                gerandoCadeiasRecursivo("A", N, cadeiaAtual + "a", cadeias);
                gerandoCadeiasRecursivo("B", N, cadeiaAtual + "b", cadeias);


                if (cadeiaAtual.length() + 1 == N) {
                    cadeias.add(cadeiaAtual + "c");
                }
                break;

            case "A":

                gerandoCadeiasRecursivo("A", N, cadeiaAtual + "a", cadeias);
                break;

            case "B":

                gerandoCadeiasRecursivo("B", N, cadeiaAtual + "b", cadeias);
                break;
        }
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> cadeias = gerarCadeias(N);
        System.out.println("Cadeias de comprimento " + N + ": " + cadeias);
    }
}
