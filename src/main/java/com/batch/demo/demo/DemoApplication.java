package com.batch.demo.demo;

import com.batch.demo.demo.domain.h2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private CompanyH2Repository companyH2Repository;

    @Autowired
    private ProductH2Repository productH2Repository;

    @Autowired
    private PurchaseH2Repository purchaseH2Repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    @Transactional("transactionManager")
    public void run(String... args) throws Exception {
        List<CompanyH2> companies = new ArrayList<>();
        CompanyH2 ibm = new CompanyH2();
        ibm.setCompanyName("IBM");
        ibm.setCountry("USA");
        ibm.setStockPrice(BigDecimal.TEN);
        companies.add(ibm);

        CompanyH2 cannon = new CompanyH2();
        cannon.setCompanyName("Cannon");
        cannon.setCountry("Japan");
        cannon.setStockPrice(BigDecimal.valueOf(65l));
        companies.add(cannon);

        CompanyH2 hitachi = new CompanyH2();
        hitachi.setCompanyName("Hitachi");
        hitachi.setStockPrice(BigDecimal.valueOf(15));
        hitachi.setCountry("Japan");
        companies.add(hitachi);

        CompanyH2 gWorks = new CompanyH2();
        gWorks.setCompanyName("GWorks");
        gWorks.setCountry("USA");
        gWorks.setStockPrice(BigDecimal.valueOf(25));
        companies.add(gWorks);

        List<ProductH2> productH2s = new ArrayList<>();
        ProductH2 gizmo = new ProductH2();
        gizmo.setProductName("Gizmo");
        gizmo.setPrice(BigDecimal.valueOf(300));
        gizmo.setCategory("Gadgets");
        gizmo.setManufacturer(gWorks);
        productH2s.add(gizmo);

        ProductH2 powerGizmo = new ProductH2();
        powerGizmo.setProductName("Powergizmo");
        powerGizmo.setPrice(BigDecimal.valueOf(500));
        powerGizmo.setCategory("Gadgets");
        powerGizmo.setManufacturer(gWorks);
        productH2s.add(powerGizmo);

        ProductH2 singleTouch = new ProductH2();
        singleTouch.setProductName("SingleTouch");
        singleTouch.setPrice(BigDecimal.valueOf(9000));
        singleTouch.setCategory("Photography");
        singleTouch.setManufacturer(cannon);
        productH2s.add(singleTouch);

        ProductH2 multiTouch = new ProductH2();
        multiTouch.setProductName("MultiTouch");
        multiTouch.setPrice(BigDecimal.valueOf(10000));
        multiTouch.setCategory("Household");
        multiTouch.setManufacturer(hitachi);
        productH2s.add(multiTouch);

        List<PurchaseH2> purchaseH2s = new ArrayList<>();
        PurchaseH2 purchaseH21 = new PurchaseH2();
        purchaseH21.setProduct(gizmo);
        purchaseH21.setBuyer("Joe Blow");
        purchaseH2s.add(purchaseH21);

        PurchaseH2 purchaseH22 = new PurchaseH2();
        purchaseH22.setProduct(gizmo);
        purchaseH22.setBuyer("Joe Blow");
        purchaseH2s.add(purchaseH22);

        PurchaseH2 purchaseH23 = new PurchaseH2();
        purchaseH23.setProduct(singleTouch);
        purchaseH23.setBuyer("Mr. Smith");
        purchaseH2s.add(purchaseH23);

        PurchaseH2 purchaseH24 = new PurchaseH2();
        purchaseH24.setProduct(multiTouch);
        purchaseH24.setBuyer("Mr. Smith");
        purchaseH2s.add(purchaseH24);

        PurchaseH2 purchaseH25 = new PurchaseH2();
        purchaseH25.setProduct(gizmo);
        purchaseH25.setBuyer("Mr. Smith");
        purchaseH2s.add(purchaseH25);


        companyH2Repository.saveAll(companies);
        productH2Repository.saveAll(productH2s);
        purchaseH2Repository.saveAll(purchaseH2s);
    }
}
