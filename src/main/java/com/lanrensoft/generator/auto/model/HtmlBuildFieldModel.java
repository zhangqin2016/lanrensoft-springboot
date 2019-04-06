package com.lanrensoft.generator.auto.model;/**
 * Created by zhangqin on 2017/5/24.
 */

/**
 * js和html类
 *
 * @author
 * @create 2017-05-24 15:27
 **/
public class HtmlBuildFieldModel {

    private String js;
    private String html;

    public String getJs() {
        return js;
    }

    public HtmlBuildFieldModel(String js, String html) {
        this.js = js;
        this.html = html;
    }

    public void setJs(String js) {
        this.js = js;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
