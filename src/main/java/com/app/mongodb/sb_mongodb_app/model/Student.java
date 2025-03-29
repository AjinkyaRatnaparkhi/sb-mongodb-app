package com.app.mongodb.sb_mongodb_app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Document(collection = "students")
// 1 is asc , -1 desc
@CompoundIndex(name = "name_year" , def = "{'name':1 , 'year': -1}")
public class Student {
	
	@Id
	private String id;
	@Field(name = "sID")
	private Integer studentNumber;
	@Indexed
	private String name;
	private String year;
	@Field(name = "score")
	private String totalScore;
	private String email;
	private List<Subject> subjects;

}
