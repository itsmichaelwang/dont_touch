package com.github.itsmichaelwang.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PlayerCircle extends Actor {
	Texture playerCircleTexture;
	float radius = 32f;
	
	public PlayerCircle(Stage stage) {
		playerCircleTexture = new Texture(Gdx.files.internal("data/PlayerCircle.png"));
		setCenterPosition(stage.getWidth() / 2, stage.getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(playerCircleTexture, getX(), getY());
	}
}
