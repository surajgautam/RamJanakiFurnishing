package com.technep.ramjanaki.product.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.technep.ramjanaki.category.model.Category;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by surajgautam on 6/25/17.
 */
@Entity
@Table(name="ecommerce_product")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="p_id")
    private int pid;

    @Column(name="p_name",nullable = false)
    @Size(min = 3,max = 30)
    @NotBlank
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.BASIC)
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    private String pname;

    @Column(name="p_price",nullable = false)
    @NotNull(message = "Price must not be null")
    private long price;

    @Column(name="p_description",nullable = false)
    @NotBlank
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.BASIC)
    private String description;

    @Column(name="p_image")
    private String image;

    @Column(name="p_active")
    private boolean active;

    @Column(name="p_views")
    private int views;

    @Column(name="p_quantity")
    private int quantity;


    @Transient
    private MultipartFile file;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "c_id")
    private Category category;


    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", active=" + active +
                ", views=" + views +
                ", quantity=" + quantity +
                ", category=" + category +
                '}';
    }
}
