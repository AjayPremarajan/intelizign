package com.intelizign.inspectorder.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.intelizign.inspectorder.entity.EventMember;

public interface EventMemberRepository extends MongoRepository<EventMember, String> {

}
