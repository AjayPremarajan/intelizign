package com.intelizign.inspectresult.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.intelizign.inspectresult.entity.EventMember;

public interface EventMemberRepository extends MongoRepository<EventMember, String> {

}
