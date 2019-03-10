package com.lanrensoft.generator.util;

/**
 * <p>
 * title:
 * </p>
 * <p>
 * description:自动生成常量类
 * </p>
 *
 * @author 张钦
 * @version 1.0
 * @create zhangqin
 * @update
 * @date 2016年3月9日
 */
public class BuildNameTool {
    public static String getName(String tableName) {
        String s[] = tableName.split("_");
        StringBuilder buffer = new StringBuilder();
        for (String string : s) {
            buffer.append(string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase()));
        }
        return buffer.toString();
    }
    public static String getMyBatisColumnName(String tableName) {
        String s[] = tableName.split("_");
        StringBuilder buffer = new StringBuilder();
        for (String string : s) {
            if(string.length()==1){
                buffer.append(string);
            }else {
                buffer.append(string.replaceFirst(string.substring(0, 1), string.substring(0, 1).toUpperCase()));
            }
        }
        return buffer.toString();
    }
    public static String getCaseName(String tableName) {
        String firesStr = getName(tableName).substring(0, 1).toLowerCase();
        return firesStr + getName(tableName).substring(1);
    }

}
