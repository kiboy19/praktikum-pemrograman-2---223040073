package dao;

import java.util.List;
import model.JenisMember;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mapper.JenisMemberMapper;

public class JenisMemberDao {
    private final SqlSessionFactory sqlSessionFactory;

    public JenisMemberDao(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int insert(JenisMember jenisMember){
        try (SqlSession session = sqlSessionFactory.openSession()){
            JenisMemberMapper mapper = session.getMapper(JenisMemberMapper.class);
            return mapper.insert(jenisMember);
        }
    }

    public int update(JenisMember jenisMember){
        try (SqlSession session = sqlSessionFactory.openSession()){
            JenisMemberMapper mapper = session.getMapper(JenisMemberMapper.class);
            return mapper.update(jenisMember);
        }
    }

    public int delete(JenisMember jenisMember){
        try (SqlSession session = sqlSessionFactory.openSession()){
            JenisMemberMapper mapper = session.getMapper(JenisMemberMapper.class);
            return mapper.delete(jenisMember);
        }
    }

    public List<JenisMember> findAll(){
        try (SqlSession session = sqlSessionFactory.openSession()){
            JenisMemberMapper mapper = session.getMapper(JenisMemberMapper.class);
            return mapper.findAll();
        }
    }
}
