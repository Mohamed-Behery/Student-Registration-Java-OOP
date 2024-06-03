package student.registration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// فئة لإنشاء واجهة المستخدم لتسجيل الطلاب
public class StudentRegistrationForm {
    private JFrame frame; // إطار النافذة
    private JTextField nameField; // حقل لإدخال اسم الطالب
    private JComboBox<String> yearComboBox; // مربع اختيار لتحديد مستوى الطالب
    private JButton addButton; // زر لإضافة الطالب إلى القائمة
    private JTable studentTable; // جدول لعرض قائمة الطلاب
    private DefaultTableModel tableModel; // نموذج للجدول
    private List<Student> studentList; // قائمة لتخزين بيانات الطلاب

    // المُنشئ لإنشاء الواجهة وتعيين الإجراءات
    public StudentRegistrationForm() {
        studentList = new ArrayList<>();

        frame = new JFrame("تسجيل الطلاب"); // إنشاء نافذة بعنوان "تسجيل الطلاب"
        frame.setSize(600, 400); // تعيين حجم النافذة
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // تعيين عملية الإغلاق عند النقر على زر الإغلاق
        frame.setLayout(null); // تعيين تخطيط النافذة ليكون مخصص

        // إنشاء وتعيين مكونات الواجهة
        JLabel nameLabel = new JLabel("الاسم:"); // تسمية لاسم الطالب
        nameLabel.setBounds(50, 50, 100, 25); // تحديد موقع وحجم التسمية
        frame.add(nameLabel);

        nameField = new JTextField(); // حقل نص لإدخال اسم الطالب
        nameField.setBounds(150, 50, 150, 25); // تحديد موقع وحجم الحقل
        frame.add(nameField);

        JLabel yearLabel = new JLabel("المستوى:"); // تسمية لمستوى الطالب
        yearLabel.setBounds(50, 100, 100, 25); // تحديد موقع وحجم التسمية
        frame.add(yearLabel);

        String[] years = {"السنة الأولى", "السنة الثانية", "السنة الثالثة", "السنة الرابعة"}; // قائمة المستويات
        yearComboBox = new JComboBox<>(years); // مربع اختيار يحتوي على قائمة المستويات
        yearComboBox.setBounds(150, 100, 150, 25); // تحديد موقع وحجم مربع الاختيار
        frame.add(yearComboBox);

        addButton = new JButton("إضافة"); // زر لإضافة الطالب
        addButton.setBounds(150, 150, 150, 25); // تحديد موقع وحجم الزر
        frame.add(addButton);

        String[] columnNames = {"الاسم", "المستوى"}; // أسماء الأعمدة في الجدول
        tableModel = new DefaultTableModel(columnNames, 0); // إنشاء نموذج للجدول
        studentTable = new JTable(tableModel); // إنشاء جدول باستخدام النموذج
        JScrollPane scrollPane = new JScrollPane(studentTable); // إنشاء نافذة تمرير للجدول
        scrollPane.setBounds(50, 200, 500, 100); // تحديد موقع وحجم نافذة التمرير
        frame.add(scrollPane);

        // إضافة حدث عند النقر على زر الإضافة
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText(); // الحصول على النص المدخل في حقل الاسم
                String year = (String) yearComboBox.getSelectedItem(); // الحصول على المستوى المختار من مربع الاختيار
                Student student;

                // تحديد نوع الطالب بناءً على المستوى المختار
                switch (year) {
                    case "السنة الأولى":
                        student = new FirstYearStudent(name);
                        break;
                    case "السنة الثانية":
                        student = new SecondYearStudent(name);
                        break;
                    case "السنة الثالثة":
                        student = new ThirdYearStudent(name);
                        break;
                    case "السنة الرابعة":
                        student = new FourthYearStudent(name);
                        break;
                    default:
                        throw new IllegalArgumentException("مستوى غير متوقع: " + year);
                }

                // إضافة الطالب إلى القائمة وتحديث الجدول
                studentList.add(student);
                tableModel.addRow(new Object[]{student.getName(), year});
            }
        });

        frame.setVisible(true); // جعل النافذة مرئية
    }

    // الدالة الرئيسية لتشغيل البرنامج
    public static void main(String[] args) {
        new StudentRegistrationForm(); // إنشاء كائن من الفئة وتشغيل الواجهة
    }
}