package com.dao;

import com.entity.ZhilingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhilingView;

/**
 * 塔台指令 Dao 接口
 *
 * @author 
 */
public interface ZhilingDao extends BaseMapper<ZhilingEntity> {

   List<ZhilingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
