package biz.imple;

import java.util.List;
import java.util.Map;

import biz.CarBiz;
import Dao.CarDao;
import Dao.imple.CarDaoImpl;
import entity.Car;

public class CarBizImpl implements CarBiz {

	CarDao cDao = new CarDaoImpl();
	
	//���빺�ﳵ
	@Override
	public int save(Map<String, Object> mapGoods) {
		// TODO Auto-generated method stub
		return cDao.insert(mapGoods);
	}

	//�����û������ҹ��ﳵ
	@Override
	public List<Car> getCarByName(String name) {
		// TODO Auto-generated method stub
		return cDao.getCarByName(name);
	}

	//����idɾ��
	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		return cDao.del(id);
	}

	//�޸���Ʒ����
	@Override
	public int updateNum(Map<String, Object> mapCar) {
		// TODO Auto-generated method stub
		return cDao.update(mapCar);
	}

	//������ƷId����
	@Override
	public int getCarById(Integer id) {
		// TODO Auto-generated method stub
		return cDao.getCarById(id);
	}

	//ȥ�ظ���ѯ
	@Override
	public List<Car> getCarGroupBy(String name) {
		// TODO Auto-generated method stub
		return cDao.getCarGroupBy(name);
	}

	//������Ʒ���ֺ�g_numɾ��
	@Override
	public int delCarByMap(String gname) {
		// TODO Auto-generated method stub
		return cDao.delCarByMap(gname);
	}

	//���ﳵ�ܼ�
	@Override
	public Double total(String name) {
		// TODO Auto-generated method stub
		return cDao.total(name);
	}

}
