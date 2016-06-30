package br.ufg.cs.controller;

import br.ufg.cs.model.Evento;
import java.sql.SQLException;

/**
 * Created by José Sergio on 16/06/2016.
 */
public class CtrEvento {

    public boolean InsertEvento(String token, Evento objEvento) throws SQLException {
        return true;
    }

    public Evento GetEvento(String token, int idEvento) throws SQLException {
        return null;
    }

    public boolean UpdateEvento(String token, Evento objEvento) throws SQLException {
        return true;
    }

    public boolean DeleteEvento(String token, Integer idEvento) throws SQLException {
        return true;
    }
}
