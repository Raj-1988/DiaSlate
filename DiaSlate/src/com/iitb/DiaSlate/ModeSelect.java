package com.iitb.DiaSlate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ModeSelect extends Activity implements OnClickListener {

	ImageView iv_Slate, iv_Uml, iv_Exit, iv_Info;
	int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modes);

		iv_Slate = (ImageView) findViewById(R.id.iv_Slate);
		iv_Uml = (ImageView) findViewById(R.id.iv_Uml);
		iv_Exit = (ImageView) findViewById(R.id.iv_Exit);
		iv_Info = (ImageView) findViewById(R.id.iv_Info);

		iv_Slate.setOnClickListener(this);
		iv_Uml.setOnClickListener(this);
		iv_Exit.setOnClickListener(this);
		iv_Info.setOnClickListener(this);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// Resetting the alpha values
		iv_Slate.setAlpha(1f);
		iv_Uml.setAlpha(1f);
		iv_Exit.setAlpha(1f);
		iv_Info.setAlpha(1f);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.iv_Slate: // SLATE IS CLICKED
			iv_Slate.setAlpha(0.5f);
			startActivity(new Intent(ModeSelect.this, Slate.class));
			break;

		case R.id.iv_Uml: // UML IS CLICKED
			iv_Uml.setAlpha(0.5f);
			startActivity(new Intent(ModeSelect.this, Uml_Menu.class));
			break;

		case R.id.iv_Exit: // EXIT IS CLICKED
			iv_Exit.setAlpha(0.5f);
			onBackPressed();
			break;

		case R.id.iv_Info: // INFO IS CLICKED
			iv_Info.setAlpha(0.5f);
			startActivity(new Intent(ModeSelect.this, AboutUs.class));
			break;

		}
	}

	@Override
	public void onBackPressed() {
	    new AlertDialog.Builder(this)
	           .setMessage("Are you sure you want to exit?")
	           .setCancelable(false)
	           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                    ModeSelect.this.finish();
	               }
	           })
	           .setNegativeButton("No", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	            	   iv_Exit.setAlpha(1f);
	               }
	           })
	           .show();
	}
}
