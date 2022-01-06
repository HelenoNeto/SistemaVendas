package Negocios;

public class Municipios {

    private int id;
    private String uf;
    private String nome;
    private String codigo_uf;
    private String codigo_pais;
    private String codigo_cidade;

    public String getCodigo_cidade() {
        return codigo_cidade;
    }

    public void setCodigo_cidade(String codigo_cidade) {
        this.codigo_cidade = codigo_cidade;
    }

    public String getCodigo_pais() {
        return codigo_pais;
    }

    public void setCodigo_pais(String codigo_pais) {
        this.codigo_pais = codigo_pais;
    }

    public String getCodigo_uf() {
        return codigo_uf;
    }

    public void setCodigo_uf(String codigo_uf) {
        this.codigo_uf = codigo_uf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
