package com.example.listener;
/**
 * 当点击屏幕时会发生反馈动作
 * @author jsjxy
 *
 */
public interface OnActionListener {
          
	     //幽灵的状态
	    public  void     ghoststate();
	   //子弹数量减少
	    public  void     bulletcondition();
	   //每击中一个幽灵，会增加得分
	    public  void     addscore();
}
