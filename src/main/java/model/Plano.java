package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="plano")
public class Plano implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlano;
    private String plano;

    public Plano() {
    }

    public Plano(String plano) {
        this.plano = plano;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

}
