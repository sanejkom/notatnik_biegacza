/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notebook.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mateusz
 */
public class UserTest {
    
    public UserTest() {
    }

    /**
     * Test of countMaxHR method, of class User.
     */
    @Test
    public void testCountMaxHR() {
        User instance = new User(70, 21);
        double expResult = 192.83;
        double result = instance.countMaxHR();
        assertEquals(expResult, result, 0.0);
    }
    
}
