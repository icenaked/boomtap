package com.zyq.boomtap.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {
    Integer id;
    Integer operateUser;
    LocalDateTime operateTime;
    String className;
    String methodName;
    String methodParams;
    String returnValue;
    Long costTime;
}
