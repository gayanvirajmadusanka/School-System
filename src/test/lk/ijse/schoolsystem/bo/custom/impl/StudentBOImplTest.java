package lk.ijse.schoolsystem.bo.custom.impl;


import lk.ijse.schoolsystem.dto.StudentDTO;

class StudentBOImplTest {
    public static void main(String[] args) throws Exception {
        new StudentBOImplTest().saveStudent();
    }

    //    @org.junit.jupiter.api.Test
    void saveStudent() throws Exception {
        new StudentBOImpl().saveStudent(
                new StudentDTO("001", "Nimal", "Colombo", 20)
        );
    }
}