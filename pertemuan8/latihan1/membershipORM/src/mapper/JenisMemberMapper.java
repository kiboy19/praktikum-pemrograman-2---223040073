package mapper;

import java.util.List;
import model.JenisMember;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface JenisMemberMapper {
    @Insert("Insert into jenis_member (id,nama) values(#{id},#{nama})")
    public Integer insert(JenisMember jenisMember);

    @Update("update jenis_member set nama = #{nama} where id = #{id}")
    public Integer update(JenisMember jenisMember);

    @Delete("delete from jenis_member where id = #{id}")
    public Integer delete(JenisMember jenisMember);

    @Select("SELECT * FROM jenis_member")
    @Results(value = {
        @Result(property = "id", column = "id"),
        @Result(property = "nama", column = "nama")})
    List<JenisMember> findAll();
}
