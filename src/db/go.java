/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import universitymanagementsystem.Tools;

/**
 *
 * @author amjd alhashede@gmail.com
 */
public class go {

    private static Connection con;
    private static String Url = "";
    private final static String UserName = "amjd";
    private final static String password = "alhashede";

    //هنا فسم الأتصال مع قواعد البيانات
    private static void setUrl() {
        Url = "jdbc:oracle:thin:@//localhost:1521/orcl";
    }

    private static void setConnection() {
        try {
            setUrl();
            con = DriverManager.getConnection(Url, UserName, password);
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
    }

    public static int insertData(String tableName, Map<String, Object> columns) {
        String strInsert;
        if (!columns.isEmpty()) {
            try {
                for (Map.Entry<String, Object> o : columns.entrySet()) {
                    if (o.getValue() == null) {
                        columns.remove(o.getKey());
                    }
                }
               
                if (!columns.isEmpty()) {
                    strInsert = "INSERT INTO " + tableName + " ( " + String.join(",", columns.keySet()) + ") values (";
                    for (Map.Entry<String, Object> entry : columns.entrySet()) {
                        strInsert += " ?, ";
                    }
                    strInsert = strInsert.substring(0, strInsert.length() - 2);
                    strInsert += ") ";
                    setConnection();
                    int i = 1;
                    con.setAutoCommit(false);
                    try (PreparedStatement ps = con.prepareStatement(strInsert)) {
                        for (Map.Entry<String, Object> entry : columns.entrySet()) {
                            ps.setObject(i++, entry.getValue());
                        }
                        int count = ps.executeUpdate();
                        con.commit();
                        return count;
                    } catch (SQLException ex) {
                        Tools.MsgBox(ex.getMessage());
                    }
                }
            } catch (SQLException ex) {
                Tools.MsgBox(ex.getMessage());
            }

        }

        return 0;
    }

    public static void updateData(String tableName, Map<String, Object> columns, Map<String, Object> whereClose) {
        String query = "UPDATE " + tableName + " SET ";
        for (Map.Entry<String, Object> entry : columns.entrySet()) {
            query += entry.getKey() + " = ?, ";
        }
        query = query.substring(0, query.length() - 2);
        if (!whereClose.isEmpty()) {
            query += " WHERE  " + String.join(" =? And ", whereClose.keySet());
        }
        query += "=? ";
        setConnection();
        try {
            PreparedStatement statement = con.prepareStatement(query);
            int i = 1;
            for (Map.Entry<String, Object> entry : columns.entrySet()) {
                statement.setObject(i++, entry.getValue());
            }
            for (Map.Entry<String, Object> entry : whereClose.entrySet()) {
                statement.setObject(i++, entry.getValue());
            }
            statement.executeUpdate();
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
    }

    public static int deleteData(String tableName, Map<String, Object> whereClose) {
        String commandString = "Delete from  " + tableName + "  ";
        if (!whereClose.isEmpty()) {
            commandString += "where   " + String.join("=? And ", whereClose.keySet()) + " =?";
        }
        setConnection();
        int i = 1;
        try (PreparedStatement ps = con.prepareStatement(commandString)) {
            for (Map.Entry<String, Object> entry : whereClose.entrySet()) {
                ps.setObject(i++, entry.getValue());
            }
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return 0;
    }

    public static int deleteData(String tableName) {
        Map<String, Object> ob = new HashMap<>();
        return deleteData(tableName, ob);
    }

    public static Date getDate(JDateChooser j) {
        return new java.sql.Date(j.getDate().getTime());
    }

    public static byte[] getImageFromFile() {
        return getImageFromFile(null);
    }

    public static byte[] getImageFromFile(JLabel showIn) {
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showOpenDialog(null);
        if (JFileChooser.CANCEL_OPTION == i) {
        } else {
            File file = chooser.getSelectedFile();
            byte[] imageData = new byte[(int) file.length()];
            try (FileInputStream fis = new FileInputStream(file)) {
                fis.read(imageData);
                if (showIn != null) {
                    showIn.setIcon(new ImageIcon(imageData));
                }
                return imageData;
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            }
        }
        return null;
    }

    public static String getAutoNumber(String tableName, String columnname) {
        try {
            setConnection();
            String strSelect = "select max(" + columnname + ") +1 from " + tableName;
            PreparedStatement stmt = con.prepareStatement(strSelect);
            stmt.executeQuery(strSelect);
            String num = "";
            while (stmt.getResultSet().next()) {
                num = stmt.getResultSet().getString(1);
            }
            closeConnection();
            if (num == null || "".equals(num)) {
                return "1";
            } else {
                return num;
            }
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
            return "0";
        }
    }

    public static Object getValueAt(int row, String ColumnName, ResultSet res) {
        try {
            int i = 0;
            while (res.next()) {
                if (i == (row - 1)) {
                    return res.getObject(ColumnName);
                }
                i++;
            }
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return null;
    }

    public static ArrayList<Object> getValueAt(ResultSet res, String ColumnName) {
        try {
            ArrayList<Object> values = new ArrayList<>();

            while (res.next()) {
                values.add(res.getObject(res.findColumn(ColumnName)));
            }
            return values;
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return null;
    }

    public static Object getValue(ResultSet res, String ColumnName) {
        try {
            return res.getObject(res.findColumn(ColumnName));
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return null;
    }

    public static void fillIntoTable(JTable table, ResultSet res) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        try {
            while (res.next()) {
                Object[] rowData = new Object[res.getMetaData().getColumnCount()];
                for (int i = 1; i <= res.getMetaData().getColumnCount(); i++) {
                    rowData[i - 1] = res.getObject(i);
                }
                tableModel.addRow(rowData);
            }
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }

    }

    public static void fillIntoJComboBox(JComboBox combo, ResultSet result, String ColumnName) {

        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
            model.removeAllElements();
            while (result.next()) {
                model.addElement(result.getString(ColumnName));
            }
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }

    }

    public static ResultSet getData(String TableName, ArrayList<String> ColumnName, Map<String, Object> whereCString) {

        setConnection();
        try {
            String query = "SELECT  ";
            if (ColumnName.isEmpty()) {
                query += " * ";
            } else {
                query += String.join(",", ColumnName);
            }
            query += "  FROM  " + TableName + "  ";

            if (!whereCString.isEmpty()) {
                query += "where " + String.join(" =? And ", whereCString.keySet()) + "=?  ";
            }
            PreparedStatement pre = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int index = 1;
            for (Object r : whereCString.values()) {
                pre.setObject(index++, r);
            }
            return pre.executeQuery();
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return null;
    }

    public static ResultSet runNonQuery(String query) {
        setConnection();
        try {
            PreparedStatement pre = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return pre.executeQuery();
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return null;
    }

    public static Object getValueBy(Map<String, Object> whereC) {
        String query = "SELECT " + whereC.get("GET") + " FROM " + whereC.get("TABLE") + " WHERE " + whereC.get("BY") + "=? ";
        try {
            PreparedStatement pre = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pre.setObject(1, whereC.get("VALUE") + "");
            ResultSet res = pre.executeQuery();
            if (res.next()) {
                return res.getObject(whereC.get("GET") + "");
            }
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage() + "");
        }
        return "";
    }

    public static void addItemIntoJComboBox(JComboBox combo, Object value) {
        DefaultComboBoxModel dcbm = (DefaultComboBoxModel) combo.getModel();
        boolean ok = false;
        for (int i = 0; i < combo.getItemCount(); i++) {
            Object item = combo.getItemAt(i);
            if (item.toString().equals(value.toString())) {
                ok = true;
                break;
            }
        }
        if (!ok) {
            dcbm.addElement(value);
        }
    }

    public static ResultSet getSearching(String tableName, ArrayList<String> ColumnName, Map<String, Object> wherC) {
        return getSearching(tableName, ColumnName, wherC, "or", "like");
    }

    public static ResultSet getSearching(String tableName, ArrayList<String> ColumnName, Map<String, Object> wherC, String AndOr) {
        return getSearching(tableName, ColumnName, wherC, AndOr, "like");
    }

    public static ResultSet getSearching(String tableName, ArrayList<String> ColumnName, Map<String, Object> wherC, String AndOr, String likeOrEquel) {
        try {
            String query = "SELECT  ";
            if (ColumnName.isEmpty()) {
                query += " * ";
            } else {
                query += String.join(",", ColumnName);
            }
            query += "  FROM  " + tableName + "  ";

            if (!wherC.isEmpty()) {
                //  query += "where " + String.join(" or ", wherC.keySet()) +"  "+String.join(" or ", wherC.);
            }
            setConnection();
            PreparedStatement pre = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int index = 1;
            Tools.MsgBox(query);
            for (Object r : wherC.values()) {
                pre.setObject(index++, r);
            }
            return pre.executeQuery();
        } catch (SQLException ex) {
            Tools.MsgBox(ex.getMessage());
        }
        return null;
    }

    public static String getYear() {
        JYearChooser j = new JYearChooser();
        return j.getYear() + "";
    }
}
