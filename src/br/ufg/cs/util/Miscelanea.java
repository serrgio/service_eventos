package br.ufg.cs.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe respons�vel por conter os as fun��es referentes a Miscelanea
 *
 * @author Jos� S�rgio de Souza
 * @date 30/06/2016 08:51:43
 * @version 1.0
 */
public class Miscelanea {

    private static Miscelanea instance;

    /**
     *
     * M�todo respons�vel por criar uma instancia da classe
     *
     * @return
     * @author Jos� S�rgio de Souza
     * @date 30/06/2016 08:51:43
     * @version 1.0
     */
    public static Miscelanea getInstance() {
        if (instance == null) {
            instance = new Miscelanea();
        }
        return instance;
    }

    public String MD5(String value) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(value.getBytes());
        BigInteger bigInteger = new BigInteger(1, md5.digest());
        String sHash = bigInteger.toString(16).toUpperCase();
        while (sHash.length() < 32) {
            sHash = "0" + sHash;
        }
        return sHash;
    }
}
