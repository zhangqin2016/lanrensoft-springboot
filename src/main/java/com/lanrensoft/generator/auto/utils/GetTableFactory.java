package com.lanrensoft.generator.auto.utils;/**
 * Created by zhangqin on 2017/5/12.
 */


import com.lanrensoft.generator.auto.model.Table;

import java.util.List;

/**
 * 获取数据结构工厂类
 *
 * @author
 * @create 2017-05-12 9:17
 **/
public interface GetTableFactory {
    List<Table> getTable();
}
