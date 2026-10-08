# Stage 1: Build ứng dụng Java bằng Maven
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /app

# Copy pom.xml và tải dependencies trước (để tận dụng Docker Cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy toàn bộ mã nguồn và đóng gói thành file JAR (bỏ qua Test để build nhanh)
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Môi trường thực thi lightweight (JRE Alpine)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy file JAR đã được build từ Stage 1
COPY --from=builder /app/target/*.jar app.jar

# Mở cổng 8080 cho container
EXPOSE 8080

# Lệnh khởi chạy ứng dụng khi container khởi động
ENTRYPOINT ["java", "-jar", "app.jar"]