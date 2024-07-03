package com.rincon.taco_cloud.Models;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "business_user_id")
    private Integer businessUserId;

    @Column(name = "createDate", nullable = false)
    private Date createDate = new Date();

    @Column(name = "lastUpdatedDate", nullable = false)
    private Date lastUpdatedDate = new Date();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<LineOrder> lineOrders;
}

