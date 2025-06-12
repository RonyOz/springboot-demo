package com.example.springboot_demo.websocket;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CustomWebSocketHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(), session);
        session.sendMessage(new TextMessage("Hola desde el servidor!"));
        System.out.println("Nueva conexión WebSocket: " + session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());
        session.close();
        System.out.println("Conexión cerrada: " + session.getId());

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Mensaje recibido: " + message.getPayload());
        System.out.println("Mensaje recibido: " + session.isOpen());
        // Ejemplo: enviar solo a quien envió el mensaje
        // session.sendMessage(new TextMessage("Tu mensaje fue recibido"));
    }

}