package cn.cjtblog.dao;

import java.util.List;

import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Temperature;

public interface TemperatureDAO {

    public void addTemperature(Temperature temperature);

    public List<Temperature> getAllTemperatures();

    public void deleteTemperature(Temperature temperature);

    public Temperature getNewestTempertuareByNode(Node node);

	public Temperature getTemmperatureById(long id);
}
