package com.afdemp.wellness.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Transactional
@Table(name = "products", catalog = "wellness2.0", schema = "")
//@XmlRootElement
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_id", nullable = false)
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 500)
    private String path;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(nullable = false, length = 200)
    private String descr;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String title;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String category;
    @Size(max = 45)
    @Column(length = 45)
    private String color;
    @Size(max = 45)
    @Column(length = 45)
    private String size;
    @Size(max = 45)
    @Column(length = 45)
    private String material;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderDetails> orderdetailsList;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String path, String descr, int stock, String title, double price, String category) {
        this.productId = productId;
        this.path = path;
        this.descr = descr;
        this.stock = stock;
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public Product(Integer productId, String path, String descr, int stock, String title, double price, String category, String color, String size, String material) {
        this.productId = productId;
        this.path = path;
        this.descr = descr;
        this.stock = stock;
        this.title = title;
        this.price = price;
        this.category = category;
        this.color = color;
        this.size = size;
        this.material = material;
    }
    
    
    // these are the minimum fields we need to create a nwe product, (according to the not null fields)
    // this should be the constructor when creating a product, I guess
    public Product(String path, String descr, int stock, String title, double price, String category) {
        this.path = path;
        this.descr = descr;
        this.stock = stock;
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public Product(String path, String descr, int stock, String title, double price, String category, List<OrderDetails> orderdetailsList) {
        this.path = path;
        this.descr = descr;
        this.stock = stock;
        this.title = title;
        this.price = price;
        this.category = category;
        this.orderdetailsList = orderdetailsList;
    }
    
    

    public Product(String path, String descr, int stock, String title, double price, String category, String color, String size, String material) {
        this.path = path;
        this.descr = descr;
        this.stock = stock;
        this.title = title;
        this.price = price;
        this.category = category;
        this.color = color;
        this.size = size;
        this.material = material;
    }

    
    
    

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    //@XmlTransient
    public List<OrderDetails> getOrderdetailsList() {
        return orderdetailsList;
    }

    public void setOrderdetailsList(List<OrderDetails> orderdetailsList) {
        this.orderdetailsList = orderdetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.productId;
        hash = 59 * hash + Objects.hashCode(this.path);
        hash = 59 * hash + Objects.hashCode(this.descr);
        hash = 59 * hash + this.stock;
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.category);
        hash = 59 * hash + Objects.hashCode(this.color);
        hash = 59 * hash + Objects.hashCode(this.size);
        hash = 59 * hash + Objects.hashCode(this.material);
        hash = 59 * hash + Objects.hashCode(this.orderdetailsList);
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
        final Product other = (Product) obj;
        if (this.productId != other.productId) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.descr, other.descr)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        if (!Objects.equals(this.orderdetailsList, other.orderdetailsList)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", path=" + path + ", descr=" + descr + ", stock=" + stock + ", title=" + title + ", price=" + price + ", category=" + category + ", color=" + color + ", size=" + size + ", material=" + material +'}';
    }

    
    
}
