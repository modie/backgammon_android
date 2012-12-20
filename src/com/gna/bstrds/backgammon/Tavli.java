package com.gna.bstrds.backgammon;

import android.app.Activity;
import android.content.Intent;
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
	static byte depth2 ;
	static byte depth1 = depth2 = 2;
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
				game.setPlayers(new Player((byte)depth1,Board.B),new Player((byte)depth2,Board.W));
				boolean frun = true;
				
				
				while(!TavliGame.b.isTerminal()){
					try
					{
						if(frun)
						{
							Thread.sleep(2000);
							frun = false  ;
						}
						game.play();
						if(depth1 ==  1 && depth2 ==1)
						{
							Thread.sleep(2000);
						}
						
					} catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
		//Intent startMainActivity = new Intent("android.intent.action.MAIN");
		//startActivity(startMainActivity);
	}
	public void setDepth(byte depth1 , byte depth2 )
	{
		this.depth1 = depth1 ;
		this.depth2 = depth2 ;
	}

}
