package com.nullcognition.paperexamples;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.security.InvalidParameterException;

import io.paperdb.Paper;
import se.emilsjolander.intentbuilder.Extra;
import se.emilsjolander.intentbuilder.IntentBuilder;

@IntentBuilder
public class MyIntentService extends IntentService{

	@Extra
	String action;

	@Extra
	String key;

	public static final String ACTION_PAPER_CLEAR   = "com.nullcognition.intentbuilder.action.PAPER_CLEAR";
	public static final String ACTION_PAPER_EXIST   = "com.nullcognition.intentbuilder.action.PAPER_EXIST";
	public static final String ACTION_PAPER_DELETE  = "com.nullcognition.intentbuilder.action.PAPER_DELETE";
	public static final String ACTION_PAPER_PUT     = "com.nullcognition.intentbuilder.action.PAPER_PUT";
	public static final String ACTION_PAPER_GET     = "com.nullcognition.intentbuilder.action.PAPER_GET";
	public static final String ACTION_PAPER_GET_DEF = "com.nullcognition.intentbuilder.action.PAPER_GET_DEF";

	public MyIntentService(){ super(MyIntentService.class.getSimpleName());}

	@Override
	protected void onHandleIntent(Intent intent){
		MyIntentServiceIntentBuilder.inject(intent, this);
		if(intent != null){
			if(action != null){
				switch(action){
					case ACTION_PAPER_CLEAR:
						clear();
						break;
					case ACTION_PAPER_EXIST:
						exist(key);
						break;
					case ACTION_PAPER_DELETE:
						delete(key);
						break;
					case ACTION_PAPER_PUT:
//						put(key, val); // intent builder/extras does not allow sending Object type
						break;
					case ACTION_PAPER_GET:
						get(key);
						break;
					case ACTION_PAPER_GET_DEF:
						getDef(key);
						break;
					default:
						throw new InvalidParameterException();
				}
			}
		}
	}

	private void clear(){ Paper.clear(getBaseContext()); } // part of ContextWrapper

	private void exist(String key){ Paper.exist(key); }

	private void delete(String key){ Paper.delete(key); }

	private static<T> void put(String key, T val){ Paper.put(key, val); }

	private void get(String key){ Paper.get(key); }

	private void getDef(String key){ Paper.get(key, new DefaultObject()); }

	// should be made to return values as per use case
	public static class DefaultObject{
		public DefaultObject(){
			// do something
		}
	}

}
