package br.ufg.cs.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Created by José Sergio on 09/06/2016.
 */
public class Usuario {
    private Long id;
    private String nome;
    private String senha;
    private String email;
    private Date dtNascimento;
    private ArrayList<Endereco> lstEndereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public ArrayList<Endereco> getLstEndereco() {
        return lstEndereco;
    }

    public void setLstEndereco(ArrayList<Endereco> lstEndereco) {
        this.lstEndereco = lstEndereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.senha);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.dtNascimento);
        hash = 97 * hash + Objects.hashCode(this.lstEndereco);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dtNascimento, other.dtNascimento)) {
            return false;
        }
        if (!Objects.equals(this.lstEndereco, other.lstEndereco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", dtNascimento=" + dtNascimento + ", lstEndereco=" + lstEndereco + '}';
    }
    
}
