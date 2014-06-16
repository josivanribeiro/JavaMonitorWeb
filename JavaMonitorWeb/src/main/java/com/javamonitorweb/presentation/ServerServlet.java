package com.javamonitorweb.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.javamonitorweb.constants.Constants;
import com.javamonitorweb.service.impl.ServerServiceImpl;


/**
 * Server Servlet.
 * 
 * @author Ribeiro_Josivan
 *
 */
@WebServlet (name="ServerServlet", urlPatterns={"/serverServlet"})
public class ServerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Logger logger = LogManager.getLogger (ServerServlet.class);
	
	private ServerServiceImpl serverService = ServerServiceImpl.getInstance();
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug ("Start executing the method doGet.");
		String status = "";
		try {
			status = getServersStatus ();
			logger.debug ("The servers status is [" + status + "]");
		} catch (Exception e) {
			logger.error ("An error occurred while getting the server status.", e);
		}
		PrintWriter out = response.getWriter();
		out.println (status);
		out.close();
		logger.debug ("Finish executing the method doGet.");
	}
	
	/**
	 * Gets the servers status.
	 * 
	 * @return
	 * @throws Exception
	 */
	private String getServersStatus () throws Exception {
		String status = "";		
		boolean isAvailable = serverService.isServersAvailable();
		status = isAvailable ? Constants.STATUS_SUCCESS : Constants.STATUS_FAILURE;				
		return status;
	}
	
}
