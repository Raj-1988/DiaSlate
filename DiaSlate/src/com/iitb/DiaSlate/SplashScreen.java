package com.iitb.DiaSlate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;


// SPLASH SCREEN

public class SplashScreen extends Activity{

	ProgressBar mProgress;
	int mProgressStatus = 0;
	Handler mHandler = new Handler();
	Thread timer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		mProgress = (ProgressBar) findViewById(R.id.pbLoadingSplash);
		mProgress.setProgress(0);
		mProgress.setMax(100);
		
		timer = new Thread(){
			@Override
			public void run(){
				try{
					
					while (mProgress.getProgress() < 100)
				{
						sleep(25); 
					mProgress.incrementProgressBy(1);
				}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					startActivity(new Intent(SplashScreen.this,ModeSelect.class));

				}
				
				
				
			}
		};
		timer.start();
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		finish();
	}
	}


