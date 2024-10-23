
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 起飞降落请求
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/hangbanYuyue")
public class HangbanYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(HangbanYuyueController.class);

    private static final String TABLE_NAME = "hangbanYuyue";

    @Autowired
    private HangbanYuyueService hangbanYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private HangbanService hangbanService;//航班信息
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZhilingService zhilingService;//塔台指令
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = hangbanYuyueService.queryPage(params);

        //字典表数据转换
        List<HangbanYuyueView> list =(List<HangbanYuyueView>)page.getList();
        for(HangbanYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HangbanYuyueEntity hangbanYuyue = hangbanYuyueService.selectById(id);
        if(hangbanYuyue !=null){
            //entity转view
            HangbanYuyueView view = new HangbanYuyueView();
            BeanUtils.copyProperties( hangbanYuyue , view );//把实体数据重构到view中
            //级联表 航班信息
            //级联表
            HangbanEntity hangban = hangbanService.selectById(hangbanYuyue.getHangbanId());
            if(hangban != null){
            BeanUtils.copyProperties( hangban , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setHangbanId(hangban.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(hangbanYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HangbanYuyueEntity hangbanYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,hangbanYuyue:{}",this.getClass().getName(),hangbanYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            hangbanYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<HangbanYuyueEntity> queryWrapper = new EntityWrapper<HangbanYuyueEntity>()
            .eq("hangban_id", hangbanYuyue.getHangbanId())
            .eq("yonghu_id", hangbanYuyue.getYonghuId())
            .in("hangban_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HangbanYuyueEntity hangbanYuyueEntity = hangbanYuyueService.selectOne(queryWrapper);
//        if(hangbanYuyueEntity==null){
            hangbanYuyue.setInsertTime(new Date());
            hangbanYuyue.setHangbanYuyueYesnoTypes(1);
            hangbanYuyue.setCreateTime(new Date());
            hangbanYuyueService.insert(hangbanYuyue);
            return R.ok();
//        }else {
//            if(hangbanYuyueEntity.getHangbanYuyueYesnoTypes()==1)
//                return R.error(511,"有相同的待审核的数据");
//            else if(hangbanYuyueEntity.getHangbanYuyueYesnoTypes()==2)
//                return R.error(511,"有相同的审核通过的数据");
//            else
//                return R.error(511,"表中有相同数据");
//        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HangbanYuyueEntity hangbanYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,hangbanYuyue:{}",this.getClass().getName(),hangbanYuyue.toString());
        HangbanYuyueEntity oldHangbanYuyueEntity = hangbanYuyueService.selectById(hangbanYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            hangbanYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(hangbanYuyue.getHangbanYuyueText()) || "null".equals(hangbanYuyue.getHangbanYuyueText())){
                hangbanYuyue.setHangbanYuyueText(null);
        }
        if("".equals(hangbanYuyue.getHangbanYuyueYesnoText()) || "null".equals(hangbanYuyue.getHangbanYuyueYesnoText())){
                hangbanYuyue.setHangbanYuyueYesnoText(null);
        }

            hangbanYuyueService.updateById(hangbanYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody HangbanYuyueEntity hangbanYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,hangbanYuyueEntity:{}",this.getClass().getName(),hangbanYuyueEntity.toString());

        HangbanYuyueEntity oldHangbanYuyue = hangbanYuyueService.selectById(hangbanYuyueEntity.getId());//查询原先数据

//        if(hangbanYuyueEntity.getHangbanYuyueYesnoTypes() == 2){//通过
//            hangbanYuyueEntity.setHangbanYuyueTypes();
//        }else if(hangbanYuyueEntity.getHangbanYuyueYesnoTypes() == 3){//拒绝
//            hangbanYuyueEntity.setHangbanYuyueTypes();
//        }
        hangbanYuyueEntity.setHangbanYuyueShenheTime(new Date());//审核时间
        hangbanYuyueService.updateById(hangbanYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HangbanYuyueEntity> oldHangbanYuyueList =hangbanYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        hangbanYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<HangbanYuyueEntity> hangbanYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HangbanYuyueEntity hangbanYuyueEntity = new HangbanYuyueEntity();
//                            hangbanYuyueEntity.setHangbanYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            hangbanYuyueEntity.setHangbanId(Integer.valueOf(data.get(0)));   //航班 要改的
//                            hangbanYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            hangbanYuyueEntity.setHangbanYuyueText(data.get(0));                    //理由 要改的
//                            hangbanYuyueEntity.setInsertTime(date);//时间
//                            hangbanYuyueEntity.setHangbanYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            hangbanYuyueEntity.setHangbanYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            hangbanYuyueEntity.setHangbanYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            hangbanYuyueEntity.setCreateTime(date);//时间
                            hangbanYuyueList.add(hangbanYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("hangbanYuyueUuidNumber")){
                                    List<String> hangbanYuyueUuidNumber = seachFields.get("hangbanYuyueUuidNumber");
                                    hangbanYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> hangbanYuyueUuidNumber = new ArrayList<>();
                                    hangbanYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("hangbanYuyueUuidNumber",hangbanYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<HangbanYuyueEntity> hangbanYuyueEntities_hangbanYuyueUuidNumber = hangbanYuyueService.selectList(new EntityWrapper<HangbanYuyueEntity>().in("hangban_yuyue_uuid_number", seachFields.get("hangbanYuyueUuidNumber")));
                        if(hangbanYuyueEntities_hangbanYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HangbanYuyueEntity s:hangbanYuyueEntities_hangbanYuyueUuidNumber){
                                repeatFields.add(s.getHangbanYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        hangbanYuyueService.insertBatch(hangbanYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = hangbanYuyueService.queryPage(params);

        //字典表数据转换
        List<HangbanYuyueView> list =(List<HangbanYuyueView>)page.getList();
        for(HangbanYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HangbanYuyueEntity hangbanYuyue = hangbanYuyueService.selectById(id);
            if(hangbanYuyue !=null){


                //entity转view
                HangbanYuyueView view = new HangbanYuyueView();
                BeanUtils.copyProperties( hangbanYuyue , view );//把实体数据重构到view中

                //级联表
                    HangbanEntity hangban = hangbanService.selectById(hangbanYuyue.getHangbanId());
                if(hangban != null){
                    BeanUtils.copyProperties( hangban , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHangbanId(hangban.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(hangbanYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody HangbanYuyueEntity hangbanYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,hangbanYuyue:{}",this.getClass().getName(),hangbanYuyue.toString());
        Wrapper<HangbanYuyueEntity> queryWrapper = new EntityWrapper<HangbanYuyueEntity>()
            .eq("hangban_yuyue_uuid_number", hangbanYuyue.getHangbanYuyueUuidNumber())
            .eq("hangban_id", hangbanYuyue.getHangbanId())
            .eq("yonghu_id", hangbanYuyue.getYonghuId())
            .eq("hangban_yuyue_text", hangbanYuyue.getHangbanYuyueText())
            .in("hangban_yuyue_yesno_types", new Integer[]{1,2})
            .eq("hangban_yuyue_yesno_text", hangbanYuyue.getHangbanYuyueYesnoText())
//            .notIn("hangban_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HangbanYuyueEntity hangbanYuyueEntity = hangbanYuyueService.selectOne(queryWrapper);
        if(hangbanYuyueEntity==null){
            hangbanYuyue.setInsertTime(new Date());
            hangbanYuyue.setHangbanYuyueYesnoTypes(1);
            hangbanYuyue.setCreateTime(new Date());
        hangbanYuyueService.insert(hangbanYuyue);

            return R.ok();
        }else {
            if(hangbanYuyueEntity.getHangbanYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(hangbanYuyueEntity.getHangbanYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
     * 参加
     */
    @RequestMapping("/qifei")
    public R qifei(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        HangbanYuyueEntity hangbanYuyueEntity = hangbanYuyueService.selectById(id);
        HangbanEntity hangbanEntity = hangbanService.selectById(hangbanYuyueEntity.getHangbanId());
        hangbanEntity.setHangbanZhuangtaiTypes(1);
        hangbanYuyueEntity.setHangbanYuyueYesnoTypes(5);
        hangbanService.updateById(hangbanEntity);
        hangbanYuyueService.updateById(hangbanYuyueEntity);
        return R.ok();
    }


    /**
     * 参加
     */
    @RequestMapping("/jiangluo")
    public R jiangluo(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        HangbanYuyueEntity hangbanYuyueEntity = hangbanYuyueService.selectById(id);
        HangbanEntity hangbanEntity = hangbanService.selectById(hangbanYuyueEntity.getHangbanId());
        hangbanEntity.setHangbanZhuangtaiTypes(2);
        hangbanYuyueEntity.setHangbanYuyueYesnoTypes(4);
        hangbanService.updateById(hangbanEntity);
        hangbanYuyueService.updateById(hangbanYuyueEntity);
        return R.ok();
    }


}

