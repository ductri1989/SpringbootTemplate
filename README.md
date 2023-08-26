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



Bài biết này sử dụng ngôn ngữ `java` phiên bản `1.8` dùng Framework `Springboot`và  lấy `swagger` làm document
## Cài đặt [Java Jdk](https://www.oracle.com/ph/java/technologies/downloads/)
(roll xuống chọn Java 8 → đây là phiên bản ổn định nhất của Java sau khi Microsoft mua lại. Các thế hệ 8x,9x thường dùng)
 - Cài đặt [Java Jdk](https://www.oracle.com/ph/java/technologies/downloads/)





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

## Tạo project `Springboot` cơ bản : [spring.io](https://start.spring.io/) → `Projects` → `Spring Initializr`
- `Project` : Maven
- `Language` : Java
- `Java` : 8 (Bản ổn định nhất trước khi Microsoft mua lại → các thế hệ 8x,9x thường dùng)
- `Dependencies`
	- Spring Web Services : dùng cho RestAPI
	- Thymeleaf : dùng để hiển thị Front-end HTML
 	- Spring Boot DevTools : tự động chạy lại server mỗi khi sửa code
	- Validation : Dùng cho việc validate param (không null, số dương, chuỗi không rỗng,...)


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


