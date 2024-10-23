package com.entity.model;

import com.entity.HangbanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 航班信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HangbanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 航班名称
     */
    private String hangbanName;


    /**
     * 航班编号
     */
    private String hangbanUuidNumber;


    /**
     * 航班照片
     */
    private String hangbanPhoto;


    /**
     * 航班地点
     */
    private String hangbanAddress;


    /**
     * 航班类型
     */
    private Integer hangbanTypes;


    /**
     * 跑道
     */
    private Integer hangbanPaodao;


    /**
     * 朝向
     */
    private String hangbanChaoxaing;


    /**
     * 时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date hangbanTime;


    /**
     * 航班状态
     */
    private Integer hangbanZhuangtaiTypes;


    /**
     * 航班介绍
     */
    private String hangbanContent;


    /**
     * 逻辑删除
     */
    private Integer hangbanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
