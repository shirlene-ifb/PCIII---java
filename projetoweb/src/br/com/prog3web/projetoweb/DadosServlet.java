package br.com.prog3web.projetoweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dados")
public class DadosServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String nome;
		String genero;
		String matricula;
		String idade;
		
		// pegando os valores de variáveis enviadas do cliente
		nome = req.getParameter("nome");
		idade = req.getParameter("idade");
		matricula = req.getParameter("matricula");
		genero = req.getParameter("genero");
		int i = Integer.parseInt(idade);
		// imprime estes dados no cliente
		out.println("<HTML><HEAD><TITLE>Resultado");
		out.println("</TITLE></HEAD><BODY>");
		out.println("<H1>Seus Dados</H1>");
		out.println("<b>Nome: </b>" + nome + "</p>");
		out.println("<b>Matrícula: </b>" + matricula + "</p>");
		out.println("<b>Idade: </b>" + idade + "</p>");
		out.println("<b>Gênero: </b>" + genero + "</p>");
		
		if (genero.equals("feminino")) {
			out.println("<BR><b>Você não precisa servir ao exército ! ");
		}
		else {
			if(i >= 18) {
				out.println("<BR><b>Você precisa servir ao exército ! ");
			}
			else {
				out.println("<BR><b>Você está ok com as obrigações militares ! </b>");
			}
		}
		out.println("<BR></BODY></HTML>");
		out.close();
	}
}
