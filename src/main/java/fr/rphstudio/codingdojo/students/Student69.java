/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rphstudio.codingdojo.students;

import fr.rphstudio.codingdojo.game.Pod;
import fr.rphstudio.codingdojo.game.PodPlugIn;

/**
 *
 * @author Romuald GRIGNON
 */
public class Student69 extends PodPlugIn {
    public Student69(Pod p) {
        super(p);
    }

    //-------------------------------------------------------
    // DECLARE YOUR OWN VARIABLES AND FUNCTIONS HERE

    float calcdistshch (int numcheck) {

        float xcheck = getCheckPointPositionX(numcheck);
        float ycheck = getCheckPointPositionY(numcheck);
        float xship = getShipPositionX();
        float yship = getShipPositionY();

        float distx = xcheck - xship;
        float disty = ycheck - yship;
        float dist = sqrt((distx * distx) + (disty * disty));
        return dist;
    }
    float calcdistchch (int numcheckavant, int numcheckapres) {
        float xcheckav = getCheckPointPositionX(numcheckavant);
        float ycheckav = getCheckPointPositionY(numcheckavant);
        float xcheckap = getCheckPointPositionX(numcheckapres);
        float ycheckap = getCheckPointPositionY(numcheckapres);

        float distx = xcheckap - xcheckav;
        float disty = ycheckap - ycheckav;
        float dist = sqrt((distx * distx) + (disty * disty));
        return dist;
    }


    float calcangle(int numcheck) {
        float xcheck = getCheckPointPositionX(numcheck);
        float ycheck = getCheckPointPositionY(numcheck);
        float xship = getShipPositionX();
        float yship = getShipPositionY();
        double angleobj = (atan2(ycheck-yship,xcheck-xship))*180/3.14;
        float diffangle = (float) angleobj - getShipAngle();
        return diffangle;
    }

    int comptsecours;

    int boostfin=0;
    
    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------
    
    @Override
    public void process(int delta) {
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE

        setPlayerName("69-Banana");

        selectShip(32);
        //setPlayerColor(160, 0, (int)(getShipBatteryLevel()*2.55), 255);

        int procheck = getNextCheckPointIndex();
        int ciblecheck = procheck;
        int proprocheck= procheck;
        float dist = calcdistshch(procheck);

        int avcheck=procheck;

        if (procheck == 0) {
            avcheck = getNbRaceCheckPoints()-1;}
        else {
            avcheck = procheck-1;}

        if ((calcdistshch(procheck) <= (calcdistchch(avcheck ,procheck ))/100*30)){
            if (procheck == (getNbRaceCheckPoints()-1)) {
                ciblecheck = 0; }
            else {
                ciblecheck = procheck+1;}
            calcdistshch(ciblecheck);
        }

        if (procheck == (getNbRaceCheckPoints()-1)) {
            proprocheck = 0; }
        else {
            proprocheck = procheck+1;}

        float diffangle = calcangle(ciblecheck);

        if (getShipSpeed() < 2.75f){
            turn(calcangle(procheck));}
        else {
            turn (calcangle(ciblecheck));
        }

        //setPlayerName(""+calcangle(0));

        if ( (( -0.05f < calcangle(0) & calcangle(0) < 0.05f) & (getNbCompletedLaps()+1 == getNbMaxLaps()) & (getNextCheckPointIndex() == 0))){
            setPlayerColor(255,255,255,255);
            if (getShipBoostLevel()==100 & calcdistshch(procheck)>=8) {
                useBoost();}
            else {
                incSpeed(1);}
            }
        else if (comptsecours <=50){
            incSpeed(1);
        }
        else if (( -0.05f < calcangle(procheck) & calcangle(procheck) < 0.05f) & ( -0.5f < calcangle(proprocheck) & calcangle(proprocheck) < 0.5f)){
            setPlayerColor(200,200,200,150);
            if (getShipBoostLevel()==100 & calcdistshch(proprocheck)>=8) {
                useBoost();}
            else {
                incSpeed(1);}
            }
        else if  (calcdistshch(procheck) <= (calcdistchch(avcheck ,procheck ))/100*30) {
            if (getShipSpeed() < 1.5f){
                incSpeed(1f );
                setPlayerColor(100,255,100,255);}
            else if (getShipSpeed()>=3){
                    incSpeed((float)(-1f * getShipSpeed()));
                    setPlayerColor(255,100,100,255);
            }
                }
        else if (calcdistshch(procheck) >= (calcdistchch(avcheck ,procheck ))/100*0 & (getShipBoostLevel() == 100) & ( -0.05f < calcangle(0) & calcangle(0) < 0.5f)) {
            useBoost();
            setPlayerColor(200,200,200,200);
        }
        else{
            incSpeed(1f);
            setPlayerColor(100,100,255,255);
        }

        comptsecours = comptsecours+1;

            // END OF CODE AREA
            //-------------------------------------------------------
        }
    }