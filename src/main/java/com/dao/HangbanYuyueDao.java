package com.dao;

import com.entity.HangbanYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HangbanYuyueView;

/**
 * 起飞降落请求 Dao 接口
 *
 * @author 
 */
public interface HangbanYuyueDao extends BaseMapper<HangbanYuyueEntity> {

   List<HangbanYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
