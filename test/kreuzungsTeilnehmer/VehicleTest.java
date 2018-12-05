/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kreuzungsTeilnehmer;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ba Tue Freddy Tran
 */
public class VehicleTest {
    
    public VehicleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getName method, of class Vehicle.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Vehicle instance = new Vehicle();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Vehicle.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "TestVehicleName";
        Vehicle instance = new Vehicle();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("TestVehicleName", instance.getName());
    }

    /**
     * Test of getPosition method, of class Vehicle.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Vehicle instance = new Vehicle();
        int expResult = 0;
        int result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Vehicle.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int position = 0;
        Vehicle instance = new Vehicle();
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals("Position stimmt nicht",0,instance.getPosition());
    }

    /**
     * Test of getIntention method, of class Vehicle.
     */
    @Test
    public void testGetIntention() {
        System.out.println("getIntention");
        Vehicle instance = new Vehicle();
        int expResult = 0;
        int result = instance.getIntention();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIntention method, of class Vehicle.
     */
    @Test
    public void testSetIntention() {
        System.out.println("setIntention");
        int intention = 0;
        Vehicle instance = new Vehicle();
        instance.setIntention(intention);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(0,instance.getIntention());
    }

    /**
     * Test of toString method, of class Vehicle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vehicle instance = new Vehicle();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class Vehicle.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Vehicle instance = new Vehicle();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentState method, of class Vehicle.
     */
    @Test
    public void testGetCurrentState() {
        System.out.println("getCurrentState");
        Vehicle instance = new Vehicle();
        Vehicle.STATE expResult = null;
        Vehicle.STATE result = instance.getCurrentState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentState method, of class Vehicle.
     */
    @Test
    public void testSetCurrentState() {
        System.out.println("setCurrentState");
        Vehicle.STATE currentState = Vehicle.STATE.FAEHRT;
        Vehicle instance = new Vehicle();
        instance.setCurrentState(currentState);
        
        assertEquals(Vehicle.STATE.FAEHRT, instance.getCurrentState());
        
    }
    
}
