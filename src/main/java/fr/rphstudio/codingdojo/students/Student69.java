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
    public Student69(Pod p){
        super(p);
    }
    
    //-------------------------------------------------------
    // DECLARE YOUR OWN VARIABLES AND FUNCTIONS HERE

     float calcdist (float x1,float x2, float y1 ,float y2) {

        float distx = x1 - x2;
        float disty = y1 - y2;
        float dist = sqrt((distx * distx) + (disty * disty));
        return dist;
    }
    
    // END OF VARIABLES/FUNCTIONS AREA
    //-------------------------------------------------------
    
    @Override
    public void process(int delta) {
        //-------------------------------------------------------
        // WRITE YOUR OWN CODE HERE

        setPlayerName("69Student");
        selectShip(32);
        setPlayerColor(140, 0, 128, 255);

        int procheck = getNextCheckPointIndex();
        float xcheck = getCheckPointPositionX(procheck);
        float ycheck = getCheckPointPositionY(procheck);

        float xship = getShipPositionX();
        float yship = getShipPositionY();



        double angleobj = (atan2(disty,distx))*180/3.14;
        float angleact = getShipAngle();
        float diffangle = (float)angleobj-angleact;

        turn(diffangle);

        System.out.println(diffangle);

        //turnTowardPosition(xcheck, ycheck);

        //float etatboost = getShipBoostLevel();

        //System.out.println(getShipSpeed());

        if (getShipSpeed()<=1f) {
            incSpeed(0.4f);
        }
        else{

            if (dist <= 1.5) {
                incSpeed(-0.15f);
                System.out.println("freine");
            }
            else if (dist >= 7) {

                    incSpeed(0.8f);
                    System.out.println("acc");
                }

            else{
                    incSpeed(0.5f);
                    System.out.println("normal");
                }}


            //moveToNextCheckPoint(0.5f);

            //if (getShipBoostLevel() == 100) {
                //useBoost(); }
                    //else {


            // END OF CODE AREA
            //-------------------------------------------------------
        }

    }