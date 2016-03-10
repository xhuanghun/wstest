package cn.cjtblog.domain;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public class SensorData extends BaseEntity {
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss:SSS")
	private Date receiveTime;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss:SSS")
	private Date sendTime;
	@ManyToOne
	private Node node;
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}

	
}
