/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

import ch.aplu.jgamegrid.Actor;
import ch.aplu.jgamegrid.GGActorCollisionListener;
import ch.aplu.jgamegrid.GameGrid;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author extra
 */
public class Ambiente extends GameGrid implements GGActorCollisionListener {

	private static Color ambienteColor = Color.WHITE;

	public Ambiente() {
		super(30, 30, 20, Color.RED, true);
		this.setBgColor(ambienteColor);
	}

	public void init() {
		ArrayList<Actor> atores = getActors(Robot.class);
		for (int i = 0; i < atores.size(); i++) {
			Actor ac = atores.get(i);
			//ac.act();
			ac.setCollisionCircle(new Point(0, 0), 5);
			ac.addActorCollisionListener(this);
			for (int k = 0; k < getActors(Robot.class).size(); k++) {
				Actor collider = getActors(Robot.class).get(k);
				if (ac != collider) {
					ac.addCollisionActor(collider);
				}
			}

		}

		show();
	}

	@Override
	public int collide(Actor a, Actor b) {
		if (a instanceof Robot) {
			System.out.print("o robo " + ((Robot) a).getId());
		}
		if (b instanceof Robot) {
			System.out.println(" colidiu com o robo " + ((Robot) b).getId());
		}
		double dir1 = a.getDirection();
		double dir2 = b.getDirection();
		int sd1 = a.getSlowDown();
		int sd2 = b.getSlowDown();
		a.setDirection(dir2);
		a.setSlowDown(sd2);
		b.setDirection(dir1);
		b.setSlowDown(sd1);
		return 5;  // Wait a moment until collision is rearmed

	}

}
