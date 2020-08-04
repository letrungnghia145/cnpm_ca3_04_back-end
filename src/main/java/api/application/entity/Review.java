package api.application.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

@Table(name = "review")
public class Review {
	@Id
	private String review_id;
	private int evaluate;
	private String comment;
	private String reviewer_name;
	private String reviewer_email;
	private String reviewer_phone;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
}
