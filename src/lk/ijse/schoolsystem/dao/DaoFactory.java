package lk.ijse.schoolsystem.dao;

import lk.ijse.schoolsystem.dao.custom.impl.StudentDAOImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return (daoFactory == null) ? (daoFactory = new DaoFactory()) : (daoFactory);
    }

    public enum DaoType {
        STUDENT, TEACHER, BOOK
    }

    public <T> T getDao(DaoType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentDAOImpl();
            case TEACHER:
                return null;
            case BOOK:
                return null;
            default:
                return null;
        }
    }
}
