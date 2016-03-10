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
public class Temperature extends SensorData{

    public final static String UNIT ="℃";
	
    private double value;
  



    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


}
