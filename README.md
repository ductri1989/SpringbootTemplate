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

Bài biết này sử dụng ngôn ngữ `java` dùng Framework `Springboot`và  lấy `swagger` làm document
##### Cách hiểu đơn giản về springboot
- `Class Server`
    - Đánh dấu đây là server : `@SpringBootApplication`
    - Star server : `SpringApplication.run(RichardTemplateApplication.class, args);`
- Các API phải là con của package `Class Server` (xem class : ControllerF)
    - `@RestController` : đánh dấu đây là Rest api
    - `@RequestMapping(path = "/api")` : khai báo path đầu của controller
    - `@PostMapping(value = "aaaa", produces = MediaType.APPLICATION_JSON_VALUE)` : đánh dấu giao thức POST cho bất kỳ method
        - value = "aaaa" : kết hợp với path đầu của controller sẽ ra url của API
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
```
```sh
@RestController
@RequestMapping(path = "/api")
public class ControllerF {
	@PostMapping(value = "aaaa", produces = MediaType.APPLICATION_JSON_VALUE)
	public MyRespone login(@RequestBody Service001_AAA service) {
		return service.respone();
	}
}
```
