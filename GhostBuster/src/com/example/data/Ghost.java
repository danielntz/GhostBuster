package com.example.data;

import com.example.ghostbuster.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * ��������
 */
public class Ghost {
     
	   private   static   int    i ;      //���������  ��ͬ�����ִ���ͬ����������
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
