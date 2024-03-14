package org.example.jiumuspace.service;

import org.example.jiumuspace.entity.QtJcDh;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiumu
 * @since 2024-03-12
 */
public interface IQtJcDhService extends IService<QtJcDh> {
    public String getIndex();
    public void addFirstIndex(String name);
    public String getFirstIndex();
    public void changeFirstIndex(Long id,String name);
    public void deleteFirstIndex(Long id);

    public void addSecondIndex(Long parentId,String name, String url);
    public String getSecondIndex(Long parentId);
    public void changeSecondIndex(Long id,String name,String url);
    public void deleteSecondIndex(Long id);
}
