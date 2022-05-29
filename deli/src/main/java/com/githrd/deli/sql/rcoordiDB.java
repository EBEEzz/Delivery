package sql;

public class rcoordiDB {
	public final int SELECT = 1000;
	public final int SELONE = 1001;
	public final int INSERT = 1002;
	
	public String setString(int code) {
		StringBuffer buff = new StringBuffer();
		switch (code) {
		case SELECT:
			buff.append("select resno,resname,reslat,reslon,mylat,mylon,resdist,category,cate_no ");
			buff.append("from rcoordi ");
			buff.append("order by resdist asc ");
			break;
		case SELONE:
			buff.append("select resno,resname,reslat,reslon,mylat,mylon,resdist,category,cate_no ");
			buff.append("from rcoordi ");
			buff.append("where resname = ? ");
			break;
			
		case INSERT:
			buff.append("insert into rcoordi ");
			buff.append("values (rcoordi_seq.nextval, ? , ? , ? , ? , ? , ? , ?, ? ) ");
			break;
		
		}
		return buff.toString();	
	}
}
