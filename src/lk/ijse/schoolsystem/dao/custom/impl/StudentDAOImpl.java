package lk.ijse.schoolsystem.dao.custom.impl;

import lk.ijse.schoolsystem.dao.custom.StudentDAO;
import lk.ijse.schoolsystem.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private Session session;

    @Override
    public void setSession(Session session) throws Exception {
        this.session = session;
    }

    @Override
    public boolean save(Student student) throws Exception {
        return session.save(student) != null;
    }

    @Override
    public boolean update(Student student) throws Exception {
        session.merge(student);
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        session.delete(session.load(Student.class, s));
        return true;
    }

    @Override
    public Student get(String s) throws Exception {
        Student student = session.get(Student.class, s);
        session.getTransaction().commit();

        return student;
    }

    @Override
    public List<Student> getAll() throws Exception {
        return session.createQuery("FROM Student").list();
    }
}
