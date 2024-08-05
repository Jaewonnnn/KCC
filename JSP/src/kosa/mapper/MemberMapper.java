package kosa.mapper;

import kosa.model.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {
    
    @Select("SELECT * FROM member WHERE id = #{id}")
    Member selectMemberById(String id);
    
    @Insert("INSERT INTO member (id, password, name, email) VALUES (#{id}, #{password}, #{name}, #{email})")
    int insertMember(Member member);
}
