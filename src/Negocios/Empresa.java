package Negocios;

import java.io.Serializable;
import java.util.Date;

public class Empresa implements Serializable {

    private int id;
    private Date data_cadastro;
    private String razao_social;
    private String nome_fantasia;
    private String endereco;
    private String num_end;
    private String comp_end;
    private String bairro;
    private String cod_municipio;
    private String municipio;
    private String uf;
    private String cep;
    private String telefone;
    private String pais;
    private String cod_pais;
    private String tipo_documento;
    private String cnpj;
    private String ie;
    private String cpf;
    private String rg;
    private String email;

    public Empresa() {

    }

    public Empresa(Integer id, Date data_cadastro, String razao_social, String nome_fantasia,
            String endereco, String num_end, String comp_end, String bairro, String cod_municipio,
            String municipio, String uf, String cep, String telefone, String pais, String cod_pais,
            String tipo_documento, String cnpj, String ie, String cpf, String rg, String email) {
        this.id = id;
        this.data_cadastro = data_cadastro;
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.endereco = endereco;
        this.num_end = num_end;
        this.comp_end = comp_end;
        this.bairro = bairro;
        this.cod_municipio = cod_municipio;
        this.municipio = municipio;
        this.uf = uf;
        this.cep = cep;
        this.telefone = telefone;
        this.pais = pais;
        this.cod_pais = cod_pais;
        this.tipo_documento = tipo_documento;
        this.cnpj = cnpj;
        this.ie = ie;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(String cod_pais) {
        this.cod_pais = cod_pais;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", data_cadastro=" + data_cadastro + ", razao_social=" + razao_social + ", nome_fantasia=" + nome_fantasia + ", endereco=" + endereco + ", num_end=" + num_end + ", comp_end=" + comp_end + ", bairro=" + bairro + ", cod_municipio=" + cod_municipio + ", municipio=" + municipio + ", uf=" + uf + ", cep=" + cep + ", telefone=" + telefone + ", pais=" + pais + ", cod_pais=" + cod_pais + ", tipo_documento=" + tipo_documento + ", cnpj=" + cnpj + ", ie=" + ie + ", cpf=" + cpf + ", rg=" + rg + ", email=" + email + '}';
    }

}
