package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.HangbanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 航班信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("hangban")
public class HangbanView extends HangbanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 航班类型的值
	*/
	@ColumnInfo(comment="航班类型的字典表值",type="varchar(200)")
	private String hangbanValue;
	/**
	* 航班状态的值
	*/
	@ColumnInfo(comment="航班状态的字典表值",type="varchar(200)")
	private String hangbanZhuangtaiValue;




	public HangbanView() {

	}

	public HangbanView(HangbanEntity hangbanEntity) {
		try {
			BeanUtils.copyProperties(this, hangbanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 航班类型的值
	*/
	public String getHangbanValue() {
		return hangbanValue;
	}
	/**
	* 设置： 航班类型的值
	*/
	public void setHangbanValue(String hangbanValue) {
		this.hangbanValue = hangbanValue;
	}
	//当前表的
	/**
	* 获取： 航班状态的值
	*/
	public String getHangbanZhuangtaiValue() {
		return hangbanZhuangtaiValue;
	}
	/**
	* 设置： 航班状态的值
	*/
	public void setHangbanZhuangtaiValue(String hangbanZhuangtaiValue) {
		this.hangbanZhuangtaiValue = hangbanZhuangtaiValue;
	}




	@Override
	public String toString() {
		return "HangbanView{" +
			", hangbanValue=" + hangbanValue +
			", hangbanZhuangtaiValue=" + hangbanZhuangtaiValue +
			"} " + super.toString();
	}
}
