package com.ruoyi.project.elevator.member.service;

import com.ruoyi.project.elevator.member.domain.Member;

import java.util.List;

public interface MemberService {

    List<Member> selectMemberList(Member member);
}
