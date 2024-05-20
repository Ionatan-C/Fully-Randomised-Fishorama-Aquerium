package com.wbs;
import java.io.IOException;
import java.util.Random;// imported Random so that it makes it easier to randomise the speed and location

/**
 * Sets-up and controls Piranha objects.
 *
 * @author Ionatan Cegodari
 * @version 28/02/2023
 * Acknowledgements: none.
 **/
public class Piranha extends Pet {

    /********************* MEMBER CONSTANTS *******************/
    // DECLARE a String and set it to the path and filename for the JavaFish image, call it TEXTURE_FILENAME:
    private static final String TEXTURE_FILENAME = "./textures/PiranhaGreen.png";


    /********************* MEMBER VARIABLES *******************/
    // This allows us to set random position and speed
    Random rand = new Random();//this instantiates the random variable which will select a random number for speed and position
    // DECLARE a float to control the x position of this JavaFish, call it _posnX:
    private float _posnX = (rand.nextFloat(0.1f,0.8f));// this will allow the fish to spawn at random x axis
    // DECLARE a float to control the y position of this JavaFish, call it _posnY:
    private float _posnY = 0.1f;
    // DECLARE a float to control the speed of this JavaFish, call it _speed:
    private float _speed = rand.nextFloat(0.0002f, 0.0010f);// this will set speed to random number between the two entered
    // DECLARE an int to control the direction of this JavaFish, call it _direction:
    private int _direction = 1;



    /****************** CONSTRUCTORS ************************/
    /**
     Constructor for objects of class Piranha.

     * @throws Exception bubbled-up from lower-level operations in the JFF
     */

    public Piranha() throws Exception{
        // INSTANTIATE parent:
        super(TEXTURE_FILENAME, 0.1f, 0.1f, 0.05f);

        // Obtain a number between [0 - 0.5].
        setPositionX(rand.nextFloat(0.5f));
        setPositionY(rand.nextFloat(0.1f,0.7f));// this sets the random y position for seahorse
        setOrientation(0);



    }

    float Rwidth = 0.95f;
    float Lwidth = 0.026f;


    /****************** PUBLIC METHODS ************************/
    /**
     * METHOD: update the Piranha - to be called on each cycle of the simulation.
     */

    public void update() {
        // UPDATE x position:
        setPositionX(_posnX += _direction * _speed);
        int team = 3;

        if (_direction == 1){
            setRightFacing();
        }
        else if (_direction == -1) {
            setLeftFacing();
        }

        try {
            if (_posnX >= Rwidth){
                setLeftFacing();
                _direction = -1;
                setPositionX(_posnX += _direction * _speed);
            }

            if (_posnX <= Lwidth){
                setRightFacing();
                _direction = 1;
                setPositionX(_posnX += _direction * _speed);
            }
        }

        catch (Exception e) {
            System.out.println("Fish boundries code has an error");
        }
        try{//this is testing weather fish is out of bounds
            if(_posnX > Rwidth){
                throw new Exception("fishOverBoundries");
            }
        } catch (Exception fishOverBoundries) {//this is catching the error if fish is out of bounds
            System.out.println("The fish has went over the boundries");
        }

        try{//this is testing weather fish is out of bounds
            if(_posnX < Lwidth){
                throw new Exception("fishOverBoundries");
            }
        } catch (Exception fishOverBoundries) {//this is catching the error if fish is out of bounds
            System.out.println("The fish has went over the boundries");
        }
    }
}

