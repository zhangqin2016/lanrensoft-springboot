package com.lanrensoft.generator.lanren.handler;

import com.lanrensoft.generator.lanren.model.TemplateData;

/**

* @Description:    模板创建

* @Author:         zhangqin

* @CreateDate:      2019/4/5 10:15
*/
public interface ITemplateHandler<T> {

    /**
     *
     * @param templatePath
     * @param templateData
     * @return
     */
    public String getTempalteCode(String templatePath, TemplateData<T> templateData);
}
