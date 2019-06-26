package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import service.IAccountService;
import service.imp.AccountService;

/**
 * Servlet implementation class AccountAction
 */
@WebServlet("/AccountAction")
public class AccountAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String intent = request.getParameter("intent");

		switch (intent) {
		case "Login":
			login(request, response);
			break;
		case "Out":
			out(request, response);
			break;
		case "NewAccount":
			newAccount(request, response);
			break;
		case "User":
			user(request, response);
			break;
		default:
			break;
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("id");
		String pwd =  request.getParameter("pwd");
		IAccountService accountService = new AccountService();
		Account account = new Account();
		account.setEmail(email);
		account.setPassword(pwd);
		account = accountService.login(account);
		try(PrintWriter out = response.getWriter()) {
			if (account != null) {
				out.write(account.toString());
				HttpSession session = request.getSession();
				session.setAttribute("user", account);
			}else {
				out.write(new Account().toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void newAccount(HttpServletRequest request, HttpServletResponse response) {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		IAccountService accountService = new AccountService();
		Account account = new Account();
		account.setEmail(email);
		account.setFirst_name(first_name);
		account.setLast_name(last_name);
		account.setPassword(password);
		try(PrintWriter out = response.getWriter()) {
			if (accountService.newAccount(account)) {
				out.write(account.toString());
			}else {
				out.write(new Account().toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void user(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("user");
		System.out.println(account);
		try(PrintWriter out = response.getWriter()) {
			if (account != null) {
				out.write(account.toString());
			}else {
				out.write(new Account().toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
@SuppressWarnings("deprecation")
public void out(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
		System.out.println("user"+session.getAttribute("user"));
	}

}
