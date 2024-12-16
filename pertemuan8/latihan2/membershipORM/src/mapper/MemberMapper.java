package mapper;

import model.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface MemberMapper {

    @Insert("INSERT INTO member (name, email, jenis_member_id) VALUES (#{name}, #{email}, #{jenisMemberId})")
    int insert(Member member);
    
    @Update("UPDATE member SET name = #{name}, email = #{email}, jenis_member_id = #{jenisMemberId} WHERE id = #{id}")
    int update(Member member);
    
    @Delete("DELETE FROM member WHERE id = #{id}")
    int delete(Member member);
    
    @Select("SELECT * FROM member")
    List<Member> findAll();
}
