package com.lanrensoft.generator.auto.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张钦 on 2016/6/28.
 */
public class FormImageModel extends BaseBuildModel {

    private String ctxPath = "${ctxPath}";
    private String coulumnTitle;
    private String coulumnCaseName;
    private String formValue;
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if (obj != null) {
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public String getCtxPath() {
        return ctxPath;
    }

    public void setCtxPath(String ctxPath) {
        this.ctxPath = ctxPath;
    }

    public String getCoulumnTitle() {
        return coulumnTitle;
    }

    public void setCoulumnTitle(String coulumnTitle) {
        this.coulumnTitle = coulumnTitle;
    }

    public String getCoulumnCaseName() {
        return coulumnCaseName;
    }

    public void setCoulumnCaseName(String coulumnCaseName) {
        this.coulumnCaseName = coulumnCaseName;
    }

    public String getFormValue() {
        return formValue;
    }

    public void setFormValue(String formValue) {
        this.formValue = formValue;
    }
}
