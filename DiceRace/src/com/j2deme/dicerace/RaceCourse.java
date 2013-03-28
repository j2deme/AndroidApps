package com.j2deme.dicerace;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class RaceCourse extends Activity {
	static final String STATE_TURN = "currentTurn";
	static final String STATE_POS = "currentPositions";
	static final String STATE_PLAYERS = "numberPlayers";
	private int players;
	private int currentTurn;
	private int[] currentPositions;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_race_course);
		setContentView(R.layout.race_course_grid);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
		super.onCreate(savedInstanceState);
				
	    if (savedInstanceState != null) {
	        currentTurn = savedInstanceState.getInt(STATE_TURN);
	        currentPositions = savedInstanceState.getIntArray(STATE_POS);
	        players = savedInstanceState.getInt(STATE_PLAYERS);
	    } else {
	    	Intent intent = getIntent();
			players = intent.getIntExtra(MainActivity.PLAYERS,1);
			int cols = (players == 1) ? 2 : players;
	    	currentPositions = new int[cols];
			for (int i = 0; i < currentPositions.length; i++) {
				currentPositions[i] = 0;
			}
			currentTurn = 1;
	    }
	    createGrid();
	}
	
	@Override
	protected void onStart(){
		super.onStart();
	}
	
	@Override
	protected void onStop() {
	    super.onStop();
	}
		
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
	    savedInstanceState.putInt(STATE_TURN, currentTurn);
	    savedInstanceState.putIntArray(STATE_POS, currentPositions);
	    savedInstanceState.putInt(STATE_PLAYERS, players);
	    
	    super.onSaveInstanceState(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_race_course, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void createGrid(){
		int cols = (players == 1) ? 2 : players;
		TableLayout tl =  (TableLayout) findViewById(R.id.tableLayout);
		for (int i = 0; i < 12; i++) {
			TableRow tr = new TableRow(this);
			TableLayout.LayoutParams params = new TableLayout.LayoutParams(
	                TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, 1f);
			for (int j = 0; j < cols; j++) {
				TableRow.LayoutParams cellParams = new TableRow.LayoutParams();
				if(i == 0){
					TextView lbl_player = new TextView(this);
					String title = "";
					if(players == 1 && j == 1){
						title = "CPU";
					} else {
						title = "P" + (j + 1);
					}
					lbl_player.setText(title);
					lbl_player.setLayoutParams(cellParams);
					lbl_player.setTag("lblPlayer"+(j+1));
					lbl_player.setTextSize(25);
					if(currentTurn == (j+1)){
						lbl_player.setTextColor(Color.parseColor("#E81809"));
					}
					tr.addView(lbl_player);
				} else {
					Button step = new Button(this);
					if(currentPositions[j] == (i-1)){
						step.setTextColor(Color.parseColor("#FA2205"));
					}
					step.setText(""+(i-1));
					step.setTag(""+i+j);
					step.setLayoutParams(cellParams);
					tr.addView(step);
				}
			}
			tr.setLayoutParams(params);
	        tl.addView(tr, params);
		}
		tl.setStretchAllColumns(true);
	}

	public void throwDice(View view){
		Intent diceIntent = new Intent(this, DiceActivity.class);
        //diceIntent.putExtra(PLAYERS, players);
        startActivity(diceIntent);
		Context context = getApplicationContext();
		CharSequence text = "Ready to throw dice!";
		int duration = Toast.LENGTH_SHORT;
		
		Toast.makeText(context, text, duration).show();
	}
}
