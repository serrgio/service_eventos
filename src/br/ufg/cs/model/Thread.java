package br.ufg.cs.model;

import java.util.Date;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe respons�vel por conter o Objeto Thread
 *
 * @author Bianca Raissa
 * @author Jos� S�rgio
 * @author Rafhael Augusto
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
@XmlRootElement
public class Thread {

    private Integer id;
    private Integer idUsuario;
    private Date dtCriacao;
    private Date dtAlteracao;
    private String sToken;
    private int perfil;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }

    public String getsToken() {
        return sToken;
    }

    public void setsToken(String sToken) {
        this.sToken = sToken;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.idUsuario);
        hash = 71 * hash + Objects.hashCode(this.dtCriacao);
        hash = 71 * hash + Objects.hashCode(this.dtAlteracao);
        hash = 71 * hash + Objects.hashCode(this.sToken);
        hash = 71 * hash + this.perfil;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Thread other = (Thread) obj;
        if (this.perfil != other.perfil) {
            return false;
        }
        if (!Objects.equals(this.sToken, other.sToken)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        if (!Objects.equals(this.dtCriacao, other.dtCriacao)) {
            return false;
        }
        return Objects.equals(this.dtAlteracao, other.dtAlteracao);
    }

    @Override
    public String toString() {
        return "Thread{" + "id=" + id + ", idUsuario=" + idUsuario + ", dtCriacao=" + dtCriacao + ", dtAlteracao=" + dtAlteracao + ", sToken=" + sToken + ", perfil=" + perfil + '}';
    }

}
