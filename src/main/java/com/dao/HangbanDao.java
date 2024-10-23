package com.dao;

import com.entity.HangbanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HangbanView;

/**
 * 航班信息 Dao 接口
 *
 * @author 
 */
public interface HangbanDao extends BaseMapper<HangbanEntity> {

   List<HangbanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
