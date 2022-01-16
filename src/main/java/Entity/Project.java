package Entity;

import java.util.Objects;

public class Project {
    private Long id;
    private String title;
    private int grade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return grade == project.grade && Objects.equals(id, project.id) && Objects.equals(title, project.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, grade);
    }
}
