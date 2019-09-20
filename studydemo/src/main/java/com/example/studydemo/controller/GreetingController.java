package com.example.studydemo.controller;

import com.example.studydemo.config.SocketSessionMap;
import com.example.studydemo.domain.Greeting;
import com.example.studydemo.domain.HelloMessage;
import com.example.studydemo.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

/**
 * @Classname GreetingController
 * @Description TODO
 * @Date 2019/9/18 15:43
 * @Author lyn
 */
@Controller
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    SocketSessionMap socketSessionMap;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        System.out.println("收到：" + message.toString() + "消息");
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/chatOut")
    public void sayHello(String userId) {
        String sessionId = socketSessionMap.getUserSessionId(userId);
        System.out.println("下线：" + userId + "  " + sessionId);
        socketSessionMap.removeSession(userId,sessionId);
    }


    @MessageMapping("/chat")
    public void sayHello(Message user) {
        System.out.println(user.getId()+"-->"+user.getPid()+":"+user.getContent());
        String userPid = String.valueOf(user.getPid());
        String userId = String.valueOf(user.getId());
        String sendTo = "/topic/chat/"+userPid;
        String content = user.getId()+":"+user.getContent();
        if (socketSessionMap.getUserSessionId(userPid)!=null){
            messagingTemplate.convertAndSend(sendTo, HtmlUtils.htmlEscape(content));
        }else {
            sendTo = "/topic/chat/"+userId;
            content = "对方已下线";
            messagingTemplate.convertAndSend(sendTo, HtmlUtils.htmlEscape(content));
        }
    }

    /**
     * 服务端使用FreeMarker模板引擎返回html网页
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/chat/{id}")
    public String chat_page(@PathVariable int id, ModelMap model) {
        model.addAttribute("id", id);
        int count = socketSessionMap.onlineCount();
        model.addAttribute("count", count);
        return "chat";
    }
}
