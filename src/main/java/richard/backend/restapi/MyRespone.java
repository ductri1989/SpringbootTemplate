package richard.backend.restapi;

public class MyRespone {
	public static final String STATUS_Success		= "Success";
	public static final String STATUS_Suspend		= "Suspend";
	public static final String STATUS_TokenError	= "Token_Error";
	public static final String STATUS_TokenTimeout	= "Token_Timeout";
	public static final String STATUS_OutOfService = "Out_Of_Service";
	public static final String STATUS_BadRequest = "Bad request";
	public static final String STATUS_Unauthorized = "Unauthorized";
	public static final String STATUS_Forbidden	= "Forbidden";
	public static final String STATUS_NotFound	= "Not found";
	public static final String STATUS_DatabaseError = "Database error";
	public static final String STATUS_DatabaseConnectionError = "Database Connection error";
	public static final String STATUS_InternalServerError = "Internal Server Error";
	public static final String STATUS_Existed	= "Existed";
	public static final String STATUS_Exception	= "Exception";
	public static final String STATUS_Repeated	= "Repeated";
	public static final String STATUS_Warning	= "Warning";
	public static final String STATUS_Invalid	= "Invalid";

	public String status;
	public String message;
	public Object data;

	public MyRespone() {
		
	}
	public MyRespone(String _status) {
		status=_status;
		message = null;
		data=null;
	}
	
	public MyRespone(String _status, String _message) {
		status=_status;
		message = _message;
		data=null;
	}
	
	public MyRespone(String _status, String _message, Object _data) {
		status=_status;
		message = _message;
		data=_data;
	}
	
	public MyRespone setStatus(String _status) {
		status=_status;
		return this;
	}
	public MyRespone setMessage(String _message) {
		message=_message;
		return this;
	}
	public MyRespone setData(Object _data) {
		data=_data;
		return this;
	}

}
