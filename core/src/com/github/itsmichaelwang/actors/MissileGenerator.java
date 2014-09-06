package com.github.itsmichaelwang.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.github.itsmichaelwang.donttouch.GameWorld;
import com.github.itsmichaelwang.donttouch.SplashScreen;

public class MissileGenerator {
	private Stage stage;
	private GameWorld world;
	private SplashScreen sScreen;
	
	private float nextMissileTimer = 0;
	private final float MISSILE_INTERVAL = 500;	// Spawn a missile every specified ms
	
	public MissileGenerator(GameWorld world, SplashScreen sScreen) {
		this.world = world;
		this.stage = world.stage;
		this.sScreen = sScreen;
	}
	
	public void generateMissiles(float delta) {
		if (sScreen.gStarted) {
			if (TimeUtils.timeSinceMillis(sScreen.gStartedTime) >= 4000) {
				nextMissileTimer -= delta * 1000;
				if (nextMissileTimer <= 0) {
					nextMissileTimer += MISSILE_INTERVAL;
					
					// Create a missile as a Box2D/Scene2D object
					Missile missile = new Missile(world);
					stage.addActor(missile);
				}
			}
		} else {
			nextMissileTimer = 0;
		}
	}
}
