package api.application.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "image")
public class ProductImages implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String pics_id;
	private String mainPic;
	private String pic_1;
	private String pic_2;
	private String pic_3;
	private String pic_4;
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JsonBackReference("product_images_ref")
	private Product product;

	public ProductImages(String mainPic, String pic_1, String pic_2, String pic_3, String pic_4) {
		super();
		this.mainPic = mainPic;
		this.pic_1 = pic_1;
		this.pic_2 = pic_2;
		this.pic_3 = pic_3;
		this.pic_4 = pic_4;
	}
}
