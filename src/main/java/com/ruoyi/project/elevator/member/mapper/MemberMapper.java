package com.ruoyi.project.elevator.member.mapper;

import com.ruoyi.project.elevator.member.domain.Member;

import java.util.List;

public interface MemberMapper {

    List<Member>  selectMemberList(Member member);


}
