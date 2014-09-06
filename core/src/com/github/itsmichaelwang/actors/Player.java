package com.github.itsmichaelwang.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.github.itsmichaelwang.donttouch.GameWorld;

public class Player extends Image {
	private Stage stage;
	private Texture playerTexture;
	private static float SIDE = 0.5f;
	private Body body;
	
	public Player(Stage stage, GameWorld world) {
		this.stage = stage;
		
		// load graphics
		playerTexture = new Texture(Gdx.files.internal("data/PlayerBox.png"));
		this.setDrawable(new TextureRegionDrawable(
				new TextureRegion(playerTexture)));
		
		// Create box2D body definition
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;
		bodyDef.position.x = stage.getWidth() / 2;
		bodyDef.position.y = stage.getHeight() / 2;
		
		// Create body in the world using definition
		body = world.box2dWorld.createBody(bodyDef);
		
		// Create box
		PolygonShape squareBox = new PolygonShape();
		squareBox.setAsBox(SIDE / 2, SIDE / 2);
		body.createFixture(squareBox, 0.0f);
		
		squareBox.dispose();
		
		// Create actor
		setPosition(body.getPosition().x - SIDE / 2,
					body.getPosition().y - SIDE / 2);
		setSize(SIDE, SIDE); 		// scale actor
		setScaling(Scaling.stretch);
		setAlign(Align.center);		// center the texture
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(playerTexture, getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		setOrigin(SIDE / 2, SIDE / 2);
		setRotation(MathUtils.radiansToDegrees * body.getAngle());
		setPosition(body.getPosition().x - SIDE / 2,
				    body.getPosition().y - SIDE / 2);
	}
	
	public void updatePosition(float screenX, float screenY) {
		float x = screenX;
		float y = screenY;
		float z = 0;
		Vector3 vector3 = new Vector3(x, y, z);
		vector3 = stage.getCamera().unproject(vector3);
		
		body.setTransform(vector3.x - 1, vector3.y, body.getAngle());	// update the box2d body
	}
}
