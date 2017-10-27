package biz;

import java.util.List;
import java.util.Map;

import entity.Car;

public interface CarBiz {

	//插入购物车
	public abstract int save(Map<String, Object> mapGoods);
	
	//根据用户名查找购物车
	public abstract List<Car> getCarByName(String name);
	
	//根据id删除
	public abstract int del(Integer id);
	
	//根据商品名字删除
	public abstract int delCarByMap(String gname);
	
	//修改商品数量
	public abstract int updateNum(Map<String, Object> mapCar);
	
	//根据商品Id查找
	public abstract int getCarById(Integer id);
	
	//去重复查询
	public abstract List<Car> getCarGroupBy(String name);
	
	//购物车总计
	public abstract Double total(String name);
}
