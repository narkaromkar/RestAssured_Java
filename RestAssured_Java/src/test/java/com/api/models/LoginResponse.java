package com.api.models;

public class LoginResponse {

    private String accessToken;
    private String refreshToken;
    private Integer id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String image;

    // Getters
    public String getAccessToken() { return accessToken; }
    public String getRefreshToken() { return refreshToken; }
    public Integer getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGender() { return gender; }
    public String getImage() { return image; }

    // Setters
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
    public void setRefreshToken(String refreshToken) { this.refreshToken = refreshToken; }
    public void setId(Integer id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setGender(String gender) { this.gender = gender; }
    public void setImage(String image) { this.image = image; }

    @Override
    public String toString() {
        return "LoginResponse{accessToken='" + accessToken + "', refreshToken='" + refreshToken + 
               "', id=" + id + ", username='" + username + "', email='" + email + 
               "', firstName='" + firstName + "', lastName='" + lastName + 
               "', gender='" + gender + "', image='" + image + "'}";
    }
}
