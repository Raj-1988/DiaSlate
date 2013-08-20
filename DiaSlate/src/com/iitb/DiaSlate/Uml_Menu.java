package com.iitb.DiaSlate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Uml_Menu extends Activity implements OnClickListener{

	static boolean isToBeEdited = false;
	static boolean isToBeViewed = false;
	ImageView iv_NewUml, iv_EditUml, iv_ViewUml, iv_HelpUml;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.uml_menu);
		
		iv_NewUml = (ImageView)findViewById(R.id.iv_NewUml);
		iv_EditUml = (ImageView)findViewById(R.id.iv_EditUml);
		iv_ViewUml = (ImageView)findViewById(R.id.iv_ViewUml);
		iv_HelpUml = (ImageView)findViewById(R.id.iv_HelpUml);
		
		iv_NewUml.setOnClickListener(this);
		iv_EditUml.setOnClickListener(this);
		iv_ViewUml.setOnClickListener(this);
		iv_HelpUml.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.iv_NewUml: // NEW UML IS CLICKED
			iv_NewUml.setAlpha(0.5f);
			isToBeEdited  = false;
			isToBeViewed = false;
			startActivity(new Intent(Uml_Menu.this, MainActivity.class));
			break;

		case R.id.iv_EditUml: // EDIT UML IS CLICKED
			iv_EditUml.setAlpha(0.5f);
			isToBeEdited  = true;
			isToBeViewed = false;
			startActivity(new Intent(Uml_Menu.this, FileList.class));
			break;

		case R.id.iv_ViewUml: // VIEW UML IS CLICKED
			iv_ViewUml.setAlpha(0.5f);
			isToBeEdited  = false;
			isToBeViewed = true;
			startActivity(new Intent(Uml_Menu.this, FileList.class));
			break;

		case R.id.iv_HelpUml: // HELP IS CLICKED
			iv_HelpUml.setAlpha(0.5f);
			startActivity(new Intent(Uml_Menu.this, Helpuml.class));
			break;

		}
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		iv_EditUml.setAlpha(1f);
		iv_ViewUml.setAlpha(1f);
		iv_NewUml.setAlpha(1f);
		iv_HelpUml.setAlpha(1f);
	}


}
