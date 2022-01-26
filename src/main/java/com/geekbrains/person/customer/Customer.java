package com.geekbrains.person.customer;

import com.geekbrains.market.Market;
import com.geekbrains.person.Person;
import com.geekbrains.person.seller.Seller;
import com.geekbrains.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customer extends Person {
    private List<Product> expectedPurchaseList;
    private List<Product> purchaseList;
    private String sellerName;
    private String sellerLastname;
   // private List<Seller> sellerNameLastname;

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerLastname() {
        return sellerLastname;
    }

    public void setSellerLastname(String sellerLastname) {
        this.sellerLastname = sellerLastname;
    }



    public Customer(List<Product> expectedPurchaseList, int cash, String sellerName, String sellerLastname ) {
        this.purchaseList = new ArrayList<>();
        this.expectedPurchaseList = expectedPurchaseList;
        this.sellerName = sellerName;
        this.sellerLastname =sellerLastname;
       // this.sellerNameLastname = sellerNameLastname;
        this.setCash(cash);
    }

    public void addPurchase(Product product) {
        if (purchaseList == null) {
            purchaseList = new ArrayList<>();
        }

        purchaseList.add(product);
    }
    public void findProductOnMarket(Market market) {


                for (Product product : getExpectedPurchaseList()) {
                    for (Seller seller : market.getSellers()){
                        boolean isBoughtSeller = seller.sellNameLastName(this,market);
                    boolean isBought = seller.sellProducts(this, product);
                    // если продукты есть и фио совпадает с заданным
                    if (isBought && isBoughtSeller) {

                        break;
                    }
                    else if (!isBoughtSeller && isBought){
                        break;
                    }

                    }
                }
            }



//
//    public void findProductOnMarket(Market market) {
//
//        for (Product product : getExpectedPurchaseList()) {
//            for (Seller seller : market.getSellers()) {
//                boolean isBought1 = seller.sellNameLastName(this);
//                boolean isBought = seller.sellProducts(this, product);
//                if (isBought1) {
//
//                    break;
//                }
//                     else if (isBought){
//
//
//                  break;
//                     }
//            }
//        }
//    }



    public void info() {

        StringBuilder result = new StringBuilder("Я купил ");
        if (purchaseList.size() == 0) {
            result.append("ничего");
        } else {

            for (Product product : purchaseList) {
                result.append(product.getName());
                result.append(" в количестве ");
                result.append(product.getQuantity());
                result.append(" ");
            }
//               // for (Seller seller : sellerNameLastname) {
//                    result.append("У продовца  ");
//                    result.append(seller.getName());
//                    result.append(" ");
//                    result.append(seller.getLastName());
//                    result.append(" ");
//            }
        }


            result.append(". У меня осталось: ");
            result.append(getCash());
            result.append(" рублей");

            System.out.println(result);
        }


        public List<Product> getExpectedPurchaseList () {
            return expectedPurchaseList;
        }




    public List<Product> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Product> purchaseList) {
        this.purchaseList = purchaseList;
    }

    
    

//    public List<Seller> getSellerNameLastname() {
//        return sellerNameLastname;
//    }
//
//    public void setSellerNameLastname(List<Seller> sellerNameLastname) {
//        this.sellerNameLastname = sellerNameLastname;
//    }
}