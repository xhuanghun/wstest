
package cn.cjtblog.webSocketHandler;

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.cjtblog.service.ImageService;
import cn.cjtblog.util.SpringUtil;

/**
 *
 * @author cai
 */
@ServerEndpoint("/image/{nodeName}")
public class ImageHandler {

	private static Logger log = LoggerFactory.getLogger(ImageHandler.class);

	private ImageService imageService = (ImageService) SpringUtil.getBean("imageService");
	private String sendTimeStr;

	@OnOpen
	public void onOpen(Session session, EndpointConfig config, @PathParam("nodeName") String nodeName) {
		log.info("nodeName : " + nodeName);
		log.info(config.getDecoders().toString());
		log.info(config.getEncoders().toString());
		log.info(config.getUserProperties().toString());
	}

	@OnMessage
	public void textMessage(Session session, String msg, @PathParam("nodeName") String nodeName) {
		log.info("nodeName : " + nodeName);
		sendTimeStr = msg;
	}

	@OnMessage
	public void binaryMessage(Session session, ByteBuffer msg, @PathParam("nodeName") String nodeName) {
		byte[] bytes = msg.array();
		imageService.addImage(nodeName, bytes, sendTimeStr);

	}

	@OnMessage
	public void pongMessage(Session session, PongMessage msg) {
		throw new UnsupportedOperationException("can't handle pongMessage");
	}

	@OnClose
	public void onClose(Session session, CloseReason reason) {
		log.info("onClose");
		System.out.println("onclose");
		log.info(reason.toString());
	}

	@OnError
	public void onError(Session session, Throwable t) {
		log.warn(getClass().toString(), t);
		try {
			session.close();
		} catch (IOException ex) {
			log.warn(getClass().toString(), ex);
		}
	}
}
