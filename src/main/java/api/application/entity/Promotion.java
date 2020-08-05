package api.application.entity;

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
public class Promotion {
	@Id
	private String promotion_id;
	private BigDecimal promotion;
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Product product;

	public Promotion(BigDecimal promotion) {
		super();
		this.promotion = promotion;
	}
}
