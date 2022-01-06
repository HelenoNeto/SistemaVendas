/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import java.math.BigDecimal;

/**
 *
 * @author Heleno
 */
public class ConfiguracaoJurosParcelasReceber {

    private Integer id;
    private String tipo_juros;
    private BigDecimal valor_juros;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_juros() {
        return tipo_juros;
    }

    public void setTipo_juros(String tipo_juros) {
        this.tipo_juros = tipo_juros;
    }

    public BigDecimal getValor_juros() {
        return valor_juros;
    }

    public void setValor_juros(BigDecimal valor_juros) {
        this.valor_juros = valor_juros;
    }
}