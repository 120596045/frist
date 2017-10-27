package  Dao;

import java.util.List;
import java.util.Map;

import entity.Car;

public interface CarDao {

	//插入购物车
	public abstract int insert(Map<String, Object> mapGoods);
	
	//根据用户名查找购物车
	public abstract List<Car> getCarByName(String name);
	
	//根据商品Id查找
	public abstract int getCarById(Integer id);
	
	//去重复查询
	public abstract List<Car> getCarGroupBy(String name);
	
	//根据id删除
	public abstract int del(Integer id);
	
	//根据商品名字和g_num删除
	public abstract int delCarByMap(String gname);
	
	//修改商品数量
	public abstract int update(Map<String, Object> mapCar);
	
	//购物车总计
	public abstract Double total(String name);
	
}
