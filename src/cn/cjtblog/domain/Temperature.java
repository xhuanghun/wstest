package cn.cjtblog.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "t_temperature")
public class Temperature {

    public final static String UNIT ="…„ œ∂»";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveTime;
    private double value;
    @ManyToOne
    private Node node;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
