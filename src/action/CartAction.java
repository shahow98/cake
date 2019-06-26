package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Cart;
import service.ICartService;
import service.imp.CartService;

/**
 * Servlet implementation class CartAction
 */
@WebServlet("/CartAction")
public class CartAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String intent = request.getParameter("intent");

		switch (intent) {
		case "AddCart":
			addCart(request, response);
			break;
		case "BrowseCart":
			browseCart(request, response);
			break;
		case "DeleteCart":
			deleteCart(request, response);
			break;
		default:
			break;
		}
	}
	
	public void addCart(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Account user = (Account) session.getAttribute("user");
		if(user != null) {
			String img_src = request.getParameter("img_src");
			String price = request.getParameter("price");
			Cart cart = new Cart();
			cart.setEmail(user.getEmail());
			cart.setImg_src(img_src);
			cart.setPrice(Float.parseFloat(price));
			ICartService cartService = new CartService();
			System.out.println("add: "+cart);
			try(PrintWriter out = response.getWriter()) {
				if (cartService.addCart(cart)) {
					out.write("success");
				}else {
					out.write("fail");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try(PrintWriter out = response.getWriter()) {
					out.write("fail");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteCart(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Account user = (Account) session.getAttribute("user");
		if(user != null) {
			String img_src = request.getParameter("img_src");
			Cart cart = new Cart();
			cart.setEmail(user.getEmail());
			cart.setImg_src(img_src);
			ICartService cartService = new CartService();
			System.out.println("delete: "+cart);
			try(PrintWriter out = response.getWriter()) {
				if (cartService.deleteCart(cart)) {
					out.write("success");
				}else {
					out.write("fail");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try(PrintWriter out = response.getWriter()) {
					out.write("fail");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void browseCart(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Account user = (Account) session.getAttribute("user");
		if(user != null) {
			ICartService cartService = new CartService();
			try(PrintWriter out = response.getWriter()) {
				List<Cart> cartList = cartService.browseCart(user.getEmail());
				if(!cartList.isEmpty()) {
					String json = "[";
					for(Cart cart : cartList) {
						json = json + cart.toString() + ",";
					}
					json = json.substring(0, json.length()-1) + "]";
					System.out.println("browseCart"+json);
					out.write(json);
				}else {
					out.write("null");
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try(PrintWriter out = response.getWriter()) {
					out.write("null");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
