package com.mapstruct.demo.Entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_faq") // Corrected table name here
@Getter
@Setter
@SQLDelete(sql = "UPDATE product_faq SET Is_Active = false WHERE product_faq_id=?") // Corrected table name here
public class ProductFaq {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_faq_id;
	@Column(name="Product_Id")
	private long product_id;
	@Column(name="Product_Faq_Name")
	private String product_Faq_name;
	@Column(name="Product_Faq_Priority")
	private String product_Faq_priority;
	@Column(name="Product_Faq_Status")
	private boolean product_faq_status ;
	  @Column(name = "Is_Active")
	  private boolean isactive= Boolean.FALSE;
	  @Temporal(TemporalType.DATE)
	    @Column(name="Start_Date")
	    private Date start_date;
	
	  @Temporal(TemporalType.DATE)
	    @Column(name="Update_Date")
	    private Date update_date;
	
	  @Temporal(TemporalType.DATE) 
	    @Column(name="End_Date")
	    private Date end_date;
	  
	  @PrePersist
	    protected void onCreate() {
	        start_date = new Date(); // Set the current date when the entity is created
	    }
}
