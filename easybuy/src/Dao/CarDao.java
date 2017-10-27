package  Dao;

import java.util.List;
import java.util.Map;

import entity.Car;

public interface CarDao {

	//���빺�ﳵ
	public abstract int insert(Map<String, Object> mapGoods);
	
	//�����û������ҹ��ﳵ
	public abstract List<Car> getCarByName(String name);
	
	//������ƷId����
	public abstract int getCarById(Integer id);
	
	//ȥ�ظ���ѯ
	public abstract List<Car> getCarGroupBy(String name);
	
	//����idɾ��
	public abstract int del(Integer id);
	
	//������Ʒ���ֺ�g_numɾ��
	public abstract int delCarByMap(String gname);
	
	//�޸���Ʒ����
	public abstract int update(Map<String, Object> mapCar);
	
	//���ﳵ�ܼ�
	public abstract Double total(String name);
	
}
