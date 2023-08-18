/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import static db.go.closeConnection;
import java.lang.reflect.Field;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import universitymanagementsystem.Tools;
import universitymanagementsystem.UniversityManagementSystem;

/**
 *
 * @author amjd
 */
public class goIN {
    static Connection con;
    private static String Url="";
    private static String UserName="amjd";
    
    //هنا فسم الأتصال مع قواعد البيانات
    public static void setUrl(){
         Url="jdbc:oracle:thin:@//localhost:1521/orcl";
     }
    
    static void setConnection(){
        try {
            setUrl();
            setCon((Connection) DriverManager.getConnection(Url, getUserName(),"alhashede"));
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
     }
     
     public static void setCon(Connection aCon) {
        con = (Connection) aCon;
    }
    
    public static void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
    }
      public static void fillToCombobox(JComboBox combo, ArrayList<Map.Entry<Integer, Map<String, Object>>> data, String ColumnName) {
        if (!data.isEmpty()) {
            DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
            for (Map.Entry<Integer, Map<String, Object>> item : data) {
                model.addElement(item.getValue().get(ColumnName));
            }
        }
    }

    static ArrayList<Object> s;

    public static void fillToTable(JTable table, ArrayList<Map.Entry<Integer, Map<String, Object>>> data) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        if (data.size() >= 1) {
            Set<String> key = data.get(0).getValue().keySet();
            for (Map.Entry<Integer, Map<String, Object>> item : data) {
                s = new ArrayList<>();

                key.forEach((String t) -> {
                    s.add(item.getValue().get(t));
                });
                model.addRow(s.toArray());
            }
        }
    }
    public static ArrayList<Map.Entry<Integer, Map<String, Object>>> getValuesByCondition(Map<String, Object> conditions) {
        try {
            setConnection();
            String query = "SELECT " + conditions.get("GET_OBJECT") + " FROM " + conditions.get("TABLE") + " WHERE " + conditions.get("WHERE_OBJECT") + " = ? ";
            PreparedStatement statement = con.prepareCall(query);
            statement.setObject(1, conditions.get("VALUE"));
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Map.Entry<Integer, Map<String, Object>>> results = new ArrayList<>();
            int rowIndex = 1;
            while (resultSet.next()) {
                Map<String, Object> result = new HashMap<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    result.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
                }
                results.add(new AbstractMap.SimpleEntry(rowIndex++, result));
            }
            closeConnection();
            return results;
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return null;
    }
    public static void insertData(String tableName, Object... values) {
        setConnection();
    String query = "INSERT INTO " + tableName + " VALUES (";
    for (int i = 0; i < values.length; i++) {
        query += "?";
        if (i != values.length - 1) {
            query += ", ";
        }
    }
    query += ")";
    try ( PreparedStatement pstmt = con.prepareStatement(query)) {
        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }
        pstmt.executeUpdate();
    } catch (SQLException e) {
    }
}
  public static Object[] printVariableNamesAndSum(Class<?> clazz, String... names) {
    Object[] values = new Object[names.length];
    for (int i = 0; i < names.length; i++) {
        try {
            Field field = clazz.getDeclaredField(names[i]);
            field.setAccessible(true);
            values[i] = field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
        }
    }
    return values;
}
   public static ArrayList<Map.Entry<Integer, Map<String, Object>>> getData(ArrayList<String>tables,ArrayList<String>ColumnName){
            Map<Object,Object>whereClose = new HashMap<>();
            return getData(tables, ColumnName,whereClose);
    }
  public static ArrayList<Map.Entry<Integer, Map<String, Object>>> getData(ArrayList<String> tables, ArrayList<String> columns, Map<Object, Object> whereClose) {
    StringBuilder query = new StringBuilder("SELECT ");
    if (!columns.isEmpty()) {
        for (String column : columns) {
            query.append(column).append(", ");
        }
        query.setLength(query.length() - 2);
    } else {
        query.append(" * ");
    }

    if (!tables.isEmpty()) {
        query.append(" FROM ");
        for (String table : tables) {
            query.append(table).append(", ");
        }
        query.setLength(query.length() - 2);
    } else {
        Tools.MsgBox("لا يمكن أن يكون هناك استعلام بدون اسم الجدول");
        return null;
    }
  int j = 1;
     query.append(" where ");
       for(Map.Entry<Object,Object>entry:whereClose.entrySet()){
           //pre.setObject(j++, entry.getKey());
        query.append(entry.getKey()).append("=").append(entry.getValue()).append(" AND ");
       }
    if (!whereClose.isEmpty()) {
  
        for (Object whereC : whereClose.keySet()) {
            
        }
        query.setLength(query.length() - 4);
    }

    Tools.MsgBox(query.toString());
    try {
        setConnection();
        PreparedStatement pre = con.prepareStatement(query.toString());
        
        ResultSet res = pre.executeQuery();
        ResultSetMetaData metaData = res.getMetaData();
        ArrayList<Map.Entry<Integer, Map<String, Object>>> data = new ArrayList<>();
        int rowIndex = 1;
        while (res.next()) {
            Map<String, Object> rowData = new HashMap<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                rowData.put(metaData.getColumnName(i), res.getObject(i));
            }
            data.add(new AbstractMap.SimpleEntry<>(rowIndex, rowData));
            rowIndex++;
        }
        return data;
    } catch (SQLException ex) {
       Tools.MsgBox(ex.getMessage());
    }
    return null;
}
    
 public static ArrayList<Map.Entry<Integer, Map<String, Object>>> getDataFrom(Map<String, Object> parameters, Map<String, Object> whereClose) {

        try {
            if (parameters.isEmpty()) {
                throw new IllegalArgumentException("The parameters map must not be empty.");
            }

// Check if the tables list is not empty.
            ArrayList<String> tables = (ArrayList<String>) parameters.get("TABLES");
            if (tables.isEmpty()) {
                throw new IllegalArgumentException("The tables list must not be empty.");
            }

// Check if the columns map is not empty.
            Map<String, ArrayList<String>> columns = (Map<String, ArrayList<String>>) parameters.get("COLUMNS");
            if (columns.isEmpty()) {
                throw new IllegalArgumentException("The columns map must not be empty.");
            }

// Check if the conditions map is not empty.
            Map<String, String> conditions = (Map<String, String>) parameters.get("conditions");
            if (conditions != null && conditions.isEmpty()) {
                throw new IllegalArgumentException("The conditions map must not be empty.");
            }

// Check if the orderBy string is not null.
            String orderBy = (String) parameters.get("orderBy");
            if (orderBy != null && orderBy.isEmpty()) {
                throw new IllegalArgumentException("The orderBy string must not be empty.");
            }

// Create a connection to the database.
// Build the query.
            StringBuilder query = new StringBuilder("SELECT ");
            for (String column : columns.get(tables.get(0))) {
                query.append(column).append(", ");
            }
            query.setLength(query.length() - 2);
            query.append(" FROM ");
            for (String table : tables) {
                query.append(table).append(" ");
            }
            if (conditions != null) {
                query.append(" WHERE ");
                for (Map.Entry<String, String> condition : conditions.entrySet()) {
                    query.append(condition.getKey()).append(" = ").append(condition.getValue()).append(" ");
                }
            }
            if (orderBy != null) {
                query.append(" ORDER BY ");
                query.append(orderBy);
            }

// Execute the query.
            PreparedStatement pre;

            pre = con.prepareStatement(query.toString());

            ResultSet resultSet = pre.executeQuery();

// Create an array list to store the results.
            ArrayList<Map.Entry<Integer, Map<String, Object>>> data = new ArrayList<>();

// Iterate through the result set.
            while (resultSet.next()) {
// Get the row.
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    row.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
                }

// Add the row to the array list.
                data.add(new AbstractMap.SimpleEntry<>(resultSet.getRow(), row));
            }

// Close the connection.
            closeConnection();

// Return the data.
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(go.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    public static void insertData2( String tableName, Object...data) {
        setConnection();
    Class<?> dataClass = data.getClass();
    Field[] fields = dataClass.getDeclaredFields();
    String query = "INSERT INTO " + tableName + " (";
    for (int i = 0; i < fields.length; i++) {
        query += fields[i].getName();
        if (i != fields.length - 1) {
            query += ", ";
        }
    }
    query += ") VALUES (";
    for (int i = 0; i < fields.length; i++) {
        query += "?";
        if (i != fields.length - 1) {
            query += ", ";
        }
    }
    query += ")";
    try (
            PreparedStatement pstmt = con.prepareStatement(query)) {
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            Object value = field.get(data);
            pstmt.setObject(i + 1, value);
        }
        pstmt.executeUpdate();
    } catch (SQLException | IllegalAccessException e) {
    }
}

   public static int InsertIntoDataBase(String tableName,String []ColumnNames,String []ValueForCoulmns){
      String commandString="Insert into "+tableName+" (";
     if(ColumnNames.length == ValueForCoulmns.length){
      for (int i = 0; i < ColumnNames.length; i++) {
          commandString+=ColumnNames[i];
        if (i != ColumnNames.length - 1) {
             commandString += ", ";
        }
      }
       commandString += ") VALUES (";
       for (int i = 0; i < ValueForCoulmns.length; i++) {
           commandString+="?";
        if (i != ValueForCoulmns.length - 1) {
             commandString += ", ";
        }
       }
       commandString+=")";
           setConnection();
          try(PreparedStatement ps=con.prepareStatement(commandString)){
             for (int i = 0; i < ValueForCoulmns.length; i++) {
                 ps.setObject(i+1,ValueForCoulmns[i]);
              }
           return ps.executeUpdate();
          }catch(SQLException ex){
              Tools.MsgBox(ex.getMessage());
          }
       
       
      }else{
          if(ColumnNames.length >= ValueForCoulmns.length){
                Tools.MsgBox("هناك نشكلة لان عدد القيم غير كافية");
          }else{
                Tools.MsgBox("هناك نشكلة لان عدد الأعمدة غير كافية");
          }
      }
      return 0;
    }
    
    public static Map<String, Object> getData(String tableName) {
        Map<String, Object> ob = new HashMap<>();
        return getData(tableName, ob);
    }
   
    public static Map<String, Object> getData(String tableName, Map<String, Object> conditions) {
        String query = "SELECT  ";
        if (conditions.isEmpty()) {
            query += " * ";
        } else {
            query += String.join(",", conditions.keySet());
        }
        query += "  FROM  " + tableName + "  ";
        String ss = " ";
        for (String key : conditions.keySet()) {
            Object value = conditions.get(key);
            if (value != null) {
                ss += key + " = ? AND ";
            }
        }
        setConnection();
        int o = 1;
        if (!ss.trim().equals("")) {
            query += " where " + ss;
            query = query.substring(0, query.length() - 4);
        }
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(query);
            for (String key : conditions.keySet()) {
                Object value = conditions.get(key);
                if (value != null) {
                    preparedStatement.setObject(o++, value);
                }
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            Map<String, Object> data = new HashMap<>();
            while (resultSet.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    if (resultSet.getMetaData().getColumnClassName(i).contains("BLOB")) {
                        data.put(metaData.getColumnName(i) + "" + i, resultSet.getBytes(i));

                    } else {
                        data.put(metaData.getColumnName(i) + "i" + i, resultSet.getObject(i));
                    }
                }
            }

//         for(Object ob:data.values()){
//             Tools.MsgBox(ob+"");
//         }
            return data;
        } catch (SQLException ex) {
        }
        return null;
    }
   
    public static String getUserName() {
        return UserName;
    }
    public static void setUserName(String aUserName) {
        UserName = aUserName;
    }
    
    public static ArrayList<Map.Entry<Integer, Map<String, Object>>> getDataFrom(String tableName, Map<String, Object> whereClose) {
        Map<String,Object>d=new HashMap<>();
        return getDataFrom(tableName,whereClose, d);
    }
    public static ArrayList<Map.Entry<Integer, Map<String, Object>>> getDataFrom(String tableName) {
        Map<String,Object>d=new HashMap<>();
        return getDataFrom(tableName, d,d);
    }
    public static ArrayList<Map.Entry<Integer, Map<String, Object>>> getDataFrom(String tableName, Map<String, Object> columnName, Map<String, Object> whereClose) {
        try {
            String query = "SELECT  ";
            if (columnName.isEmpty()) {
                query += " * ";
            } else {
                query += String.join(",", columnName.keySet());
            }
            query += "  FROM  " + tableName + "  ";
            if (!whereClose.isEmpty()) {
                query += "where " + String.join(" =? And ", whereClose.keySet()) + "=?  ";
            }
            setConnection();
            int index = 1;
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement(query);
            for (String key : whereClose.keySet()) {
                Object value = whereClose.get(key);
                preparedStatement.setObject(index++, value);
            }
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            ArrayList<Map.Entry<Integer, Map<String, Object>>> data = new ArrayList<>();
               
            int rowIndex = 1;
            while (rs.next()) {
                Map<String, Object> rowData = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(rsmd.getColumnName(i), rs.getObject(i));
                }
                data.add(new AbstractMap.SimpleEntry<>(rowIndex, rowData));
                rowIndex++;
            }
            
            return data;
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return null;
    }

}
