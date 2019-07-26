package com.wjup.websocket.controller;

import com.wjup.websocket.ProductWebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by wjup on 2019/7/26 12:24
 */
@Controller
public class IndexController {

    @Autowired
    private ProductWebSocket productWebSocket;

    @GetMapping("/")
    @ResponseBody
    public String index() {

        return "Hello world!this is SpringBoot+webSocket demo!";
    }

    /**
     * 系统给某人发送消息
     * http://127.0.0.1:12006/test?userId=wjup001&message=下个月加薪
     * @param userId 用户id
     * @param message 消息
     * @return 结果提示
     */
    @ResponseBody
    @GetMapping("/sysSend")
    public String test(String userId, String message){
        if ("".equals(userId) || userId == null) {
            return "发送用户id不能为空";
        }
        if ("".equals(message) || message == null) {
            return "发送信息不能为空";
        }
        productWebSocket.systemSendToUser(userId, message);
        return "发送成功！";
    }

    @RequestMapping(value = "/ws")
    public String ws() {
        return "ws";
    }

    @RequestMapping(value = "/ws1")
    public String ws1() {
        return "ws1";
    }

    /**
     * 给所有人发消息
     * @return 成功提示
     */
    @ResponseBody
    @GetMapping("/seedAll")
    public String sendAll(String message) {
        productWebSocket.sendAll(message);
        return "发送成功";
    }
}
