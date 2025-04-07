# 🕒 Java Clock Application (Analog & Digital)

This project includes **two Java GUI applications** developed using **Swing**:
1. **Analog Clock** – A visually styled round clock with moving hands.
2. **Digital Clock** – A modern digital interface that shows time and date.

---

## 📌 Features

### ✅ Analog Clock
- Displays current hour, minute, and second hands.
- Updates every second using a `Timer`.
- Shows formatted time (HH:MM:SS) and date (DD/MM/YYYY).
- Smooth rendering with anti-aliasing.

### ✅ Digital Clock
- Displays current system time in `HH:MM:SS` format.
- Shows full formatted date (`Day, Month Date, Year`).
- Real-time update every second.
- Styled labels with different fonts and colors.

---

## 🧰 Technologies Used

- Java
- Java Swing
- AWT (Abstract Window Toolkit)
- Timers
- `Calendar`, `SimpleDateFormat`, and `GregorianCalendar` classes

---

## 🧑‍💻 How to Run

1. **Save the files:**
   - `AnalogClock.java`
   - `Digital_clock.java`

2. **Compile:**
javac AnalogClock.java javac Digital_clock.java

3. **Run:**
java AnalogClock java Digital_clock

---

---

## 📌 Notes

- The **Analog Clock** uses trigonometry to draw the hands based on the current time.
- The **Digital Clock** uses `SimpleDateFormat` to easily format time and date.
- Both applications use `javax.swing.Timer` to trigger GUI updates every second.
- Fully resizable and responsive interfaces.
- You can run both clocks independently.

---
