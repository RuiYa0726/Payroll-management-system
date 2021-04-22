package servlets;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import beans.*;

public class Sign extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	doPost(request,response);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
response.setContentType("text/html");
PrintWriter out=response.getWriter();

HttpSession session=request.getSession(true);
String Sign = request.getParameter("Sign");   

try {
String src = Sign; 
//����һ����Կ  
KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");  //��ȡ��Կ������ʵ��  
keyPairGenerator.initialize(512);  // ��ʼ������  
KeyPair keyPair = keyPairGenerator.generateKeyPair();    
RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();//���ɹ�Կ  
RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();  // ����˽Կ  
  
//��˽Կ����ǩ��  
PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());  //˽Կת����pkcs8��ʽ  
KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec); // ��key������������˽Կ  
Signature signature = Signature.getInstance("MD5withRSA");  //  md5 RSAǩ������  
signature.initSign(privateKey);  //��ʼ��ǩ��  
signature.update(src.getBytes());  
byte[] result = signature.sign();  //����Ϣ����ǩ��  
X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());  
PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);  
signature.initVerify(publicKey);
String PK=publicKey.toString();
System.out.println(PK);
int len=PK.length();
System.out.println(len);
String str0=PK.substring(0,44);
System.out.println(str0);
session.setAttribute("str0",str0);
String str1=PK.substring(45,89);
System.out.println(str1);
session.setAttribute("str1",str1);
String str2=PK.substring(90,134);
System.out.println(str2);
session.setAttribute("str2",str2);
String str3=PK.substring(135,179);
System.out.println(str3);
session.setAttribute("str3",str3);
String str4=PK.substring(180,219);
System.out.println(str4);
session.setAttribute("str4",str4);
session.setAttribute("result",result);
response.sendRedirect("Signout.jsp");
}catch(Exception e) {
	e.printStackTrace();
}

out.flush();
out.close();
}


}


