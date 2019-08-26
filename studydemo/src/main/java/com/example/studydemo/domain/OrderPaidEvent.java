package com.example.studydemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Classname OrderPaidEvent
 * @Description TODO
 * @Date 2019/8/26 15:28
 * @Author lyn
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPaidEvent {


    private String orderId;

    private BigDecimal num;

}
