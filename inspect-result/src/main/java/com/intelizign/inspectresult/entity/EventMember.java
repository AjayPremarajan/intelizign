package com.intelizign.inspectresult.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "event_member_inspect_result")
public class EventMember {
	@Id
	@Column(name = "event_id", nullable = false)
	private String eventId;
	@Column(name = "source", nullable = false)
	private String source;
	@Column(name = "destination", nullable = false)
	private String destination;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "eventMember")
	private EventBody eventBody;
}
