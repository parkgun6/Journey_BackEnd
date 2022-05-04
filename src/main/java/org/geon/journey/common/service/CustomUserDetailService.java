package org.geon.journey.common.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.geon.journey.common.dto.AuthMemberDTO;
import org.geon.journey.common.entity.Member;
import org.geon.journey.common.mapper.MemberMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("CustomUserDetailService loadUserByUsername : " + username);

        Optional<Member> result = mapper.findByEmail(username, false);

        if(result.isEmpty()){
            throw new UsernameNotFoundException("Check Email or Social");
        }
        Member member = result.get();
        AuthMemberDTO authMemberDTO = new AuthMemberDTO(
                member.getEmail(),
                member.getPassword(),
                member.isFromSocial(),
                member.getRoleSet().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).collect(Collectors.toSet())
        );
        authMemberDTO.setName(member.getName());
        authMemberDTO.setFromSocial(member.isFromSocial());
        return authMemberDTO;
    }
}
