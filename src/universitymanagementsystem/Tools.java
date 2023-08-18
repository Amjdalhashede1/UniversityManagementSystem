/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package universitymanagementsystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amjd
 */
public class Tools {

    // this method for show JoptionMessage
    public static void MsgBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static boolean confirmMsg(String question) {
        int num = JOptionPane.showConfirmDialog(null, question);
        return (num == JOptionPane.YES_OPTION);
    }

    public static void openForm(JFrame form) {
        form.setLocationRelativeTo(null);
        form.getContentPane().setBackground(new Color(255, 255, 255));
        form.setVisible(true);
    }

    public static void setColumnSize(JTable table, int column, int preferredWidth, int mainwidth) {
        table.getColumnModel().getColumn(column).setMinWidth(mainwidth);
        table.getColumnModel().getColumn(column).setPreferredWidth(preferredWidth);
    }

    public static void setTableStyle(JTable table) {
        table.getTableHeader().setFont(new FontUIResource(Font.DIALOG, Font.BOLD, 16));
        table.setFont(new FontUIResource(Font.SANS_SERIF, Font.BOLD, 12));
        table.setRowHeight(27);
        table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        table.setSelectionBackground(new Color(0, 0, 70));
        table.setSelectionForeground(Color.WHITE);
        table.getTableHeader().setResizingAllowed(true);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }

    public static void ClearText(Container continer) {
        for (Component component : continer.getComponents()) {
            if (component instanceof JTextField) {
                JTextField t = (JTextField) component;
                t.setText("");
            } else if (component instanceof JTextPane) {
                JTextPane t = (JTextPane) component;
                t.setText("");
            } else if (component instanceof Container) {
                ClearText((Container) component);
            }
        }
    }

    public static String getLike(String txt) {
        return " like '%" + txt + "%'";
    }

    public static void addRowIntoTable(JTable table, Object... ob) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        ArrayList<Object> row = new ArrayList<>();
        row.addAll(Arrays.asList(ob));
        model.addRow(row.toArray());
    }

    public static boolean ButtonUp(KeyEvent evt) {
        return (evt.getKeyCode() == 38);
    }

    public static boolean ButtonDown(KeyEvent evt) {
        return (evt.getKeyCode() == 40);
    }

    public static boolean ButtonRight(KeyEvent evt) {
        return (evt.getKeyCode() == 39);
    }

    public static boolean ButtonLeft(KeyEvent evt) {
        return (evt.getKeyCode() == 37);
    }

    public static boolean ButtonEnter(KeyEvent evt) {
        return evt.getKeyChar() == KeyEvent.VK_ENTER;
    }

    public static boolean ButtonCtrl(KeyEvent evt) {
        return evt.getKeyCode() == 17;
    }

    public static void removeRowsInTable(JTable tblPhones) {
        DefaultTableModel model = (DefaultTableModel) tblPhones.getModel();
        model.setRowCount(0);
    }

}
