package com.github.itsmichaelwang.donttouch;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class SplashScreen implements Screen {
	
	Game gameLauncher;
	SpriteBatch spriteBatch;
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter parameter;
	BitmapFont font12;
	
	// Passing in the game to control screens
	public SplashScreen(Game g) {
		this.gameLauncher = g;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		font12.setColor(0, 0, 0, 1);
		font12.draw(spriteBatch, "Hold finger to screen to begin!", 25, 160);
		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		spriteBatch = new SpriteBatch();
		generator = new FreeTypeFontGenerator(Gdx.files.internal("data/press-start_regular.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = 12;
		font12 = generator.generateFont(parameter);
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		generator.dispose();
		
	}

}
