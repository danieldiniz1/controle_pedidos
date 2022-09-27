package br.com.controle.pedidos.controller.handler;

public class StandardError {

    private Integer status;
    private String menssagem;
    private Long timeStamp;

    public StandardError() {
    }

    public StandardError(Integer status, String menssagem, Long timeStamp) {
        this.status = status;
        this.menssagem = menssagem;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
