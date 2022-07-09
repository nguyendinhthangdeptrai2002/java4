package lap3;

import java.io.IOException;


import java.util.Properties;

import javax.mail.Message;
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
 * Servlet implementation class bai5
 */
@WebServlet("/bai5")
public class bai5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bai5() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/guimail/form.jsp").forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nhan = request.getParameter("nhan");
		String di = request.getParameter("gui");
		String noidung = request.getParameter("noidung");
		String subject = request.getParameter("subject");

		Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 587);
    	 
        Session s = Session.getInstance(props,  new javax.mail.Authenticator() {
                       protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(di, "dinhthang2002");
                    }}); 
        Message msg = new MimeMessage(s);
		    try {
		    	
	             msg.setFrom(new InternetAddress(di));//nguoigui
	             msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(nhan));//nguoinhan
	             msg.setSubject(subject);
	             msg.setText(noidung);
	             Transport.send(msg);
	             System.out.println("thanh cong");
			} catch (Exception e) {				
				e.printStackTrace();
			}
		
	}

}
