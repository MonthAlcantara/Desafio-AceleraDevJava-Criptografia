package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CriptografiaCesariana implements Criptografia {
    List<String> listaTexto = new ArrayList<>();

    @Override
    public String criptografar(String texto) {

        return realizarConversao(texto, 3);
    }

    @Override
    public String descriptografar(String texto) {

        return realizarConversao(texto, -3);
    }

    private String realizarConversao(String texto, int codificador) {
        validarTexto(texto);
        char[] arrayTexto = texto.toCharArray();

        for (char value : arrayTexto) listaTexto.add(Character.toString(value));
        return listaTexto.stream()
                .map(c -> modificarCaracter(0, c, codificador))
                .map(String::valueOf)
                .collect(Collectors.joining())
                .toLowerCase();
    }

    private char modificarCaracter(int index, String lista, int codificador) {
        return (Character.isDigit(lista.charAt(index)) || !Character.isLetter(lista.charAt(index)))
                ? lista.charAt(index) : (char) (lista.charAt(index) + codificador);
    }

    private void validarTexto(String texto) throws IllegalArgumentException {
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Erro! Você deve informar um texto");
        }
    }
}
