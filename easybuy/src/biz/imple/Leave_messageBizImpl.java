package biz.imple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dao.Leave_messageDao;
import Dao.imple.Leave_messageDaoImpl;
import biz.Leave_messageBiz;
import entity.Leave_message;
import entity.ObjPage;



public class Leave_messageBizImpl implements Leave_messageBiz {

	public Leave_messageBizImpl() {
	};

	Leave_messageDao leave = new Leave_messageDaoImpl();

	/**
	 * �� ���ݿ���� ���� ����
	 */
	@Override
	public int addMessage(Leave_message lm) {

		return leave.addMessage(lm);
	}

	/**
	 * ��ҳ��ʾ ��������
	 */
	@Override
	public ObjPage showLmByPage(int pageindex, int pagesize) {

		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("pageindex", (pageindex - 1) * pagesize);
		map.put("pagesize", pagesize);
		List<Leave_message> list = leave.getLmByPage(map);

		ObjPage pagelm = new ObjPage();
		// �� page ���� ���� ����ֵ
		pagelm.setPageIndex(pageindex);
		int count= leave.getCount();
		if(leave.getCount()%pagesize==0){
			count=leave.getCount()/pagesize;
		}else{
			count=leave.getCount()/pagesize+1;
		}
		pagelm.setPageSize(pagesize);
		pagelm.setCount(leave.getCount());
		pagelm.setPageObj(list);
		pagelm.setPageTotal(count);
		return pagelm;
	}

	/**
	 * ���ݿ� �޸� �ظ����� ����
	 */

	@Override
	public void updateMessage(Leave_message lm) {
		leave.updateMessage(lm);
	}

	/**
	 * ͨ��ID ɾ����������
	 */

	@Override
	public int deleteMessage(int i) {
		int p = leave.deleteMessage(i);
		return p;
	}
}
