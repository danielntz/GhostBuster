package com.example.data;

import com.example.ghostbuster.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * 幽灵种类
 */
public class Ghost {
     
	   private   static   int    i ;      //幽灵的种类  不同的数字代表不同的幽灵类型
	  private   Bitmap    bitmap;
	   public   Ghost (){
		   
	   }
      
	    public      Bitmap  kindghost(int  i){
	    	   
	    	    switch (i) {
				case    0:
					   bitmap = BitmapFactory.decodeResource(null,R.drawable.ghost0);
					break;
				case 1:
				
					 break;
					
				case 2:
					 
					break;
			
				}  
	    	return  bitmap;
	    }
	
}
