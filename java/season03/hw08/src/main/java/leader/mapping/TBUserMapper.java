package leader.mapping;

import java.util.List;
import leader.domain.TBUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TBUserMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 *
	 * @mbg.generated
	 */
	@Delete({ "delete from users", "where username = #{username,jdbcType=VARCHAR}" })
	int deleteByPrimaryKey(String username);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 *
	 * @mbg.generated
	 */
	@Insert({ "insert into users (username, password, ", "enabled)",
			"values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ", "#{enabled,jdbcType=BIT})" })
	int insert(TBUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 *
	 * @mbg.generated
	 */
	@Select({ "select", "username, password, enabled", "from users", "where username = #{username,jdbcType=VARCHAR}" })
	@Results({ @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
			@Result(column = "enabled", property = "enabled", jdbcType = JdbcType.BIT) })
	TBUser selectByPrimaryKey(String username);

	@Select({ "select", "username, password, enabled", "from users", "where username = #{username,jdbcType=VARCHAR} AND enabled= #{enabled,jdbcType=BIT}" })
	@Results({ @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
			@Result(column = "enabled", property = "enabled", jdbcType = JdbcType.BIT) })
	List<TBUser>  selectByPrarams(String username,boolean enabled);

	@Select("<script>select username, password, enabled from users where username in "
			+ "<foreach collection=\"userIds\" index=\"index\" item=\"theId\" open=\"(\"  separator=\",\" close=\")\"> #{theId} </foreach></script>")
	@Results({ @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
			@Result(column = "enabled", property = "enabled", jdbcType = JdbcType.BIT) })
	List<TBUser> selectByCondition(@Param("userIds") List<String> ids);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 *
	 * @mbg.generated
	 */
	@Select({ "select", "username, password, enabled", "from users" })
	@Results({ @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
			@Result(column = "enabled", property = "enabled", jdbcType = JdbcType.BIT) })
	List<TBUser> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table users
	 *
	 * @mbg.generated
	 */
	@Update({ "update users", "set password = #{password,jdbcType=VARCHAR},", "enabled = #{enabled,jdbcType=BIT}",
			"where username = #{username,jdbcType=VARCHAR}" })
	int updateByPrimaryKey(TBUser record);
}