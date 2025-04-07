import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AddData {
    public static void addStaff(String url, String user, String password) {
        JFrame addFrame = new JFrame("Add New Staff");
        addFrame.setSize(500, 400);
        
        JPanel outerPanel = new JPanel();
        outerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.Y_AXIS));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField workField = new JTextField();
        JTextField salaryField = new JTextField();

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(labelFont);
        idField.setFont(fieldFont);
        formPanel.add(idLabel);
        formPanel.add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        nameField.setFont(fieldFont);
        formPanel.add(nameLabel);
        formPanel.add(nameField);

        JLabel workLabel = new JLabel("Work:");
        workLabel.setFont(labelFont);
        workField.setFont(fieldFont);
        formPanel.add(workLabel);
        formPanel.add(workField);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setFont(labelFont);
        salaryField.setFont(fieldFont);
        formPanel.add(salaryLabel);
        formPanel.add(salaryField);

        JButton submit = new JButton("Add");
        submit.setPreferredSize(new Dimension(120, 40));
        submit.setFont(new Font("Arial", Font.BOLD, 16));
        submit.setMargin(new Insets(10, 20, 10, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submit);

        outerPanel.add(formPanel);
        outerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        outerPanel.add(buttonPanel);

        addFrame.add(outerPanel);

        submit.addActionListener(e -> {
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                String query = "INSERT INTO rog (id, name, work, salary) VALUES (?, ?, ?, ?)";
                PreparedStatement pst = con.prepareStatement(query);

                pst.setInt(1, Integer.parseInt(idField.getText()));
                pst.setString(2, nameField.getText());
                pst.setString(3, workField.getText());
                pst.setInt(4, Integer.parseInt(salaryField.getText()));

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Staff Added Successfully!");
                con.close();
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for ID and Salary.");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error occurred.");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An unexpected error occurred.");
            }
        });

        addFrame.setLocationRelativeTo(null);
        addFrame.setVisible(true);
    }
}