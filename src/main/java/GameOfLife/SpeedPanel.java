package GameOfLife;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SpeedPanel extends JPanel {
    private final JSlider slider;
    public SpeedPanel() {
        setBorder(new EmptyBorder(10,0,10,0));
        JLabel title = new JLabel("Evolution Speed (ms):");
        add(title);

        slider = new JSlider(100,1000,300);
        slider.setFont(slider.getFont().deriveFont(9f));
        slider.setMajorTickSpacing(100);
        slider.setMinorTickSpacing(50);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        add(slider);

        title.setText("Evolution Speed (ms): " + slider.getValue());

        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        slider.addChangeListener(e -> {
            title.setText("Evolution Speed (ms): " + slider.getValue());
        });
    }
    public int getSpeed() {
        return slider.getValue();
    }
}
