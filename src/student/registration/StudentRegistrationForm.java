package student.registration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StudentRegistrationForm {
    private JPanel panel1;
    private JTextField nameField;
    private JComboBox levelField;
    private JButton addButton;
    private JLabel nameLabel;
    private JLabel levelLabel;

    public StudentRegistrationForm() {
        // إضافة العناصر إلى levelComboBox
        levelField.addItem("السنة الأولى");
        levelField.addItem("السنة الثانية");
        levelField.addItem("السنة الثالثة");
        levelField.addItem("السنة الرابعة");

        // إضافة حدث عند النقر على زر الإضافة
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // تفريغ الحقول عند النقر على زر الإضافة
                nameField.setText("");
                levelField.setSelectedIndex(0); // تعيين الخيار الأول كقيمة افتراضية
            }
        });
    }

    // الدالة الرئيسية لتشغيل البرنامج
    public static void main(String[] args) {
        JFrame frame = new JFrame("تسجيل الطلاب");
        frame.setContentPane(new StudentRegistrationForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

