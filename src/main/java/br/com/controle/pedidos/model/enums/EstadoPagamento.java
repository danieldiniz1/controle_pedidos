package br.com.controle.pedidos.model.enums;

public enum EstadoPagamento {

    PENDENTE(1,"Pagamento encontra-se Pendente"),
    QUITADO(2,"Pagamento encontra-se Quitado"),
    CANCELADO(3,"Pedido foi cancelado");

    private Integer codigo;
    private String descricao;

    EstadoPagamento(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer codigo){
        if (codigo == null){
            return null;
        }

        for (EstadoPagamento estadoPagamento : EstadoPagamento.values()) {
            if (estadoPagamento.getCodigo().equals(codigo)){
                return estadoPagamento;
            }
        }
        throw new IllegalArgumentException("não foi encontrado estado de pagamento para código: " + codigo);
    }
}
