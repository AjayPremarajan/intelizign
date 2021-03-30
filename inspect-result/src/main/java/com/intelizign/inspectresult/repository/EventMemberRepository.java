package com.intelizign.inspectresult.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.intelizign.inspectresult.entity.EventMember;

public interface EventMemberRepository extends JpaRepository<EventMember, String> {

}
