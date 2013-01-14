package com.gna.bstrds.backgammon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText etW;
	EditText etB;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = (Button)findViewById(R.id.button1);
        Button bt2 = (Button)findViewById(R.id.button2);
        etW = (EditText)findViewById(R.id.etW);
        etB = (EditText)findViewById(R.id.etB);
        
        etW.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				etW.setText("");
				
			}
		});
        etB.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				etB.setText("");
				
			}
		});
        bt1.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent startTavli = new Intent("android.intent.action.TAVLI");
				startActivity(startTavli);
				
			}
		});
        bt2.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View arg0)
			{
				boolean done = false ;
				while(!done){
					try{
						Tavli.depth1 = Byte.parseByte(etB.getText().toString());
						Tavli.depth2 = Byte.parseByte(etW.getText().toString());
						done = true ;
					}
					catch(Exception e)
					{
						
					}
				}
				Intent startTavli = new Intent("android.intent.action.TAVLI");
				startActivity(startTavli);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
