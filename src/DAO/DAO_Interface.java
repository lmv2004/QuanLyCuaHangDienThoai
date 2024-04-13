package DAO;

import java.util.ArrayList;

public interface DAO_Interface<T,ID> {
    public int insert(T t) ;
	
    public int update(T t);
	
    public int delete(ID id);
	
    public ArrayList<T> selecAll();
	
    public T selectById(ID id) ;
	
	
    public ArrayList<T> selectByCondition(String condition);
}
