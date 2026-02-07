# 🚗 NeuroFleetX – Smart Fleet & Ride Management System

NeuroFleetX is a full-stack fleet and ride management web application designed to simulate real-world urban mobility systems.  
It supports **multiple user roles**, **ride booking**, **driver routing**, and **fleet health monitoring**.

---

## ✨ Features

### 👤 User Roles
- **Customer** – Book rides and view fare details
- **Driver** – Accept rides and view route on map
- **Admin / Fleet Manager** – Manage vehicles and monitor health

---

### 🚕 Ride Booking
- Pickup & drop location input
- Vehicle type selection
- Automatic fare calculation
- Booking status lifecycle:
  - `PENDING → ONGOING → COMPLETED`

---

### 🗺 Route Visualization
- Interactive map using **Leaflet**
- Pickup & drop markers
- Route line between locations
- Driver can end ride from map view

---

### 🚘 Fleet Dashboard (Admin)
- Add vehicles
- View battery, fuel, engine wear
- Health calculation (Healthy / Due / Critical)
- Local storage–based persistence

---

### ❤️ Vehicle Health Monitoring
- Health score calculation
- Status indicators
- Maintenance overview

---

## 🛠 Tech Stack

### Frontend
- React
- React Router
- Axios
- Leaflet Maps
- CSS

### Backend
- Spring Boot
- REST APIs
- Spring Security (Basic setup)
- Gradle
- H2 / Local storage (for demo)

---

## 🔐 Authentication
- Login & Registration
- Role-based navigation
- Protected routes

---
## 📂 Project Structure

