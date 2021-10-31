package com.ienh;

public class Main {

    public static void main(String[] args) {

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++ CIFRA DE CESAR +++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        System.out.println();

        Cipher cipher = new Cipher();
        String text = "Exercício: Algoritmo de CIFRA DE CESAR feito em java, escrito por Cleomar Gigolette da Silva dia 31-10-2021";
        System.out.println("TEXTO DE ENTRADA: " + text);
        System.out.println();

        ResultEncryptDTO resultEncryptDTO = cipher.encryptCesar(text);

        System.out.println("TEXTO CRIPTOGRAFADO: " + resultEncryptDTO.getResult());
        System.out.println();
        System.out.println("CHAVE CRIADA RANDÔMICA: " + resultEncryptDTO.getKey());
        System.out.println();

        String textDecrypt = cipher.decryptCesar(resultEncryptDTO.getResult(), resultEncryptDTO.getKey());

        System.out.println("TEXTO DE SAÍDA DESCRIPTOGRAFADO: " + textDecrypt);

        System.out.println();
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++ FIM ++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
