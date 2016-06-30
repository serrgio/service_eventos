package br.ufg.cs.controller;

import br.ufg.cs.model.Evento;
import java.sql.SQLException;

/**
 * Created by José Sergio on 16/06/2016.
 */
public class CtrEvento {

    public boolean InsertEvento(Evento objEvento) throws SQLException {
        return true;
    }

    public Evento GetEvento(String token) throws SQLException {
        return null;
    }

    public boolean UpdateEvento(Evento objEvento) throws SQLException {
        return true;
    }

    public boolean DeleteEvento(Integer idEvento) throws SQLException {
        return true;
    }
}
