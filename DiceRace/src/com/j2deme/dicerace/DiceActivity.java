package com.j2deme.dicerace;

import java.util.Random;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class DiceActivity extends Activity {
	private Button Dado;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dice);
		Dado = (Button) findViewById(R.id.Dado);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_dice, menu);
		return true;
	}
	
	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	public void lanzar(View view){
		Resources res = getResources();
		int currentapiVersion = android.os.Build.VERSION.SDK_INT;
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
