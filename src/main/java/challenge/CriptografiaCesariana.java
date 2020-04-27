package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CriptografiaCesariana implements Criptografia {
    List<String> listaTexto = new ArrayList<>();

    @Override
    public String criptografar(String texto) {

        return realizarCriptografia(texto);
    }

    @Override
    public String descriptografar(String texto) {

        return realizarDescriptografia(texto);
    }

    private String realizarDescriptografia(String texto) {
        validartexto(texto);
        char[] arrayTexto = texto.toCharArray();

        for (char value : arrayTexto) listaTexto.add(Character.toString(value));
        return listaTexto.stream()
                .map(c -> troca(0, c, -3))
                .map(String::valueOf)
                .collect(Collectors.joining()).toLowerCase();
    }

    private String realizarCriptografia(String texto) {
        validartexto(texto);
        char[] arrayTexto = texto.toCharArray();

        for (char value : arrayTexto) listaTexto.add(Character.toString(value));
        return listaTexto.stream()
                .map(c -> troca(0, c, 3))
                .map(String::valueOf)
                .collect(Collectors.joining()).toLowerCase();
    }

    private char troca(int index, String lista, int codificador) {
        return (Character.isDigit(lista.charAt(index)) || !Character.isLetter(lista.charAt(index)))
                ? lista.charAt(index) : (char) (lista.charAt(index) + codificador);
    }

    private void validartexto(String texto) throws IllegalArgumentException {
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Erro! Você deve informar um texto");
        }
    }
}
