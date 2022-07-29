package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

    @Id
    private int idPerfil;
    @Id
    private int idUsuario;
    private String nickName;
    private boolean kids_profile;

    public Perfil() {
    }

    public Perfil(int idPerfil, int idUsuario, String nickName, boolean kids_profile) {
        this.idPerfil = idPerfil;
        this.idUsuario = idUsuario;
        this.nickName = nickName;
        this.kids_profile = kids_profile;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isKids_profile() {
        return kids_profile;
    }

    public void setKids_profile(boolean kids_profile) {
        this.kids_profile = kids_profile;
    }
}

