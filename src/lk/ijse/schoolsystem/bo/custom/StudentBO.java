package lk.ijse.schoolsystem.bo.custom;

import lk.ijse.schoolsystem.bo.SuperBO;
import lk.ijse.schoolsystem.dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean saveStudent(StudentDTO dto) throws Exception;

    public StudentDTO getStudent(String id) throws Exception;

    public boolean updateStudent(StudentDTO dto) throws Exception;

    public boolean deleteStudent(String id) throws Exception;

    public List<StudentDTO> getAllStudents() throws Exception;
}
