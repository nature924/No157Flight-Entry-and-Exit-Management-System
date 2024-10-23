
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
 * 航班信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/hangban")
public class HangbanController {
    private static final Logger logger = LoggerFactory.getLogger(HangbanController.class);

    private static final String TABLE_NAME = "hangban";

    @Autowired
    private HangbanService hangbanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private HangbanYuyueService hangbanYuyueService;//起飞降落请求
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
        params.put("hangbanDeleteStart",1);params.put("hangbanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = hangbanService.queryPage(params);

        //字典表数据转换
        List<HangbanView> list =(List<HangbanView>)page.getList();
        for(HangbanView c:list){
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
        HangbanEntity hangban = hangbanService.selectById(id);
        if(hangban !=null){
            //entity转view
            HangbanView view = new HangbanView();
            BeanUtils.copyProperties( hangban , view );//把实体数据重构到view中
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
    public R save(@RequestBody HangbanEntity hangban, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,hangban:{}",this.getClass().getName(),hangban.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HangbanEntity> queryWrapper = new EntityWrapper<HangbanEntity>()
            .eq("hangban_name", hangban.getHangbanName())
            .eq("hangban_address", hangban.getHangbanAddress())
            .eq("hangban_types", hangban.getHangbanTypes())
            .eq("hangban_paodao", hangban.getHangbanPaodao())
            .eq("hangban_chaoxaing", hangban.getHangbanChaoxaing())
            .eq("hangban_zhuangtai_types", hangban.getHangbanZhuangtaiTypes())
            .eq("hangban_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HangbanEntity hangbanEntity = hangbanService.selectOne(queryWrapper);
        if(hangbanEntity==null){
            hangban.setHangbanDelete(1);
            hangban.setInsertTime(new Date());
            hangban.setCreateTime(new Date());
            hangbanService.insert(hangban);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HangbanEntity hangban, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,hangban:{}",this.getClass().getName(),hangban.toString());
        HangbanEntity oldHangbanEntity = hangbanService.selectById(hangban.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(hangban.getHangbanPhoto()) || "null".equals(hangban.getHangbanPhoto())){
                hangban.setHangbanPhoto(null);
        }
        if("".equals(hangban.getHangbanContent()) || "null".equals(hangban.getHangbanContent())){
                hangban.setHangbanContent(null);
        }

            hangbanService.updateById(hangban);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HangbanEntity> oldHangbanList =hangbanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<HangbanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            HangbanEntity hangbanEntity = new HangbanEntity();
            hangbanEntity.setId(id);
            hangbanEntity.setHangbanDelete(2);
            list.add(hangbanEntity);
        }
        if(list != null && list.size() >0){
            hangbanService.updateBatchById(list);
        }

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
            List<HangbanEntity> hangbanList = new ArrayList<>();//上传的东西
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
                            HangbanEntity hangbanEntity = new HangbanEntity();
//                            hangbanEntity.setHangbanName(data.get(0));                    //航班名称 要改的
//                            hangbanEntity.setHangbanUuidNumber(data.get(0));                    //航班编号 要改的
//                            hangbanEntity.setHangbanPhoto("");//详情和图片
//                            hangbanEntity.setHangbanAddress(data.get(0));                    //航班地点 要改的
//                            hangbanEntity.setHangbanTypes(Integer.valueOf(data.get(0)));   //航班类型 要改的
//                            hangbanEntity.setHangbanPaodao(Integer.valueOf(data.get(0)));   //跑道 要改的
//                            hangbanEntity.setHangbanChaoxaing(data.get(0));                    //朝向 要改的
//                            hangbanEntity.setHangbanTime(sdf.parse(data.get(0)));          //时间 要改的
//                            hangbanEntity.setHangbanZhuangtaiTypes(Integer.valueOf(data.get(0)));   //航班状态 要改的
//                            hangbanEntity.setHangbanContent("");//详情和图片
//                            hangbanEntity.setHangbanDelete(1);//逻辑删除字段
//                            hangbanEntity.setInsertTime(date);//时间
//                            hangbanEntity.setCreateTime(date);//时间
                            hangbanList.add(hangbanEntity);


                            //把要查询是否重复的字段放入map中
                                //航班编号
                                if(seachFields.containsKey("hangbanUuidNumber")){
                                    List<String> hangbanUuidNumber = seachFields.get("hangbanUuidNumber");
                                    hangbanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> hangbanUuidNumber = new ArrayList<>();
                                    hangbanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("hangbanUuidNumber",hangbanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //航班编号
                        List<HangbanEntity> hangbanEntities_hangbanUuidNumber = hangbanService.selectList(new EntityWrapper<HangbanEntity>().in("hangban_uuid_number", seachFields.get("hangbanUuidNumber")).eq("hangban_delete", 1));
                        if(hangbanEntities_hangbanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HangbanEntity s:hangbanEntities_hangbanUuidNumber){
                                repeatFields.add(s.getHangbanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [航班编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        hangbanService.insertBatch(hangbanList);
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
        PageUtils page = hangbanService.queryPage(params);

        //字典表数据转换
        List<HangbanView> list =(List<HangbanView>)page.getList();
        for(HangbanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HangbanEntity hangban = hangbanService.selectById(id);
            if(hangban !=null){


                //entity转view
                HangbanView view = new HangbanView();
                BeanUtils.copyProperties( hangban , view );//把实体数据重构到view中

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
    public R add(@RequestBody HangbanEntity hangban, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,hangban:{}",this.getClass().getName(),hangban.toString());
        Wrapper<HangbanEntity> queryWrapper = new EntityWrapper<HangbanEntity>()
            .eq("hangban_name", hangban.getHangbanName())
            .eq("hangban_uuid_number", hangban.getHangbanUuidNumber())
            .eq("hangban_address", hangban.getHangbanAddress())
            .eq("hangban_types", hangban.getHangbanTypes())
            .eq("hangban_paodao", hangban.getHangbanPaodao())
            .eq("hangban_chaoxaing", hangban.getHangbanChaoxaing())
            .eq("hangban_zhuangtai_types", hangban.getHangbanZhuangtaiTypes())
            .eq("hangban_delete", hangban.getHangbanDelete())
//            .notIn("hangban_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HangbanEntity hangbanEntity = hangbanService.selectOne(queryWrapper);
        if(hangbanEntity==null){
            hangban.setHangbanDelete(1);
            hangban.setInsertTime(new Date());
            hangban.setCreateTime(new Date());
        hangbanService.insert(hangban);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

