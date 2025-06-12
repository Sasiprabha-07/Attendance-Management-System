package com.ams.model;

import java.time.LocalDateTime;

public class User {
    private int userId;
    private String name;
    private String role; // e.g., "Admin", "Employee", "Student"
    private String username;
    private String passwordHash; // Stored hashed password
    private String department; // Or "Class"
    private String contactInfo;
    private LocalDateTime createdAt;

    public User() {} // Default constructor for JavaFX TableView

    public User(int userId, String name, String role, String username, String department, String contactInfo, LocalDateTime createdAt) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.username = username;
        this.department = department;
        this.contactInfo = contactInfo;
        this.createdAt = createdAt;
    }

    // --- Getters and Setters ---
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "User{" +
               "userId=" + userId +
               ", name='" + name + '\'' +
               ", role='" + role + '\'' +
               ", username='" + username + '\'' +
               '}';
    }
}