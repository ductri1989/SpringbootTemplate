package richard.backend.restapi.test_F;

import richard.backend.restapi.BaseService;
import richard.backend.restapi.MyRespone;

public class Service001_AAA extends BaseService{

	
	public String aaaa;
	public int bbb;
	
	@Override
	protected MyRespone respone() {
		return new MyRespone(MyRespone.STATUS_Success,"12123213213");
	}

}
