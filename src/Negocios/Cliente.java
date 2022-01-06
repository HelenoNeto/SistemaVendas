package Negocios;

import java.util.Date;

public class Cliente {

    private Integer id;
    private String nome;
    private String apelido;
    private String cpf;
    private String rg;
    private String orgao_rg;
    private String cnpj;
    private String ie;
    private String tipo_pessoa;
    private String endereco;
    private String num_end;
    private String comp_end;
    private String bairro;
    private String cep;
    private String cod_municipio;
    private String municipio;
    private String uf;
    private String telefone;
    private String celular;
    private String obs;
    private String email;
    private Date data_nasc;
    private Date data_cadastro;
    private boolean excluido;
    private Date data_edicao;
    private Date data_exclusao;
    private Integer id_usuario_insercao;
    private Integer id_usuario_edicao;
    private Integer id_usuario_exclusao;
    private Integer quantidade_dias_visita;

    public Cliente(Integer id, String nome, String apelido, String cpf, String rg, String orgao_rg, String cnpj, String ie, String tipo_pessoa, String endereco, String num_end, String comp_end, String bairro, String cep, String cod_municipio, String municipio, String uf, String telefone, String celular, String obs, String email, Date data_nasc, Date data_cadastro, boolean excluido, Date data_edicao, Date data_exclusao, Integer id_usuario_insercao, Integer id_usuario_edicao, Integer id_usuario_exclusao, Integer quantidade_dias_visita) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.cpf = cpf;
        this.rg = rg;
        this.orgao_rg = orgao_rg;
        this.cnpj = cnpj;
        this.ie = ie;
        this.tipo_pessoa = tipo_pessoa;
        this.endereco = endereco;
        this.num_end = num_end;
        this.comp_end = comp_end;
        this.bairro = bairro;
        this.cep = cep;
        this.cod_municipio = cod_municipio;
        this.municipio = municipio;
        this.uf = uf;
        this.telefone = telefone;
        this.celular = celular;
        this.obs = obs;
        this.email = email;
        this.data_nasc = data_nasc;
        this.data_cadastro = data_cadastro;
        this.excluido = excluido;
        this.data_edicao = data_edicao;
        this.data_exclusao = data_exclusao;
        this.id_usuario_insercao = id_usuario_insercao;
        this.id_usuario_edicao = id_usuario_edicao;
        this.id_usuario_exclusao = id_usuario_exclusao;
        this.quantidade_dias_visita = quantidade_dias_visita;
    }

    public Cliente() {

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

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
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

    public String getOrgao_rg() {
        return orgao_rg;
    }

    public void setOrgao_rg(String orgao_rg) {
        this.orgao_rg = orgao_rg;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
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

    public String getCod_municipio() {
        return cod_municipio;
    }

    public void setCod_municipio(String cod_municipio) {
        this.cod_municipio = cod_municipio;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
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

    public Integer getQuantidade_dias_visita() {
        return quantidade_dias_visita;
    }

    public void setQuantidade_dias_visita(Integer quantidade_dias_visita) {
        this.quantidade_dias_visita = quantidade_dias_visita;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }

}
