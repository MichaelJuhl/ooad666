package daoInterface;

import java.sql.SQLException;
import java.util.ArrayList;

import dal.Member;


public interface IMemberDAO {
	
	Member getMember(int memberID) throws DALException;
	ArrayList<Member> getMemberList() throws DALException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	void createMember(Member member) throws DALException;
	void updateMember(int memberID, Member member) throws DALException;
	void deleteMember(int memberID) throws DALException;


}
