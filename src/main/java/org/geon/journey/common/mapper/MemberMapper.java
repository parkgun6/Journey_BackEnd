package org.geon.journey.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.geon.journey.common.entity.Member;

import java.util.Optional;

@Mapper
public interface MemberMapper {

    Long registMember(Member member);

    Optional<Member> findByEmail(String username, boolean fromSocial);
}