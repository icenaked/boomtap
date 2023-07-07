package com.zyq.boomtap.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//仅运行时有效
@Retention(RetentionPolicy.RUNTIME)
//作用在方法上，不作用在类上
@Target(ElementType.METHOD)
public @interface Log {

}
