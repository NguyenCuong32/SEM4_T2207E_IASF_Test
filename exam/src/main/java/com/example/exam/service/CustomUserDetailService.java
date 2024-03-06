package com.example.exam.service;

import com.example.exam.repository.MemberRepository;
import com.example.exam.entity.CustomMemberDetail;
import com.example.exam.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findById(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found")
                );
        return new CustomMemberDetail(member);
    }
}
