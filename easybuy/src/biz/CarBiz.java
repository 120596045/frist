package biz;

import java.util.List;
import java.util.Map;

import entity.Car;

public interface CarBiz {

	//���빺�ﳵ
	public abstract int save(Map<String, Object> mapGoods);
	
	//�����û������ҹ��ﳵ
	public abstract List<Car> getCarByName(String name);
	
	//����idɾ��
	public abstract int del(Integer id);
	
	//������Ʒ����ɾ��
	public abstract int delCarByMap(String gname);
	
	//�޸���Ʒ����
	public abstract int updateNum(Map<String, Object> mapCar);
	
	//������ƷId����
	public abstract int getCarById(Integer id);
	
	//ȥ�ظ���ѯ
	public abstract List<Car> getCarGroupBy(String name);
	
	//���ﳵ�ܼ�
	public abstract Double total(String name);
}
