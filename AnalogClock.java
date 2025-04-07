import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AnalogClock extends JPanel implements ActionListener {
    private Timer timer;

    public AnalogClock() {
        this.timer = new Timer(1000, this);
        this.timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Get current time
        Calendar calendar = new GregorianCalendar();
        int hours = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);

        // Draw the clock face
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2 - 8;
        int centerX = width / 2;
        int centerY = height / 2;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        // Draw clock hands
        drawHand(g2d, centerX, centerY, radius - 20, (hours % 12 + minutes / 60.0) * 30);
        drawHand(g2d, centerX, centerY, radius - 10, (minutes + seconds / 60.0) * 6);
        g2d.setColor(Color.MAGENTA);
        drawHand(g2d, centerX, centerY, radius - 10, seconds * 6);

        // Draw date and time
        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        String dateString = String.format("%02d/%02d/%04d", calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        g2d.drawString(timeString, centerX - 40, centerY + radius + 20);
        g2d.drawString(dateString, centerX - 40, centerY + radius + 40);
    }

    private void drawHand(Graphics2D g2d, int centerX, int centerY, int length, double angle) {
        double rad = Math.toRadians(angle - 90);
        int x = centerX + (int) (length * Math.cos(rad));
        int y = centerY + (int) (length * Math.sin(rad));
        g2d.drawLine(centerX, centerY, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Analog Clock with Date and Time");
        AnalogClock clock = new AnalogClock();
        frame.add(clock);
        frame.setSize(400, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
