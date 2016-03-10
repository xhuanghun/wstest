package cn.cjtblog.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TestHandler extends TextWebSocketHandler {
	private static Logger logger=LoggerFactory.getLogger(TestHandler.class);
	@Override
	public void handleMessage(WebSocketSession session,
			WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		logger.info("recieve message" +message);
	}

}
