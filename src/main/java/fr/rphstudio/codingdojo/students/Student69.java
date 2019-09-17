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
    float indcheck;
    float Xship;
    float Yship;
    float Xcheck;
    float Ycheck;
    float angleship;
    float Xdist;
    float Ydist;


    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------

    @Override
    public void process(int delta) {
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE
        indcheck = getNextCheckPointIndex();
        Xship = getShipPositionX();
        Yship = getShipPositionY();
        Xcheck = getNextCheckPointX();
        Ycheck = getNextCheckPointY();
        angleship = getShipAngle();
        Xdist = Xcheck - Xship;
        Ydist = Ycheck - Yship;

        setPlayerName("BANANA 69");
        selectShip(32);
        setPlayerColor(255, 0, 255, 130);
        if (getShipAngle()==atan2(Ydist,Xdist)*180/3.14){
            incSpeed(1.0f);
        }
        else{
            turn(5f);
        }
        // END OF CODE AREA
        //-------------------------------------------------------
        }

}

    

