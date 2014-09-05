package com.github.itsmichaelwang.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PlayerCircle extends Actor {
	private Stage stage;
	private Texture playerCircleTexture;
	private float radius = 32f;
	
	public PlayerCircle(Stage stage) {
		this.stage = stage;
		playerCircleTexture = new Texture(Gdx.files.internal("data/PlayerCircle.png"));
		setCenterPosition((stage.getWidth() - radius) / 2, (stage.getHeight() - radius) / 2);
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(playerCircleTexture, getX(), getY());
	}
	
	public void updatePosition(float screenX, float screenY) {
		float x = screenX;
		float y = screenY;
		float z = 0;
		Vector3 vector3 = new Vector3(x, y, z);
		
		vector3 = stage.getCamera().unproject(vector3);
		setPosition(vector3.x + 32, vector3.y + 32);
	}
	

}
