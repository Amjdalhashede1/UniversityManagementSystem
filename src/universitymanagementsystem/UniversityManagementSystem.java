/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package universitymanagementsystem;

import FORMS.frmMain;
import db.goIN;

    import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;

public class UniversityManagementSystem {
    public static int x = 7;
    public static int y = 8;
    public static int num1 = 7;
    public static int num2 = 8;

    public static byte[] selectAndConvertImage() {
        byte[] imageData = null;
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            imageData = new byte[(int) file.length()];
            try (FileInputStream fis = new FileInputStream(file)) {
                fis.read(imageData);
            } catch (Exception e) {
            }
        }
        return imageData;
    }
      public static int id=3;
      public static String name ="amjd";

    public static void main(String[] args) {
        Tools.openForm(new frmMain());
        //   Object [] ob=go.printVariableNamesAndSum(this,"id","name");
        System.out.println("hello all the world");

    }
    
}