package student.registration;

// فئة تمثل الطالب
public class Student {
    private String name;

    // المُنشئ
    public Student(String name) {
        this.name = name;
    }

    // الحصول على الاسم
    public String getName() {
        return name;
    }

    // تعيين الاسم
    public void setName(String name) {
        this.name = name;
    }
}
