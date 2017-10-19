package cn.yunhe.collection;

import java.util.ArrayList;
import java.util.Collection;

public class NewArrayList extends ArrayList{

	@Override
	public boolean add(Object e) {
		if(this.contains(e)){
			return false;
		}
		return super.add(e);		
	}

	@Override
	public void add(int index, Object element) {
	  
		super.add(index, element);
	}

	@Override
	public boolean addAll(Collection c) {
		if(this.contains(c)){
			return false;
		}
		return super.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection c) {
		if(this.contains(c)){
			return false;
		}
		return super.addAll(index, c);
	}
	
	/***
	 * 通过下标插入元素
	 * @param index
	 * @param element
	 */
	
	public void addIndex(int index, Object element){
		if(this.contains(element)){
			return;
		}
		add(index,element);
	}

	
}
