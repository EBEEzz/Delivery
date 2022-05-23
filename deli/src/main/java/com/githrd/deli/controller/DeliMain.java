package com.githrd.deli.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class DeliMain implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view ="/main";
		return view;
	}

}
