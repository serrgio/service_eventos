package br.ufg.cs.util;

/**
 * Created by José Sergio on 16/06/2016.
 */
public class Login extends Conexao {

    private static Login instance;

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }
}
