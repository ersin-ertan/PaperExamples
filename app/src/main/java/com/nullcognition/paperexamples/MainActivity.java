package com.nullcognition.paperexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Paper.init(this);
		// all other methods should be called in a background thread
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		int id = item.getItemId();

		switch(id){
			case R.id.action_clear:
				return true;
			case R.id.action_exist:
				return true;
			case R.id.action_delete:
				return true;
			case R.id.action_put:
				return true;
			case R.id.action_get:
				return true;
			case R.id.action_get_def:
				return true;


		}

		return super.onOptionsItemSelected(item);
	}
}
