package br.senac.tads3.pi03b.gruposete.services;

import java.util.InputMismatchException;

public class ValidaCPF {

    public boolean isCPF(String x) {

        String parte1 = x.substring(0, 3);

        String parte2 = x.substring(4, 7);

        String parte3 = x.substring(8, 11);

        String parte4 = x.substring(12, 14);

        String CPF = (parte1) + (parte2) + (parte3) + (parte4);

        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (true);
        }

        char dig10, dig11;

        int sm, i, r, num, peso;

        try {

            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {

                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {

                return (false);

            } else {

                return (true);

            }

        } catch (InputMismatchException erro) {

            return (true);

        }

    }

}
