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

        //Variables de checkpoints

        int nbcheck = getNbRaceCheckPoints();
        int procheck = getNextCheckPointIndex();

        //Variables de positions

        float xship = getShipPositionX();
        float yship = getShipPositionY();
        float xcheck = getCheckPointPositionX(procheck);
        float ycheck = getCheckPointPositionY(procheck);

        int nextproCheckpoint=(procheck+1)%nbcheck;

        float xprecheck = getCheckPointPositionX(nextCheckpoint);
        float yprecheck = getCheckPointPositionY(nextCheckpoint);
        float xprocheck = getCheckPointPositionX(nextproCheckpoint);
        float yprocheck = getCheckPointPositionY(nextproCheckpoint);

        //Distances

        float dist = calcdist(xcheck,xship,ycheck,yship);

        float diffdist = calcdiffdist(xcheck,xprecheck,ycheck,yprecheck);

        //Orientation prochaine balise

        double angleobj = (atan2(ycheck-yship,xcheck-xship))*180/PI;
        float diffangle = (float)angleobj-getShipAngle();

        rotation=diffangle;

        float dist2 = dist*0.5f*getShipSpeed();

        //Anticipation de la balise encore après

        double angleobjpro = (atan2(yprocheck-yship,xprocheck-xship))*180/PI;
        float diffproangle = (float)angleobjpro-getShipAngle();

        //Accéleration

        if (dist<=3 && getShipSpeed()>= 1f){
            incSpeed(-0.8f);
            rotation=diffproangle;
        }
        else{
            incSpeed(1.0f);
            rotation=diffangle;
        }

        turn(rotation);

        // END OF CODE AREA
        //-------------------------------------------------------
    }

}



