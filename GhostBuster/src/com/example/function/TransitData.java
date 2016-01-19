package com.example.function;

import com.example.data.Point;
 

/**
 * 进行不同界面的传值
 * @author jsjxy
 *
 */
public class TransitData {
        
	
	      public   static   Point  ghostpoints[] = new Point[6];    //用来保存幽灵的坐标点
	      public   static   Point  miaozhunpoints= new Point();    //用来保存按下的瞄准点的坐标
	      public    static  float     down_X;      //按下的横坐标
	  	  public    static   float   down_Y;     //按下的纵坐标
	  	  public     static   boolean   isdown ;   //是否发生了按下动作
	     public     static    boolean   zidanshu ; // 按下瞄准器，发出一颗子弹
	     public    static    int         score;                //如果分数达到250，则就是弹出升级界面
	  	 public   static    boolean     judge = false ;      //判断是否要在屏幕上显示文字
	  	 public   static    Boolean    jiantingcondition  = true; // 判断是否要弹出角色升级界面
	  	 
	     public   static boolean   isjianting(){
	    	 return jiantingcondition;
	     }
	     public  static void setjianting(boolean   jianting){
	    	   TransitData.jiantingcondition = jianting;
	     }
	     
	  	  public static boolean isJudge() {
			return judge;
		}
		public static void setJudge(boolean judge) {
			TransitData.judge = judge;
		}
		public static int getScore() {
			return score;
		}
		public static void setScore(int score) {
			TransitData.score = score;
		}
		public static boolean isZidanshu() {
			return zidanshu;
		}
		public static void setZidanshu(boolean zidanshu) {
			TransitData.zidanshu = zidanshu;
		}
		public static boolean isIsdown() {
			return isdown;
		}
		public static void setIsdown(boolean isdown) {
			  TransitData.isdown = isdown;
		}
		public static float getDown_X() {
			return down_X;
		}
		public static void setDown_X(float down_X) {
			TransitData.down_X = down_X;
		}
		public static float getDown_Y() {
			return down_Y;
		}
		public static void setDown_Y(float down_Y) {
			TransitData.down_Y = down_Y;
		}
		//获得幽灵出现的位置坐标
	       public static Point[] getGhostpoints() {
			return ghostpoints;
		}
		public static void setGhostpoints(Point[] ghostpoints) {
			TransitData.ghostpoints = ghostpoints;
		}
		//获得当前瞄准器的位置坐标
		public static Point getMiaozhunpoints() {
			return miaozhunpoints;
		}
		public static void setMiaozhunpoints(Point miaozhunpoints) {
			TransitData.miaozhunpoints = miaozhunpoints;
		}
	
	         
	     
	       
	
	
	
	
}
