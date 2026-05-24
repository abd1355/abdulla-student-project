package StudentManagementSystem;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StudentUI {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();

        JFrame frame = new JFrame("Student Management");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JButton addBtn = new JButton("Add Student");
        JButton viewBtn = new JButton("View Students");
        JButton updateBtn = new JButton("Update Student");
        JButton deleteBtn = new JButton("Delete Student");

        addBtn.setBounds(100, 30, 200, 30);
        viewBtn.setBounds(100, 70, 200, 30);
        updateBtn.setBounds(100, 110, 200, 30);
        deleteBtn.setBounds(100, 150, 200, 30);

        frame.add(addBtn);
        frame.add(viewBtn);
        frame.add(updateBtn);
        frame.add(deleteBtn);

        // ADD
        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Name:");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
            String course = JOptionPane.showInputDialog("Enter Course:");

            dao.addStudent(name, age, course);
            JOptionPane.showMessageDialog(frame, "Student Added!");
        });

        // VIEW
        viewBtn.addActionListener(e -> {
            String data = dao.getAllStudents();
            JOptionPane.showMessageDialog(frame, data);
        });

        // UPDATE
        updateBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
            String name = JOptionPane.showInputDialog("Enter New Name:");

            dao.updateStudent(id, name);
            JOptionPane.showMessageDialog(frame, "Updated!");
        });

        // DELETE
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));

            dao.deleteStudent(id);
            JOptionPane.showMessageDialog(frame, "Deleted!");
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
