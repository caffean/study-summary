package com.example.studydemo.listener;

import com.example.studydemo.config.SocketSessionMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;

/**
 * @Classname STOMPConnectEventListener
 * @Description 监听webSocket服务器的连接只需要实现ApplicationListener<>接口
 * @Date 2019/9/18 16:16
 * @Author lyn
 */
@Component
public class STOMPConnectEventListener implements ApplicationListener<SessionConnectEvent> {

    @Autowired
    SocketSessionMap socketSessionMap;

    //@Override
    //public void onApplicationEvent(SessionConnectEvent event) {
    //    StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
    //    //判断客户端的连接状态
    //    switch (sha.getCommand()) {
    //        case CONNECT:
    //            System.out.println("上线");
    //            break;
    //        case DISCONNECT:
    //            System.out.println("下线");
    //            break;
    //        case SUBSCRIBE:
    //            System.out.println("订阅");
    //            break;
    //        case SEND:
    //            System.out.println("发送");
    //            break;
    //        case UNSUBSCRIBE:
    //            System.out.println("取消订阅");
    //            break;
    //        default:
    //            break;
    //    }


    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        String userId = sha.getFirstNativeHeader("id");
        String sessionId = sha.getSessionId();
        switch (sha.getCommand()) {
            case CONNECT:
                System.out.println("上线：" + userId + "  " + sessionId);
                socketSessionMap.registerSession(userId, sessionId);
                break;
            default:
                break;
        }
    }

}
