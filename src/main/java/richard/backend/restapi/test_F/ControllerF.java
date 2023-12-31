package richard.backend.restapi.test_F;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import richard.backend.restapi.MyRespone;

@RestController
@RequestMapping(path = "/api")
public class ControllerF {

	@ApiOperation("Đây là title hiển thị trên Swagger")
	@PostMapping(value = "aaaa", produces = MediaType.APPLICATION_JSON_VALUE)
	public MyRespone login(@Valid @RequestBody Service001_AAA service) {
		return service.respone();
	}
	
	
	@ApiOperation("Đây là title hiển thị trên Swagger")
	@PostMapping(value = "bbb", produces = MediaType.APPLICATION_JSON_VALUE)
	public MyRespone login(@Valid @RequestBody Service_Login service) {
		return service.respone();
	}
	
	
}
