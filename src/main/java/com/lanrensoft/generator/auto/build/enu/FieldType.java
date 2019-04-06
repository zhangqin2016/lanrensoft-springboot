package com.lanrensoft.generator.auto.build.enu;/**
 * Created by zhangqin on 2017/11/16.
 */

/**
 * @author
 * @create 2017-11-16 17:24
 **/
public enum  FieldType {
    SELECT("_select_","多选"),
    IMAGE("_img","图片"),
    DIC("_dic_","字典"),
    DATE("_date","日期"),
    FILE("_file","附件"),
    HTML("_html","富文本"),
    TEXTAREA("_textarea","多选"),
    RADIO("_radio_","单选按钮")
    ;
    private String type;
    private String des;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    FieldType(String type, String des) {
        this.type = type;
        this.des = des;
    }

}
