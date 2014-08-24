package com.github.itsmichaelwang.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SplashScreenText extends Actor {
	Stage stage;
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter parameter;
	BitmapFont font;
	
	private final float FONT_SIZE = 12f;
	
	public SplashScreenText(Stage stage) {
		this.stage = stage;
		generator = new FreeTypeFontGenerator(Gdx.files.internal("data/press-start_regular.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = Math.round(FONT_SIZE * Gdx.graphics.getDensity());
		font = generator.generateFont(parameter);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		CharSequence str = "Press/Hold finger below!";
		float fontWidth = font.getBounds(str).width;
		float fontHeight = font.getBounds(str).height;
		
		font.setColor(1, 1, 1, 1);
		font.drawWrapped(batch, str,
				(stage.getCamera().viewportWidth - fontWidth) / 2,
				(stage.getCamera().viewportHeight - fontHeight) / 2 + 128,
				stage.getCamera().viewportWidth, HAlignment.CENTER);
	}
	
	public void dispose() {
		generator.dispose();
		font.dispose();
	}
}
