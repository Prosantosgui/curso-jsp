package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

import java.io.IOException;

import dao.DAOLoginRepository;


@WebServlet(urlPatterns = {"/principal/ServletLogin", "/ServletLogin"})//Mapeamento de URL que vem da tela
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private DAOLoginRepository daoLoginRepository = new DAOLoginRepository();
	
	public ServletLogin() {	
	}	
	
	//Recebe dados pela url em parametros
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	//Recebe dados enviados por um formulario
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
       String login = request.getParameter("login");
       String senha = request.getParameter("senha");
       String url = request.getParameter("url");
       
       try {
		
    	   ModelLogin modellogin = new ModelLogin();
    	   modellogin.setLogin(login);
    	   modellogin.setSenha(senha);
    	   
           if(login != null && !login.isEmpty() && senha!= null && !senha.isEmpty()) {       
        	   
               if(daoLoginRepository.validarAutenticacao(modellogin)) {//Simulando login
            	   
            	   request.getSession().setAttribute("usuario", modellogin.getLogin());
            	   
            	   if (url == null || url.equals("null")) {
    				url = "principal/principal.jsp";
            	   }
            	   
                   RequestDispatcher redirecionar = request.getRequestDispatcher(url);
                   redirecionar.forward(request, response);
                   
               } else {
                   RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
                   request.setAttribute("msg", "Informe login e senha corretamente!");
                   redirecionar.forward(request, response);
               }
           } else {
               RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
               request.setAttribute("msg", "Login e senha devem ser informados!");
               redirecionar.forward(request, response);
           }
    	   
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.toString());
			redirecionar.forward(request, response);
		}
    }

}
