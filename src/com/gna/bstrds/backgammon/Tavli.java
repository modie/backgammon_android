package com.gna.bstrds.backgammon;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Tavli extends Activity{
	TavliGame game ;
	Thread t = new Thread();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        
		game = new TavliGame(this, dm.heightPixels ,dm.widthPixels);
		setContentView(game);
		
		t = new Thread(){
			
			@Override
			public void run()
			{
				game.setPlayers(new Player((byte)1,Board.B),new Player((byte)1,Board.W));
				
				
				while(!TavliGame.b.isTerminal()){
				try
				{
					game.play();
					Thread.sleep(2000);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		};
		t.start();
	}

}
