

package cn.cjtblog.webSocketHandler;

import java.io.IOException;

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

import cn.cjtblog.service.SmokeService;
import cn.cjtblog.util.SpringUtil;

/**
 *
 * @author cai
 */
@ServerEndpoint("/smoke/{nodeName}")
public class SmokeHandler {
	private static Logger logger = LoggerFactory.getLogger(SmokeHandler.class);
   
    private  SmokeService smokeService =  (SmokeService) SpringUtil.getBean("smokeService");
    private String sendTimeStr;
    private String valueStr;
    private String nodeName;
    private int receivePhase=0;
    @OnOpen
    public void onOpen(Session session, EndpointConfig config,@PathParam("nodeName")String nodeName) {
    	logger.info("nodeName : "+nodeName);
        this.nodeName=nodeName;
    }

    @OnMessage
    public void textMessage(Session session, String msg) {
    	logger.info("msg :"+msg);
        if(receivePhase==0){
            sendTimeStr=msg;
            receivePhase=1;
        }
        else{
            valueStr=msg;
            smokeService.addSmoke(nodeName, valueStr, sendTimeStr);
            logger.info("handle success");
            receivePhase=0;
        }
    }

    @OnMessage
    public void pongMessage(Session session, PongMessage msg) {
;
            throw new UnsupportedOperationException("can't handle pongMessage");
    }
    @OnClose
    public void onClose(Session session,CloseReason reason){
    	logger.info("onClose");
    	logger.info(reason.toString());
    }
    @OnError
    public void onError(Session session,Throwable t){
    	logger.warn(getClass().toString(), t);
		try {
			session.close();
		} catch (IOException ex) {
			logger.warn(getClass().toString(), ex);
		}
    }
}
