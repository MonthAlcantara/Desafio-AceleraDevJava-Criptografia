package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {

        return realizarCriptografia(texto, 3, 35);
    }

    @Override
    public String descriptografar(String texto) {

        return realizarDescriptografia(texto, 3, 29);
    }

    private String realizarDescriptografia(String texto, int converteMinusculo, int converteMaiuculo) {
        String textoDecifrado = "";
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Erro! Você deve informar um texto");
        } else {
            for (int i = 0; i < texto.length(); i++) {
                if (Character.isDigit(texto.charAt(i)) || !Character.isLetter(texto.charAt(i))) {
                    textoDecifrado += texto.charAt(i);
                } else if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    textoDecifrado += (char) (texto.charAt(i) - converteMinusculo);
                } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                    textoDecifrado += (char) (texto.charAt(i) + converteMaiuculo);
                }
            }
        }

        return textoDecifrado;
    }

    private String realizarCriptografia(String texto, int converteMinusculo, int converteMaiuculo) {
        String textoCifrado = "";
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Erro! Você deve informar um texto");
        } else {
            for (int i = 0; i < texto.length(); i++) {
                if (Character.isDigit(texto.charAt(i)) || !Character.isLetter(texto.charAt(i))) {
                    textoCifrado += texto.charAt(i);
                } else if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    textoCifrado += (char) (texto.charAt(i) + converteMinusculo);
                } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                    textoCifrado += (char) (texto.charAt(i) + converteMaiuculo);
                }
            }
        }

        return textoCifrado;
    }
}
