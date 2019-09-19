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
        return sqrt((distx * distx) + (disty * disty));
    }
    float calcdiffdist (float x1,float x2, float y1 ,float y2) {

        float diffdistx = x2 - x1;
        float diffdisty = y2 - y1;
        return sqrt((diffdistx * diffdistx) + (diffdisty * diffdisty));
    }

    boolean batteryIsLow() {
        return getShipBatteryLevel() > 5f;
    }

    boolean checkpointIsCharger() {
        return true;
    }

    boolean batteryIsModerate() {
        return getShipBatteryLevel() > 25f;
    }

    boolean currentlyCharging = false;

    int nextCheckpoint;

    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------

    @Override
    public void process(int delta) {
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE
        setPlayerName("BANANA 69");
        selectShip(32);
        setPlayerColor(255, 0, 255, 130);

        float rotation;
        if (!batteryIsLow() || currentlyCharging) { // if battery is critically low
            int closestCheckIndex = 99;
            float distClosest = 10000;
            for(int i = 0; i < getNbRaceCheckPoints(); i++) {
                if (calcdist(getCheckPointPositionX(i), getShipPositionX(), getShipPositionY(i), getShipPositionY()) < distClosest) {
                    closestCheckIndex = i;
                    distClosest = calcdist(getCheckPointPositionX(i), getShipPositionX(), getShipPositionY(i), getShipPositionY());
                }
            }
            if (getShipBatteryLevel() < 99f) {
                currentlyCharging = true;
            } else {
                currentlyCharging = false;
            }

            // Make the movement
        } else if { // if battery is moderately charged
            //Need to check if next checkpoint is a charging point AND if we are on it

        } else { // then if battery is charged enough
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

            // Distances

            float dist = calcdist(xCheck, xShip, yCheck, yShip);

            float diffdist = calcdiffdist(xCheck, xPrecheck, yCheck, yPrecheck);

            // Orientation toward next checkpoint

            double angleobj = (atan2(yCheck - yShip, xCheck - xShip)) * 180 / PI;
            float diffangle = (float) angleobj - getShipAngle();

            float dist2 = dist * 0.5f * getShipSpeed();

            // Anticipation de la balise encore après

            double angleobjpro = (atan2(yProCheck - yShip, xProCheck - xShip)) * 180 / PI;
            float diffproangle = (float) angleobjpro - getShipAngle();

            // Accéleration

            if (dist <= 3 && getShipSpeed() >= 1f) {
                incSpeed(-0.8f);
                rotation = diffproangle;
            } else {
                incSpeed(1.0f);
                rotation = diffangle;
            }
            turn(rotation);
        }

        // END OF CODE AREA
        //-------------------------------------------------------
    }

}



