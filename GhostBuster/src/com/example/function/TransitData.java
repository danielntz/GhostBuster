package com.example.function;

import com.example.data.Point;
 

/**
 * ���в�ͬ����Ĵ�ֵ
 * @author jsjxy
 *
 */
public class TransitData {
        
	
	      public   static   Point  ghostpoints[] = new Point[6];    //������������������
	      public   static   Point  miaozhunpoints= new Point();    //�������水�µ���׼�������
	      public    static  float     down_X;      //���µĺ�����
	  	  public    static   float   down_Y;     //���µ�������
	  	  public     static   boolean   isdown ;   //�Ƿ����˰��¶���
	     public     static    boolean   zidanshu ; // ������׼��������һ���ӵ�
	     public    static    int         score;                //��������ﵽ250������ǵ�����������
	  	 public   static    boolean     judge = false ;      //�ж��Ƿ�Ҫ����Ļ����ʾ����
	  	 public   static    Boolean    jiantingcondition  = true; // �ж��Ƿ�Ҫ������ɫ��������
	  	 
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
		//���������ֵ�λ������
	       public static Point[] getGhostpoints() {
			return ghostpoints;
		}
		public static void setGhostpoints(Point[] ghostpoints) {
			TransitData.ghostpoints = ghostpoints;
		}
		//��õ�ǰ��׼����λ������
		public static Point getMiaozhunpoints() {
			return miaozhunpoints;
		}
		public static void setMiaozhunpoints(Point miaozhunpoints) {
			TransitData.miaozhunpoints = miaozhunpoints;
		}
	
	         
	     
	       
	
	
	
	
}
