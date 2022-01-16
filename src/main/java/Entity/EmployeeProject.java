package Entity;

import java.util.Objects;

public class EmployeeProject {
    private Long id;

    private Long idEmployee;
    private Long idProject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeProject that = (EmployeeProject) o;
        return Objects.equals(id, that.id) && Objects.equals(idEmployee, that.idEmployee) && Objects.equals(idProject, that.idProject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idEmployee, idProject);
    }
}
