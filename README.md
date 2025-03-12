# Stock Market Data Analysis

## 📌 Introduction

This project focuses on analyzing stock market data using Java and data structures. It implements various algorithms to process, analyze, and extract insights from historical stock price data stored in CSV files. The project demonstrates key concepts of **file handling, data structures, and algorithm implementation** in Java.

## 📊 Dataset Overview

The dataset consists of historical stock data for various companies, stored in CSV files. Each file contains:

- **Date**: The trading date.
- **Open**: Opening price of the stock.
- **High**: Highest price reached during the day.
- **Low**: Lowest price reached during the day.
- **Close**: Closing price of the stock.
- **Volume**: Number of shares traded on that day.

### Sample Data (Google - GOOGL)

| Date       | Open | High | Low  | Close | Volume    |
|------------|------|------|------|-------|-----------|
| 2004-08-19 | 2.50 | 2.60 | 2.40 | 2.51  | 893181924 |
| 2004-08-20 | 2.53 | 2.73 | 2.52 | 2.71  | 456686856 |
| 2004-08-23 | 2.77 | 2.84 | 2.73 | 2.74  | 365122512 |
| 2004-08-24 | 2.78 | 2.79 | 2.59 | 2.62  | 304946748 |

## 🏗️ Project Structure

```
Analyzing-Stock-Data/
│── src/                    # Source code for data analysis
│   │── Main.java            # Main entry point of the program
│   │── FileManager.java     # Handles file reading and data extraction
│   │── Stock.java           # Represents stock data with attributes
│   │── StockAnalyzer.java   # Contains data analysis methods
│   │── SortingAlgorithms.java # Implements sorting techniques (e.g., QuickSort, MergeSort)
│── datasets/               # Folder containing stock data CSV files
│── .idea/                  # Project configuration files (for IntelliJ IDEA)
│── .gitignore              # Files to ignore in version control
│── README.md               # Project documentation (this file)
│── LICENSE                 # Project licensing information
│── project.iml             # IntelliJ IDEA project module file
```

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed:
- **Java Development Kit (JDK 8 or higher)**
- **An Integrated Development Environment (IDE) such as IntelliJ IDEA**

### Installation & Usage

1. **Clone the repository:**
   ```bash
   git clone https://github.com/KFMBB/Analyzing-Stock-Data.git
   ```

2. **Navigate to the project directory:**
   ```bash
   cd Analyzing-Stock-Data
   ```

3. **Open the project in IntelliJ IDEA** (or any preferred Java IDE).

4. **Ensure all dependencies are set up correctly.**

5. **Run the `Main.java` file** to start the analysis.

## 🛠️ Features & Functionality

### 📂 File Handling
- Reads and extracts stock data from CSV files using `FileManager.java`.

### 📈 Stock Data Representation
- The `Stock.java` class models stock attributes (date, open, close, high, low, volume) and provides structured data handling.

### 📊 Stock Analysis
- `StockAnalyzer.java` contains methods to calculate:
  - Highest and lowest stock prices
  - Average stock price over a period
  - Stock price trends

### 🔍 Sorting & Searching Algorithms
- `SortingAlgorithms.java` implements various sorting methods for stock data:
  - **QuickSort**: Efficient sorting for large datasets.
  - **MergeSort**: Stable sorting method with predictable time complexity.
  - **Bubble Sort (for small datasets)**: Demonstrates basic sorting concepts.

### 🔎 Searching Algorithms
- Implements **binary search** and **linear search** for retrieving stock data efficiently.

### 📊 Graphical Data Representation
- Implementing visualization features using JavaFX or external libraries to graph trends.

## 🤝 Contributing

Contributions are welcome! If you'd like to contribute:
- Fork the repository
- Create a new branch (`git checkout -b feature-branch`)
- Commit your changes (`git commit -m 'Added new feature'`)
- Push to the branch (`git push origin feature-branch`)
- Open a Pull Request

## 🙌 Acknowledgments

A special thanks to contributors and the open-source community for their continuous support!

