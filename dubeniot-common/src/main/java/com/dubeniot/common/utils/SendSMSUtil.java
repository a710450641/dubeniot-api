package com.dubeniot.common.utils;
import java.util.HashMap;
import java.util.Set;

public class SendSMSUtil {
	//手机号码
	private String phone;
	//验证码
	private String validatecode;
	//服务器模式 0：为调试 1:为上线
	private int type=1;
	//初始化主账号
	private String ACCOUNT_SID="8a216da85982d9da015985ff4a8a007f";
	//主账号令牌
	private String AUTH_TOKEN="cf91bc012a5b4264860237d5664fcf00";
	//应用ID
	private String App_ID="8a216da85982d9da015985ff4b410083";
	//短信模板ID
	private String TEMPLATE_ID="148686";
	
	/**
	 * 
	 * @param phone 手机号码
	 * @param validatecode 验证码
	 */
	public SendSMSUtil(String phone, String validatecode) {
		this.phone = phone;
		this.validatecode = validatecode;
	}
	public Object Send(){
		HashMap<String, Object> result = null;
		//初始化SDK
		//CCPRestSmsSDK sb_restAPI = new CCPRestSmsSDK();
		 CCPRestSDK restAPI = new CCPRestSDK();
		//初始化服务器地址和端口   
		if(type==0){
			//restAPI.init("sandboxapp.cloopen.com", "8883");
		}else if(type==1){
			restAPI.init("app.cloopen.com", "8883");
		}
		//初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN
		restAPI.setAccount(ACCOUNT_SID,AUTH_TOKEN);
		//*初始化应用ID  
		restAPI.setAppId(App_ID);
		// 5 五分钟内有效
		result = restAPI.sendTemplateSMS(phone,TEMPLATE_ID ,new String[]{validatecode,"5"});
		System.out.println("SDKTestGetSubAccounts result=" + result);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
//			@SuppressWarnings("unchecked")
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}
		return result.get("statusCode");
	}
}