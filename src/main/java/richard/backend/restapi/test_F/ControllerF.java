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

	@ApiOperation("Đăng nhập Device")
	@PostMapping(value = "aaaa", produces = MediaType.APPLICATION_JSON_VALUE)
	public MyRespone login(@Valid @RequestBody Service001_AAA service) {
		return service.respone();
	}
	
	
}
