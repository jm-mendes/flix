package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="classificacao")
public class Classificacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClassificacao;
    private String classificacao;

    public Classificacao() {
    }

    public Classificacao( String classificacao) {
        this.classificacao = classificacao;
    }

    public int getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(int idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

}
