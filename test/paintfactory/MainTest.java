/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintfactory;

import static java.util.Arrays.asList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luke
 */
public class MainTest {
    
    public MainTest() {
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
     * Test of readFile method, of class Main.
     */
    @Test
    public void testReadFile() {//2 Cases,both Valid - Tests Successful input & output
        System.out.println("readFile & getOrders");
        String o = "test.txt";
        Main instance = new Main();
        List expResult = asList(2, 5, 3, 1, 1, 1, 2, 3, 0, 2, 0, 1, 5, 0, 3, 2, 1, 3, 0, 1, 2, 1);
        List result = instance.readFile(o);
        
        instance.getOrders(expResult);//Prints successful cases in correct format
        assertEquals(expResult, result);
    }
}
