# Skill Forge(Still in progress)

Skill Forge is a skill-based service marketplace where users can create, browse, buy, and sell services, leave reviews, and get notifications.  
The platform follows a layered architecture with clear separation between UI, controllers, services, repositories, and database.

---

## 📌 Entities & Services

| **Entity**     | **Service**              | **Controller**               |
|----------------|--------------------------|-------------------------------|
| User           | `UserService`            | `UserController`              |
| Skill          | `SkillService`           | `SkillController`             |
| Gig            | `GigService`             | `GigController`               |
| Order          | `OrderService`           | `OrderController`             |
| Review         | `ReviewService`          | `ReviewController`            |
| Notification   | `NotificationService`    | `NotificationController`      |

---

## 🔄 High-Level Flow

### **1. Authentication**
- **GET** `/register` → Display registration form  
- **POST** `/register` → `UserController` → `UserService` → DB (Add user) → Redirect to `home.html`
- **GET** `/login` → Display login form  
- **POST** `/login` → `UserController` → Validate credentials → Redirect to `home.html`

---

### **2. From Home Page (Post-Login)**

#### **Profile**
- `/profile` → View / Update profile

#### **Skills**
- `/skills` → Browse / Add / Edit skills via `SkillController`

#### **Buy Service**
- `/gigs` → Browse gigs via `GigController`
- `/orders` → Place order

#### **Sell Service**
- `/gigs/add` → Create gig via `GigController`

#### **Search Skill**
- `/skills/search?query=...`

#### **Notifications**
- `/notifications` → View notifications via `NotificationController`

#### **Reviews**
- `/reviews` → View / Add reviews via `ReviewController`

---
