import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class StaffManagementGUI {
    public static void main(String[] args) {
        Gui3 g3=new Gui3();
        SwingUtilities.invokeLater(()->{
            g3.frame();
        });
    }

}
class Gui3{
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "Vijay#369";
    public void frame(){
    JFrame jf = new JFrame("STAFF DETAILS");
        jf.setSize(800, 400);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.getContentPane().setBackground(Color.BLACK);

    //FOR BUTTON1

    JButton jb1 = new JButton("CODING");
        jb1.setBounds(50, 100, 100, 50);
        jb1.setFocusable(false);
        jb1.setBackground(Color.BLUE);
        jb1.setForeground(Color.black);
        jf.add(jb1);
        jb1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Button1();
        }
    });

    //FOR BUTTON2

    JButton jb2 = new JButton("INFRA");
        jb2.setBounds(200, 100, 100, 50);
        jb2.setFocusable(false);
        jb2.setBackground(Color.BLUE);
        jb2.setForeground(Color.black);
        jf.add(jb2);
        jb2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Button2();
        }
    });

    //FOR BUTTON3

    JButton jb3 = new JButton("OPERATIONS");
        jb3.setBounds(350, 100, 100, 50);
        jb3.setFocusable(false);
        jb3.setBackground(Color.BLUE);
        jb3.setForeground(Color.black);
        jf.add(jb3);
        jb3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Button3();
        }
    });

    //FOR BUTTON4

    JButton jb4 = new JButton("DEVELOPMENT");
        jb4.setBounds(500, 100, 100, 50);
        jb4.setFocusable(false);
        jb4.setBackground(Color.BLUE);
        jb4.setForeground(Color.black);
        jf.add(jb4);
        jb4.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Button4();
        }
    });

    //FOR BUTTON 5

    JButton jb5 = new JButton("DESIGN");
        jb5.setBounds(650, 100, 100, 50);
        jb5.setFocusable(false);
        jb5.setBackground(Color.BLUE);
        jb5.setForeground(Color.black);
        jf.add(jb5);
        jb5.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Button5();
        }
    });

    //FOR BUTTON6

    JButton jb6 = new JButton("VIEW DATA");
        jb6.setBounds(320, 200, 150, 80);
        jb6.setFocusable(false);
        jb6.setBackground(Color.BLUE);
        jb6.setForeground(Color.black);
        jf.add(jb6);
        jb6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Button6();
        }
    });
}

    public void Button1() {
        JFrame f1 = new JFrame("CODING STAFF");

        // Create a JTextArea for displaying data
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setSize(400,500);
        textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Add the JTextArea to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the JScrollPane to the main frame
        f1.getContentPane().add(scrollPane, BorderLayout.BEFORE_LINE_BEGINS);

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM rog where work='Coding'");

            // Process the result set and append data to the JTextArea

            String h = "id        name        work\n";
            String l = "--------------------------------\n";
            textArea.append(h);
            textArea.append(l);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("work");
                String data = String.format("%-10d %-8s       %s\n", id, name, age);
                textArea.append(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set default close operation and make the frame visible
        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f1.setSize(450, 500);
        f1.setLocationRelativeTo(null); // Center the frame
        f1.setVisible(true);
        f1.setResizable(false);

    }

    //FOR BUTTON2

    public void Button2() {
        // Create the main frame
        JFrame f2 = new JFrame("INFRA STAFF");

        // Create a JTextArea for displaying data
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setSize(500,500);
        textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Add the JTextArea to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the JScrollPane to the main frame
        f2.getContentPane().add(scrollPane, BorderLayout.CENTER);

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM rog where work='infra'");

            // Process the result set and append data to the JTextArea
            String h = "id        name        work\n";
            String l = "--------------------------------\n";
            textArea.append(h);
            textArea.append(l);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("work");
                String data = String.format("%-10d %-8s      %s\n", id, name, age);
                textArea.append(data);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set default close operation and make the frame visible
        f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f2.setSize(500, 500);
        f2.setLocationRelativeTo(null); // Center the frame
        f2.setVisible(true);
        f2.setResizable(false);

    }
    //FOR BUTTON3
    public void Button3() {

        JFrame f3 = new JFrame("OPERATIONS STAFF");

        // Create a JTextArea for displaying data
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setSize(500,500);
        textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Add the JTextArea to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the JScrollPane to the main frame
        f3.getContentPane().add(scrollPane, BorderLayout.CENTER);

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM rog where work='Operations'");

            // Process the result set and append data to the JTextArea
            String h = "id        name        work\n";
            String l = "--------------------------------\n";
            textArea.append(h);
            textArea.append(l);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("work");
                String data = String.format("%-10d %-8s     %s\n", id, name, age);
                textArea.append(data);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set default close operation and make the frame visible
        f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f3.setSize(500, 500);
        f3.setLocationRelativeTo(null); // Center the frame
        f3.setVisible(true);
        f3.setResizable(false);

    }

    //FOR BUTTON4

    public void Button4() {
        JFrame f4 = new JFrame("DEVELOPEMENT STAFF");

        // Create a JTextArea for displaying data
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setSize(500,500);
        textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Add the JTextArea to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the JScrollPane to the main frame
        f4.getContentPane().add(scrollPane, BorderLayout.CENTER);

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM rog where work = 'Development'");
            String h = "id        name        work\n";
            String l = "--------------------------------\n";
            textArea.append(h);
            textArea.append(l);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("work");
                String data = String.format("%-10d %-8s      %s\n", id, name, age);
                textArea.append(data);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set default close operation and make the frame visible
        f4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f4.setSize(500, 500);
        f4.setLocationRelativeTo(null); // Center the frame
        f4.setVisible(true);
        f4.setResizable(false);

    }

    //FOR BUTTON5
    public void Button5() {
        JFrame f5 = new JFrame("DESIGN STAFF");

        // Create a JTextArea for displaying data
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setSize(500,500);
        textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Add the JTextArea to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the JScrollPane to the main frame
        f5.getContentPane().add(scrollPane, BorderLayout.CENTER);

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM rog where work='Design'");

            // Process the result set and append data to the JTextArea
            String h = "id        name        work\n";
            String l = "--------------------------------\n";
            textArea.append(h);
            textArea.append(l);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("work");
                String data = String.format("%-10d %-8s       %s\n", id, name, age);
                textArea.append(data);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set default close operation and make the frame visible
        f5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f5.setSize(500, 500);
        f5.setLocationRelativeTo(null); // Center the frame
        f5.setVisible(true);
        f5.setResizable(false);

    }

    //FOR BUTTON6

    public void Button6() {
        JFrame f6 = new JFrame("ALL THE STAFF");

        // Create a JTextArea for displaying data
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setSize(500,500);
        textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Add the JTextArea to a JScrollPane for scrolling
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the JScrollPane to the main frame
        f6.getContentPane().add(scrollPane, BorderLayout.PAGE_START);

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM rog");

            // Process the result set and append data to the JTextArea
            String h = "id         name         work\n";
            String l = "--------------------------------\n";
            textArea.append(h);
            textArea.append(l);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("work");
                String data = String.format("%-10d %-8s      %2s\n", id, name, age);
                textArea.append(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        f6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f6.setSize(600, 600);
        f6.setLocationRelativeTo(null); // Center the frame
        f6.setVisible(true);
        f6.setResizable(false);

    }
}
