package com.yyh.outandinconfig.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "str")
    private String str;

    public User(Long id,String name){
        this.id = id;
        this.name = name;
    }

    public String getStr(){
        return "重写get方法:"+id+name;
    }
}
