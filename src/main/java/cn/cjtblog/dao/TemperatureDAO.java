package cn.cjtblog.dao;

import java.util.List;

import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Smoke;
import cn.cjtblog.domain.Temperature;

public interface TemperatureDAO {

    public void add(Temperature temperature);

    public List<Temperature> getAll();

    public void delete(Temperature temperature);

    public Temperature getNewestByNode(Node node);

	public Temperature getById(long id);
	public List<Temperature> getAllByNode(Node node);
}
