# Backend Server
Backend là tất cả những phần hỗ trợ hoạt động của game,ứng dụng hoặc website mà người dùng không thể nhìn thấy được. Backend bao gồm :
- Máy chủ vật lý
- Database
- Ứng dụng server (Server core)

## Các công nghệ xây dựng Backend 
- Java
- C#
- NodeJS
- Python
- Golang
- Ruby
- Rust
- PHP

(sắp xếp theo số lượng tin tuyển dụng trên các trang việc làm)



Bài biết này sử dụng ngôn ngữ `java` phiên bản `1.8` dùng Framework `Springboot` và  lấy `swagger` làm document
(Kiểm tra phiên bản java đã cài trong máy : java -version)

## Setup môi trường lập trình
 - Cài đặt [Java Jdk](https://www.oracle.com/ph/java/technologies/downloads/) : roll xuống chọn Java 8 (Bản ổn định nhất trước khi Microsoft mua lại → các thế hệ 8x,9x thường dùng)
 - IDE : có nhiều ide để lập trình java
	- [Eclipse](https://www.eclipse.org/downloads/) : tác giả quen sử dụng ide này
	- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
	- ...

## Tạo project `Springboot` cơ bản : [spring.io](https://start.spring.io/) → `Projects` → `Spring Initializr`
(mục đích : cần file pom.xml chuẩn để lấy `dependency`)
 - `Project` : Maven
 - `Language` : Java
 - `Java` : 8 (Bản ổn định nhất trước khi Microsoft mua lại → các thế hệ 8x,9x thường dùng)
 - `Dependencies` : chọn `Spring Web Services` để dùng cho RestAPI

## Đưa project vào Eclipse
(Chú ý thanh loading ở góc phải dưới của Eclipse load lần đầu của thư viện khá lâu)
 - Cách 1 : `File` → `Import` → `Maven` → `Existing Maven Projects` : Browse đến thư mục springboot đã tạo từ web
 - Cách 2 : `File` → `New` → `Maven project` → check `Create a simple project (skip archetype selection)`
	- Group Id : Tên tổ chức / công ty / cá nhân của dự án
	- Artifact Id : Tên của packge, dự án
	- Sau khi tạo project thì copy 3 phần này trong file pom đã tải từ trang chủ `Springboot`
```sh
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.3</version>
		<relativePath/>
	</parent>


	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web-services</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
```

## Phát triển dự án `Springboot`
#### Step 1 : Tạo `package` : pkChuaApi
#### Step 2 : Tạo `Class` : MyServer
```sh
@SpringBootApplication
public class MyServer {

	public static void main(String[] args) {
		SpringApplication.run(MyServer.class, args);
	}

}
```
 - `@SpringBootApplication` : đánh dấu đây là server + các api sẽ nằm trong `package` chứa `Class` MyServer
 - `SpringApplication.run` : Star server
#### Step 3 : viết api cho Server










## Cách hiểu đơn giản về springboot

- `Class Server`
    - `@SpringBootApplication` : đánh dấu server bắt đầu từ `package name` này, tất cả các `Controller` nằm trong `package name` này sẽ chạy bởi server này
    - `SpringApplication.run` : Star server
- Các `Controller` của `Server` này phải là con của package `Class Server`
    - `@RestController` : đánh dấu đây là Rest api
    - `@RequestMapping(path = "/api")` : khai báo path đầu của controller
    - `@PostMapping(value = "aaaa", produces = MediaType.APPLICATION_JSON_VALUE)` : đánh dấu giao thức POST cho bất kỳ method
        - value = "aaaa" : kết hợp với path đầu của controller sẽ ra url của API (/api/aaaa)
        - produces = MediaType.APPLICATION_JSON_VALUE : sử dụng giao thức post với cấu trúc là Json
        - `@RequestBody CLASS` : các properties trong `CLASS` trở thành params của API
        - Giá trị trả về của method : tự chuyển thành Json của giao thức `POST`
```sh
@SpringBootApplication
public class RichardTemplateApplication {
	public static void main(String[] args) {
		SpringApplication.run(RichardTemplateApplication.class, args);
	}
}

@RestController
@RequestMapping(path = "/api")
public class ControllerF {
	@PostMapping(value = "aaaa", produces = MediaType.APPLICATION_JSON_VALUE)
	public MyRespone login(@RequestBody Service001_AAA service) {
		return service.respone();
	}
}
```










## Cách viết document cho `springboot`


```sh
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>
```


