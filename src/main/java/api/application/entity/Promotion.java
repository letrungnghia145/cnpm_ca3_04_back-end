package api.application.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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

@Table(name = "promotion")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String promotion_id;
	private BigDecimal promotion;
	@JsonBackReference("product_promotion_ref")
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Product product;

	public Promotion(BigDecimal promotion) {
		super();
		this.promotion = promotion;
	}
}
