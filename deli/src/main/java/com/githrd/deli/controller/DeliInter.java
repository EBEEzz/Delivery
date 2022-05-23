package com.githrd.deli.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public interface DeliInter {
	String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
}
