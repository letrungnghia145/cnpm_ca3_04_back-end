package api.application.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "image")
public class ProductImages {
	@Id
	private String pics_id;
	private String mainPic;
	private String pic_1;
	private String pic_2;
	private String pic_3;
	private String pic_4;
}
