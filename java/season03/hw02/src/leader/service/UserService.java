package leader.service;

import java.util.List;

import leader.bean.User;
import leader.bean.UserSession;

public class UserService {

	public boolean createUser(User user)
	{
		return true;
	}
	public boolean deleteUser(long userId)
	{
		return true;
	}
	public boolean disableUser(long userId)
	{
		return true;
	}
	public List<User> queryUsers(String userNamePrex,boolean onlyValidUser)
	{
		return null;
	}
	/**
	 * ������벻�ԣ����ص�UserSession������sessionIdΪ�գ��ͻ��˿��������жϣ�����UserSession.isValid����
	 * @param userName
	 * @param md5EncodedPassword
	 * @return
	 */
	public UserSession login(String userName,String md5EncodedPassword)
	{
		return new UserSession();
	}
}
