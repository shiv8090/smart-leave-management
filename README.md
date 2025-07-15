# smart-leave-management
Spring Boot + Thymeleaf based Leave Management System
# 📝 Smart Leave Management System

A Spring Boot + Thymeleaf full-stack web application that allows employees to apply for leaves and lets admins manage those requests. Built following the MVC pattern and layered architecture for clean code and maintainability.

---

## 🚀 Features

✅ Employee Registration and Login  
✅ Role-based Access (Employee & Admin)  
✅ Apply for Casual or Sick Leave  
✅ Admin can Approve or Reject Leaves  
✅ View Applied Leaves with Status  
✅ Input Validation with Error Messages  
✅ Clean Thymeleaf-based HTML UI  
✅ In-memory H2 database (can switch to MySQL easily)

---

## 🧰 Tech Stack

| Layer     | Technology                          |
|-----------|--------------------------------------|
| Backend   | Java 17, Spring Boot, Spring MVC     |
| Frontend  | HTML5, CSS3, Bootstrap, Thymeleaf    |
| Database  | H2 (or MySQL), Spring Data JPA       |
| Tools     | IntelliJ / STS, Maven, Git, GitHub   |

---

## 📂 Project Folder Structure

smart-leave-management/
├── src/main/java/in/ashokit/
│ ├── controller/ --> MVC Controller Classes
│ ├── entity/ --> Entity Classes (Employee, LeaveRequest)
│ ├── repo/ --> Repository Interfaces
│ ├── Lservice/ --> Service Interface and Implementation
│ └── SmartLeaveManagementAppApplication.java
├── src/main/resources/
│ ├── templates/ --> HTML Thymeleaf Files
│ └── application.properties
├── pom.xml
└── README.md

🛠️ How to Run Locally
bash
Copy
Edit
# 1. Clone the repository
git clone https://github.com/yourusername/smart-leave-management.git

# 2. Navigate into the project folder
cd smart-leave-management

# 3. Run the app (make sure Java & Maven are installed)
mvn spring-boot:run
➡ Open your browser and visit: http://localhost:1020/

🙋‍♂️ Author
Shivshankar Patil
📧 Email:patilshiva8975@gmail.com
🔗 LinkedIn Profile :- https://www.linkedin.com/in/shivshankarpatil/
💼 Aspiring Java Developer | Spring Boot Enthusiast
