package guestbook;

import java.util.ArrayList;

public interface Service {
	public void addArticle(Article a);
	public Article getArticle(int num);
	public ArrayList<Article> getAll();
	public void editArticle(Article a);
	public void delArticle(int num);
}
