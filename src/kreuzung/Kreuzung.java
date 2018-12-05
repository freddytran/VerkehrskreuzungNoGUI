package kreuzung;

/**
 *
 * @author Ba Tue Freddy Tran
 */
import kreuzungsTeilnehmer.Vehicle;
import java.util.ArrayList;

public class Kreuzung implements Verkehrskreuzung{
    
    protected static ArrayList<Vehicle>Verkehrsteilnehmer = new ArrayList<>();
    private static ArrayList<Vehicle>WarteListe = new ArrayList<>();
    
    private static int autoAmpel;

    @Override
    public String toString() {
        if(Verkehrsteilnehmer.isEmpty() == true){
            System.out.println("An den Ampeln steht jetzt niemand mehr.");
        }else{
            for(int i = 0; i < Kreuzung.Verkehrsteilnehmer.size(); i++){
                System.out.println(Kreuzung.Verkehrsteilnehmer.get(i).toString());
            }
        }    
        
        return "";
    }
    
    public String toString2() {
        if(WarteListe.isEmpty() == true){
            System.out.println("WarteListe ist jetzt leer");
        }else{
            for(int i = 0; i < Kreuzung.WarteListe.size(); i++){
                System.out.println(Kreuzung.WarteListe.get(i).toString());
            }
        }
        
        return "";
    }

    @Override
    public void addBeobachter(Vehicle vehicle) {
        Verkehrsteilnehmer.add(vehicle);
    }

    @Override
    public void removeBeobachter(Vehicle vehicle) {
        Verkehrsteilnehmer.remove(vehicle);
    }
    
    /**
     * Hier wird die statische ArrayList mit den Verkehrsteilnehmer durchlaufen
     * und bei jedem Durchlauf wird die Methode update() von der Vehicle - Klasse
     * aufgerufen.
     */
    @Override
    public void notifyAlleBeobachter() {
         
        if(Verkehrsteilnehmer.isEmpty() == true){
            System.out.println("Liste ist jetzt leer.Probeee");
        }else{
            Verkehrsteilnehmer.get(0).update();
        }
        /*for(int i = 0; i < Verkehrsteilnehmer.size(); i++){
            System.out.println("Anzahl der Durchläufe: " + i);
            Verkehrsteilnehmer.get(i).update();
            //System.out.println(this.Verkehrsteilnehmer.size());
        }*/
    }

    /**
     * @return the autoAmpel 
     */
    public static synchronized int getAutoAmpel() {
        return autoAmpel;
    }

    /**
     * @param aAutoAmpel the autoAmpel to set
     */
    public static synchronized void setAutoAmpel(int aAutoAmpel) {
        autoAmpel = aAutoAmpel;
    }
    
    /**
     *  Methode die aufgerufen wird, wenn das NordSüd - Ampelpaar grün ist.
     */
    public void NordSuedGruen(){
        System.out.println("----------------------------------NORDSÜD AMPEL GRÜN-----------------------------------------");
        int i = 0;
        if(Verkehrsteilnehmer.isEmpty() == true){
            System.out.println("Liste ist leer NORDSUED.");
        }
        while(i < Verkehrsteilnehmer.size() && Verkehrsteilnehmer.isEmpty() ==  false){
            if(Verkehrsteilnehmer.get(i).getPosition() == 0 ||
                Verkehrsteilnehmer.get(i).getPosition() == 2 || 
                Verkehrsteilnehmer.get(i).getIntention() == 12 ||
                Verkehrsteilnehmer.get(i).getIntention() == 13)     {
                
                    System.out.println(Verkehrsteilnehmer.get(i).getName() + " will nach " +
                       Verkehrsteilnehmer.get(i).getIntention());
                    
                    WarteListe.add(Verkehrsteilnehmer.get(i));
                    Verkehrsteilnehmer.remove(i);
                    i = 0;
            }else{
                i++;
            }
        }
        
        this.toString();
        System.out.println("+++++++++++++++++WarteListe wird ausgegeben.+++++++++++++++");
        this.toString2();
        System.out.println("+++++++++++WarteLste ist fertig ausgegeben++++++++++++++++++");
        System.out.println("");
        this.verkehrsRegel();
        System.out.println("***********************Ende der Ausgabe**********************");
        this.toString2();
        
        firstDrive();
        secondDrive();
    }
    
