package com.gemini.ssm.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: linyijin
 * @Date: Created in 2018/2/1 10:20
 * @Description: mybatis逆向工程main函数
 **/
public class GenUtils {
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String genCfg = "/generatorConfig.xml";
        File configFile = new File(GenUtils.class.getResource(genCfg).getFile());
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration configuration = null;
        try {
            configuration = configurationParser.parseConfiguration(configFile);
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = null;
        try {
            myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        try {
            myBatisGenerator.generate(null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
