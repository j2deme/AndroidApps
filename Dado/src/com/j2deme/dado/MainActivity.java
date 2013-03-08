package com.j2deme.dado;

import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button Dado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Dado = (Button) findViewById(R.id.Dado);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	public void lanzar(View b) {
		Resources res = getResources();
		int currentapiVersion = android.os.Build.VERSION.SDK_INT;
		/* Para cambiar el texto
		String[] numbers = {
			res.getString(R.string.one),
			res.getString(R.string.two),
			res.getString(R.string.three),
			res.getString(R.string.four),
			res.getString(R.string.five),
			res.getString(R.string.six)
		};
		Dado.setText(numbers[nextValue-1]);
		*/
		
		Drawable[] sides = {
			res.getDrawable(R.drawable.dice_1),
			res.getDrawable(R.drawable.dice_2),
			res.getDrawable(R.drawable.dice_3),
			res.getDrawable(R.drawable.dice_4),
			res.getDrawable(R.drawable.dice_5),
			res.getDrawable(R.drawable.dice_6),
		};
		
    	Drawable drawable = sides[random()-1];
		if (currentapiVersion >= android.os.Build.VERSION_CODES.JELLY_BEAN){
			Dado.setBackground(drawable);
		} else{
			Dado.setBackgroundDrawable(drawable);
		}
	}
	
	public int random(){
		int r;
		Random rand = new Random();
    	r = rand.nextInt(6) + 1;
    	return r;
	}

}