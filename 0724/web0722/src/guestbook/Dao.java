package guestbook;

import java.util.ArrayList;

public interface Dao {
	public void insert(Article a);//글번호, 작성일 자동
	public Article select(int num);
	public ArrayList<Article> selectAll();
	public void update(Article a);
	public void delete(int num);
}
