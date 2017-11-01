package com.xujun.fragmenttabhostdemo.utils;

import android.widget.EditText;

/**
 * 
 * @author zhengpf
 * 2017-5-11
 * 类说明:EditText输入验证
 */
public class EditTextInputUtil {

	/**
	 * 输入小数时限制输入的小数位数
	 * @param text EditText控件
	 * @param s CharSequence对象
	 * @param limit 限制输入的位数
	 */
	public static void setEditTextAccuracy(EditText text, CharSequence s, int limit) {
		/**
         * 限制输入数据最多为 limit 位小数
         */
        if (s.toString().contains(".")) {
            if (s.length() - 1 - s.toString().indexOf(".") > limit) {
                s = s.toString().subSequence(0, s.toString().indexOf(".") + limit + 1);
                text.setText(s);
                text.setSelection(s.length());
            }
        }
        
        /**
         * 第一位输入小数点的话自动变换为 0.
         */
        if (s.toString().trim().substring(0).equals(".")) {
            s = "0" + s;
            text.setText(s);
            text.setSelection(text.getText().toString().length());
        }

        /**
         * 避免重复输入小数点前的0 ,没有意义
         */
        if (s.toString().startsWith("0") && s.toString().trim().length() > 1) {
            if (s.toString().contains(".")){
                if (!s.toString().substring(1, 2).equals(".")) {
                    String decimalText = s.toString().substring(s.toString().indexOf("."));
                    text.setText(s.subSequence(0, 1) + decimalText);
                    text.setSelection(1);
                    return;
                }
            }else {
                if (!s.toString().substring(1, 2).equals(".")) {
                    text.setText(s.subSequence(0, 1));
                    text.setSelection(1);
                    return;
                }
            }
        }
	}
}
