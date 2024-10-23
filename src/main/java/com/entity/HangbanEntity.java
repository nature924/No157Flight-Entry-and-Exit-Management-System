package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 航班信息
 *
 * @author 
 * @email
 */
@TableName("hangban")
public class HangbanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HangbanEntity() {

	}

	public HangbanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 航班名称
     */
    @ColumnInfo(comment="航班名称",type="varchar(200)")
    @TableField(value = "hangban_name")

    private String hangbanName;


    /**
     * 航班编号
     */
    @ColumnInfo(comment="航班编号",type="varchar(200)")
    @TableField(value = "hangban_uuid_number")

    private String hangbanUuidNumber;


    /**
     * 航班照片
     */
    @ColumnInfo(comment="航班照片",type="varchar(200)")
    @TableField(value = "hangban_photo")

    private String hangbanPhoto;


    /**
     * 航班地点
     */
    @ColumnInfo(comment="航班地点",type="varchar(200)")
    @TableField(value = "hangban_address")

    private String hangbanAddress;


    /**
     * 航班类型
     */
    @ColumnInfo(comment="航班类型",type="int(11)")
    @TableField(value = "hangban_types")

    private Integer hangbanTypes;


    /**
     * 跑道
     */
    @ColumnInfo(comment="跑道",type="int(11)")
    @TableField(value = "hangban_paodao")

    private Integer hangbanPaodao;


    /**
     * 朝向
     */
    @ColumnInfo(comment="朝向",type="varchar(200)")
    @TableField(value = "hangban_chaoxaing")

    private String hangbanChaoxaing;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="时间",type="timestamp")
    @TableField(value = "hangban_time")

    private Date hangbanTime;


    /**
     * 航班状态
     */
    @ColumnInfo(comment="航班状态",type="int(11)")
    @TableField(value = "hangban_zhuangtai_types")

    private Integer hangbanZhuangtaiTypes;


    /**
     * 航班介绍
     */
    @ColumnInfo(comment="航班介绍",type="longtext")
    @TableField(value = "hangban_content")

    private String hangbanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "hangban_delete")

    private Integer hangbanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：航班名称
	 */
    public String getHangbanName() {
        return hangbanName;
    }
    /**
	 * 设置：航班名称
	 */

    public void setHangbanName(String hangbanName) {
        this.hangbanName = hangbanName;
    }
    /**
	 * 获取：航班编号
	 */
    public String getHangbanUuidNumber() {
        return hangbanUuidNumber;
    }
    /**
	 * 设置：航班编号
	 */

    public void setHangbanUuidNumber(String hangbanUuidNumber) {
        this.hangbanUuidNumber = hangbanUuidNumber;
    }
    /**
	 * 获取：航班照片
	 */
    public String getHangbanPhoto() {
        return hangbanPhoto;
    }
    /**
	 * 设置：航班照片
	 */

    public void setHangbanPhoto(String hangbanPhoto) {
        this.hangbanPhoto = hangbanPhoto;
    }
    /**
	 * 获取：航班地点
	 */
    public String getHangbanAddress() {
        return hangbanAddress;
    }
    /**
	 * 设置：航班地点
	 */

    public void setHangbanAddress(String hangbanAddress) {
        this.hangbanAddress = hangbanAddress;
    }
    /**
	 * 获取：航班类型
	 */
    public Integer getHangbanTypes() {
        return hangbanTypes;
    }
    /**
	 * 设置：航班类型
	 */

    public void setHangbanTypes(Integer hangbanTypes) {
        this.hangbanTypes = hangbanTypes;
    }
    /**
	 * 获取：跑道
	 */
    public Integer getHangbanPaodao() {
        return hangbanPaodao;
    }
    /**
	 * 设置：跑道
	 */

    public void setHangbanPaodao(Integer hangbanPaodao) {
        this.hangbanPaodao = hangbanPaodao;
    }
    /**
	 * 获取：朝向
	 */
    public String getHangbanChaoxaing() {
        return hangbanChaoxaing;
    }
    /**
	 * 设置：朝向
	 */

    public void setHangbanChaoxaing(String hangbanChaoxaing) {
        this.hangbanChaoxaing = hangbanChaoxaing;
    }
    /**
	 * 获取：时间
	 */
    public Date getHangbanTime() {
        return hangbanTime;
    }
    /**
	 * 设置：时间
	 */

    public void setHangbanTime(Date hangbanTime) {
        this.hangbanTime = hangbanTime;
    }
    /**
	 * 获取：航班状态
	 */
    public Integer getHangbanZhuangtaiTypes() {
        return hangbanZhuangtaiTypes;
    }
    /**
	 * 设置：航班状态
	 */

    public void setHangbanZhuangtaiTypes(Integer hangbanZhuangtaiTypes) {
        this.hangbanZhuangtaiTypes = hangbanZhuangtaiTypes;
    }
    /**
	 * 获取：航班介绍
	 */
    public String getHangbanContent() {
        return hangbanContent;
    }
    /**
	 * 设置：航班介绍
	 */

    public void setHangbanContent(String hangbanContent) {
        this.hangbanContent = hangbanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getHangbanDelete() {
        return hangbanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setHangbanDelete(Integer hangbanDelete) {
        this.hangbanDelete = hangbanDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Hangban{" +
            ", id=" + id +
            ", hangbanName=" + hangbanName +
            ", hangbanUuidNumber=" + hangbanUuidNumber +
            ", hangbanPhoto=" + hangbanPhoto +
            ", hangbanAddress=" + hangbanAddress +
            ", hangbanTypes=" + hangbanTypes +
            ", hangbanPaodao=" + hangbanPaodao +
            ", hangbanChaoxaing=" + hangbanChaoxaing +
            ", hangbanTime=" + DateUtil.convertString(hangbanTime,"yyyy-MM-dd") +
            ", hangbanZhuangtaiTypes=" + hangbanZhuangtaiTypes +
            ", hangbanContent=" + hangbanContent +
            ", hangbanDelete=" + hangbanDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
