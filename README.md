🛒 MiniBay – Hybrid E-commerce Recommendation Engine (Java)

📌 Overview:

MiniBay is a console-based e-commerce application that demonstrates how real online stores (Amazon, eBay, Flipkart) recommend products to users.
The system generates personalized product recommendations using a Hybrid Recommendation Engine implemented in Java with MySQL.

🎯 Features:

Product catalog simulation
User interaction tracking
Personalized recommendations
Cold-start problem handling
Hybrid AI recommendation strategy
Console-based e-commerce flow (MiniBay)

🧠 Recommendation Algorithms:

The system automatically selects the best algorithm depending on the user’s activity.

Scenario	                       Algorithm Used
🆕 New user (no history)	      Popularity-Based
👤 Low activity user	          Content-Based Filtering
🛍️ Active user	                   Collaborative Filtering

1️⃣ Collaborative Filtering-

Finds users with similar behavior using Cosine Similarity and recommends products they liked.

Example:
Users who bought a Gaming Mouse also bought a Smart Watch → recommend Smart Watch.

2️⃣ Content-Based Filtering-

Recommends products similar to what the user already likes using product categories.

Example:
User buys Electronics → recommend more Electronics.

3️⃣ Popularity-Based Recommendations-

Fallback method for brand-new users.
Recommends the most purchased products overall.

🏗️ System Architecture
MySQL Database
      ↓
Data Loader (JDBC)
      ↓
User-Item Matrix Builder
      ↓
Hybrid Recommendation Engine
      ↓
MiniBay Console Application

🗄️ Database Schema:

Tables
users
products
user_interactions

User interactions build the User-Item Matrix used for recommendations.

💻 Tech Stack:

Java (JDK 21)
MySQL
JDBC
VS Code

▶️ How to Run:

1️⃣ Create Database-
CREATE DATABASE ecommerce_db;

Run the SQL scripts to create tables and insert sample data.

2️⃣ Compile Project-
javac -cp "lib/*" src/models/*.java src/database/*.java src/recommender/*.java src/*.java

3️⃣ Run Application-
java -cp "lib/*;src" Main

🧪 Demo Users:
User ID	Purpose
6	New user → Popularity
5	Low activity → Content-based
1	Active user → Collaborative

🎮 Demo Flow:

===== MiniBay =====
1. View All Products
2. Get Recommendations
3. Exit

Enter a user ID to see personalized recommendations.

📈 Learning Outcomes:

Recommendation system design
Collaborative filtering implementation
Cosine similarity computation
Hybrid recommendation strategy
Java + MySQL integration

👨‍💻 Author:

B.Tech Computer Science Project – Recommendation Systems