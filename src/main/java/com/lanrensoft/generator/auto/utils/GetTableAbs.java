package com.lanrensoft.generator.auto.utils;/**
 * Created by zhangqin on 2017/5/12.
 */

import com.lanrensoft.common.kit.PathKit;
import com.lanrensoft.common.kit.Prop;
import com.lanrensoft.common.kit.PropKit;
import com.lanrensoft.generator.auto.model.Table;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.util.List;

/**
 * @author 张钦
 * @create 2017-05-12 9:20
 **/
public abstract class GetTableAbs implements GetTableFactory {
    protected static DataSource dataSource;
    protected static JdbcTemplate jdbcTemplate;

    static {
        dataSource = getDataSource(GetTable.prop);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private static DriverManagerDataSource getDataSource(Prop map) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(map.get("jdbc.driver"));
        dataSource.setUrl(map.get("jdbc.url"));
        dataSource.setUsername(map.get("jdbc.username"));
        dataSource.setPassword(map.get("jdbc.password"));
        return dataSource;
    }
    @Override
    public abstract List<Table> getTable();
}
