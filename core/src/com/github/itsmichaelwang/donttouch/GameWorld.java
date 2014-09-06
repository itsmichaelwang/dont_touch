package com.github.itsmichaelwang.donttouch;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.github.itsmichaelwang.actors.Player;

public class GameWorld {
	public static float UNIT_WIDTH = SplashScreen.VIRTUAL_WIDTH / 160;
	public static float UNIT_HEIGHT = SplashScreen.VIRTUAL_HEIGHT / 160;
	
	public final Stage stage;
	public World box2dWorld;
	public Player player;
	
	public GameWorld() {
		box2dWorld = new World(new Vector2(0, 0), true);
		stage = new Stage(new ExtendViewport(UNIT_WIDTH, UNIT_HEIGHT)); // set game viewport to meters
		
		generateWorld();
	}
	
	private void generateWorld() {
		// create box2D bodies and respective actors here
		player = new Player(stage, this);
		stage.addActor(player);
		
		// add more game elements here
	}
	
	public void update(float delta) {
		// perform game logic here
		box2dWorld.step(delta, 3, 3); // update box2D world
		stage.act(delta);	// update game stage
	}
}
