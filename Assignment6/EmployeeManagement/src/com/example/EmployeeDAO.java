
package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/company_db";

    private static final String USER = "root";

    // Replace with your actual MySQL password.
    private static final String PASSWORD = "Saumya#9103";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Insert a new employee
    public boolean addEmployee(
            int id, String name, String department, double salary) {

        String sql = "INSERT INTO employees "
                + "(emp_id, name, department, salary) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setDouble(4, salary);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Could not add employee: " + e.getMessage(), e);
        }
    }

    // Retrieve all employees
    public List<Object[]> getAllEmployees() {

        List<Object[]> employees = new ArrayList<>();

        String sql = "SELECT emp_id, name, department, salary "
                + "FROM employees ORDER BY emp_id";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Object[] employee = {
                        rs.getInt("emp_id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getBigDecimal("salary")
                };

                employees.add(employee);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Could not retrieve employees: "
                            + e.getMessage(), e);
        }

        return employees;
    }
}
