package com.lanrensoft.generator.auto.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张钦 on 2016/6/16.
 */
public class ControllerModel extends BaseBuildModel {

    private String basePackage;
    private String description;
    private String createTime;
    private String author;
    private String beanName;
    private String caseBeanName;
    private String beanService;
    private String caseBeanService;
    private String baseUrl;
    private String idType;
    private String criteria;
    private String idName;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getCaseBeanName() {
        return caseBeanName;
    }

    public void setCaseBeanName(String caseBeanName) {
        this.caseBeanName = caseBeanName;
    }


    public String getBeanService() {
        return beanService;
    }

    public void setBeanService(String beanService) {
        this.beanService = beanService;
    }

    public String getCaseBeanService() {
        return caseBeanService;
    }

    public void setCaseBeanService(String caseBeanService) {
        this.caseBeanService = caseBeanService;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

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

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }
}
