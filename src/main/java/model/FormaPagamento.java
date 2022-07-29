package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="formapagamento")
public class FormaPagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormaPagamento;
    private String formaPagamento;

    public FormaPagamento() {
    }

    public FormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(int idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
