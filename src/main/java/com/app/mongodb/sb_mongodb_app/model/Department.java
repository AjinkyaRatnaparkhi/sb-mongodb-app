package com.app.mongodb.sb_mongodb_app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Document(collection = "departments") // this is optional as the default name is same as class name
public class Department {

	@Id
	private String id;
	private String name;
	private String location;

}
