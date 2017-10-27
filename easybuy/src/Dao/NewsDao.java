package Dao;

import java.util.List;
import entity.News;
import entity.ObjPage;

public interface NewsDao {
	
			// ������������
			public List<News> getAllNews();

			// �������
			public int saveNews(News news);

			// �޸�
			public int updateNews(News news);

			// ɾ��
			public int delNews(Integer id);
			
			//��������ѯ
			public News getNewsById(Integer id);
			
			//��ǰҳ������
			public List<News> getNewsByPage(ObjPage page);
		
			//�ܼ�¼��
			public int getCount();
}
