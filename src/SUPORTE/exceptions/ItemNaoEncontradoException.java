package SUPORTE.exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exceção responsável por tratar os erros internos do sistema.
 */
public class ItemNaoEncontradoException extends Exception {

    /**
     * Comment for
     * <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2L;

    /**
     * Creates a new ErroInternoException object.
     */
    public ItemNaoEncontradoException(Class classeDoErro) {
        super("Item Nao Encontrado!");
    }

    /**
     * Creates a new ErroInternoException object.
     *
     * @param mensagem de erro
     */
    public ItemNaoEncontradoException(Class classeDoErro, String message) {
        super(message);

    }

    /**
     * @param message
     * @param cause
     */
    public ItemNaoEncontradoException(Class classeDoErro, String message, Throwable cause) {
        super(message, cause);
    }
}