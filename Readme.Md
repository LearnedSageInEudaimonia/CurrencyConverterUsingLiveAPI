# Java Currency Converter (Live API)

A simple command-line based currency converter built in Java that fetches **live exchange rates** using an API and maintains a history of conversions in a local CSV file.

---

## Features

-  Real-time currency conversion using public API
-  JSON parsing using `org.json`
-  File I/O to store and display conversion history
-  CLI-based input (Java Scanner)
-  Modular structure for clean and maintainable code

---

## Technologies Used

- Java 8+
- Live Exchange Rate API (`https://api.exchangerate-api.com`)
- `org.json` library (for JSON parsing)
- CSV for storing conversion history

---

##  Project Structure

```plaintext
CurrencyConverter/
├── src/
│   ├── Main.java              # Handles CLI interaction and core logic
│   ├── ApiHandler.java        # Fetches live exchange rates via HTTP GET
│   └── HistoryManager.java    # Manages reading/writing to conversion history (CSV)
│
├── history.csv                # Stores conversion history (auto-created on first run)
├── README.md                  # Project documentation
├── pom.xml                    # Using Maven for dependency management
