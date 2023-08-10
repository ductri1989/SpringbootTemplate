package richard.backend.restapi.test_F;

import java.util.Random;
import java.util.UUID;

import richard.backend.restapi.BaseService;
import richard.backend.restapi.MyRespone;
import richard.backend.restapi.dto.DTO_AAA;

public class Service_Login extends BaseService {
	public String username;
	public transient String password;
	public int countryCode;
	
	
	@Override
	protected MyRespone respone() {
		
		
		System.out.println("username : "+username);
		System.out.println("password : "+password);
		System.out.println("countryCode : "+countryCode);
		
		DTO_AAA aaa = new DTO_AAA();
		aaa.abc = UUID.randomUUID().toString();
		aaa.xyz = new Random().nextLong();
		return new MyRespone(MyRespone.STATUS_Success).setData(aaa);
	}

}
