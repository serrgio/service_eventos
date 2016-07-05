/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.br.ufg.cs.util;

import br.ufg.cs.util.Login;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author serrg
 */
public class LoginTest {
    
    public LoginTest() {
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
     * Test of getInstance method, of class Login.
     */
    @org.junit.Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Login expResult = null;
        Login result = Login.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Logar method, of class Login.
     */
    @org.junit.Test
    public void testLogar() throws Exception {
        System.out.println("Logar");
        String email = "";
        String senha = "";
        Login instance = new Login();
        String expResult = "";
        String result = instance.Logar(email, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
