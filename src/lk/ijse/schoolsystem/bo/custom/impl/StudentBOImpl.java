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

        try (Session session = HibernateUtil.getSession()) {
            studentDAO.setSession(session);
            session.beginTransaction();
            Student student = studentDAO.get(id);
            if (student != null) {
                return new StudentDTO(student.getId(), student.getName(), student.getAddress(), student.getAge());
            }
            return null;
        }

    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws Exception {
        try (Session session = HibernateUtil.getSession()) {
            studentDAO.setSession(session);
            session.beginTransaction();
            boolean isUpdated = studentDAO.update(new Student(dto.getId(), dto.getName(), dto.getAddress(), dto.getAge()));
            return isUpdated;
        }
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        try (Session session = HibernateUtil.getSession()) {
            studentDAO.setSession(session);
            session.beginTransaction();
            boolean isDeleted = studentDAO.delete(id);
            session.getTransaction().commit();
            return isDeleted;
        }
    }

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        return null;
    }
}
