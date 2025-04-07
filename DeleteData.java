import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DeleteData {
    public static void deleteStaff(String url, String user, String password) {
        JFrame deleteFrame = new JFrame("Delete Staff");
        deleteFrame.setSize(350, 200);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 16);

        JLabel idLabel = new JLabel("Enter Staff ID:");
        idLabel.setFont(labelFont);

        JTextField idField = new JTextField(15);
        idField.setFont(textFieldFont);
        idField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        mainPanel.add(idLabel);
        mainPanel.add(idField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setPreferredSize(new Dimension(100, 30));
        deleteBtn.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteBtn);

        mainPanel.add(buttonPanel);

        deleteFrame.add(mainPanel);
        deleteFrame.setLocationRelativeTo(null);
        deleteFrame.setVisible(true);

        deleteBtn.addActionListener(e -> {
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                String query = "DELETE FROM rog WHERE id = " + idField.getText();
                st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Staff Deleted Successfully!");
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting staff.");
            }
        });
    }
}