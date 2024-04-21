package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Thiết lập đường viền cho ô của JTable
        ((JComponent) c).setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK)); // Viền đen 1 pixel

        return c;
    }
}