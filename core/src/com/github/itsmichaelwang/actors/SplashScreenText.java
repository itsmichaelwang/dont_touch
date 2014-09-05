package com.github.itsmichaelwang.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.github.itsmichaelwang.donttouch.SplashScreen;

public class SplashScreenText extends Actor {
	Stage stage;
	SplashScreen sScreen;
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter parameter;
	BitmapFont font;
	
	private final float FONT_SIZE = 12f;
	
	public SplashScreenText(Stage stage, SplashScreen sScreen) {
		this.stage = stage;
		this.sScreen = sScreen;
		generator = new FreeTypeFontGenerator(Gdx.files.internal("data/press-start_regular.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = Math.round(FONT_SIZE * Gdx.graphics.getDensity());
		font = generator.generateFont(parameter);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		CharSequence str;
		font.setColor(1, 1, 1, 1);
		
		// Series of conditions that determine game text
		if (!sScreen.gStarted) {
			str = "Press/Hold to begin!";
		} else {
			if (TimeUtils.timeSinceMillis(sScreen.gStartedTime) <= 1000) {
				str = "3";
			} else if (TimeUtils.timeSinceMillis(sScreen.gStartedTime) <= 2000) {
				str = "2";
			} else if (TimeUtils.timeSinceMillis(sScreen.gStartedTime) <= 3000) {
				str = "1";
			} else {
				str = "";	// empty string
			}
		}
		
		// Draw it unless it is an empty string
		if (!str.toString().isEmpty()) {
			float fontHeight = font.getBounds(str).height;
			font.drawMultiLine(batch, str, 
					0, (stage.getHeight() - fontHeight) / 2 + 150, stage.getWidth(),
					HAlignment.CENTER);
		}
	}
	
	public void dispose() {
		generator.dispose();
		font.dispose();
	}
}
