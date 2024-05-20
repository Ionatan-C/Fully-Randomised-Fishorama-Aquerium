package com.wbs;
///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////

import org.marcprice.jff.simulation.*;
import java.util.ArrayList;


/**
 * App is the top-level class for the Aquarium simulation.
 * @author Ionatan Cegodari
 * @version 28/02/2023
 *
 */
public class App {

    /***************** Program Entry-point ********************/
    public static void main(String[] args) throws Exception {
        App app = new App(new SceneMaker());
        app.run();
    }
    /**********************************************************/

    /***************** MEMBER CONSTANTS ***********************/
    // DECLARE & set an int to represent the key code for the ESC key, call it ESCAPE_KEY:
    private static final int ESCAPE_KEY = 256;
    /********************* MEMBER VARIABLES *******************/
    // DECLARE a Scene to store the scene, call it _scene:
    private Scene _scene;
    // DECLARE a float to store the aspect ratio of the window, call it _aspectRatio:
    private float _aspectRatio = 1.0f;



    /****************** CONSTRUCTORS **************************/
    /**
     * Constructor for top-level App class
     * @param sceneMaker used by JFF2 to make a Scene (window).
     * @throws Exception all exceptions are bubbled-up to the user.
     */
    public App(SceneMaker sceneMaker) throws Exception {
        // CREATE _scene:
        _scene = new Scene(sceneMaker);

        // SET the aspect ratio of the scene:
        _aspectRatio = _scene.getWindowHeight();
        _aspectRatio /= _scene.getWindowWidth();
    }

    /****************** PUBLIC METHODS ************************/

    /**
     * METHOD: run the real-time loop.
     */
    public void run() throws Exception {

        ArrayList<Pet> blueFishPets = new ArrayList<Pet>();
        for (int i = 0; i < 5; i++) {
            Pet blueFish = new JavaFish();
            blueFishPets.add(blueFish);
            _scene.addDisplayObject(blueFish);
        }

        ArrayList<Pet> urchinPets = new ArrayList<Pet>();
        for (int i = 0; i < 5; i++) {
            Pet urchinFish = new Urchin();
            urchinPets.add(urchinFish);
            _scene.addDisplayObject(urchinFish);
        }

        ArrayList<Pet> seaHorsePets = new ArrayList<Pet>();
        for (int i = 0; i < 5; i++) {
            Pet seaHorse = new SeaHorse();
            seaHorsePets.add(seaHorse);
            _scene.addDisplayObject(seaHorse);
        }

        ArrayList<Pet> piranhaPets = new ArrayList<Pet>();
        for (int i = 0; i < 5; i++) {
            Pet piranha = new Piranha();
            piranhaPets.add(piranha);
            _scene.addDisplayObject(piranha);
        }

        // RUN the real-time loop until the user has pressed the ESCAPE key...
        while (!_scene.isKeyPressed(ESCAPE_KEY)) {
            // UPDATE assets:
            for (Pet fish: blueFishPets) {
                fish.update();
            }

            for (Pet fish: urchinPets) {
                fish.update();
            }

            for (Pet fish: seaHorsePets) {
                fish.update();
            }

            for (Pet fish: piranhaPets) {
                fish.update();
            }

            // RENDER scene:
            _scene.render();
        }

        // CLOSE _scene:
        _scene.close();
    }

    /****************** PRIVATE METHODS *************************/

}

