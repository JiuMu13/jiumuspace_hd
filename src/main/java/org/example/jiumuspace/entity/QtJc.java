package org.example.jiumuspace.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author jiumu
 * @since 2024-03-12
 */
@TableName("qt_jc")
@ApiModel(value = "QtJc对象", description = "")
public class QtJc implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("以路径方式命名，主键唯一")
    private String id;

    @ApiModelProperty("网页内容（markdown格式）")
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "QtJc{" +
            "id = " + id +
            ", text = " + text +
        "}";
    }
}
