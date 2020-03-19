package Model;

public class Submit {
    private String homework_title;
    private String teacher_name;
    private String student_name;
    private String content;

    public Submit () { }

    public Submit(String homework_title, String teacher_name, String student_name, String content) {
        this.homework_title = homework_title;
        this.teacher_name = teacher_name;
        this.student_name = student_name;
        this.content = content;
    }

    public void setHomework_title(String homework_title) {
        this.homework_title = homework_title;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHomework_title() {
        return homework_title;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public String getStudent_name() {
        return student_name;
    }

    public String getContent() {
        return content;
    }
}
