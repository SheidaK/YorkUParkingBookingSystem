package presentation;

import objects.Manager;
import objects.SuperManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * GUI for the SuperManager to create new manager accounts
 */
public class SuperManagerView extends JFrame {
    private SuperManager superManager;
    private JTable managersTable;
    private DefaultTableModel tableModel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton createButton, removeButton;

    public SuperManagerView() {
        superManager = SuperManager.getInstance();
        initComponents();
        loadManagers();
    }

    private void initComponents() {
        setTitle("Super Manager Console");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table setup
        String[] columnNames = {"Username", "Role"};
        tableModel = new DefaultTableModel(columnNames, 0);
        managersTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(managersTable);
        add(scrollPane, BorderLayout.CENTER);

        // Input Panel
        JPanel inputPanel = new JPanel(new FlowLayout());
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        createButton = new JButton("Create Manager");
        removeButton = new JButton("Remove Selected");

        inputPanel.add(new JLabel("Username:"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);
        inputPanel.add(createButton);
        inputPanel.add(removeButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Action Listeners
        createButton.addActionListener(this::createManager);
        removeButton.addActionListener(this::removeManager);
    }

    private void createManager(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username and Password required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (superManager.createManager(username, password, "Manager")) {
            loadManagers();
        } else {
            JOptionPane.showMessageDialog(this, "Manager already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeManager(ActionEvent e) {
        int selectedRow = managersTable.getSelectedRow();
        if (selectedRow >= 0) {
            String username = (String) tableModel.getValueAt(selectedRow, 0);
            superManager.removeManager(username);
            loadManagers();
        }
    }

    private void loadManagers() {
        tableModel.setRowCount(0);
        List<Manager> managers = superManager.getAllManagers();
        if(managers != null) {for (Manager manager : managers) {
            tableModel.addRow(new Object[]{manager.getEmail(), manager.getRole()});
        }
        }
    }

    public static void showSuperManagerView() {
        SwingUtilities.invokeLater(() -> {
            SuperManagerView view = new SuperManagerView();
            view.setVisible(true);
        });
    }
}
