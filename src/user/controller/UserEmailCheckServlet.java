package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UserEmailCheckServlet
 */
@WebServlet("/ajax/emailCheck")
public class UserEmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEmailCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");
		
		String host = "smtp.gmail.com";
		String user = "pro9735aa@gmail.com";
		String password = "TKfl123*";
		
		Properties props= new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		StringBuffer temp =new StringBuffer();
        Random rnd = new Random();
        for(int i=0;i<10;i++)
        {
            int rIndex = rnd.nextInt(3);
            switch (rIndex) {
            case 0:
                temp.append((char) ((int) (rnd.nextInt(26)) + 97));
                break;
            case 1:
                temp.append((char) ((int) (rnd.nextInt(26)) + 65));
                break;
            case 2:
                temp.append((rnd.nextInt(10)));
                break;
            }
        }
        String userToEmail = temp.toString();
        System.out.println(userToEmail);
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() { protected PasswordAuthentication getPasswordAuthentication() { return new PasswordAuthentication(user, password); } });
        
        
        try {
        	MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(user));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress("pro9735@naver.com"));
			
			msg.setSubject("안녕하세요 pufit 메일 인증입니다.");
			msg.setText("인증번호는 : " + temp);
			
			Transport.send(msg);
			System.out.println("이메일 전송");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        PrintWriter out = response.getWriter();
        out.print(userToEmail);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
