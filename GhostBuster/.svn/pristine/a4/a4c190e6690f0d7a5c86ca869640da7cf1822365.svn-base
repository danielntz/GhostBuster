package com.example.ghostbuster;

import com.example.UI.AboutView;
import com.example.UI.AchievementView;
import com.example.UI.Gameview;
import com.example.UI.RegisterView;
import com.example.UI.ShareView;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private   ImageButton    kaishi;
	private   ImageButton    fenxiang;
	private   ImageButton   chengjiu;
	private   ImageButton   guanyu;
	private   ImageButton   zhuce;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.denglujiemian_activity);
        initzuijan();       //初始化所有组件



	}
	//初始化界面中的组件
	public  void  initzuijan(){

		kaishi =  (ImageButton) findViewById(R.id.play);
		fenxiang =  (ImageButton) findViewById(R.id.share);
		chengjiu =  (ImageButton) findViewById(R.id.achievement);
		guanyu =  (ImageButton) findViewById(R.id.about);
		zhuce  = (ImageButton)findViewById(R.id.register);
		kaishi.setOnClickListener(this);
		fenxiang.setOnClickListener(this);
		chengjiu.setOnClickListener(this);
		guanyu.setOnClickListener(this);
		zhuce.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.play:
			Intent  intent  = new Intent(MainActivity.this, Gameview.class);
			startActivity(intent);
         	break;
		case R.id.share:
            Intent intent1= new Intent(MainActivity.this,ShareView.class);
            startActivity(intent1);
			break;
		case R.id.achievement:
            Intent intent2 = new Intent(MainActivity.this,AchievementView.class);
            startActivity(intent2);
			break;
		case R.id.about:
          Intent intent3 = new Intent(MainActivity.this,AboutView.class);
          startActivity(intent3);
			break;
		case R.id.register:
			Intent intent4 = new Intent(MainActivity.this,RegisterView.class);
			startActivity(intent4);
			break;

		}
	}


}
