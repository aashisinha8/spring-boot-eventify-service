

	package com.eventify.eventify_service.dto;

	import org.jspecify.annotations.Nullable;

import jakarta.validation.constraints.Email;
	import jakarta.validation.constraints.NotBlank;
	import jakarta.validation.constraints.Size;

	public class UserDTORequest {

	    @NotBlank(message = "Name is required")
	    private String name;

	    @Email(message = "Invalid email format")
	    @NotBlank(message = "Email is required")
	    private String email;
	    
	    @NotBlank(message = "Password is required")
	    @Size(min = 6, message = "Password must be at least 6 characters")
	    private String password;
        
	    @NotBlank(message = "Role is required")
	    private String role;

		public String getName() {
			// TODO Auto-generated method stub
			return name;
		}

		public String getEmail() {
			// TODO Auto-generated method stub
			return email;
		}

		public String getRole() {
			// TODO Auto-generated method stub
			return role;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getPassword() {
			// TODO Auto-generated method stub
			return password;
		}

	    // getters & setters
	}
