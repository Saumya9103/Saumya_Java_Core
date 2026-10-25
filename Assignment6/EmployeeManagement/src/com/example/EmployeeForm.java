
package com.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

public class EmployeeForm extends JFrame {

    private final JTextField idField = new JTextField();
    private final JTextField nameField = new JTextField();
    private final JTextField departmentField = new JTextField();
    private final JTextField salaryField = new JTextField();

    private final EmployeeDAO dao = new EmployeeDAO();

    private final String[] columns = {
            "Employee ID", "Name", "Department", "Salary"
    };

    private final DefaultTableModel tableModel =
            new DefaultTableModel(columns, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

    private final JTable employeeTable = new JTable(tableModel);

    public EmployeeForm() {

        setTitle("Employee Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 8, 8));
        formPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 10, 15));

        formPanel.add(new JLabel("Employee ID:"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Department:"));
        formPanel.add(departmentField);

        formPanel.add(new JLabel("Salary:"));
        formPanel.add(salaryField);

        JButton submitButton = new JButton("Submit");
        JButton viewButton = new JButton("View All Employees");

        formPanel.add(submitButton);
        formPanel.add(viewButton);

        // Employee table
        employeeTable.setRowHeight(24);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                "Employee Records"));

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        submitButton.addActionListener(e -> addEmployee());
        viewButton.addActionListener(e -> viewEmployees());
    }

    private void addEmployee() {

        try {
            String idText = idField.getText().trim();
            String name = nameField.getText().trim();
            String department = departmentField.getText().trim();
            String salaryText = salaryField.getText().trim();

            if (idText.isEmpty() || name.isEmpty()
                    || department.isEmpty() || salaryText.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "Please fill in all fields.");
                return;
            }

            int id = Integer.parseInt(idText);
            BigDecimal salary = new BigDecimal(salaryText);

            if (id <= 0 || salary.compareTo(BigDecimal.ZERO) < 0
                    || salary.scale() > 2
                    || salary.precision() - salary.scale() > 8) {
                JOptionPane.showMessageDialog(
                        this, "Enter a valid ID and salary "
                                + "(maximum 2 decimal places).");
                return;
            }

            boolean inserted = dao.addEmployee(
                    id, name, department, salary.doubleValue());

            if (inserted) {
                JOptionPane.showMessageDialog(
                        this, "Employee added successfully!");

                idField.setText("");
                nameField.setText("");
                departmentField.setText("");
                salaryField.setText("");

                viewEmployees();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this, "Employee ID must be an integer "
                            + "and salary must be a valid number.");
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(
                    this, ex.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewEmployees() {

        try {
            List<Object[]> employees = dao.getAllEmployees();

            tableModel.setRowCount(0);

            for (Object[] employee : employees) {
                tableModel.addRow(employee);
            }

            if (employees.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "No employee records found.");
            }

        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(
                    this, ex.getMessage(), "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeForm form = new EmployeeForm();
            form.setVisible(true);
        });
    }
}
