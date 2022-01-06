package Utilitarios;

public class Ok {

    public static void main(String[] argumentos) {

        System.out.println("socontem numeros: " + soContemNumeros("0123456789"));
        System.out.println("socontem numeros: " + soContemNumeros("012hhh3456789"));
    }

    public static boolean soContemNumeros(String texto) {
        if (texto == null) {
            return false;
        }
        for (char letra : texto.toCharArray()) {
            if (letra < '0' || letra > '9') {
                return false;
            }
        }
        return true;

    }
}