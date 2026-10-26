# OrangeHRM Test Automation Project

This repository contains an end-to-end automated test suite for the **OrangeHRM** application built using **Selenium WebDriver**, **Java**, and **TestNG** inside a Maven project.

---

## 🛠 Tech Stack & Tools

- **Language:** Java (JavaSE-1.8)
- **Automation Framework:** Selenium WebDriver
- **Test Runner:** TestNG
- **Build Tool:** Apache Maven
- **IDE:** Eclipse IDE

---

## 📁 Project Structure

```text
OrangeHRM/
├── src/main/java/
│   └── BaseClass.java                    # Base setup, driver initialization, and teardown
├── src/test/java/
│   ├── AdminAddUserTest.java             # Test for creating a new user in Admin module
│   ├── AdminSearch.java                  # Test for searching users in Admin module
│   ├── LeaveListFilterTest.java          # Test for filtering records in Leave module
│   ├── RecruitmentAddCandidateTest.java  # Test for adding a new candidate
│   ├── RecruitmentCandidatesTest.java    # Test for candidate management/search
│   └── Time.java                         # Test scenarios for Time module
├── resume_sample.txt                     # Test data file used for file upload tests
├── Batch.xml                             # TestNG suite XML file for batch execution
└── pom.xml                               # Maven project dependencies and configurations
