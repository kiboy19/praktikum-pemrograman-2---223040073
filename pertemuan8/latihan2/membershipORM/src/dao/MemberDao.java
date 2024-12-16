package dao;

import java.util.List;
import model.Member;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mapper.MemberMapper;

public class MemberDao {
    private final SqlSessionFactory sqlSessionFactory;

    public MemberDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int insert(Member member){
        try (SqlSession session = sqlSessionFactory.openSession()){
            MemberMapper mapper = session.getMapper(MemberMapper.class);
            return mapper.insert(member);
        }
    }

    public int update(Member member){
        try (SqlSession session = sqlSessionFactory.openSession()){
            MemberMapper mapper = session.getMapper(MemberMapper.class);
            return mapper.update(member);
        }
    }

    public int delete(Member member){
        try (SqlSession session = sqlSessionFactory.openSession()){
            MemberMapper mapper = session.getMapper(MemberMapper.class);
            return mapper.delete(member);
        }
    }

    public List<Member> findAll(){
        try (SqlSession session = sqlSessionFactory.openSession()){
            MemberMapper mapper = session.getMapper(MemberMapper.class);
            return mapper.findAll();
        }
    }
}
