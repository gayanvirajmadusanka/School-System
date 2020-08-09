package lk.ijse.schoolsystem.bo;

import lk.ijse.schoolsystem.bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return (boFactory == null) ? (boFactory = new BOFactory()) : (boFactory);
    }

    public enum BoType {
        STUDENT
    }

    public <T> T getBo(BOFactory.BoType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentBOImpl();
            default:
                return null;
        }
    }

}
