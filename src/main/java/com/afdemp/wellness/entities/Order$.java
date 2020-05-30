package com.afdemp.wellness.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Transactional
@Table(name = "orders", catalog = "wellness2.0", schema = "")
//@XmlRootElement
public class Order$ implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private short pending;
    @Size(max = 200)
    @Column(length = 200)
    private String comments;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetailsList;
  
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customer;

    public Order$() {
    }

    public Order$(Integer orderId) {
        this.orderId = orderId;
    }

    public Order$(Integer orderId, Date date, short pending) {
        this.orderId = orderId;
        this.date = date;
        this.pending = pending;
    }

    public Order$(Date date, short pending, Customer customer) {
        this.date = date;
        this.pending = pending;
        this.customer = customer;
    }

    public Order$(Date date, short pending, String comments, Customer customer) {
        this.date = date;
        this.pending = pending;
        this.comments = comments;
        this.customer = customer;
    }
    
    

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public short getPending() {
        return pending;
    }

    public void setPending(short pending) {
        this.pending = pending;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    //@XmlTransient
    @Bean("list")
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderdetailsList) {
        this.orderDetailsList = orderdetailsList;
    }
    
    
    
    public void addOrderDetailsToList(OrderDetails od){
        this.orderDetailsList.add(od);
    }
    
    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.orderId);
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + this.pending;
        hash = 97 * hash + Objects.hashCode(this.comments);
        hash = 97 * hash + Objects.hashCode(this.orderDetailsList);
        hash = 97 * hash + Objects.hashCode(this.customer);
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
        final Order$ other = (Order$) obj;
        if (this.pending != other.pending) {
            return false;
        }
        if (!Objects.equals(this.comments, other.comments)) {
            return false;
        }
        if (!Objects.equals(this.orderId, other.orderId)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.orderDetailsList, other.orderDetailsList)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        return true;
    }

    

    

    @Override
    public String toString() {
        return "Order${" + "orderId=" + orderId + ", date=" + date + ", pending=" + pending + ", comments=" + comments +", customer=" + customer + '}';
    }

    
    
}
