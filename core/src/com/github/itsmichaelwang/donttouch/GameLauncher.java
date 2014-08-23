package com.github.itsmichaelwang.donttouch;

import com.badlogic.gdx.Game;

public class GameLauncher extends Game {
	
	@Override
	public void create () {
		setScreen(new SplashScreen(this));
	}
}
