import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


class Expense {
    double amount;
    String category;
    String date;

    Expense(double amount, String category, String date){
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public String toString(){
        return amount + " | " + category + " | " + date;
    }
}


public class ExpenseGUI {

    static ArrayList<Expense> list = new ArrayList<>();

    public static void main(String[] args) {

        JFrame frame = new JFrame("Expense Tracker");

        frame.setSize(400, 450);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        JLabel l1 = new JLabel("Amount:");
        l1.setBounds(30, 30, 100, 30);
        frame.add(l1);

        JLabel l2 = new JLabel("Category:");
        l2.setBounds(30, 80, 100, 30);
        frame.add(l2);

        JLabel l3 = new JLabel("Date:");
        l3.setBounds(30, 130, 100, 30);
        frame.add(l3);

        // Text Fields
        JTextField t1 = new JTextField();
        t1.setBounds(150, 30, 150, 30);
        frame.add(t1);

        JTextField t2 = new JTextField();
        t2.setBounds(150, 80, 150, 30);
        frame.add(t2);

        JTextField t3 = new JTextField();
        t3.setBounds(150, 130, 150, 30);
        frame.add(t3);

        // Button
        JButton btn = new JButton("Add Expense");
        btn.setBounds(100, 180, 150, 40);
        frame.add(btn);

        // Text Area
        JTextArea area = new JTextArea();
        area.setBounds(30, 240, 320, 100);
        area.setEditable(false);
        frame.add(area);

        // Total Label
        JLabel totalLabel = new JLabel("Total: 0");
        totalLabel.setBounds(30, 350, 200, 30);
        frame.add(totalLabel);

        // Button Logic
        btn.addActionListener(e -> {

            try {
                double amount = Double.parseDouble(t1.getText());
                String category = t2.getText();
                String date = t3.getText();

                // Create object
                Expense exp = new Expense(amount, category, date);
                list.add(exp);

                // Display
                area.append(exp.toString() + "\n");

                // Calculate total
                double total = 0;
                for(Expense ex : list){
                    total += ex.amount;
                }

                totalLabel.setText("Total: " + total);

                JOptionPane.showMessageDialog(frame, "Expense Added!");

                // Clear fields
                t1.setText("");
                t2.setText("");
                t3.setText("");

            } catch(Exception ex){
                JOptionPane.showMessageDialog(frame, "Enter valid amount!");
            }
        });

        frame.setVisible(true);
    }
}