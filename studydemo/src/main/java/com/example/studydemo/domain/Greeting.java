package com.example.studydemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Greeting
 * @Description TODO
 * @Date 2019/9/18 15:44
 * @Author lyn
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {

    private String content;
}
