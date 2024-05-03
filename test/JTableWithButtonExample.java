import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTableWithButtonExample extends JFrame {

    public JTableWithButtonExample() {
        setTitle("JTable with Button Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dữ liệu cho bảng
        Object[][] data = {
                {"Item 1"},
                {"Item 2"},
                {"Item 3"}
        };

        // Tiêu đề cột
        String[] columns = {"Name", "Action"};

        CustomTableModel model = new CustomTableModel(data, columns);

        JTable table = new JTable(model);

        // Tạo một custom TableCellRenderer để hiển thị button trong cột Action
        table.getColumnModel().getColumn(1).setCellRenderer(new ButtonRenderer());

        // Tạo một custom TableCellEditor để xử lý sự kiện khi button được nhấn
        table.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTableWithButtonExample().setVisible(true);
            }
        });
    }

    // Custom table model
    static class CustomTableModel extends AbstractTableModel {
        private final Object[][] data;
        private final String[] columns;

        public CustomTableModel(Object[][] data, String[] columns) {
            this.data = data;
            this.columns = columns;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return columns[column];
        }
    }

    // Custom TableCellRenderer để hiển thị button trong cell
    static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // Custom TableCellEditor để xử lý sự kiện khi button được nhấn
    static class ButtonEditor extends DefaultCellEditor {
        protected JButton button;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                    // Xử lý sự kiện khi nút được nhấn
                    JOptionPane.showMessageDialog(null, "Button clicked!");
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText((value == null) ? "" : value.toString());
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return button.getText();
        }
    }
}
