package br.com.controle.pedidos.model.enums;

import java.util.Arrays;

public enum TipoCliente {

    PESSOAFISICA(1,"Pessoa Fisica"),
    PESSOAJURIDICA(1,"Pessoa Juridica");

    private Integer codigo;
    private String descricao;

    TipoCliente(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer codigo){
        if (codigo == null){
            return null;
        }

        for (TipoCliente tipoCliente : TipoCliente.values()) {
            if (tipoCliente.getCodigo().equals(codigo)){
                return tipoCliente;
            }
        }
        throw new IllegalArgumentException("Não existe o tipo de cliente com o código solicitado. Código = " + codigo);
    }

}
