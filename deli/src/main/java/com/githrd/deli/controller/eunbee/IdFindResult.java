package com.githrd.deli.controller.eunbee;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.deli.controller.*;
import com.githrd.deli.dao.*;

public class IdFindResult implements DeliInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/find/idFindResult";
		String mail = req.getParameter("fmail");
		
		EunbeeDao eDao = new EunbeeDao();
		String fid = eDao.getId(mail);
		
		req.setAttribute("FID", fid);
		return view;
	}

}
