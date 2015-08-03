package com.nullcognition.paperexamples;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity{

	public static final String KEY = "key";

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

		/*
		* // From Component A
LongTaskOne().execute();

// From Component B at the same time
LongTaskTwo().execute();

		Both use the same worker thread, thus they run sequentially.
		To run in parallel, use the executeOnExecutor(Executor exec, Params... params)
AsyncTask.SERIAL_EXECUTOR;
AsyncTask.THREAD_POOL_EXECUTOR;

as the executor type

		*/

		switch(id){
			case R.id.action_clear:
				AsyncTask.execute(new Runnable(){
					@Override
					public void run(){
						Paper.clear(getApplicationContext());

					}
				});
				return true;
			case R.id.action_exist:
				AsyncTask.execute(new Runnable(){
					@Override
					public void run(){
						Log.e("logErr", "exist:" + Boolean.valueOf(Paper.exist(KEY)));
					}
				});
				return true;
			case R.id.action_delete:
				AsyncTask.execute(new Runnable(){
					@Override
					public void run(){
						Log.e("logErr", "delete:" + Paper.delete(KEY).toString());
					}
				});
				return true;
			case R.id.action_put:
				AsyncTask.execute(new Runnable(){
					@Override
					public void run(){
						Log.e("logErr", "put:" + Paper.put(KEY, "put-value").toString());
					}
				});
				return true;
			case R.id.action_get:
				AsyncTask.execute(new Runnable(){
					@Override
					public void run(){
						Log.e("logErr", "get:" + Paper.get(KEY));
					}
				});
				return true;
			case R.id.action_get_def:
				AsyncTask.execute(new Runnable(){
					@Override
					public void run(){
						Log.e("logErr", "get-def:" + Paper.get(KEY, "get-default"));
					}
				});
				return true;
		}

		return super.onOptionsItemSelected(item);
	}


}
