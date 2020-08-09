package lk.ijse.schoolsystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import lk.ijse.schoolsystem.bo.BOFactory;
import lk.ijse.schoolsystem.bo.custom.StudentBO;
import lk.ijse.schoolsystem.dto.StudentDTO;

public class StudentForm {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtAge;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colAge;
    public TableView tbl;

    private StudentBO studentBO;

    public void initialize() {
        studentBO = BOFactory.getInstance().getBo(BOFactory.BoType.STUDENT);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws Exception {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO studentDTO = new StudentDTO(txtId.getText(), txtId.getText(), txtName.getText(), Integer.parseInt(txtAge.getText()));
        if (studentBO.saveStudent(studentDTO)) {
            new Alert(Alert.AlertType.INFORMATION, "Saved", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try again", ButtonType.OK).show();
        }
    }
}
