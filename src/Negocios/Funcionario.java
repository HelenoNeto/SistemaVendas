package Negocios;

import java.util.Date;

public class Funcionario {

    private Integer id;
    private String nome;
    private String endereco;
    private String num_end;
    private String comp_end;
    private String bairro;
    private String cep;
    private String codigo_municipio;
    private String municipio;
    private String uf;
    private String telefone;
    private String celular;
    private String email;
    private String obs;
    private Date data_cadastro;
    private String cpf;
    private String rg;
    private String usuario;
    private String senha;
    private boolean excluido;
    private Date data_edicao;
    private Date data_exclusao;
    private Integer id_usuario_insercao;
    private Integer id_usuario_edicao;
    private Integer id_usuario_exclusao;

    public Funcionario() {

    }

    public Funcionario(Integer id, String nome, String endereco, String num_end, String comp_end, String bairro, String cep, String codigo_municipio, String municipio, String uf, String telefone, String celular, String email, String obs, Date data_cadastro, String cpf, String rg, String usuario, String senha, boolean excluido, Date data_edicao, Date data_exclusao, Integer id_usuario_insercao, Integer id_usuario_edicao, Integer id_usuario_exclusao) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.num_end = num_end;
        this.comp_end = comp_end;
        this.bairro = bairro;
        this.cep = cep;
        this.codigo_municipio = codigo_municipio;
        this.municipio = municipio;
        this.uf = uf;
        this.telefone = telefone;
        this.celular = celular;
        this.email = email;
        this.obs = obs;
        this.data_cadastro = data_cadastro;
        this.cpf = cpf;
        this.rg = rg;
        this.usuario = usuario;
        this.senha = senha;
        this.excluido = excluido;
        this.data_edicao = data_edicao;
        this.data_exclusao = data_exclusao;
        this.id_usuario_insercao = id_usuario_insercao;
        this.id_usuario_edicao = id_usuario_edicao;
        this.id_usuario_exclusao = id_usuario_exclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNum_end() {
        return num_end;
    }

    public void setNum_end(String num_end) {
        this.num_end = num_end;
    }

    public String getComp_end() {
        return comp_end;
    }

    public void setComp_end(String comp_end) {
        this.comp_end = comp_end;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCodigo_municipio() {
        return codigo_municipio;
    }

    public void setCodigo_municipio(String codigo_municipio) {
        this.codigo_municipio = codigo_municipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isExcluido() {
        return excluido;
    }

    public void setExcluido(boolean excluido) {
        this.excluido = excluido;
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

    @Override
    public String toString() {
        return id + " - " + nome;
    }

}
