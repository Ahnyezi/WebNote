package guestbook;

import java.util.ArrayList;

public interface Dao {
	public void insert(Article a);//�۹�ȣ, �ۼ��� �ڵ�
	public Article select(int num);
	public ArrayList<Article> selectAll();
	public void update(Article a);
	public void delete(int num);
}
