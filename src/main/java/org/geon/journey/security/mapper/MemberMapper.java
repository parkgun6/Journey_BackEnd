package org.geon.journey.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.geon.journey.security.entity.Member;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    void registMember(Member member);

    void registMemberRole(Member member);

    Optional<Member> findByEmail(String username, boolean fromSocial);
}
