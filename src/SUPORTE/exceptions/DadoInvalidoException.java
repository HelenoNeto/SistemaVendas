package SUPORTE.exceptions;

public class DadoInvalidoException extends Exception {

    private String msg_detalhada = "";

    public DadoInvalidoException() {
        super("Dado inválido.");
    }

    public DadoInvalidoException(String msg_simples) {
        super(msg_simples);
    }

    public DadoInvalidoException(String msg_simples, String msg_detalhada) {
        super(msg_simples);
        this.msg_detalhada = msg_detalhada;
    }

    public String getMessageDetalhada() {
        return this.msg_detalhada;
    }

}
