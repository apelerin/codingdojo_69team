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

    float calcdist(int numcheck) {

        float xcheck = getCheckPointPositionX(numcheck);
        float ycheck = getCheckPointPositionY(numcheck);
        float xship = getShipPositionX();
        float yship = getShipPositionY();

        float distx = xcheck - xship;
        float disty = ycheck - yship;
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

    int comptcolo = 0;

    int arcenciel ( int compt) {
        if (comptcolo >1200){
            comptcolo=0;
        }
        else {
            comptcolo = comptcolo+1;}

        if (comptcolo<=200) {
            setPlayerColor(140, 0, 128, 255);
        }
        else if (comptcolo<=400) {
            setPlayerColor(0, 0, 135, 255);
        }
        else if (comptcolo<=600) {
            setPlayerColor(0, 172, 39, 255);
        }
        else if (comptcolo<=800) {
            setPlayerColor(255, 217, 0, 255);
        }
        else if (comptcolo<=1000) {
            setPlayerColor(255, 38, 0, 255);
        }
        else if (comptcolo<=12000) {
            setPlayerColor(255, 0, 150, 255);
        }
        return compt;
    }
    
    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------
    
    @Override
    public void process(int delta) {
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE

        setPlayerName("69Student");
        selectShip(32);

        arcenciel(comptcolo);

        //setPlayerColor(140, 0, 128, 255);

        int procheck = getNextCheckPointIndex();
        int ciblecheck = procheck;

        float dist = calcdist(procheck);

        if (dist <=2){
            if (procheck == getNbRaceCheckPoints()) {
                ciblecheck = 0; }

            else {
                ciblecheck = procheck+1;}

            calcdist(ciblecheck);
        }

        float diffangle = calcangle(ciblecheck);

        if (getShipSpeed() < 2f){
            turn(calcangle(procheck));}
        else {
            turn (calcangle(ciblecheck));
        }


        if (dist <= 3) {
            if (getShipSpeed() < 1.5f){
                incSpeed(0.4f * getShipSpeed());}
            else {
                    incSpeed(-0.8f * getShipSpeed());

            }}
        else if (dist >=8 & (getShipBoostLevel() == 100) & (diffangle == 0)) {
            useBoost();
        }
        else{
            incSpeed(1f);
        }

            // END OF CODE AREA
            //-------------------------------------------------------
        }
    }