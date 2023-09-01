package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.SingleConnectionBanco;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/principal/*"}) //Intercepta todas as requisições do projeto ou mapeamento
public class FilterAutenticacao implements Filter {
    
	private static Connection connection;
	
    public FilterAutenticacao() {
        super(); 
    }

    //Encerra os processos quando o servidor é parado
    //Ex: finaliza conexão com o banco
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Intercepta as requisições e as respostas do sistema
	//Tudo que o sistema fizer passa por aqui
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		try {
			HttpServletRequest req = (HttpServletRequest) request;		
			HttpSession session = req.getSession();
			
			String usuarioLogado = (String) session.getAttribute("usuario");
			
			String urlParaAutenticar = req.getServletPath();//Url que está sendo acessada
			
			//Validar se está logado se não, manda pra tela de login
			if (usuarioLogado == null &&
					!urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {//Não está logado
				
				RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
				request.setAttribute("msg", "Por favor realize o login!");
				redirecionar.forward(req, response);
				return;//Para a execução e redireciona para o login
				
			}else {
				chain.doFilter(req, response);
			}
			
			connection.commit();//Deu tudo certo, então commita as alterações no banco de dados
			
		}catch (Exception e) {
			e.printStackTrace();
			
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	//Inicia os processos ou recursos quando o servidor sobe o projeto
	//Ex: inicia conexão com o banco
	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnectionBanco.getConnection();
	}

}
