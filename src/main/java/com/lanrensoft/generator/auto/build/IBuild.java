package com.lanrensoft.generator.auto.build;

import com.lanrensoft.generator.auto.model.Table;

import java.util.List;

/**
 * Created by 张钦 on 2016/6/16.
 */
public interface IBuild {
    void build(List<Table> tables, String src, boolean isReplace);
    void build(List<Table> tables, String src);
}
