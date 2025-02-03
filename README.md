# 🏁 Racing Results Formatter

---

## 🧩 Project Description
This project reads and processes racing data from input files,
formats it, and outputs a structured table displaying racer statistics.
The system handles input parsing, model building, and table generation.
---

## 🚀 Features

- Reads racer abbreviations, start times, and end times from input files.

- Calculates and formats race results.

- Generates a structured output table.

- Implements unit tests with JUnit and Mockito.

---

## 🧰 Tech stack used in this project
- **Java 21** 
- **JUnit 5** (Testing framework)
- **Mockit** (Mocking framework for unit tests)
- **Maven** (Build and dependency management tool)

---

## 🔑 Key Features
- **Modular Structure:** Well-defined service and model layers.
- **File-Based Input Handling:** Reads data from structured text files.
- **Flexible Table Formatting:** Supports customizable table output.
- **Unit Tests:** Ensures reliability with JUnit and Mockito.


---

## 📂 Project Structure
```
src
├── main
│   ├── java
│   │   └── org.moldavets
│   │       ├── mapper         // Mapping utilities
│   │       ├── model          // Domain model classes
│   │       │   ├── input      // Input-related model classes
│   │       │   └── table      // Table formatting model classes
│   │       ├── service        // Core service interfaces
│   │       │   └── impl       // Implementations of service interfaces
│   │       ├── utils          // Utility classes
│   │       └── Main.java      // Application entry point
│   └── resources
│       └── data               // Input files (abbreviations, start times, end times)
│           ├── abbreviations.txt
│           ├── start.log
│           └── end.log
└── test
    └── java
        └── org.moldavets
            ├── mapper         // Tests for mapping utilities
            ├── service        // Tests for service layer
            │   └── impl       // Tests for service implementations
            └── utils          // Tests for utility classes
```
---

## ⚙️ Installation and Setup

**1. Clone the Repository**
```
git clone https://github.com/BohdanMoldavets/RaceProject.git
cd RaceProject
```

**2. Install Dependencies**

```
cd RaceProject
mvn clean install
```

**3. Start the Application**

---

## 🛑 FAQ
### Q: How do I modify the input files?
 + **A:** Update the files in the ```src/main/resources/data``` directory with new racer data.
### Q: How can I run tests?
+ **A:** Execute the following command:
```
mvn test
```
---
# Contact
+ Email: [steamdlmb@gmail.com](mailto:steamdlmb@gmail.com)
+ [Telegram](https://telegram.me/moldavets)
+ [Linkedin](https://www.linkedin.com/in/bohdan-moldavets/)


