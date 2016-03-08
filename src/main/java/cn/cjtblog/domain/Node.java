/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.cjtblog.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author cai
 */
@Entity
@Table(name = "t_node")
public class Node {



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;


	private String nodeName;
    private double longitude;
    private double latitude;
    @OneToMany(mappedBy="node")
    private Set<Image> images=new HashSet<>();
    @OneToMany(mappedBy="node")
    private Set<Temperature> temperatures=new HashSet<>();
    @OneToMany(mappedBy="node",fetch=FetchType.EAGER)
    private Set<Smoke> smokes=new HashSet<>();
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }



    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<Temperature> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(Set<Temperature> temperatures) {
        this.temperatures = temperatures;
    }

    public Set<Smoke> getSmokes() {
        return smokes;
    }

    public void setSmokes(Set<Smoke> smokes) {
        this.smokes = smokes;
    }

	@Override
	public String toString() {
		return "Node [id=" + id + ", nodeName=" + nodeName + ", longitude=" + longitude + ", latitude=" + latitude
				+ "]";
	}


    
}
