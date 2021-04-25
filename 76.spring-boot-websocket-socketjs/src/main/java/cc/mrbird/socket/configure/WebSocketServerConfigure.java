package cc.mrbird.socket.configure;

import cc.mrbird.socket.handler.MyStringWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author MrBird
 */
@Configuration
@EnableWebSocket //开启WebSocket相关功能
public class WebSocketServerConfigure implements WebSocketConfigurer {

    //注入创建的MyStringWebSocketHandler，并将其注册到了WebSocketHandlerRegistry
    @Autowired
    private MyStringWebSocketHandler myStringWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                //当客户端通过/connecturl和服务端连接通信时，使用MyStringWebSocketHandler处理会话
                .addHandler(myStringWebSocketHandler, "/connect")
                //withSockJS的含义是，通信的客户端是通过SockJS实现的
                .withSockJS();
    }
}
