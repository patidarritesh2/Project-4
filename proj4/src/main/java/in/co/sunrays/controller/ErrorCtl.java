package in.co.sunrays.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.sunrays.util.ServletUtility;

/**
 * Servlet implementation class ErrorCtl
 *
 * @author Ritesh Patidar
 *
 */
@WebServlet ("/ErrorCtl")
public class ErrorCtl extends BaseCtl {
	
	// Contains Display Logic..............
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}
	
	// Contaiins Submit Logics................
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.ERROR_VIEW;
	}

}
