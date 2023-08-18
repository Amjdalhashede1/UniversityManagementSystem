/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entry;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import Entry.TABLE.*;
import static Entry.TABLE.DEPARTMENT.*;
import Entry.TABLE.DEPARTMENT;
import static Entry.TABLE.MANAGER.MANAGER_NAME;
import java.util.ArrayList;
import java.util.Arrays;

public class Departments implements mainData {
    static Object table=TABLE.DEPARTMENTS;
    static Object get=DEPT_ID;
    static Object By=DEPT_NAME;
 

    public Departments() {
      
    }

    @Override
    public void Add(Map<String, Object> values) {
        db.go.insertData(TABLE.DEPARTMENTS+ "", values);
    }

    @Override
    public void delete(Map<String,Object>whereC) {
     db.go.deleteData(TABLE.DEPARTMENTS+"", whereC);
    }

    @Override
    public void update(Map<String, Object> values,Map<String,Object>whereC) {
         db.go.updateData(TABLE.DEPARTMENTS + "", values,whereC);
    }

    @Override
    public Object getAutoNumber(Object ob) {
      return db.go.getAutoNumber(TABLE.DEPARTMENTS + "", ob+ "");
    }

    @Override
    public void getAllRows(JTable table) {
         ArrayList<String>ColumnName=new ArrayList<>(Arrays.asList(DEPT_ID+"",DEPT_NAME+"",EDUCATIONLEVEL+"",YEARCOUNT+"",MANAGER_NAME+""));
         db.go.fillIntoTable(table,db.go.getData(TABLE.VIEW.Department_DATA_TABLE+"", ColumnName,new HashMap<>()));
    }

    @Override
    public void getOneRow(JTable table,Object val) {
        Map<String,Object>whereV=new HashMap<>();
        whereV.put(DEPARTMENT.DEPT_ID+"",val);
        db.go.fillIntoTable(table, db.go.getData(VIEW.Department_DATA_TABLE+"", new ArrayList<>(), whereV)); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public  void setBy(Object By) {
        Departments.By = By;
    }

    public  void setGet(Object get) {
        Departments.get = get;
    }

    public  void setTable(Object table) {
        Departments.table = table;
    }
    
}
