import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Slapsgiving extends JFrame {
    private JLabel countdownLabel;

    public Slapsgiving() {
        setTitle("Slapsgiving Countdown");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // Remove title bar
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Who doesn't like full screen

        countdownLabel = new JLabel("", SwingConstants.CENTER);
        countdownLabel.setFont(new Font("Serif", Font.BOLD, 48));
        add(countdownLabel);

        Timer timer = new Timer(1000, e -> updateCountdown());
        timer.start();

        updateCountdown();
    }

    private void updateCountdown() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();
        LocalDate thanksgiving = LocalDate.of(today.getYear(), Month.NOVEMBER, getThanksgivingDay(today.getYear()));

        LocalDateTime thanksgivingTime = LocalDateTime.of(thanksgiving, LocalTime.of(21, 0));
        if (now.isAfter(thanksgivingTime)) {
            thanksgivingTime = LocalDateTime.of(thanksgiving.plusYears(1), LocalTime.of(21, 0));
        }

        Duration duration = Duration.between(now, thanksgivingTime);
        long days = duration.toDays();
        duration = duration.minus(days, ChronoUnit.DAYS);
        long hours = duration.toHours();
        duration = duration.minus(hours, ChronoUnit.HOURS);
        long minutes = duration.toMinutes();
        duration = duration.minus(minutes, ChronoUnit.MINUTES);
        long seconds = duration.getSeconds();

        String countdownText = String.format("%d : %02d : %02d : %02d", days, hours, minutes, seconds);
        countdownLabel.setText(countdownText);
    }

    private int getThanksgivingDay(int year) {
        LocalDate novemberFirst = LocalDate.of(year, Month.NOVEMBER, 1);
        int firstThursday = 4 - novemberFirst.getDayOfWeek().getValue();
        if (firstThursday < 1) {
            firstThursday += 7;
        }
        return firstThursday + 21; // 4th Thursday of November
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Slapsgiving frame = new Slapsgiving();
            frame.setVisible(true);
        });
    }
}
