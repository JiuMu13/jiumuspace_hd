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
@TableName("qt_user")
@ApiModel(value = "QtUser对象", description = "")
public class QtUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键，自增")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户详细信息（暂未实现）")
    private Long detailId;

    @ApiModelProperty("用户昵称（可重复）")
    private String name;

    @ApiModelProperty("用户账号")
    private String account;

    @ApiModelProperty("用户密码")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "QtUser{" +
            "id = " + id +
            ", detailId = " + detailId +
            ", name = " + name +
            ", account = " + account +
            ", password = " + password +
        "}";
    }
}
