package com.lanrensoft.generator;


import com.lanrensoft.generator.util.GeneratorConfigXml;
import com.lanrensoft.generator.util.GeneratorMetadata;

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
