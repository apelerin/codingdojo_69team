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
    
    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------
    
    @Override
    public void process(int delta) {
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE

        setPlayerName("69Student");
        selectShip(32);
        setPlayerColor(140, 0, 128, 175);

        int procheck = getNextCheckPointIndex();
        float xcheck = getCheckPointPositionX(procheck);
        float ycheck = getCheckPointPositionY(procheck);
        float xship = getShipPositionX();
        float yship = getShipPositionY();

        float dist= calcdist(procheck);

        if (dist <=2.2){
            procheck= procheck+1;
            calcdist(procheck);
         }

        //double angleobj = (atan2(getCheckPointPositionY(procheck)-yship,getCheckPointPositionX(procheck)-xship))*180/3.14;
        //float diffangle = (float)angleobj-getShipAngle();

        float diffangle = calcangle(procheck);
        turn(diffangle);

        if (getShipSpeed()<=1f) {
            incSpeed(0.45f);
        }
        else{

            if (dist <= 2.5) {
                incSpeed(-1f*getShipSpeed());
            }
             else if (dist >=8 & (getShipBoostLevel()==100) & (diffangle==0)) {
                     useBoost();
                 }
             else if (dist >=6.5) {
                incSpeed(1);
            }

            else{
                    incSpeed(0.75f);
                }}

            // END OF CODE AREA
            //-------------------------------------------------------
        }

    }