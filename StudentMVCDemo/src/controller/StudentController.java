package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Student;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public StudentController() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		if(action.equals("showallstudent")){
			StudentDAO dao = new StudentDAO();
			List<Student> students = dao.selectAll();
			
			RequestDispatcher rd = request.getRequestDispatcher("showallstudent.jsp");
			request.setAttribute("students", students);
			rd.forward(request, response);
		}else if(action.equals("search")){
			String name = request.getParameter("name");
			
			StudentDAO dao = new StudentDAO();
			List<Student> students = dao.selectByName(name);
			
			RequestDispatcher rd = request.getRequestDispatcher("showallstudent.jsp");
			request.setAttribute("students", students);
			rd.forward(request, response);
		}else if(action.equals("addstudent")){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			
			Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setAge(age);
			
			StudentDAO dao = new StudentDAO();
			boolean result = dao.insert(student);
			
			if(result){
				List<Student> students = dao.selectAll();
				
				RequestDispatcher rd = request.getRequestDispatcher("showallstudent.jsp");
				request.setAttribute("students", students);
				rd.forward(request, response);
			}
		}else if(action.equals("edit")){
			String id = request.getParameter("id");
			StudentDAO dao = new StudentDAO();
			
			Student student = dao.selectById(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("editstudent.jsp");
			request.setAttribute("student", student);
			rd.forward(request, response);
		}else if(action.equals("updatestudent")){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			
			Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setAge(age);
			
			StudentDAO dao = new StudentDAO();
			boolean result = dao.update(student);
			
			if(result){
				List<Student> students = dao.selectAll();
				
				RequestDispatcher rd = request.getRequestDispatcher("showallstudent.jsp");
				request.setAttribute("students", students);
				rd.forward(request, response);
			}
		}else if(action.equals("delete")){
			String id = request.getParameter("id");			
			
			StudentDAO dao = new StudentDAO();
			boolean result = dao.delete(id);
			
			if(result){
				List<Student> students = dao.selectAll();
				
				RequestDispatcher rd = request.getRequestDispatcher("showallstudent.jsp");
				request.setAttribute("students", students);
				rd.forward(request, response);
			}
		}
	}

}
















