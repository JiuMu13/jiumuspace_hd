package mtbatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CreateCode {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/jiumuspace?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8", "root", "root")
                .globalConfig(builder -> {
                    builder.author("jiumu") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("D://mybatis"); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);
                }))
                .packageConfig(builder -> {
                    builder.parent("org.example.jiumuspace") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://mybatis")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("qt_user").addInclude("qt_jc").addInclude("qt_dh");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
