package mapper;

import model.JenisMember;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface JenisMemberMapper {
    
    @Insert("INSERT INTO jenis_member (name, description) VALUES (#{name}, #{description})")
    int insert(JenisMember jenisMember);
    
    @Update("UPDATE jenis_member SET name = #{name}, description = #{description} WHERE id = #{id}")
    int update(JenisMember jenisMember);
    
    @Delete("DELETE FROM jenis_member WHERE id = #{id}")
    int delete(JenisMember jenisMember);
    
    @Select("SELECT * FROM jenis_member")
    List<JenisMember> findAll();
}
