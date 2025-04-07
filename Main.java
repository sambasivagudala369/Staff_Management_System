import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "Vijay#369";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame jf = new JFrame("STAFF DETAILS");
        jf.setSize(800, 520);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setBackground(Color.BLACK);

        // HEADING LABEL
        JLabel heading = new JLabel("STAFF MANAGEMENT SYSTEM");
        heading.setBounds(200, 20, 400, 40);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
        heading.setForeground(Color.WHITE);
        heading.setText("<html><u>STAFF MANAGEMENT SYSTEM</u></html>");
        jf.add(heading);

        // Display buttons
        createDisplayButtons(jf);
        
        // CRUD operation buttons
        createCRUDButtons(jf);
    }

    private static void createDisplayButtons(JFrame frame) {
        JButton jb1 = createDepartmentButton("CODING", 50, 100);
        jb1.addActionListener(e -> DisplayData.showCodingStaff(url, user, password));
        frame.add(jb1);

        JButton jb2 = createDepartmentButton("INFRA", 200, 100);
        jb2.addActionListener(e -> DisplayData.showInfraStaff(url, user, password));
        frame.add(jb2);

        JButton jb3 = createDepartmentButton("OPERATIONS", 350, 100);
        jb3.addActionListener(e -> DisplayData.showOperationsStaff(url, user, password));
        frame.add(jb3);

        JButton jb4 = createDepartmentButton("DEVELOPMENT", 500, 100);
        jb4.addActionListener(e -> DisplayData.showDevelopmentStaff(url, user, password));
        frame.add(jb4);

        JButton jb5 = createDepartmentButton("DESIGN", 650, 100);
        jb5.addActionListener(e -> DisplayData.showDesignStaff(url, user, password));
        frame.add(jb5);

        JButton jb6 = new JButton("VIEW DATA");
        jb6.setBounds(320, 205, 150, 80);
        jb6.setFocusable(false);
        jb6.setBackground(Color.GREEN);
        jb6.setForeground(Color.black);
        jb6.addActionListener(e -> DisplayData.showAllStaff(url, user, password));
        frame.add(jb6);
    }

    private static void createCRUDButtons(JFrame frame) {
        JButton jb7 = new JButton("ADD NEW STAFF");
        jb7.setBounds(50, 350, 150, 50);
        jb7.setFocusable(false);
        jb7.setBackground(Color.RED);
        jb7.setForeground(Color.BLACK);
        jb7.addActionListener(e -> AddData.addStaff(url, user, password));
        frame.add(jb7);

        JButton jb8 = new JButton("UPDATE SALARY");
        jb8.setBounds(320, 350, 150, 50);
        jb8.setFocusable(false);
        jb8.setBackground(Color.RED);
        jb8.setForeground(Color.BLACK);
        jb8.addActionListener(e -> UpdateData.updateSalary(url, user, password));
        frame.add(jb8);

        JButton jb9 = new JButton("DELETE STAFF");
        jb9.setBounds(600, 350, 150, 50);
        jb9.setFocusable(false);
        jb9.setBackground(Color.RED);
        jb9.setForeground(Color.BLACK);
        jb9.addActionListener(e -> DeleteData.deleteStaff(url, user, password));
        frame.add(jb9);
    }

    private static JButton createDepartmentButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 100, 50);
        button.setFocusable(false);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.black);
        return button;
    }
}