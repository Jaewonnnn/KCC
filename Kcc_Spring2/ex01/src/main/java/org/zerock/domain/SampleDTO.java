package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO객체 vs DTO객체
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleDTO {
	private String name;
	private int age;
}
