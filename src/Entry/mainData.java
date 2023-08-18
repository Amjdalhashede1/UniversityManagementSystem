/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Entry;

import java.util.Map;
import javax.swing.JTable;

/**
 *
 * @author amjd
 */
public interface mainData {
    public void Add(Map<String,Object>values);
    public void delete(Map<String,Object>whereC);
    public void update(Map<String, Object> values,Map<String,Object>whereC);
    public Object getAutoNumber(Object ob);
    public void getAllRows(JTable table);
    public void getOneRow(JTable table,Object val);
    public void getCustomeRow(String statement,JTable table);
    public Object getValueBy(Object value);
}