    /**
     * Methode die aufgerufen wird, wenn das WestOst - Ampelpaar grün ist.
     */
    public void WestOstGruen(){
        System.out.println("--------------------------------------WESTOST AMPEL GRÜN------------------------------------");
        int i = 0;
        if(Verkehrsteilnehmer.isEmpty() == true){
            System.out.println("Liste ist leer WESTOST.");
        }
        while(i < Verkehrsteilnehmer.size() && Verkehrsteilnehmer.isEmpty() ==  false){
            if(Verkehrsteilnehmer.get(i).getPosition() == 1 ||
                Verkehrsteilnehmer.get(i).getPosition() == 3 || 
                Verkehrsteilnehmer.get(i).getIntention() == 10 ||
                Verkehrsteilnehmer.get(i).getIntention() == 11)     {
                
                    System.out.println(Verkehrsteilnehmer.get(i).getName() + " will nach " +
                       Verkehrsteilnehmer.get(i).getIntention());
                    
                    WarteListe.add(Verkehrsteilnehmer.get(i));
                    Verkehrsteilnehmer.remove(i);
                    i = 0;
            }else{
                i++;
            }
        }
        
        this.toString();
        System.out.println("++++++++++++++++++++WarteListe wird ausgegeben.+++++++++++++++++");
        
        System.out.println("++++++++++++++++WarteLste ist fertig ausgegeben++++++++++++++++");
        System.out.println("");
        this.verkehrsRegel();
        this.toString2();
        System.out.println("*************************Ende der Ausgabe*********************");
        this.toString2();
        
        firstDrive();
        secondDrive();
    }
    
