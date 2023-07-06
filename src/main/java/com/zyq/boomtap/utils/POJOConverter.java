package com.zyq.boomtap.utils;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Plain Old Java Object：简单、传统的java对象，强调不依赖特定框架和技术，POJO名称由Martin Fowler等人提出。
 * PO\VO等对象相互转换，仅按字段名称进行复制
 * @author fanyanpeng
 * @date 2023/4/11 4:21
 */
@Slf4j
public class POJOConverter {


    /**
     * 使用Spring自带的转换器进行字段复制
     * @date 2023/4/11 4:22
     * @param from 原对象
     * @param to 目的对象
     * @return void
     */
    public static void convert(Object from, Object to){
        BeanUtils.copyProperties(from, to);
    }


    /**
     * 完成属性的简单复制
     * @date 2023/4/11 21:32
     * @param from 原对象
     * @param toClass 目标类
     * @return java.lang.Object
     */
    @SneakyThrows
    public static Object convertTo(Object from, Class toClass){
        Object to = toClass.getDeclaredConstructor().newInstance();
        BeanUtils.copyProperties(from,to);
        return to;
    }



//    static Map<Class, Class> convertMap=new HashMap<>();
//    static {
//        convertMap.put(AnalysisConfig.class, AnalysisConfigVO.class);
//        convertMap.put(AnalysisPipeline.class, AnalysisPipelineVO.class);
//        convertMap.put(AnalysisVisualization.class, AnalysisVisualizationVO.class);
//        convertMap.put(Config.class, ConfigVO.class);
//        convertMap.put(Deployment.class, DeploymentVO.class);
//        convertMap.put(FileField.class, FileFieldVO.class);
//        convertMap.put(FileInfo.class, FileInfoVO.class);
//        convertMap.put(MachineLearningPipeline.class, MachineLearningPipelineVO.class);
//        convertMap.put(Model.class, ModelVO.class);
//        convertMap.put(Prediction.class, PredictionVO.class);
//        convertMap.put(User.class, UserVO.class);
//        // 将转换类反着来一遍。
//        List<Class> keys =new ArrayList<>(convertMap.keySet());
//        for(Class key : keys){
//            Class value = convertMap.get(key);
//            convertMap.put(value,key);
//        }
//    }

    /**
     * 递归地进行转换，PO\VO互转
     * @date 2023/4/11 22:51
     * @param fromObj
     * @return java.lang.Object
     */
//    @SneakyThrows
//    public static Object convert(Object fromObj){
//        if(fromObj == null){
//            log.warn("转换POJO对象出现了传入值为null值");
//            return null;
//        }
//        Class fromClass = fromObj.getClass();
//        Class toClass = convertMap.get(fromClass);
//
//        Object toObj =  toClass.getDeclaredConstructor().newInstance();
//        BeanUtils.copyProperties(fromObj, toObj);
//        try{
//            Field[] fields = fromClass.getDeclaredFields();
//            for(Field fromField:fields){
//                fromField.setAccessible(true);
//                Class fromFieldClass = fromField.getType();
//                String fieldName = fromField.getName();
//                Object subObj=null;
//                // 列表
//                if(fromFieldClass.equals(List.class)){
//                    Type type = fromField.getGenericType();
//                    ParameterizedType parameterizedType = (ParameterizedType) type;
//
//                    Class subClass =(Class) parameterizedType.getActualTypeArguments()[0];
//                    // 若列表内可以转换
//                    if(convertMap.keySet().contains(subClass)){
//
//                        List<?> fromList = (List<?>)fromField.get(fromObj);
//                        // 只有List不为空的时候才需要遍历
//                        if(fromList != null){
//                            List<Object> toList = new ArrayList<>();
//                            for(Object item:fromList){
//                                toList.add(convert(item));
//                            }
//                            subObj = toList;
//                        }
//                    }
//                }
//                // 若直接是需要转换的
//                if(convertMap.keySet().contains(fromFieldClass)){
//                    Object fieldValue = fromField.get(fromObj);
//                    subObj = convert(fieldValue);
//                }
//                // 若该字段转换成功了
//                if(subObj!=null){
//                    Field toField = toClass.getDeclaredField(fieldName);//获取所有字段
//                    toField.setAccessible(true);
//                    toField.set(toObj,subObj);
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            log.error("转换出错");
//        }
//
//        return toObj;
//    }

}
