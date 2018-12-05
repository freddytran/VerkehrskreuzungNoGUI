/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import kreuzungsTeilnehmer.Auto;
import kreuzungsTeilnehmer.Vehicle;
import kreuzung.Kreuzung;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Ba Tue Freddy Tran
 */
public class KreuzungTest {
    
    public KreuzungTest() {
    }
    ArrayList<Vehicle>Verkehrsteilnehmer;
    @BeforeClass
    public static void setUpClass() {
       ArrayList<Vehicle>Verkehrsteilnehmer = new ArrayList<>();
       Kreuzung kreuzung = new Kreuzung();
       Auto autoNordSued = new Auto();
       Auto autoOstWest = new Auto();
       Auto autoOstNord = new Auto();
       
       autoNordSued.setName("A1NordSued");
       autoNordSued.setPosition(0);
       autoNordSued.setIntention(2);
       autoNordSued.setCurrentState(Vehicle.STATE.WARTET_AMPEL);
       
       autoOstWest.setName("A2OstWest");
       autoOstWest.setPosition(3);
       autoOstWest.setIntention(1);
       autoOstWest.setCurrentState(Vehicle.STATE.WARTET_AMPEL);
       
       autoOstNord.setName("A3OstNord");
       autoOstNord.setPosition(3);
       autoOstNord.setIntention(0);
       autoOstNord.setCurrentState(Vehicle.STATE.WARTET_AMPEL);
       
       kreuzung.addBeobachter(autoNordSued);
       kreuzung.addBeobachter(autoOstWest);
       kreuzung.addBeobachter(autoOstNord);
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of toString method, of class Kreuzung.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Kreuzung instance = new Kreuzung();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString2 method, of class Kreuzung.
     */
    @Test
    public void testToString2() {
        System.out.println("toString2");
        Kreuzung instance = new Kreuzung();
        String expResult = "";
        String result = instance.toString2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBeobachter method, of class Kreuzung.
     */
    @Test
    public void testAddBeobachter() {
        System.out.println("addBeobachter");
        Kreuzung instance = new Kreuzung();
        
        // TODO review the generated test code and remove the default call to fail.
       fail("fail");
    }

    /**
     * Test of removeBeobachter method, of class Kreuzung.
     */
    @Test
    public void testRemoveBeobachter() {
        System.out.println("removeBeobachter");
        Vehicle vehicle = null;
        Kreuzung instance = new Kreuzung();
        instance.removeBeobachter(vehicle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyAlleBeobachter method, of class Kreuzung.
     */
    @Test
    public void testNotifyAlleBeobachter() {
        System.out.println("notifyAlleBeobachter");
        Kreuzung instance = new Kreuzung();
        
        // TODO review the generated test code and remove the default call to fail.
       ArrayList<Vehicle>Verkehrsteilnehmer = new ArrayList<>();
       Auto autoNordSued = new Auto();
       Auto autoOstWest = new Auto();
       Auto autoOstNord = new Auto();
       
       autoNordSued.setName("A1NordSued");
       autoNordSued.setPosition(0);
       autoNordSued.setIntention(2);
       autoNordSued.setCurrentState(Vehicle.STATE.WARTET_AMPEL);
       
       autoOstWest.setName("A2OstWest");
       autoOstWest.setPosition(3);
       autoOstWest.setIntention(1);
       autoOstWest.setCurrentState(Vehicle.STATE.WARTET_AMPEL);
       
       autoOstNord.setName("A3OstNord");
       autoOstNord.setPosition(3);
       autoOstNord.setIntention(0);
       autoOstNord.setCurrentState(Vehicle.STATE.WARTET_AMPEL);
       
       instance.addBeobachter(autoNordSued);
       instance.addBeobachter(autoOstWest);
       instance.addBeobachter(autoOstNord);
       
       instance.notifyAlleBeobachter();
        // TODO review the generated test code and remove the default call to fail.
       //assertEquals("Falsche Anzahl",0,Verkehrsteilnehmer.size());
       assertTrue(Verkehrsteilnehmer.isEmpty());
    }

    /**
     * Test of getAutoAmpel method, of class Kreuzung.
     */
    @Test
    public void testGetAutoAmpel() {
        System.out.println("getAutoAmpel");
        int expResult = 0;
        int result = Kreuzung.getAutoAmpel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAutoAmpel method, of class Kreuzung.
     */
    @Test
    public void testSetAutoAmpel() {
        System.out.println("setAutoAmpel");
        int aAutoAmpel = 0;
        Kreuzung.setAutoAmpel(aAutoAmpel);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(0, Kreuzung.getAutoAmpel());
    }

    /**
     * Test of NordSuedGruen method, of class Kreuzung.
     */
    @Test
    public void testNordSuedGruen() {
       System.out.println("NordSuedGruen");
       Kreuzung instance = new Kreuzung();
       instance.NordSuedGruen();
       
       assertTrue(Verkehrsteilnehmer.size()>0);
    }

    /**
     * Test of WestOstGruen method, of class Kreuzung.
     */
    @Test
    public void testWestOstGruen() {
        System.out.println("WestOstGruen");
        Kreuzung instance = new Kreuzung();
        instance.WestOstGruen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verkehrsRegel method, of class Kreuzung.
     */
    @Test
    public void testVerkehrsRegel() {
        System.out.println("verkehrsRegel");
        Kreuzung instance = new Kreuzung();
        instance.verkehrsRegel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkFussOstStrasse method, of class Kreuzung.
     */
    @Test
    public void testCheckFussOstStrasse() {
        System.out.println("checkFussOstStrasse");
        Kreuzung instance = new Kreuzung();
        int expResult = 0;
        int result = instance.checkFussOstStrasse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkFussNordStrasse method, of class Kreuzung.
     */
    @Test
    public void testCheckFussNordStrasse() {
        System.out.println("checkFussNordStrasse");
        Kreuzung instance = new Kreuzung();
        int expResult = 0;
        int result = instance.checkFussNordStrasse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkFussWestStrasse method, of class Kreuzung.
     */
    @Test
    public void testCheckFussWestStrasse() {
        System.out.println("checkFussWestStrasse");
        Kreuzung instance = new Kreuzung();
        int expResult = 0;
        int result = instance.checkFussWestStrasse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkFussSuedStrasse method, of class Kreuzung.
     */
    @Test
    public void testCheckFussSuedStrasse() {
        System.out.println("checkFussSuedStrasse");
        Kreuzung instance = new Kreuzung();
        int expResult = 0;
        int result = instance.checkFussSuedStrasse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkNordGeradeAusFahrer method, of class Kreuzung.
     */
    @Test
    public void testCheckNordGeradeAusFahrer() {
        System.out.println("checkNordGeradeAusFahrer");
        Kreuzung instance = new Kreuzung();
        int expResult = 0;
        int result = instance.checkNordGeradeAusFahrer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkSuedGeradeAusFahrer method, of class Kreuzung.
     */
    @Test
    public void testCheckSuedGeradeAusFahrer() {
        System.out.println("checkSuedGeradeAusFahrer");
        Kreuzung instance = new Kreuzung();
        int expResult = 0;
        int result = instance.checkSuedGeradeAusFahrer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkWestGeradeAusFahrer method, of class Kreuzung.
     */
    @Test
    public void testCheckWestGeradeAusFahrer() {
        System.out.println("checkWestGeradeAusFahrer");
        Kreuzung instance = new Kreuzung();
        int expResult = 0;
        int result = instance.checkWestGeradeAusFahrer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkOstGeradeAusFahrer method, of class Kreuzung.
     */
    @Test
    public void testCheckOstGeradeAusFahrer() {
        System.out.println("checkOstGeradeAusFahrer");
        Kreuzung instance = new Kreuzung();
        int expResult = 0;
        int result = instance.checkOstGeradeAusFahrer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of firstDrive method, of class Kreuzung.
     */
    @Test
    public void testFirstDrive() {
        System.out.println("firstDrive");
        Kreuzung instance = new Kreuzung();
        instance.firstDrive();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of secondDrive method, of class Kreuzung.
     */
    @Test
    public void testSecondDrive() {
        System.out.println("secondDrive");
        Kreuzung instance = new Kreuzung();
        instance.secondDrive();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
