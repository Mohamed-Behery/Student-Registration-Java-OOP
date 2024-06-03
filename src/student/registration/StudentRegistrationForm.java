package student.registration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentRegistrationForm {
    private JFrame frame;
    private JTextField nameField;
    private JTextField ageField;
    private JComboBox<String> levelComboBox;
    private JButton registerButton;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private List<Student> studentList;

    public StudentRegistrationForm() {
        studentList = new ArrayList<>();

        frame = new JFrame("Student Registration");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 50, 100, 25);
        frame.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 50, 150, 25);
        frame.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 100, 100, 25);
        frame.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(150, 100, 150, 25);
        frame.add(ageField);

        JLabel levelLabel = new JLabel("Level:");
        levelLabel.setBounds(50, 150, 100, 25);
        frame.add(levelLabel);

        String[] levels = {"First Year", "Second Year", "Third Year", "Fourth Year"};
        levelComboBox = new JComboBox<>(levels);
        levelComboBox.setBounds(150, 150, 150, 25);
        frame.add(levelComboBox);

        registerButton = new JButton("Register");
        registerButton.setBounds(150, 200, 150, 25);
        frame.add(registerButton);

        String[] columnNames = {"Name", "Age", "Level"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setBounds(50, 250, 500, 100);
        frame.add(scrollPane);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String level = (String) levelComboBox.getSelectedItem();
                Student student;

                switch (level) {
                    case "First Year":
                        student = new FirstYearStudent(name, age);
                        break;
                    case "Second Year":
                        student = new SecondYearStudent(name, age);
                        break;
                    case "Third Year":
                        student = new ThirdYearStudent(name, age);
                        break;
                    case "Fourth Year":
                        student = new FourthYearStudent(name, age);
                        break;
                    default:
                        throw new IllegalArgumentException("Unexpected value: " + level);
                }

                studentList.add(student);
                tableModel.addRow(new Object[]{student.getName(), student.getAge(), level});
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
