import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UpdateData {
    public static void updateSalary(String url, String user, String password) {
        JFrame updateFrame = new JFrame("Update Salary");
        updateFrame.setSize(400, 250);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 16);

        JLabel idLabel = new JLabel("Staff ID:");
        idLabel.setFont(labelFont);

        JTextField idField = new JTextField(15);
        idField.setFont(textFieldFont);

        JLabel salaryLabel = new JLabel("New Salary:");
        salaryLabel.setFont(labelFont);

        JTextField salaryField = new JTextField(15);
        salaryField.setFont(textFieldFont);

        mainPanel.add(idLabel);
        mainPanel.add(idField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(salaryLabel);
        mainPanel.add(salaryField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton updateBtn = new JButton("Update");
        updateBtn.setFont(new Font("Arial", Font.BOLD, 14));
        updateBtn.setPreferredSize(new Dimension(100, 30));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(updateBtn);

        mainPanel.add(buttonPanel);

        updateFrame.add(mainPanel);
        updateFrame.setLocationRelativeTo(null);
        updateFrame.setVisible(true);

        updateBtn.addActionListener(e -> {
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                String query = String.format("UPDATE rog SET salary = %s WHERE id = %s",
                        salaryField.getText(), idField.getText());
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Salary Updated Successfully!");
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error updating salary.");
            }
        });
    }
}