package com.github.itsmichaelwang.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Player extends Actor {
	private Stage stage;
	private Texture playerCircleTexture;
	private float side = 10f;
	Body body;
	
	public Player(Stage stage, World world) {
		this.stage = stage;	// use stage to unproject screen touches
		playerCircleTexture = new Texture(Gdx.files.internal("data/PlayerBox.png"));
		
		// Create box2D body definition
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;
		bodyDef.position.set((stage.getWidth() - side) / 2,
				(stage.getHeight() - side) / 2);
		
		// Create body in the world using definition
		body = world.createBody(bodyDef);
		
		// Create box
		PolygonShape squareBox = new PolygonShape();
		squareBox.setAsBox(10.0f, 10.0f);
		body.createFixture(squareBox, 0.0f);
		squareBox.dispose();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(playerCircleTexture, getX(), getY());
	}
	
	@Override
	public void act(float delta) {
		setPosition(body.getPosition().x, body.getPosition().y);
	}
	
	public void updatePosition(float screenX, float screenY) {
		float x = screenX;
		float y = screenY;
		float z = 0;
		Vector3 vector3 = new Vector3(x, y, z);
		vector3 = stage.getCamera().unproject(vector3);
		
		body.setTransform(vector3.x + 32, vector3.y + 32, 0);	// update the box2d body
	}
	

}
