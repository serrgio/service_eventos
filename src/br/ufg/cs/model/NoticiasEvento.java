package br.ufg.cs.model;

import java.util.Date;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Classe responsável por conter o Objeto NoticiasEvento
 *
 * @author José Sérgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
@XmlRootElement
public class NoticiasEvento {
    private Integer id;
    private Integer idEvento;
    private Integer idUsuario;
    private Date dtCadastro;
    private String sTitulo;
    private String sDescricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getsTitulo() {
        return sTitulo;
    }

    public void setsTitulo(String sTitulo) {
        this.sTitulo = sTitulo;
    }

    public String getsDescricao() {
        return sDescricao;
    }

    public void setsDescricao(String sDescricao) {
        this.sDescricao = sDescricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.idEvento);
        hash = 23 * hash + Objects.hashCode(this.idUsuario);
        hash = 23 * hash + Objects.hashCode(this.dtCadastro);
        hash = 23 * hash + Objects.hashCode(this.sTitulo);
        hash = 23 * hash + Objects.hashCode(this.sDescricao);
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
        final NoticiasEvento other = (NoticiasEvento) obj;
        if (!Objects.equals(this.sTitulo, other.sTitulo)) {
            return false;
        }
        if (!Objects.equals(this.sDescricao, other.sDescricao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idEvento, other.idEvento)) {
            return false;
        }
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        if (!Objects.equals(this.dtCadastro, other.dtCadastro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NoticiasEvento{" + "id=" + id + ", idEvento=" + idEvento + ", idUsuario=" + idUsuario + ", dtCadastro=" + dtCadastro + ", sTitulo=" + sTitulo + ", sDescricao=" + sDescricao + '}';
    }
   
}
