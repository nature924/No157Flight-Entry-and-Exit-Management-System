package com.entity.vo;

import com.entity.HangbanYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 起飞降落请求
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("hangban_yuyue")
public class HangbanYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "hangban_yuyue_uuid_number")
    private String hangbanYuyueUuidNumber;


    /**
     * 航班
     */

    @TableField(value = "hangban_id")
    private Integer hangbanId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 理由
     */

    @TableField(value = "hangban_yuyue_text")
    private String hangbanYuyueText;


    /**
     * 航班报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 报名状态
     */

    @TableField(value = "hangban_yuyue_yesno_types")
    private Integer hangbanYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "hangban_yuyue_yesno_text")
    private String hangbanYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "hangban_yuyue_shenhe_time")
    private Date hangbanYuyueShenheTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：报名编号
	 */
    public String getHangbanYuyueUuidNumber() {
        return hangbanYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setHangbanYuyueUuidNumber(String hangbanYuyueUuidNumber) {
        this.hangbanYuyueUuidNumber = hangbanYuyueUuidNumber;
    }
    /**
	 * 设置：航班
	 */
    public Integer getHangbanId() {
        return hangbanId;
    }


    /**
	 * 获取：航班
	 */

    public void setHangbanId(Integer hangbanId) {
        this.hangbanId = hangbanId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：理由
	 */
    public String getHangbanYuyueText() {
        return hangbanYuyueText;
    }


    /**
	 * 获取：理由
	 */

    public void setHangbanYuyueText(String hangbanYuyueText) {
        this.hangbanYuyueText = hangbanYuyueText;
    }
    /**
	 * 设置：航班报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：航班报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getHangbanYuyueYesnoTypes() {
        return hangbanYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setHangbanYuyueYesnoTypes(Integer hangbanYuyueYesnoTypes) {
        this.hangbanYuyueYesnoTypes = hangbanYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getHangbanYuyueYesnoText() {
        return hangbanYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setHangbanYuyueYesnoText(String hangbanYuyueYesnoText) {
        this.hangbanYuyueYesnoText = hangbanYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getHangbanYuyueShenheTime() {
        return hangbanYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setHangbanYuyueShenheTime(Date hangbanYuyueShenheTime) {
        this.hangbanYuyueShenheTime = hangbanYuyueShenheTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
