package com.j2deme.converter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (EditText) findViewById(R.id.value);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void calculate(View view){
		RadioButton celsiusButton = (RadioButton) findViewById(R.id.celsius);
		RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.fahrenheit);
		if (text.getText().length() == 0) {
			Toast.makeText(this, "Ingresa un número valido",Toast.LENGTH_LONG).show();
	        return;
		}
		
		float inputValue = Float.parseFloat(text.getText().toString());
		if (celsiusButton.isChecked()) {
			text.setText(String.valueOf(FahrenheitToCelsius(inputValue)));
	        celsiusButton.setChecked(false);
	        fahrenheitButton.setChecked(true);
	      } else {
	        text.setText(String.valueOf(CelsiusToFahrenheit(inputValue)));
	        fahrenheitButton.setChecked(false);
	        celsiusButton.setChecked(true);
	      }
	}
	
	// Convierte Fahrenheit a Celsius
	private float FahrenheitToCelsius(float fahrenheit) {
		return ((fahrenheit - 32) * 5 / 9);
	}

	// Convierte Celsius a Fahrenheit
	private float CelsiusToFahrenheit(float celsius) {
		return ((celsius * 9) / 5) + 32;
	}
}
