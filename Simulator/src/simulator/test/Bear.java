package simulator.test;

// Bear.java
// Detect collision with instance of given actor class
// Used in Ex04.java, Ex06a.java
import ch.aplu.jgamegrid.Actor;

public class Bear extends Actor {

    private Class clazz;

    public Bear(Class clazz) {
        super("sprite/bear.gif");
        this.clazz = clazz;
    }

    public void act() {
        if (isMoveValid()) {
            move();
        } else {
            if (isHorzMirror()) // at left border
            {
                setHorzMirror(false);
                turn(270);
                move();
                turn(270);
            } else // at right border
            {
                setHorzMirror(true);
                turn(90);
                move();
                turn(90);
            }
        }
        tryToEat();
    }

    private void tryToEat() {
        Actor actor
            = gameGrid.getOneActorAt(getLocation(), clazz);
        if (actor != null) {
            actor.hide();
        }
    }
}
