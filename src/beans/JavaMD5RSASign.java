﻿package beans;

import java.security.KeyFactory;  
import java.security.KeyPair;  
import java.security.KeyPairGenerator;  
import java.security.PrivateKey;  
import java.security.PublicKey;  
import java.security.Signature;  
import java.security.interfaces.RSAPrivateKey;  
import java.security.interfaces.RSAPublicKey;  
import java.security.spec.PKCS8EncodedKeySpec;  
import java.security.spec.X509EncodedKeySpec;


public class JavaMD5RSASign {
	private static String src = "i look";  
    
    public static void main(String[] args) {  
        MD5RSASign();  
    }     
    public static void MD5RSASign(){  
          
        try {  
              
            // 生成一对密钥  
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");  //获取密钥生成器实例  
            keyPairGenerator.initialize(512);  // 初始化长度  
            KeyPair keyPair = keyPairGenerator.generateKeyPair();    
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();//生成公钥  
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();  // 生成私钥  
              
            //用私钥进行签名  
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());  //私钥转换成pkcs8格式  
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec); // 用key工厂对象生成私钥  
            Signature signature = Signature.getInstance("MD5withRSA");  //  md5 RSA签名对象  
            signature.initSign(privateKey);  //初始化签名  
            signature.update(src.getBytes());  
            byte[] result = signature.sign();  //对消息进行签名  
            System.out.println("签名结果："+result);  
              
//              
//            //用公钥进行验证  
//            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());  
//            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);  
//            signature.initVerify(publicKey);  
//            signature.update(src.getBytes());  
//            boolean verify = signature.verify(result);  
//            System.out.println("验证结果:"+verify);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }

}
