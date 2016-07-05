/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.br.ufg.cs.util;

import br.ufg.cs.util.Miscelanea;
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
public class MiscelaneaTest {
    
    public MiscelaneaTest() {
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
     * Test of getInstance method, of class Miscelanea.
     */
    @org.junit.Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Miscelanea expResult = null;
        Miscelanea result = Miscelanea.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MD5 method, of class Miscelanea.
     */
    @org.junit.Test
    public void testMD5() {
        System.out.println("MD5");
        String value = "";
        Miscelanea instance = new Miscelanea();
        String expResult = "";
        String result = instance.MD5(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
