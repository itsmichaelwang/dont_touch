package com.github.itsmichaelwang.actors;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.github.itsmichaelwang.donttouch.SplashScreen;

public class MissileGenerator {
	private Stage stage;
	private World world;
	private SplashScreen sScreen;
	
	private float nextMissileTimer = 0;
	private final float MISSILE_INTERVAL = 500;	// Spawn a missile every 0.5s
	
	public MissileGenerator(Stage stage, World world, SplashScreen sScreen) {
		this.stage = stage;
		this.world = world;
		this.sScreen = sScreen;
	}
	
	public void generateMissiles(float delta) {
		if (sScreen.gStarted) {
			if (TimeUtils.timeSinceMillis(sScreen.gStartedTime) >= 4000) {
				nextMissileTimer -= delta;
				if (nextMissileTimer <= 0) {
					nextMissileTimer += MISSILE_INTERVAL;
					
					// Create a missile as a Box2D object
					float spawnLocation = MathUtils.random(stage.getHeight() * 2);
					Missile missile = new Missile();
				}
				
			}
		} else {
			nextMissileTimer = 0;
		}
	}
}
