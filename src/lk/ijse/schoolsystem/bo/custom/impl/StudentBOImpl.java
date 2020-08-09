package lk.ijse.schoolsystem.bo.custom.impl;

import lk.ijse.schoolsystem.bo.custom.StudentBO;
import lk.ijse.schoolsystem.dao.DaoFactory;
import lk.ijse.schoolsystem.dao.custom.StudentDAO;
import lk.ijse.schoolsystem.db.HibernateUtil;
import lk.ijse.schoolsystem.dto.StudentDTO;
import lk.ijse.schoolsystem.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = DaoFactory.getInstance().getDao(DaoFactory.DaoType.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {

        try (Session session = HibernateUtil.getSession()) {
            studentDAO.setSession(session);
            session.beginTransaction();
            boolean isSaved = studentDAO.save(new Student(dto.getId(), dto.getName(), dto.getAddress(), dto.getAge()));
            session.getTransaction().commit();
            return isSaved;
        }
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        return null;
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return false;
    }

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        return null;
    }
}
