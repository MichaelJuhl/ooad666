package dalinterface;

import java.sql.SQLException;
import java.util.ArrayList;

import dal.Member;


public interface IMember {
	
	Member getMember(int memberID) throws DALException;
	ArrayList<Member> getMemberList() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	void createMember(Member member) throws DALException;
	void updateMember(int memberID, Member member) throws DALException;
	void deleteMember(int memberID) throws DALException;


}
