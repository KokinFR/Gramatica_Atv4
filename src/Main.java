/*
1 – Implemente um método em Java que verifique se uma cadeia de caracteres pertence
à linguagem definida ela gramática regular abaixo:
Detalhes da Gramática:
• A gramática é definida pelas seguintes produções:
o S → aA | bB
o A → aA | ε
o B → bB | ε
*/
public class Main {
    public static boolean pertenceLinguagem(String cadeia){
        //Cadeia vazia
        if (cadeia.isEmpty()){
            return false;
        }
        if (cadeia.charAt(0) == 'a'){
            return veriA(cadeia, 1);
        } else if (cadeia.charAt(0) == 'b'){
            return veriB(cadeia, 1);
        } else {
            return false;
        }
    }
    public static boolean veriA(String cadeia, int len){
        if (len >= cadeia.length()){
            return true;
        }
        if (cadeia.charAt(len) == 'a'){
            return veriA(cadeia, len + 1);
        }
        return false;
    }
    public static boolean veriB(String cadeia, int len){
        if (len >= cadeia.length()){
            return true;
        }
        if (cadeia.charAt(len) == 'b'){
            return veriA(cadeia, len + 1);
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(pertenceLinguagem("aaa"));
        System.out.println(pertenceLinguagem("bbb"));
        System.out.println(pertenceLinguagem("aab"));
        System.out.println(pertenceLinguagem("bba"));
        System.out.println(pertenceLinguagem("a"));
        System.out.println(pertenceLinguagem("b"));

    }
}