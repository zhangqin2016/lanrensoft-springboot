package com.lanrensoft.generator.lanren.handler;

import com.lanrensoft.generator.lanren.model.Table;
import com.lanrensoft.generator.lanren.model.TemplateData;

/**

* @Description:  

* @Author:         zhangqin

* @CreateDate:     2019/4/6 0006 23:32

* @UpdateUser:     zhangqin

* @UpdateDate:     2019/4/6 0006 23:32

* @UpdateRemark:   

* @Version:        1.0

*/
public interface IBuildDataHandler<T> {

    public TemplateData<T> getData(Table table);
}
