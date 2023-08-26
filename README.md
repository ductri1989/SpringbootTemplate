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
 - `@SpringBootApplication` : đánh dấu đây là server + các api sẽ nằm trong `package` chứa `Class` MyServer
 - `SpringApplication.run` : Star server
```sh
@SpringBootApplication
public class MyServer {

	public static void main(String[] args) {
		SpringApplication.run(MyServer.class, args);
	}

}
```
#### Step 3 : viết api cho Server
 - Tạo `package` : `pkChuaApi.rest` (api luôn luôn là con của `pkChuaApi`)
 - Tạo `Class` : MyController 
    - `@RestController` : đánh dấu đây là Rest api
    - `@RequestMapping(path = "/api")` : khai báo path đầu của controller
    - `@GetMapping(value = "get")` : đánh dấu giao thức GET (Test với trình duyệt [url](http://localhost:8080/api/get) )
    - `@PostMapping(value = "post2", produces = MediaType.APPLICATION_JSON_VALUE)` : đánh dấu giao thức POST cho bất kỳ method (Test với [Post Man](https://www.postman.com/downloads/))
        - value = "post2" : kết hợp với path đầu của controller sẽ ra url của API (/api/post2)
        - produces = MediaType.APPLICATION_JSON_VALUE : sử dụng giao thức post với cấu trúc là Json
        - `@RequestBody Service1` : các properties trong `Service1` trở thành params của API
        - Giá trị trả về của method : tự chuyển thành Json của giao thức `POST`
```sh
@RestController
@RequestMapping(path = "/api")
public class MyController {

	@GetMapping(value = "get")
	public String demoGet() {
		return "aaaaaaa";
	}
	
	@PostMapping(value = "post1")
	public MyData demoPost1() {
		return new MyData("Richard",(byte) 1,34);
	}
	
	@PostMapping(value = "post2", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object demoPost2(@RequestBody Service1 service) {
		return service.respone();
	}
}
```
```sh
public class MyData {
	public String name;
	protected int age;
	private byte sex;
	
	public MyData(String _name,byte _sex,int _age) {
		name=_name;
		sex=_sex;
		age=_age;
	}
}
```
```sh
public class Service1 {
	public String name;
	public byte sex;
	public int age;
	
	public Object respone() {
		return new MyData(name, sex, age);
	}
	
}
```

Test với `Post Man` (Start server trước khi test)
 - Đổi giao thức `GET` sang `POST`
 - Điền URL : http://localhost:8080/api/post2
 - `Body` → `raw` → đổi `Text` thành `JSON`
```sh
{
    "name": "aaaaa",
    "sex": 1,
    "age": 400
}
```








## Sử dụng document cho `springboot`
(bài viết này sử dụng `springboot 2.5.14` + `swagger 2.9.2`)
#### Step 1 : lựa chọn phiên bản phù hợp giữa `springboot` và `swagger` 
#### Step 2 : Thêm `swagger` vào dự án :
 - Khai báo sử dụng thư viện `swagger` trong file pom.xml
 - Tạo class Config : `Swagger2Config`
 - Thêm mô tả cho document `@ApiOperation("Đây là title hiển thị trên Swagger")` phía trên `@PostMapping`

```sh
@Component
@Configuration
@EnableSwagger2
public class Swagger2Config {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}
}
```

```sh
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.14</version>
		<relativePath />
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
#### Step 3 : truy cập [document](http://localhost:8080/swagger-ui.html) sau khi start Server
