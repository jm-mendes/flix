package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private int formaPagamento;
    private String email;
    private String nomeUsuario;
    private int plano;

    public Usuario() {
    }

    public Usuario(int formaPagamento, String email, String nomeUsuario, int plano) {
        this.formaPagamento = formaPagamento;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.plano = plano;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getPlano() {
        return plano;
    }

    public void setPlano(int plano) {
        this.plano = plano;
    }
}
