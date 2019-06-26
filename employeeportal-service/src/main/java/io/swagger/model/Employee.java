package io.swagger.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Employee
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-24T04:53:56.519Z")

public class Employee   {
  @JsonProperty("employeeId")
  private int employeeId = 0;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("gender")
  private String gender = null;

  @JsonProperty("dob")
  private String dob = null;

  @JsonProperty("department")
  private String department = null;

  public Employee employeeId(int employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  /**
   * ID of the Employee
   * @return employeeId
  **/
  @ApiModelProperty(value = "ID of the Employee")

  @Valid

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public Employee firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First Name of the Employee
   * @return firstName
  **/
  @ApiModelProperty(value = "First Name of the Employee")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Employee lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last Name of the Employee
   * @return lastName
  **/
  @ApiModelProperty(value = "Last Name of the Employee")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Employee gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Gender of the Employee
   * @return gender
  **/
  @ApiModelProperty(value = "Gender of the Employee")


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Employee dob(String dob) {
    this.dob = dob;
    return this;
  }

  /**
   * Date of Birth of the Employee
   * @return dob
  **/
  @ApiModelProperty(value = "Date of Birth of the Employee")


  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public Employee department(String department) {
    this.department = department;
    return this;
  }

  /**
   * Department of the Employee
   * @return department
  **/
  @ApiModelProperty(value = "Department of the Employee")


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.employeeId, employee.employeeId) &&
        Objects.equals(this.firstName, employee.firstName) &&
        Objects.equals(this.lastName, employee.lastName) &&
        Objects.equals(this.gender, employee.gender) &&
        Objects.equals(this.dob, employee.dob) &&
        Objects.equals(this.department, employee.department);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employeeId, firstName, lastName, gender, dob, department);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    
    sb.append("    employeeId: ").append(toIndentedString(employeeId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

