package br.ufg.cs.model;

import java.util.Objects;

/**
 * Classe responsável por conter o Objeto Token
 *
 * @author Bianca Raissa
 * @author José Sérgio
 * @author Rafhael Augusto
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class Token {
    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.valor);
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
        final Token other = (Token) obj;
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Token{" + "valor=" + valor + '}';
    }
    
}
