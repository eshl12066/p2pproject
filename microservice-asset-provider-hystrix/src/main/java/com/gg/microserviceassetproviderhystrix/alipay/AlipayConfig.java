package com.gg.microserviceassetproviderhystrix.alipay;

import java.io.FileWriter;
import java.io.IOException;



public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2088102179577342";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCDNexacziUrfoYlAHT7y1pJCdfuVkFrGMdGdK5D0SgvbrcnSVaLDVEDdD4ilmNEdQh4FqvF8Z+x0sGvm6bZnHLsdxZCJgcktAlxTXi+VbMSu7YRhafC2Ef0B99aZCWcv8jkYGQymv53VDJMul+gR1exaMCh4wBzGGBrN4BI96V+8CW0KEBYLusWvlo4axyUEN6lBW3e8iuJ7vGLH8My18tmZSuEZPOLCQVxN9u6Viw00IWcD7lF2jkjX/P0buS4uu4EcDiDpfwjd5tZukjRmfXlw1IZ1MSjZGL0U8OF8IxifMp2c94/pr9WLDM5inLhWmI2k4aQF0iuFz8pndB0yW9AgMBAAECggEAEkyO7f5rwbCR1KOvrZMJzkQQibUbyULFf+V+EfkjJRfQ27u+3diUhS04G7GP07DM2PylKQ4zzLKWsBYW7u1WqYXgqTodnL6M8PeUEFed11gL/3Wm6f94SCuKeL8kPxdCpf9BBqR0cqB/B9Bl6BKxuenuVgf5arbKUn99ZsNN47TJbz3iGI+sH98IXbILIWeX78LIAb2s5e3u5Y3ZCQo8zj0aprhh9hqpE+lcq+ETfvn53jces1i1/SMTehI6iQ9HhqZcja+rDYG04WT+ksMY5wRKbaM8tn2vSblYK1CMbkLv7uLllfsEDpXLjzLc7jRoi55YCensZk2RKP5UZkRFAQKBgQDB8+jkstKEinEvHhXEMxE7g0fo92pZ5pGUwBqZ6hmNTpdkp/YXpQ9CnAbQ17RSVRoVmpCNrnHFiE4ZUbtzQDtavnz4yplTN1gteOSGvDrK+PUaINxHZ1HwkCnOgIZXgiZwwvrumiZDNnqeYMHWAbeRZs2qZ6dKJ2rFbO2wGmNMMQKBgQCtL6Pqu6DLQWsvGnEivqpvZHSgPmV/QoWMUVYp9MfWyY5uNU0Y8KE3jvXyNgYZg8pnTAHWVwqoA5kfis+u94TuW6vFZsXNCYR/PJt7K0iuZmK4uu9ARuT51+W9l/eZjJBDDQ0iuPXc8Q2DxiZzzOdPrHGXs+MtMQZaUY6AcXkrTQKBgEwaG3DZJbcx5zVYtau1afaTDX1Az28VBFx8gDOSYpJKmya4rNwcPP+i3x3E9ZE0qTZ+3mdpYmTildpjcozHUELL6ZdpT34SgjvdarXfV6ZaxzmIWUZ/KOyedHj9fzkI7XJjXziOLaND1hsc1hHVvKSF1P8fCsoS61cp5Z2qzPmRAoGAdIuVzJZde8rXXYh20EHtIi9BCMFUvlI+2xG1YWC3xwQ2lFXMP1dXtrK/MjNG4Y69+8u7hMlog26AciiQ4JbzXxBTxPEHdZbNEm7v1vBm5e5CyzwJW4EaAERY98C3wB5GysiSqWY9FmUliiMjp1Qh6Y0LmGJXJAdU1h0CP8+dEhUCgYAcU5DUYXYmIgrpjl+BqGPcCmH3EQIVcDMd7Haoa3XwaWBvPZQLk6HB5jxkSHemOhz2lag9FaEYLrBxmFDtaeTqat5HZFwhGPsLK5zz/XDf7BqJt0q6M5vuna7OFCWO4gM7rdgc3wWwEHp9/PZvuWmaUnIfhmZFmkvuDpOy47ny7Q==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjIddPshCieKlm68xfkm614WuD7qEKNqv13xkIbhGcGBfI+txRDnPFa65BJiLdeUKEaSNBAVu1Ewhg+g6+ShaCJd/idDEELFSprFPzvchd5cvty41LY+iPd0ju7IfUaF8MlxS9G0y0NRSJZhM+ICdrD+MN0/QimP3Wo1F3x9H2FckSOeV0bdjazhd/aJxryJiwVakQ8Awz0PZWh39t30ImEt3W8qkL7QVHj8U//0YohoGEzuXgVEWfMpko5Q7oZejR6UzXxJihoB+CWkjf2cXIiU/DdxVs0qEt07ZYncfxGXsBzrnGQ8g+DMS/X1N0kpTNfnTFekagDHaXFmbxGYpVwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String notify_url = "http://localhost:8080/Alipay/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	/*vue路径*/
    public static String notify_url = "http://localhost:1006/src/main/webapp/jsp/notify_url.jsp";
    //H:\ideaProject\git\p2pproject\microservice-asset-provider-hystrix\src\main\webapp\WEB-INF\jsp\notify_url.jsp

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:1006/p2pProject/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:\\";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

