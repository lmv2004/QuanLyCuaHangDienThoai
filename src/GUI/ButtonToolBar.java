package GUI;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import javax.swing.JLabel;
public class ButtonToolBar extends JLabel{
    private FlatSVGIcon svgIcon;
    public void setSVGImage(String image, int width, int height) {
        svgIcon = new FlatSVGIcon(image, width, height);
        setIcon(svgIcon);
    }
}
