package api.application.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "review")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String review_id;
	private int evaluate;
	private String comment;
	private String reviewer_name;
	private String reviewer_email;
	private String reviewer_phone;
	@JsonBackReference("product_reviews_ref")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
}
