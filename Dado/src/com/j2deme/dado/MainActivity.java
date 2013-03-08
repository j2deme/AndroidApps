package com.j2deme.dado;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
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
	
	public void lanzar(View b) {
		Resources res = getResources();
		String[] numbers = {
			res.getString(R.string.one),
			res.getString(R.string.two),
			res.getString(R.string.three),
			res.getString(R.string.four),
			res.getString(R.string.five),
			res.getString(R.string.six)
		};
		int nextValue;
		Random rand = new Random();
    	nextValue = rand.nextInt(6) + 1;
    	Dado.setText(numbers[nextValue-1]);
	  }

}
