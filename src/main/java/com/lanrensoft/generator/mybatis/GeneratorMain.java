package com.lanrensoft.generator.mybatis;


import com.lanrensoft.generator.mybatis.util.GeneratorConfigXml;
import com.lanrensoft.generator.mybatis.util.GeneratorMetadata;

/**
 * Created by zhangqin on 2016/4/8.
 */
public class GeneratorMain {
    public static void main(String[] args) {
        String generatorConfigPath = GeneratorConfigXml.generate();
        GeneratorMetadata.remove();
        GeneratorMetadata.generate(generatorConfigPath);
    }
}
