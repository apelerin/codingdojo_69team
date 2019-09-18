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

    float calcdist (int numcheck) {

        float xcheck = getCheckPointPositionX(numcheck);
        float ycheck = getCheckPointPositionY(numcheck);
        float xship = getShipPositionX();
        float yship = getShipPositionY();

        float distx = xcheck - xship;
        float disty = ycheck - yship;
        float dist = sqrt((distx * distx) + (disty * disty));
        return dist;
    }

     float calcdistold (float x1,float x2, float y1 ,float y2) {

        float distx = x2 - x1;
        float disty = y2 - y1;
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

        float dist= calcdist(procheck);

        if (dist <=2.2){
            procheck= procheck+1;
            calcdist(procheck);
            //dist= calcdistold(getCheckPointPositionX(procheck),getShipPositionX(),getCheckPointPositionY(procheck),getShipPositionY());
         }

        double angleobj = (atan2(getCheckPointPositionY(procheck)-yship,getCheckPointPositionX(procheck)-xship))*180/3.14;
        float diffangle = (float)angleobj-getShipAngle();

        turn(diffangle);

        System.out.println(dist);

        //turnTowardPosition(xcheck, ycheck);

        //float etatboost = getShipBoostLevel();

        //System.out.println(getShipSpeed());

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


            //moveToNextCheckPoint(0.5f);

            //if (getShipBoostLevel() == 100) {
                //useBoost(); }
                    //else {


            // END OF CODE AREA
            //-------------------------------------------------------
        }

    }