package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("managemnetProduct")
@PreAuthorize("hasAnyRole('ADMIN','SALE')")
public class ManagementProduct {
    // xem Dashboard
    @GetMapping("readDashboard")
    public String readDashboard(){
        return "readDashboard";
    }

    //CRUD Category
    @GetMapping("createCategory")
    public String managementCategory(){
        return "managementCategory";
    }
    @GetMapping("readCategory ")
    public String managementCategory1(){
        return "managementCategory";
    }
    @GetMapping("updateCategory")
    public String managementCategory2(){
        return "update Category";
    }
    @GetMapping("deleteCategory")
    public String deleteCategory(){
        System.out.println("Delete Sercessfull");
        return "Delete Sercessfull";
    }


    //CRUD Product

    @GetMapping("createProduct")
    public String createProduct(){
        return "add Product";
    }
    @GetMapping("readProduct ")
    public String readProduct(){
        return "readdd ";
    }
    @GetMapping("updateProduct")
    public String updateProduct(){
        return "update Category";
    }
    @GetMapping("deleteProduct")
    public String deleteProduct(){
        System.out.println("Delete Sercessfull");
        return "Delete Sercessfull";
    }

    // CRUD Brand

    @GetMapping("createBrand")
    public String createBrand(){
        return "add Brand";
    }
    @GetMapping("readBrand ")
    public String readBrand(){
        return "read Brand ";
    }
    @GetMapping("updateBrand")
    public String updateBrand(){
        return "update Brand";
    }
    @GetMapping("deleteBrand")
    public String deleteBrand(){
        System.out.println("Delete Sercessfull");
        return "Delete Sercessfull";
    }


    // CRU Order
    @GetMapping("createOrder")
    public String createOrder(){
        return "add Order";
    }
    @GetMapping("readOrder")
    public String readOrder(){
        return "read Order ";
    }
    @GetMapping("updateOrder")
    public String updateOrder(){
        return "update Order";
    }

    // CRUD Blogs

    @GetMapping("createBlog")
    public String createBlog(){
        return "add Blog";
    }
    @GetMapping("readBlog")
    public String readBlog(){
        return "read Blog ";
    }
    @GetMapping("updateBlog")
    public String updateBlog(){
        return "update Blog";
    }
    @PreAuthorize("hasAnyRole('AUTHOR','ADMIN','SALE')")
    @GetMapping("deleteBlog")
    public String deleteBlog(){
        System.out.println("Delete Sercessfull");
        return "Delete Sercessfull";
    }


























}
