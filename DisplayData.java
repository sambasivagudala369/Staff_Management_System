import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DisplayData {
    public static void showStaffData(String title, String query, String url, String user, String password) {
        JFrame frame = new JFrame(title);
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            String h = "id        name        work        salary\n";
            String l = "------------------------------------------\n";

            textArea.append(h);
            textArea.append(l);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String work = resultSet.getString("work");
                int salary = resultSet.getInt("salary");
                String data = String.format("%-10d %-10s %-12s %-10d\n", id, name, work, salary);
                textArea.append(data);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void showCodingStaff(String url, String user, String password) {
        showStaffData("CODING STAFF", "SELECT id, name, work, salary FROM rog WHERE work='Coding'", url, user, password);
    }

    public static void showInfraStaff(String url, String user, String password) {
        showStaffData("INFRA STAFF", "SELECT id, name, work, salary FROM rog WHERE work='infra'", url, user, password);
    }

    public static void showOperationsStaff(String url, String user, String password) {
        showStaffData("OPERATIONS STAFF", "SELECT id, name, work, salary FROM rog WHERE work='Operations'", url, user, password);
    }

    public static void showDevelopmentStaff(String url, String user, String password) {
        showStaffData("DEVELOPEMENT STAFF", "SELECT id, name, work, salary FROM rog WHERE work='Development'", url, user, password);
    }

    public static void showDesignStaff(String url, String user, String password) {
        showStaffData("DESIGN STAFF", "SELECT id, name, work, salary FROM rog WHERE work='Design'", url, user, password);
    }

    public static void showAllStaff(String url, String user, String password) {
        JFrame frame = new JFrame("ALL THE STAFF");
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.PAGE_START);

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM rog");

            String h = "id        name        work            salary\n";
            String l = "------------------------------------------\n";

            textArea.append(h);
            textArea.append(l);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String work = resultSet.getString("work");
                int salary = resultSet.getInt("salary");
                String data = String.format("%-5d %-12s %-15s %10d\n", id, name, work, salary);
                textArea.append(data);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}