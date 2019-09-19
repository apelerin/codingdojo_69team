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

    float calcdist (float x1,float x2, float y1 ,float y2) {

        float distx = x2 - x1;
        float disty = y2 - y1;
        float dist = sqrt((distx * distx) + (disty * disty));
        return dist;
    }
    float calcdiffdist (float x1,float x2, float y1 ,float y2) {

        float diffdistx = x2 - x1;
        float diffdisty = y2 - y1;
        float diffdist = sqrt((diffdistx * diffdistx) + (diffdisty * diffdisty));
        return diffdist;
    }

    boolean isSufficientlyCharged() {
        if (getShipBatteryLevel() > 5f) {
            return true;
        } else {
            return false;
        }
    }

    int nextCheckpoint;

    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------

    @Override
    public void process(int delta) {
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE
        setPlayerName("69-Banana");
        selectShip(32);
        setPlayerColor(255, 0, 255, 130);

        float rotation;
        if (!isSufficientlyCharged()) {

        } else  {
            //Variables de checkpoints

            int nbCheck = getNbRaceCheckPoints();
            int proCheck = getNextCheckPointIndex();

            //Variables de positions

            float xShip = getShipPositionX();
            float yShip = getShipPositionY();
            float xCheck = getCheckPointPositionX(proCheck);
            float yCheck = getCheckPointPositionY(proCheck);

            int nextProCheckpoint = (proCheck + 1) % nbCheck;

            float xPrecheck = getCheckPointPositionX(nextCheckpoint);
            float yPrecheck = getCheckPointPositionY(nextCheckpoint);
            float xProCheck = getCheckPointPositionX(nextProCheckpoint);
            float yProCheck = getCheckPointPositionY(nextProCheckpoint);

            //Distances

            float dist = calcdist(xCheck, xShip, yCheck, yShip);

            float diffdist = calcdiffdist(xCheck, xPrecheck, yCheck, yPrecheck);

            //Orientation prochaine balise

            double angleobj = (atan2(yCheck - yShip, xCheck - xShip)) * 180 / PI;
            float diffangle = (float) angleobj - getShipAngle();
            diffangle=(diffangle+360)%360;
            float dist2 = dist * 0.5f * getShipSpeed();

            //Anticipation de la balise encore après

            double angleobjpro = (atan2(yProCheck - yShip, xProCheck - xShip)) * 180 / PI;
            float diffproangle = (float) angleobjpro - getShipAngle();
            
            diffproangle=(diffproangle+360)%360;
            if (diffproangle<180){
                diffproangle=5;
            } else {
                diffproangle=-5;
            }

            //Compensation

            float xspeed = getShipSpeedX();
            float yspeed = getShipSpeedY();
            float directionSpeed = atan2(yspeed,xspeed)*180/PI;
            float diff = (float)((angleobj-directionSpeed)+360)%360;
            float diffcompensation;
            float ecart= abs(diff-180)*getShipSpeed()/100;


            if(diff<180){
                setPlayerColor(255,255,0,255);
                diffcompensation=ecart;
            } else {
                setPlayerColor(255,0,0,255);
                diffcompensation=-ecart;
            }

            // mise a jour du nouvelle objectif

            diffangle=(diffangle+diffcompensation+360)%360;

            if (diffangle<180){
                diffangle=5;
            } else {
                diffangle=-5;
            }

            //Accéleration et rotation

            if (dist<=2 && getShipSpeed()>=3f){
                incSpeed(-1.0f);
                rotation = diffproangle;
            } else {
                incSpeed(1.0f);
                rotation=diffangle;

            /*
            if (diff>180 && angleobj+10<diff || diff>180 && angleobj-10>diff){
                rotation=-diff;
            }
            else if (diff<180 && angleobj+10<diff || diff<180 && angleobj-10>diff){
                rotation=diff;
            }
             */
            }

        //Tourner

            turn(rotation);

        // END OF CODE AREA
        //-------------------------------------------------------
    }

}