package com.afdemp.wellness.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Transactional
@Table(name="orderdetails", catalog = "wellness2.0", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"order_id", "product_id"})})
//@XmlRootElement

public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "od_id", nullable = false)
    private Integer odId;
    @Basic(optional = false)
    private int quantity;
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Order$ order;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Product product;

    public OrderDetails() {
    }

    public OrderDetails(Integer odId) {
        this.odId = odId;
    }

    public OrderDetails(Integer odId, int quantity) {
        this.odId = odId;
        this.quantity = quantity;
    }

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public int getQuantity() {
        return quantity;
    }
    

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order$ getOrder() {
        return order;
    }

    public void setOrder(Order$ order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.odId);
        hash = 59 * hash + this.quantity;
        hash = 59 * hash + Objects.hashCode(this.order);
        hash = 59 * hash + Objects.hashCode(this.product);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderDetails other = (OrderDetails) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.odId, other.odId)) {
            return false;
        }
        if (!Objects.equals(this.order, other.order)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

    

    

    @Override
    public String toString() {
        return "Orderdetails{" + "odId=" + odId + ", quantity=" + quantity + ", orderId=" + order + ", productId=" + product + '}';
    }

    
    
}
