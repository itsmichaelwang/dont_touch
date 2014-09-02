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

public class SplashScreenText extends Actor {
	Stage stage;
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter parameter;
	BitmapFont font;
	
	private final float FONT_SIZE = 12f;
	
	boolean gStarted = false;
	public void startGame() { gStarted = true; }
	long gStartedTime;
	
	public SplashScreenText(Stage stage) {
		this.stage = stage;
		generator = new FreeTypeFontGenerator(Gdx.files.internal("data/press-start_regular.ttf"));
		parameter = new FreeTypeFontParameter();
		parameter.size = Math.round(FONT_SIZE * Gdx.graphics.getDensity());
		font = generator.generateFont(parameter);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		CharSequence str;
		
		// Series of conditions that determine game text
		if (!gStarted) {
			gStartedTime = TimeUtils.millis();
			str = "Press/Hold to begin!";
		} else {
			if (TimeUtils.timeSinceMillis(gStartedTime) <= 1000) {
				str = "3";
			} else if (TimeUtils.timeSinceMillis(gStartedTime) <= 2000) {
				str = "2";
			} else if (TimeUtils.timeSinceMillis(gStartedTime) <= 3000) {
				str = "1";
			} else {
				str = "";	// null for empty string
			}
		}
		
		// Draw it unless it is an empty string
		if (!str.toString().isEmpty()) {
			float fontWidth = font.getBounds(str).width;
			float fontHeight = font.getBounds(str).height;
			
			font.setColor(1, 1, 1, 1);
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
