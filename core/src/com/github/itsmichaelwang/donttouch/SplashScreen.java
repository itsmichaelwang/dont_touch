package com.github.itsmichaelwang.donttouch;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.github.itsmichaelwang.actors.PlayerCircle;
import com.github.itsmichaelwang.actors.SplashScreenText;

public class SplashScreen implements Screen, InputProcessor {
	
	private static final int VIRTUAL_WIDTH = 800;
	private static final int VIRTUAL_HEIGHT = 480;
	
	private Game gameLauncher;
	private SpriteBatch batch;
	
	private Stage stage;
	private SplashScreenText text;
	private PlayerCircle playerCircle;
	
	
	// Passing in the game to control screens
	public SplashScreen(Game g) {
		this.gameLauncher = g;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		stage = new Stage(new ExtendViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT), batch);
		text = new SplashScreenText(stage);
		stage.addActor(text);
		playerCircle = new PlayerCircle(stage);
		stage.addActor(playerCircle);
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
		batch.dispose();
		stage.dispose();
		text.dispose();
	}
	
	/**
	 * InputProcessor methods
	 */
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
