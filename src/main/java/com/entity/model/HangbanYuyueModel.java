package com.entity.model;

import com.entity.HangbanYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 起飞降落请求
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HangbanYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String hangbanYuyueUuidNumber;


    /**
     * 航班
     */
    private Integer hangbanId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 理由
     */
    private String hangbanYuyueText;


    /**
     * 航班报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 报名状态
     */
    private Integer hangbanYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String hangbanYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date hangbanYuyueShenheTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
