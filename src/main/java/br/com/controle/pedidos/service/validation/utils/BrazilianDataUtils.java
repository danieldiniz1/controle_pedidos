package br.com.controle.pedidos.service.validation.utils;

public class BrazilianDataUtils {

    public static Boolean isvalidCPF(String cpf){

        if ( cpf == null || !cpf.matches("\\d{11}") ||  cpf.matches(cpf.charAt(0) + "{11}")){
            return Boolean.FALSE;
        }
        return validacaoCPF(cpf);
    }

    private static Boolean validacaoCPF(String cpf) {
        final char[] chars = cpf.toCharArray();
        Integer firstDigito = Integer.parseInt(String.valueOf(chars[9]));
        Integer lastDigito = Integer.parseInt(String.valueOf(chars[10]));

        if (!calcularDigito(chars,1).equals(firstDigito) || !calcularDigito(chars,2).equals(lastDigito)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private static Integer calcularDigito(char[] chars, int digito) {

        Integer totalSoma = 0;
        Integer length;
        if(digito == 1) {
             length = chars.length-1;
            for (int i = 0; i < 9; i++) {
                totalSoma += Integer.parseInt(String.valueOf(chars[i])) * length;
                length--;
            }
        } else {
            length = chars.length;
            for (int i = 0; i < 10; i++) {
                totalSoma += Integer.parseInt(String.valueOf(chars[i])) * length;
                length--;
            }
        }

        int result = totalSoma * 10 % 11;
        return result == 10 ? 0 : result;
    }
}

