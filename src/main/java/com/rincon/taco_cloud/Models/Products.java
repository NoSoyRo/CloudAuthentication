package com.rincon.taco_cloud.Models;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "createDate", nullable = false)
    private Date createDate = new Date();

    @Column(name = "lastUpdatedDate", nullable = false)
    private Date lastUpdatedDate = new Date();
}

