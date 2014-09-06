package com.github.itsmichaelwang.donttouch;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameRenderer {
	GameWorld world;
	OrthographicCamera camera;
	SpriteBatch batch;
	
	public GameRenderer(GameWorld world) {
		this.world = world;
		// keep the stage camera
		this.camera = (OrthographicCamera) world.stage.getCamera();
	}
	
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.stage.draw();  
	}
}
