package mapper;

import java.util.List;
import model.JenisMember;
import model.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MemberMapper {
    @Insert("Insert into member (id,nama,jenis_member_id) values(#{id},#{nama},#{jenisMemberId})")
    public Integer insert(Member member);

    @Update("update member set nama = #{nama}, jenis_member_id = #{jenisMemberId} where id = #{id}")
    public Integer update(JenisMember jenisMember);

    @Delete("delete from member where id = #{id}")
    public Integer delete(JenisMember jenisMember);

    @Select("SELECT * FROM member")
    @Results(value = {
        @Result(property = "id", column = "id"),
        @Result(property = "nama", column = "nama"),
        @Result(property = "jenisMember", column = "jenis_member_id",
        javaType = JenisMember.class, one = @One(select = "getJenisMember"))})
    List<Member>findAll();

    @Select("SELECT * FROM jenis_member WHERE id = #{id}")
    @Results(value = {
        @Result(property = "id", column = "id"),
        @Result(property = "nama", column = "nama")})
    JenisMember getJenisMember(String jenisMemberId);
}