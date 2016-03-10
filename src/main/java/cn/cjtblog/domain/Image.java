package cn.cjtblog.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_image")
public class Image extends SensorData{
	public static final String SUFFIX = ".jpg";
	public static final String SAVEIMAGEDIR = System.getProperty("IOTWebSocket.root");
	public static final String IMAGEBASICURL ="IOTImage/";
	private String URL;
	public String getURL() {
		return URL;
	}
	public void setURL(String URL) {
		this.URL = URL;
	}
}
