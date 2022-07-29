package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tipoconteudo")
public class TipoConteudo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoConteudo;

    private String tipoConteudo;

    public TipoConteudo() {
    }

    public TipoConteudo(String tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }

    public int getIdTipoConteudo() {
        return idTipoConteudo;
    }

    public void setIdTipoConteudo(int idTipoConteudo) {
        this.idTipoConteudo = idTipoConteudo;
    }

    public String getTipoConteudo() {
        return tipoConteudo;
    }

    public void setTipoConteudo(String tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }
}
