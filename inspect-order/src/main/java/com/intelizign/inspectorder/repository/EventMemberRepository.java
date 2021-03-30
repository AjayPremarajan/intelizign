package com.intelizign.inspectorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intelizign.inspectorder.entity.EventMember;

public interface EventMemberRepository extends JpaRepository<EventMember, String> {

}
