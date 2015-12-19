package com.example.function;

import java.io.IOException;

import android.R;
import android.content.Context;
import android.media.MediaPlayer;

public class PlayVoice {
      
	   private  MediaPlayer     Player;
     private    String path ;
     private   Context context;
	
	    public  PlayVoice(){
	    	
	    }
	
	   public   PlayVoice(MediaPlayer   player  ,Context context){
		      this.Player = player;
		      this.context = context;
	   }
	   
	   public  void  start() throws IllegalStateException, IOException
	   {
		           if(this.Player == null){
		        	    this.Player = new MediaPlayer();
		          	 path = "";
		        	 
		      	  this.Player.setDataSource(path);
		        	
			          this.Player.prepare();
		        	   
		           }
		           this.Player.start();
		         
	   }
	
}
