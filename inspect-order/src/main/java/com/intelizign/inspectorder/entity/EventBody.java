package com.intelizign.inspectorder.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "event_body_inspect_order")
public class EventBody {
	@Id
	@Column(name = "event_id", nullable = false)
	private String eventId;
	// payload
	@Column(name = "station_type", nullable = true)
	private String stationType;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "eventBody")
	private ProductAttribute productAttribute;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "event_id", nullable = true)
	@ToString.Exclude
	private EventMember eventMember;
}
