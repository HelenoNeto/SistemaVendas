package Negocios;

import java.util.Date;
import javax.persistence.Temporal;

public class Grupo {

    private int id;
    private String descricao;
    private boolean excluido;
    private boolean vasilhames;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_insercao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_edicao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_exclusao;
    private Integer id_usuario_insercao;
    private Integer id_usuario_edicao;
    private Integer id_usuario_exclusao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
    }

    public boolean isVasilhames() {
        return vasilhames;
    }

    public void setVasilhames(boolean vasilhames) {
        this.vasilhames = vasilhames;
    }

    public Date getData_insercao() {
        return data_insercao;
    }

    public void setData_insercao(Date data_insercao) {
        this.data_insercao = data_insercao;
    }

    public Date getData_edicao() {
        return data_edicao;
    }

    public void setData_edicao(Date data_edicao) {
        this.data_edicao = data_edicao;
    }

    public Date getData_exclusao() {
        return data_exclusao;
    }

    public void setData_exclusao(Date data_exclusao) {
        this.data_exclusao = data_exclusao;
    }

    public Integer getId_usuario_insercao() {
        return id_usuario_insercao;
    }

    public void setId_usuario_insercao(Integer id_usuario_insercao) {
        this.id_usuario_insercao = id_usuario_insercao;
    }

    public Integer getId_usuario_edicao() {
        return id_usuario_edicao;
    }

    public void setId_usuario_edicao(Integer id_usuario_edicao) {
        this.id_usuario_edicao = id_usuario_edicao;
    }

    public Integer getId_usuario_exclusao() {
        return id_usuario_exclusao;
    }

    public void setId_usuario_exclusao(Integer id_usuario_exclusao) {
        this.id_usuario_exclusao = id_usuario_exclusao;
    }

}
