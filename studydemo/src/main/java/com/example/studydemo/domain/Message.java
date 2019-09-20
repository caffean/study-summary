package com.example.studydemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Message
 * @Description TODO
 * @Date 2019/9/18 16:27
 * @Author lyn
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private int id; //用户ID
    private String content;//发送内容
    private int pid;    //发送到用户
}
