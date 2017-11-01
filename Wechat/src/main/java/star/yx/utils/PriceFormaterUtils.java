package star.yx.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 处理价格相关的工具类
 */

public class PriceFormaterUtils {
    /**
     * @param price
     * @return
     * 格式化人民币
     */
    public static String format(Double price){
        NumberFormat  numberFormat  = NumberFormat.getCurrencyInstance();
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format(price);
    }

    /**
     * @param d
     * @return
     * 将double类型转换为两位小数的字符串
     */
    public  static String formatDouble2String(double d){
        DecimalFormat df   = new DecimalFormat("######0.00");
       return df.format(d);
    }
}
