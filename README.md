# Pet Service API 🐾

This repository contains a **technical job assignment** developed as part of a hiring process.

---

## 🕒 Project Context

The assignment was intended to be a **2–3 hour project**.  
- The **main structure** took around **3 hours**.  
- I later added about **30 minutes** for **integration testing** (I got temporarily stuck with some configuration issues).

---

## 🧱 Architecture & Design

I aimed to build **clean, well-structured code** within the limited timeframe.  
Given the simplicity of the exercise, I opted for a **fully layered architecture** (Controller → Application → Domain → Infrastructure), taking inspiration from **DDD principles** but avoiding unnecessary boilerplate or "anemic" use case classes that felt excessive for this scope.

My goal was to deliver:
- Readable and maintainable code.
- A clear separation of concerns.
- A practical demonstration of how I apply **DDD** and **TDD** principles under time constraints.

I believe the final result achieves that balance — **concise, functional, and conceptually sound**.

---

## ⚠️ Notes & Lessons Learned

The only part I really disliked (and slightly regret) was the **mocking of JPA repositories**, which was “recommended” in the assignment instructions.  
In hindsight, setting up a lightweight **H2 in-memory database** would have been far easier and more natural than dealing with mock complexity and related issues.

---

## 🧪 Testing

An integration test suite is included.  
Additionally, a **Bruno collection** is available under the `resources` folder for quick manual testing of endpoints.

---

## 🚀 How to Run

Make sure you have **Java 17+** and **Maven** installed.

```bash
mvn clean install
mvn spring-boot:run
```

Then, open [http://localhost:8080](http://localhost:8080) and use the Bruno collection to test the API.

---

## ✅ Summary

- ⏱ Duration: ~3.5 hours total  
- 🧠 Approach: Layered Architecture + Light DDD  
- 🧰 Tech Stack: Java 17, Spring Boot, JPA, JUnit 5, Mockito  
- 🧪 Tests: Unit & Integration (with MockMvc)

---

_Thanks for reviewing this project!_
