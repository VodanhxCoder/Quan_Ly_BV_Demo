/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Access_Object;

/**
 *
 * @author khue1
 */

import java.util.ArrayList;

//Quyết định các chức năng chính cho chương trình 
public interface DaoInterface<T> {
    public int insert(T t);

    public int update(T t, String id);

    public int deleteById(String id);
    
    public void deleteAll();

    public ArrayList<T> selectAll();

    public T selectById(String id);
}
