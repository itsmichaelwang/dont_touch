package com.github.itsmichaelwang.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.github.itsmichaelwang.donttouch.GameWorld;

public class Missile extends Image {
	private Stage stage;
	private Texture missileTexture;
	private Body body;
	private float height = 0.25f;
	private float width = height * 3 / 8;
	
	public Missile(GameWorld world) {
		this.stage = world.stage;
		
		// load graphics
		missileTexture = new Texture(Gdx.files.internal("data/DumbMissile.png"));
		setDrawable(new TextureRegionDrawable(new TextureRegion(missileTexture)));
		
		// Create box2D body definition
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.KinematicBody;
		bodyDef.position.x = -height / 2;
		bodyDef.position.y = MathUtils.random(stage.getHeight());
		
		// Create body in the world using definition
		body = world.box2dWorld.createBody(bodyDef);
		body.setLinearVelocity(new Vector2(1.0f, 0.0f));
		
		// Create box
		PolygonShape squareBox = new PolygonShape();
		squareBox.setAsBox(width / 2, height / 2);
		body.createFixture(squareBox, 0.0f);
		
		squareBox.dispose();
		
		// Create actor
		setPosition(body.getPosition().x - width / 2,
					body.getPosition().y - height / 2);
		setSize(width, height); 		// scale actor
		setScaling(Scaling.stretch);
		setAlign(Align.center);		// center the texture
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(missileTexture, getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		setOrigin(width / 2, height / 2);
		setRotation(MathUtils.radiansToDegrees * body.getAngle());
		setPosition(body.getPosition().x - width / 2,
				    body.getPosition().y - height / 2);
	}
}
