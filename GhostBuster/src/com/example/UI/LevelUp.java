package com.example.UI;

import com.example.ghostbuster.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.PopupWindow;

public class LevelUp   extends  Activity {
   
	    private   PopupWindow    levelwindow ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.levelup_activity);
		 levelwindow = new PopupWindow();
				 
		
		
		
		
	}

	
	    
}