    /**
     * Methode, die alle nötigen Verkehrsregeln abarbeitet.
     */
    public synchronized void verkehrsRegel(){        
        int weststreet;
        int eaststreet;
        int northstreet;
        int southstreet;
        int northStraight;
        int southStraight;
        int westStraight;
        int eastStraight;
        
        //Check für Fussgaenger an einzelnen Straßen
        weststreet = checkFussWestStrasse();
        eaststreet = checkFussOstStrasse();
        northstreet = checkFussNordStrasse();
        southstreet = checkFussSuedStrasse();
        
        //Check für Fahrer die Gerade aus fahren wollen.
        northStraight = checkNordGeradeAusFahrer();
        southStraight = checkSuedGeradeAusFahrer();
        westStraight = checkWestGeradeAusFahrer();
        eastStraight = checkOstGeradeAusFahrer();
        
        
        if(WarteListe.isEmpty()){
            System.out.println("Liste LEER");
        }
        
        int i = 0;
        while(i < WarteListe.size()){
            
            //NORDEN NACH SÜDEN
            if(WarteListe.get(i).getPosition() == 0 && WarteListe.get(i).getIntention() == 5){
                System.out.println(WarteListe.get(i).getName() + " will gerade aus");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            //NORDEN NACH OSTEN  - 1.FALL: es existieren Fussgaenger die im Weg sind.
            if(WarteListe.get(i).getPosition() == 0 && WarteListe.get(i).getIntention() == 6 && eaststreet > 0){
                System.out.println(WarteListe.get(i).getName() + " will Rechts abbiegen, aber auf Fussgaenger warten");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.WARTET_KREUZUNG); 
            }
            
            //NORDEN NACH OSTEN - 2.FALL: keine Fussgaenger im Weg.
            if(WarteListe.get(i).getPosition() == 0 && WarteListe.get(i).getIntention() == 6 && eaststreet == 0){
                System.out.println(WarteListe.get(i).getName() + " will rechts abbiegen, alles frei kann sofort fahren.");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT); 
            }
            
            //NORDEN NACH WESTEN - 1.FALL: Alles frei, kann sofort fahren.
            if(WarteListe.get(i).getPosition() == 0 && WarteListe.get(i).getIntention() == 7
                    && (weststreet == 0 && southStraight == 0)){
                System.out.println(WarteListe.get(i).getName() + " will Links abbiegen, alles Frei kann sofort Fahren.");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            //NORDEN NACH WESTEN - 2.FALL: Ist entweder Auto oder Fussgaenger im Weg
            if(WarteListe.get(i).getPosition() == 0 && WarteListe.get(i).getIntention() == 7
                    && (weststreet > 0 || southStraight > 0)){
                System.out.println(WarteListe.get(i).getName() + " will Links abbiegen, muss aber warten.");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.WARTET_KREUZUNG);
            }
            
            //WESTEN NACH OSTEN
            if(WarteListe.get(i).getPosition() == 1 && WarteListe.get(i).getIntention() == 5){
                System.out.println(WarteListe.get(i).getName() + " will gerade aus");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            //WESTEN NACH NORDEN - 1. FALL: Fussgaenger im Weg
            if(WarteListe.get(i).getPosition() == 1 && WarteListe.get(i).getIntention() == 6 && northstreet > 0){
                System.out.println(WarteListe.get(i).getName() + " will Rechts abbiegen, aber auf Fussgaenger warten");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.WARTET_KREUZUNG);
            }
            
            //WESTEN NACH NORDEN - 2. FALL: keine Fussgaenger im Weg
            if(WarteListe.get(i).getPosition() == 1 && WarteListe.get(i).getIntention() == 6 && northstreet == 0){
                System.out.println(WarteListe.get(i).getName() + " will rechts abbiegen, alles frei kann sofort fahren.");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            //WESTEN NACH SÜDEN - 1.FAll: alles Frei, kann sofort fahren.
            if(WarteListe.get(i).getPosition() == 1 && WarteListe.get(i).getIntention() == 7 &&
                    (southstreet == 0 && eastStraight == 0)){
                System.out.println(WarteListe.get(i).getName() + " will Links abbiegen, alles frei, kann sofort Fahren.");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            //WESTEN NACH SÜDEN - 2.FAll: Ist entweder Auto oder Fussgaenger im Weg
            if(WarteListe.get(i).getPosition() == 1 && WarteListe.get(i).getIntention() == 7 &&
                    (southstreet > 0 || eastStraight > 0)){
                System.out.println(WarteListe.get(i).getName() + "Links abbiegen, muss aber noch warten.");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.WARTET_KREUZUNG);
            }
            
            //SÜDEN NACH NORDEN
            if(WarteListe.get(i).getPosition() == 2 && WarteListe.get(i).getIntention() == 5){
                System.out.println(WarteListe.get(i).getName() + " will gerade aus fahren");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            //SÜDEN NACH WESTEN - 1. FALL: Fussgaenger im Weg
            if(WarteListe.get(i).getPosition() == 2 && WarteListe.get(i).getIntention() == 6 && weststreet > 0){
                System.out.println(WarteListe.get(i).getName() + " will Rechts abbiegen, aber muss auf Fussgaenger warten");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.WARTET_KREUZUNG);
            }
            
            //SÜDEN NACH WESTEN - 2. FALL: keine Fussgaenger im Weg
            if(WarteListe.get(i).getPosition() == 2 && WarteListe.get(i).getIntention() == 6 && weststreet == 0){
                System.out.println(WarteListe.get(i).getName() + "will rechts abbiegen, alles frei, kann sofort fahren");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            //SÜDEN NACH OSTEN - 1.FAll: alles frei, kann sofort fahren.
            if(WarteListe.get(i).getPosition() == 2 && WarteListe.get(i).getIntention() == 7
                    && (eaststreet == 0 && northStraight == 0)){
                System.out.println(WarteListe.get(i).getName() + " will Links abbiegen, alles frei, kann sofort fahren.");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            //SÜDEN NACH OSTEN - 2.FAll: Entweder Auto oder Fussgaenger im Weg.
            if(WarteListe.get(i).getPosition() == 2 && WarteListe.get(i).getIntention() == 7
                    && (eaststreet > 0 || northStraight > 0)){
                System.out.println(WarteListe.get(i).getName() + " will Links abbiegen, muss aber noch warten");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.WARTET_KREUZUNG);
            }
            
            //OSTEN NACH WESTEN
            if(WarteListe.get(i).getPosition() == 3 && WarteListe.get(i).getIntention() == 5){
                System.out.println(WarteListe.get(i).getName() + " will gerade aus fahren");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            //OSTEN NACH SÜDEN - 1.FALL: Fussgaenger im Weg
            if(WarteListe.get(i).getPosition() == 3 && WarteListe.get(i).getIntention() == 6 && southstreet > 0){
                System.out.println(WarteListe.get(i).getName() + " will Rechts abbiegen, aber auf Fussgaenger warten");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.WARTET_KREUZUNG);
            }
            
            //OSTEN NACH SÜDEN - 1.FALL: Fussgaenger im Weg
            if(WarteListe.get(i).getPosition() == 3 && WarteListe.get(i).getIntention() == 6 && southstreet == 0){
                System.out.println(WarteListe.get(i).getName() + " will rechts abbiegen, alles frei, kann sofort fahren");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            //OSTEN NACH NORDEN - 1.FALL: alles frei, kann sofort fahren.
            if(WarteListe.get(i).getPosition() == 3 && WarteListe.get(i).getIntention() == 7 &&
                    (northstreet == 0 && westStraight == 0)){
                System.out.println( WarteListe.get(i).getName() + " will Links abbiegen, alles frei, kann sofort fahren.");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            //OSTEN NACH NORDEN - 2.FALL: Entweder Auto oder Fussgaenger im Weg.
            if(WarteListe.get(i).getPosition() == 3 && WarteListe.get(i).getIntention() == 7 &&
                    (northstreet > 0 || westStraight > 0)){
                System.out.println(WarteListe.get(i).getName() + " will Links abbiegen, muss aber noch warten.");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.WARTET_KREUZUNG);
            }
            
            //FUßGAENGER DIE DIE OST- ODER WESTSTRASSE ÜBERQUEREN WOLLEN
            if(WarteListe.get(i).getIntention() == 10 || WarteListe.get(i).getIntention() == 11
                    || WarteListe.get(i).getIntention() == 12 || WarteListe.get(i).getIntention() == 13){
                System.out.println(WarteListe.get(i).getName() + " will Straße überqueren");
                WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            }
            
            i++;
        }
        
    }
    
    /**
     * Anzahl der Fussgaenger die, die Oststraße überqueren wollen.
     * @return counterFuss
     */
    public int checkFussOstStrasse(){
       int counterFuss = 0;
        for(int i = 0; i < WarteListe.size(); i++){
            if(WarteListe.get(i).getPosition() == 20 || WarteListe.get(i).getPosition() == 23 &&
                    WarteListe.get(i).getIntention() == 12 || WarteListe.get(i).getIntention() == 13){
                
                counterFuss++;
            }
        }
        return counterFuss;
    }
    
    /**
     * Anzahl der Fussgaenge die, die NordStraße überqueren wollen
     * @return counterFuss
     */
    public int checkFussNordStrasse(){
       int counterFuss = 0;
        for(int i = 0; i < WarteListe.size(); i++){
            if(WarteListe.get(i).getPosition() == 20 || WarteListe.get(i).getPosition() == 21 &&
                    WarteListe.get(i).getIntention() == 10 || WarteListe.get(i).getIntention() == 11){
                
                counterFuss++;
            }
        }
        return counterFuss;
    }
    
    /**
     * Anzahl der Fussgaener, die die WestStrasse überqueren wollen
     * @return couterFuss
     */
    public int checkFussWestStrasse(){
       int counterFuss = 0;
        for(int i = 0; i < WarteListe.size(); i++){
            if(WarteListe.get(i).getPosition() == 21 || WarteListe.get(i).getPosition() == 22 &&
                    WarteListe.get(i).getIntention() == 12 || WarteListe.get(i).getIntention() == 13){
                
                counterFuss++;
            }
        }
        return counterFuss;
    }
    
    /**
     * Anzahl der Fussgaenger, die die SuedStrasse überqueren wollen
     * @return counterFuss
     */
    public int checkFussSuedStrasse(){
       int counterFuss = 0;
        for(int i = 0; i < WarteListe.size(); i++){
            if(WarteListe.get(i).getPosition() == 22 || WarteListe.get(i).getPosition() == 23 &&
                    WarteListe.get(i).getIntention() == 10 || WarteListe.get(i).getIntention() == 11){
                
                counterFuss++;
            }
        }
        return counterFuss;
    }
    
   
    /**
     * Von Nord nach Süd  - Gerade aus Fahrer.
     * @return counterNGeradeAus
     */
    public int checkNordGeradeAusFahrer(){
        int counterNGeradeAus = 0;
        
        for(int i = 0; i < WarteListe.size(); i++){
            if(WarteListe.get(i).getPosition() == 0 && WarteListe.get(i).getIntention() == 5){
                
                counterNGeradeAus++;
            }
        }
        return counterNGeradeAus;
    }
    
    /**
     * Von Süd nach Nord - Gerade aus Fahrer.
     * @return counterSGeradeAus
     */
    public int checkSuedGeradeAusFahrer(){
        int counterSGeradeAus = 0;
        
        for(int i = 0; i < WarteListe.size(); i++){
            if(WarteListe.get(i).getPosition() == 2 && WarteListe.get(i).getIntention() == 5){
                
                counterSGeradeAus++;
            }
        }
        return counterSGeradeAus;
    }
    
    /**
     * WestGeradeAusFahrer West nach Ost
     * @return counterWGeradeAus
     */
    public int checkWestGeradeAusFahrer(){
        int counterWGeradeAus = 0;
        
        for(int i = 0; i < WarteListe.size(); i++){
            if(WarteListe.get(i).getPosition() == 1 && WarteListe.get(i).getIntention() == 5){
                
                counterWGeradeAus++;
            }
        }
        return counterWGeradeAus;
    }
    
    /**
     * OstGeradeAusFahrer Ost nach Westen.
     * @return counterOGeradeAus
     */
    public int checkOstGeradeAusFahrer(){
        int counterOGeradeAus = 0;
        
        for(int i = 0; i < WarteListe.size(); i++){
            if(WarteListe.get(i).getPosition() == 3 && WarteListe.get(i).getIntention() == 5){
                
                counterOGeradeAus++;
            }
        }
        return counterOGeradeAus;
    }
    
    /**
     * Methode für die Teilnehmer mit Vorfahrt.
     */
    public void firstDrive(){
        int i = 0;
        while(i < WarteListe.size()){
            if(WarteListe.get(i).getCurrentState() == Vehicle.STATE.FAEHRT){
                System.out.println(WarteListe.get(i).getName() + " überquert die Straße");
                WarteListe.remove(i);
                i = 0;
            }else{
                System.out.println(WarteListe.get(i).getName() + " muss noch warten");
                i++;
            }
        }
        System.out.println("***************Die mit Vorrang sind fertig.**********");
        secondDrive();
    }
    
    /**
     * Methode für die Teilnehmer nach denen die Vorfahrt haben.
     */
    public void secondDrive(){
        int i = 0;
        while(i < WarteListe.size()){
            System.out.println("Straße ist frei und " + WarteListe.get(i).getName() + " kann jetzt die Straße überqueren.");
            WarteListe.get(i).setCurrentState(Vehicle.STATE.FAEHRT);
            i++;
        }
        WarteListe.clear();
    }
}