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
 * 起飞降落请求
 *
 * @author 
 * @email
 */
@TableName("hangban_yuyue")
public class HangbanYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HangbanYuyueEntity() {

	}

	public HangbanYuyueEntity(T t) {
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
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "hangban_yuyue_uuid_number")

    private String hangbanYuyueUuidNumber;


    /**
     * 航班
     */
    @ColumnInfo(comment="航班",type="int(11)")
    @TableField(value = "hangban_id")

    private Integer hangbanId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 理由
     */
    @ColumnInfo(comment="理由",type="longtext")
    @TableField(value = "hangban_yuyue_text")

    private String hangbanYuyueText;


    /**
     * 航班报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="航班报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "hangban_yuyue_yesno_types")

    private Integer hangbanYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "hangban_yuyue_yesno_text")

    private String hangbanYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "hangban_yuyue_shenhe_time")

    private Date hangbanYuyueShenheTime;


    /**
     * 创建时间  listShow
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
	 * 获取：报名编号
	 */
    public String getHangbanYuyueUuidNumber() {
        return hangbanYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setHangbanYuyueUuidNumber(String hangbanYuyueUuidNumber) {
        this.hangbanYuyueUuidNumber = hangbanYuyueUuidNumber;
    }
    /**
	 * 获取：航班
	 */
    public Integer getHangbanId() {
        return hangbanId;
    }
    /**
	 * 设置：航班
	 */

    public void setHangbanId(Integer hangbanId) {
        this.hangbanId = hangbanId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：理由
	 */
    public String getHangbanYuyueText() {
        return hangbanYuyueText;
    }
    /**
	 * 设置：理由
	 */

    public void setHangbanYuyueText(String hangbanYuyueText) {
        this.hangbanYuyueText = hangbanYuyueText;
    }
    /**
	 * 获取：航班报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：航班报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getHangbanYuyueYesnoTypes() {
        return hangbanYuyueYesnoTypes;
    }
    /**
	 * 设置：报名状态
	 */

    public void setHangbanYuyueYesnoTypes(Integer hangbanYuyueYesnoTypes) {
        this.hangbanYuyueYesnoTypes = hangbanYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getHangbanYuyueYesnoText() {
        return hangbanYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setHangbanYuyueYesnoText(String hangbanYuyueYesnoText) {
        this.hangbanYuyueYesnoText = hangbanYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getHangbanYuyueShenheTime() {
        return hangbanYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setHangbanYuyueShenheTime(Date hangbanYuyueShenheTime) {
        this.hangbanYuyueShenheTime = hangbanYuyueShenheTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "HangbanYuyue{" +
            ", id=" + id +
            ", hangbanYuyueUuidNumber=" + hangbanYuyueUuidNumber +
            ", hangbanId=" + hangbanId +
            ", yonghuId=" + yonghuId +
            ", hangbanYuyueText=" + hangbanYuyueText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", hangbanYuyueYesnoTypes=" + hangbanYuyueYesnoTypes +
            ", hangbanYuyueYesnoText=" + hangbanYuyueYesnoText +
            ", hangbanYuyueShenheTime=" + DateUtil.convertString(hangbanYuyueShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
