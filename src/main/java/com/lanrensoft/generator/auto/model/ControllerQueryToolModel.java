package com.lanrensoft.generator.auto.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张钦 on 2016/7/29.
 */
public class ControllerQueryToolModel extends BaseBuildModel {
    @Override
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
    private List<ControllerQueryModel> criterias;
    private String basePackage;

    public List<ControllerQueryModel> getCriterias() {
        return criterias;
    }

    public void setCriterias(List<ControllerQueryModel> criterias) {
        this.criterias = criterias;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
