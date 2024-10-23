package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.HangbanYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 起飞降落请求
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("hangban_yuyue")
public class HangbanYuyueView extends HangbanYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String hangbanYuyueYesnoValue;

	//级联表 航班信息
		/**
		* 航班名称
		*/

		@ColumnInfo(comment="航班名称",type="varchar(200)")
		private String hangbanName;
		/**
		* 航班编号
		*/

		@ColumnInfo(comment="航班编号",type="varchar(200)")
		private String hangbanUuidNumber;
		/**
		* 航班照片
		*/

		@ColumnInfo(comment="航班照片",type="varchar(200)")
		private String hangbanPhoto;
		/**
		* 航班地点
		*/

		@ColumnInfo(comment="航班地点",type="varchar(200)")
		private String hangbanAddress;
		/**
		* 航班类型
		*/
		@ColumnInfo(comment="航班类型",type="int(11)")
		private Integer hangbanTypes;
			/**
			* 航班类型的值
			*/
			@ColumnInfo(comment="航班类型的字典表值",type="varchar(200)")
			private String hangbanValue;
		/**
		* 跑道
		*/

		@ColumnInfo(comment="跑道",type="int(11)")
		private Integer hangbanPaodao;
		/**
		* 朝向
		*/

		@ColumnInfo(comment="朝向",type="varchar(200)")
		private String hangbanChaoxaing;
		/**
		* 时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="时间",type="timestamp")
		private Date hangbanTime;
		/**
		* 航班状态
		*/
		@ColumnInfo(comment="航班状态",type="int(11)")
		private Integer hangbanZhuangtaiTypes;
			/**
			* 航班状态的值
			*/
			@ColumnInfo(comment="航班状态的字典表值",type="varchar(200)")
			private String hangbanZhuangtaiValue;
		/**
		* 航班介绍
		*/

		@ColumnInfo(comment="航班介绍",type="longtext")
		private String hangbanContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer hangbanDelete;
	//级联表 用户
		/**
		* 用户编号
		*/

		@ColumnInfo(comment="用户编号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public HangbanYuyueView() {

	}

	public HangbanYuyueView(HangbanYuyueEntity hangbanYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, hangbanYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getHangbanYuyueYesnoValue() {
		return hangbanYuyueYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setHangbanYuyueYesnoValue(String hangbanYuyueYesnoValue) {
		this.hangbanYuyueYesnoValue = hangbanYuyueYesnoValue;
	}


	//级联表的get和set 航班信息

		/**
		* 获取： 航班名称
		*/
		public String getHangbanName() {
			return hangbanName;
		}
		/**
		* 设置： 航班名称
		*/
		public void setHangbanName(String hangbanName) {
			this.hangbanName = hangbanName;
		}

		/**
		* 获取： 航班编号
		*/
		public String getHangbanUuidNumber() {
			return hangbanUuidNumber;
		}
		/**
		* 设置： 航班编号
		*/
		public void setHangbanUuidNumber(String hangbanUuidNumber) {
			this.hangbanUuidNumber = hangbanUuidNumber;
		}

		/**
		* 获取： 航班照片
		*/
		public String getHangbanPhoto() {
			return hangbanPhoto;
		}
		/**
		* 设置： 航班照片
		*/
		public void setHangbanPhoto(String hangbanPhoto) {
			this.hangbanPhoto = hangbanPhoto;
		}

		/**
		* 获取： 航班地点
		*/
		public String getHangbanAddress() {
			return hangbanAddress;
		}
		/**
		* 设置： 航班地点
		*/
		public void setHangbanAddress(String hangbanAddress) {
			this.hangbanAddress = hangbanAddress;
		}
		/**
		* 获取： 航班类型
		*/
		public Integer getHangbanTypes() {
			return hangbanTypes;
		}
		/**
		* 设置： 航班类型
		*/
		public void setHangbanTypes(Integer hangbanTypes) {
			this.hangbanTypes = hangbanTypes;
		}


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

		/**
		* 获取： 跑道
		*/
		public Integer getHangbanPaodao() {
			return hangbanPaodao;
		}
		/**
		* 设置： 跑道
		*/
		public void setHangbanPaodao(Integer hangbanPaodao) {
			this.hangbanPaodao = hangbanPaodao;
		}

		/**
		* 获取： 朝向
		*/
		public String getHangbanChaoxaing() {
			return hangbanChaoxaing;
		}
		/**
		* 设置： 朝向
		*/
		public void setHangbanChaoxaing(String hangbanChaoxaing) {
			this.hangbanChaoxaing = hangbanChaoxaing;
		}

		/**
		* 获取： 时间
		*/
		public Date getHangbanTime() {
			return hangbanTime;
		}
		/**
		* 设置： 时间
		*/
		public void setHangbanTime(Date hangbanTime) {
			this.hangbanTime = hangbanTime;
		}
		/**
		* 获取： 航班状态
		*/
		public Integer getHangbanZhuangtaiTypes() {
			return hangbanZhuangtaiTypes;
		}
		/**
		* 设置： 航班状态
		*/
		public void setHangbanZhuangtaiTypes(Integer hangbanZhuangtaiTypes) {
			this.hangbanZhuangtaiTypes = hangbanZhuangtaiTypes;
		}


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

		/**
		* 获取： 航班介绍
		*/
		public String getHangbanContent() {
			return hangbanContent;
		}
		/**
		* 设置： 航班介绍
		*/
		public void setHangbanContent(String hangbanContent) {
			this.hangbanContent = hangbanContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getHangbanDelete() {
			return hangbanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setHangbanDelete(Integer hangbanDelete) {
			this.hangbanDelete = hangbanDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户编号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 用户编号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "HangbanYuyueView{" +
			", hangbanYuyueYesnoValue=" + hangbanYuyueYesnoValue +
			", hangbanName=" + hangbanName +
			", hangbanUuidNumber=" + hangbanUuidNumber +
			", hangbanPhoto=" + hangbanPhoto +
			", hangbanAddress=" + hangbanAddress +
			", hangbanPaodao=" + hangbanPaodao +
			", hangbanChaoxaing=" + hangbanChaoxaing +
			", hangbanTime=" + DateUtil.convertString(hangbanTime,"yyyy-MM-dd") +
			", hangbanContent=" + hangbanContent +
			", hangbanDelete=" + hangbanDelete +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
