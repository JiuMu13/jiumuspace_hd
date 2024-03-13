package org.example.jiumuspace.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("qt_jc_dh")
@ApiModel(value = "QtJcDh对象", description = "")
public class QtJcDh implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("导航名")
    private String name;

    @ApiModelProperty("父类id,顶层为-1")
    private Long parentId;

    @ApiModelProperty("url地址")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "QtJcDh{" +
            "id = " + id +
            ", name = " + name +
            ", parentId = " + parentId +
            ", url = " + url +
        "}";
    }
}
