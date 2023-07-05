package com.zyq.boomtap.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data=@Getter+@Setter+@ToString+@EqualsAndHashCode
@Data
//无参与有参（除了static字段外）构造方法
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    private String username;

    private String password;

    private String email;

    private Short age;

    private String sex;

    private String tel;

    private String addr;

    private String card;

    private Short married;

    private Double salary;

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                ", email='" + email + '\'' +
//                ", age=" + age +
//                ", sex='" + sex + '\'' +
//                ", tel='" + tel + '\'' +
//                ", addr='" + addr + '\'' +
//                ", card='" + card + '\'' +
//                ", married=" + married +
//                ", salary=" + salary +
//                '}';
//    }
}
