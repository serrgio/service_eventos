/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.br.ufg.cs.util;

import br.ufg.cs.util.Conexao;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author serrg
 */
public class ConexaoTest {
    
    public ConexaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class Conexao.
     */
    @org.junit.Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Conexao expResult = null;
        Conexao result = Conexao.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Conectar method, of class Conexao.
     */
    @org.junit.Test
    public void testConectar() {
        System.out.println("Conectar");
        Conexao instance = new Conexao();
        Connection expResult = null;
        Connection result = instance.Conectar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
