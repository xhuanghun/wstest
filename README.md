# wstest

> 基于Spring4+JPA2+JSR-356实现的物联网WebSocket服务后台，JSR-356规范定义了包括了Websocket客户端和服务端的整套java Websocket api. Tomcat自7.0.47版本开始也提供了对JSR-356支持

##网页端演示
本项目服务端通过开放以下webSocket端点进行数据的发送和采集
* ws://{server}/image/{nodeName} 作为图像采集服务端点
* ws://{server}/image/{nodeName} 作为温度采集服务端点
* ws://{server}/image/{nodeName} 作为烟雾采集服务端点
* 任何支持webSocket的客户端均可以采用以下流程进行数据的发送向webSocket URL
创建webSocket的连接->发送采集时间(文本格式：yyyy/MM/dd HH:mm:ss:SSS)->发送数据（二进制图片数据或者温度烟雾文本数据)->(循环发送或者断开连接)
* 以下是通过网页端进行模拟测试（网页端的图像采集模块在有带摄像头的火狐44.0.2和IE EdGE，手机版火狐能够很好的运行，新版的chrome 由于安全的原因，已经禁止在非https的域进行摄像头调用。)
![演示地址]http://cjtblog.cn/wstest/
