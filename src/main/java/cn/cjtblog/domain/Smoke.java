package cn.cjtblog.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cai
 */
@Entity
@Table(name = "t_smoke")
public class Smoke extends SensorData{

    public static final String UNIT = "PPM";
	
    private double value;
   
    public double getValue() {
        return value;
    }

}
