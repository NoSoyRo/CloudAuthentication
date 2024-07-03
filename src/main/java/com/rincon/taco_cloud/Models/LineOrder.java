package com.rincon.taco_cloud.Models;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "line_order")
@Data
public class LineOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "createDate", nullable = false)
    private Date createDate = new Date();

    @Column(name = "lastUpdatedDate", nullable = false)
    private Date lastUpdatedDate = new Date();
}

