package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name="portfolio")
public class Portfolio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVideo;
    private int idEpisodio,idTemporada, idSerie, idClassificacao, idCategoria;
    private int tipoConteudo;
    private String nome, nomeSerie, sinopse;
    private Date dataExpiracao;
    private int anoLancamento;
    private String duracao;

    public Portfolio() {
    }

    public Portfolio(int idEpisodio, int idTemporada, int idSerie, int idClassificacao, int idCategoria, int tipoConteudo, String nome, String nomeSerie, String sinopse, Date dataExpiracao, int anoLancamento, String duracao) {
        this.idEpisodio = idEpisodio;
        this.idTemporada = idTemporada;
        this.idSerie = idSerie;
        this.idClassificacao = idClassificacao;
        this.idCategoria = idCategoria;
        this.tipoConteudo = tipoConteudo;
        this.nome = nome;
        this.nomeSerie = nomeSerie;
        this.sinopse = sinopse;
        this.dataExpiracao = dataExpiracao;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public int getIdEpisodio() {
        return idEpisodio;
    }

    public void setIdEpisodio(int idEpisodio) {
        this.idEpisodio = idEpisodio;
    }

    public int getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(int idTemporada) {
        this.idTemporada = idTemporada;
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public int getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(int idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getTipoConteudo() {
        return tipoConteudo;
    }

    public void setTipoConteudo(int tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeSerie() {
        return nomeSerie;
    }

    public void setNomeSerie(String nomeSerie) {
        this.nomeSerie = nomeSerie;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
