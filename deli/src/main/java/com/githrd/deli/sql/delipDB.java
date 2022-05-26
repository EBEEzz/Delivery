package util;


public class delipDB {
	public final int SELECT = 1000;
	public final int SELONE = 1001;
	public final int INSERT = 1002;

	public String setString(int code) {
		StringBuffer buff = new StringBuffer();
		switch (code) {
		case SELECT:
			buff.append("select no, name, dist, lat, lon ");
			buff.append("from deliplace ");
			buff.append("order by dist asc ");
			break;
		case SELONE:
			buff.append("select no, name, dist ");
			buff.append("from deliplace ");
			buff.append("where name = ? ");
			break;

		case INSERT:
			buff.append("insert into deliplace ");
			buff.append("values (deli_seq.nextval, ? , ? , ? , ? , ? , ? ) ");
			break;
		
		}
		return buff.toString();	
	}

}
