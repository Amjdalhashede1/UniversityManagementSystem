/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entry;

import Entry.TABLE.SEARCH;
import static Entry.TABLE.STUDENT.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;

/**
 *
 * @author amjd
 */
public class Students implements mainData{
    static Object table=TABLE.STUDENTS;
    static Object get=STD_NAME;
    static Object By=STD_ID;
    @Override
    public void Add(Map<String, Object> values) {
         db.go.insertData(TABLE.STUDENTS + "", values); 
    }

    @Override
    public void delete(Map<String, Object> whereC) {
      db.go.deleteData(TABLE.STUDENTS + "", whereC);
    }
    @Override
    public void update(Map<String, Object> values, Map<String, Object> whereC) {
       db.go.updateData(TABLE.STUDENTS + "", values,whereC);
    }

    @Override
    public Object getAutoNumber(Object Auto) {
       return db.go.getAutoNumber(TABLE.STUDENTS + "", Auto+"");
    }

    @Override
    public void getAllRows(JTable table) {
        // ArrayList<String>ColumnName=new ArrayList<>(Arrays.asList(REGESTY_NUMBER+"",STD_NAME+"",DEPT_NAME+"",SCHOOLYEAR+""));
         db.go.fillIntoTable(table,db.go.getData(TABLE.VIEW.STUDENT_DATA_TABLE+"", new ArrayList<>(),new HashMap<>()));

    }

    @Override
    public void getOneRow(JTable table, Object val) {
          Map<String,Object>whereV=new HashMap<>();
          whereV.put(REGESTY_NUMBER+"",val);
       //   db.go.fillIntoTable(table, db.go.getData(.Department_DATA_TABLE+"", new ArrayList<>(), whereV)); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      }

    @Override
    public void getCustomeRow(String statement, JTable table) {
        db.go.fillIntoTable(table, db.go.runNonQuery(statement));
    }

    @Override
    public Object getValueBy(Object value) {
        Map<String,Object>values=new HashMap<>();
        values.put(SEARCH.TABLE+"" , table);
        values.put(TABLE.SEARCH.GET +"", get);
        values.put(TABLE.SEARCH.BY+"", By);
        values.put(TABLE.SEARCH.VALUE +"", value);
        return db.go.getValueBy(values); 
    }

    public static void setBy(Object By) {
        Students.By = By;
    }

    public static void setGet(Object get) {
        Students.get = get;
    }

    public static void setTable(Object table) {
        Students.table = table;
    }

    
}
