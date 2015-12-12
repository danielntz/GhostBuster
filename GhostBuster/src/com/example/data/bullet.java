package com.example.data;

import com.example.ghostbuster.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class bullet {
             
	   private   Bitmap   kindbullet;
	   private   int          i ;                            //×Óµ¯ÐÍºÅ0 £¬ 1 £¬2
	  public   bullet(){
		  
	  }
	  public   bullet(Bitmap   bullet){
		     this.kindbullet = bullet;
	  }
	   
	  public  Bitmap  currentkind(int  i){
		      switch (i) {
			    case 0:
				       kindbullet =  BitmapFactory.decodeResource(null, R.drawable.zidan);
				       break;
			   
			    	  
			     case 1:
			       break;
			    case 2:
                 break;
			}
              return  kindbullet;
		    
	  }
	  
}
