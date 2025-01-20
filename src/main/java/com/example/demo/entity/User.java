package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the userId will be auto-generated.
    private Integer userId; // Stores the unique identifier for each user.

    @Column(nullable = false, unique = true) // Ensures that the username is unique and cannot be null.
    private String username; // Stores the username for user authentication.

    @Column(nullable = false, unique = true) // Ensures that the email is unique and cannot be null.
    private String email; // Stores the user's email for communication and login.

    @Column(nullable = false) // Ensures that the password cannot be null.
    private String password; // Stores the hashed password for user authentication.

    @Enumerated(EnumType.STRING) // Maps the role as a string value (e.g., ADMIN or CUSTOMER).
    @Column(nullable = false)
    private Role role; // Stores the user's role (ADMIN or CUSTOMER).

    @Column(nullable = false, updatable = false) // Ensures the creation timestamp is set and cannot be updated.
    private LocalDateTime createdAt = LocalDateTime.now(); // Automatically sets the creation timestamp.

    @Column(nullable = false) // Ensures the updated timestamp is set and can be updated.
    private LocalDateTime updatedAt = LocalDateTime.now(); // Automatically updates the timestamp on modification.

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    
	public User(Integer userId, String username, String email, String password, Role role, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String email, String password, Role role, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

    
    
}