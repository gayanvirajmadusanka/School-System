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

    private void clearAllTxt() {
        txtId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtAge.setText("");
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws Exception {
        String id = txtId.getText();
        if (studentBO.deleteStudent(id)) {
            new Alert(Alert.AlertType.INFORMATION, "Successfully deleted", ButtonType.OK).show();
            clearAllTxt();
        } else {
            new Alert(Alert.AlertType.WARNING, "No student found for " + id, ButtonType.OK).show();
            clearAllTxt();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO = new StudentDTO(txtId.getText(), txtName.getText(), txtAddress.getText(), Integer.parseInt(txtAge.getText()));
        try {
            if (studentBO.updateStudent(studentDTO)) {
                new Alert(Alert.AlertType.INFORMATION, "Updated", ButtonType.OK).show();
                clearAllTxt();
            } else {
                new Alert(Alert.AlertType.WARNING, "Not updated", ButtonType.OK).show();
                clearAllTxt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO studentDTO = new StudentDTO(txtId.getText(), txtName.getText(), txtAddress.getText(), Integer.parseInt(txtAge.getText()));
        if (studentBO.saveStudent(studentDTO)) {
            new Alert(Alert.AlertType.INFORMATION, "Saved", ButtonType.OK).show();
            clearAllTxt();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try again", ButtonType.OK).show();
            clearAllTxt();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) throws Exception {
        String id = txtId.getText();
        StudentDTO studentDTO = studentBO.getStudent(id);
        if (studentDTO != null) {
            txtName.setText(studentDTO.getName());
            txtAddress.setText(studentDTO.getAddress());
            txtAge.setText(Integer.toString(studentDTO.getAge()));
        } else {
            new Alert(Alert.AlertType.WARNING, "No student found for " + id, ButtonType.OK).show();
            clearAllTxt();
        }
    }

    public void txtStudentIdOnACtion(ActionEvent actionEvent) throws Exception {
        btnSearchOnAction(actionEvent);
    }
}
