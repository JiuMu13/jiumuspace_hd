package org.example.jiumuspace.service.impl;

import com.alibaba.fastjson.JSON;
import net.sf.jsqlparser.statement.create.table.Index;
import org.example.jiumuspace.entity.Index2;
import org.example.jiumuspace.entity.IndexList;
import org.example.jiumuspace.entity.QtJcDh;
import org.example.jiumuspace.mapper.QtJcDhMapper;
import org.example.jiumuspace.service.IQtJcDhService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiumu
 * @since 2024-03-12
 */
@Service
public class QtJcDhServiceImpl extends ServiceImpl<QtJcDhMapper, QtJcDh> implements IQtJcDhService {

    @Autowired
    QtJcDhMapper qtJcDhMapper;

    @Override
    public String getIndex() {
        //查询所有顶层接口
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("parentId",-1);
        List<QtJcDh> index = qtJcDhMapper.selectByMap(map);
        IndexList[] list=new IndexList[index.size()];
        int i=0;
        for (QtJcDh qtJcDh : index) {
            list[i]=new IndexList();
            list[i].setName(qtJcDh.getName());
            HashMap<String, Object> map2 = new HashMap<>(1);
            map2.put("parentId",qtJcDh.getId());
            List<QtJcDh> index2 = qtJcDhMapper.selectByMap(map2);
            Index2[] children=new Index2[index2.size()];
            int j=0;
            for (QtJcDh jcDh : index2) {
                Index2 t = new Index2(jcDh.getName(), jcDh.getUrl());
                children[j++]=t;
            }
            list[i++].setChildren(children);
        }
        return JSON.toJSONString(list);
    }
}
