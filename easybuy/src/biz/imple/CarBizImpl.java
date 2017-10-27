package biz.imple;

import java.util.List;
import java.util.Map;

import biz.CarBiz;
import Dao.CarDao;
import Dao.imple.CarDaoImpl;
import entity.Car;

public class CarBizImpl implements CarBiz {

	CarDao cDao = new CarDaoImpl();
	
	//插入购物车
	@Override
	public int save(Map<String, Object> mapGoods) {
		// TODO Auto-generated method stub
		return cDao.insert(mapGoods);
	}

	//根据用户名查找购物车
	@Override
	public List<Car> getCarByName(String name) {
		// TODO Auto-generated method stub
		return cDao.getCarByName(name);
	}

	//根据id删除
	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		return cDao.del(id);
	}

	//修改商品数量
	@Override
	public int updateNum(Map<String, Object> mapCar) {
		// TODO Auto-generated method stub
		return cDao.update(mapCar);
	}

	//根据商品Id查找
	@Override
	public int getCarById(Integer id) {
		// TODO Auto-generated method stub
		return cDao.getCarById(id);
	}

	//去重复查询
	@Override
	public List<Car> getCarGroupBy(String name) {
		// TODO Auto-generated method stub
		return cDao.getCarGroupBy(name);
	}

	//根据商品名字和g_num删除
	@Override
	public int delCarByMap(String gname) {
		// TODO Auto-generated method stub
		return cDao.delCarByMap(gname);
	}

	//购物车总计
	@Override
	public Double total(String name) {
		// TODO Auto-generated method stub
		return cDao.total(name);
	}

}
