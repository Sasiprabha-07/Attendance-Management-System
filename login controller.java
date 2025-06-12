package com.ams.controller;

import com.ams.dao.UserDao;
import com.ams.model.User;
import com.ams.util.PasswordHasher;
import com.ams.view.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    private UserDao userDao = new UserDao();

    @FXML
    public void handleLoginButtonAction(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Login Error", "Please enter username and password.");
            return;
        }

        try {
            User user = userDao.getUserByUsername(username);
            if (user != null && PasswordHasher.checkPassword(password, user.getPasswordHash())) {
                System.out.println("Login successful for user: " + user.getUsername() + " with role: " + user.getRole());
                // Pass the user's role to the main application
                MainApplication.showMainView(user.getRole());
            } else {
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to connect to database or query data. Check console for details.");
            e.printStackTrace();
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Application Error", "Could not load main application view.");
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}