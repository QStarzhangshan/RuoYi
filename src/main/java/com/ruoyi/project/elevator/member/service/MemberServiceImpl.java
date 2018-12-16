package com.ruoyi.project.elevator.member.service;

import com.ruoyi.project.elevator.member.domain.Member;
import com.ruoyi.project.elevator.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("MemberService")
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> selectMemberList(Member member) {
        List<Member> members = memberMapper.selectMemberList(member);
        System.out.println("----------"+members.toString());
        return members;
    }
}
